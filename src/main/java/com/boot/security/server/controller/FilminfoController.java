package com.boot.security.server.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableResponse;
import com.boot.security.server.service.impl.ActorServiceImpl;
import com.boot.security.server.service.impl.DirectorServiceImpl;
import com.boot.security.server.service.impl.FilminfoServiceImpl;
import com.boot.security.server.utils.FileUploadUtils;
import com.boot.security.server.utils.HttpHelper;
import com.boot.security.server.utils.PropertyHolder;
import com.google.gson.Gson;

import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.model.Actor;
import com.boot.security.server.model.BaiduFilmInfomation;
import com.boot.security.server.model.BaiduFilmInfomation.Result.Movie;
import com.boot.security.server.model.Director;
import com.boot.security.server.model.Filminfo;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/filminfos")
public class FilminfoController {

    @Autowired
    private FilminfoServiceImpl _filmInfoService;
    @Autowired
    private DirectorServiceImpl _directorService;
    @Autowired
    private ActorServiceImpl _actorService;

    @PostMapping
    @ApiOperation(value = "保存")
    public Filminfo save(@RequestBody Filminfo filminfo) {
    	_filmInfoService.save(filminfo);

        return filminfo;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Filminfo get(@PathVariable Long id) {
    	Filminfo film = _filmInfoService.getById(id);
    	if(film.getDirectorId() != null){	//导演id
    		StringBuffer direbf = new StringBuffer();
    		String[] directorlist = film.getDirectorId().split(",");
    		for(int i=0;i<directorlist.length;i++){
    			Director dire = _directorService.getById(Long.valueOf(directorlist[i]));
    			direbf.append(dire.getName()+",");
    		}
    		film.setDirector(direbf.substring(0, direbf.length()-1));
    	}
    	
    	if(film.getCastId() != null){	//演员
    		StringBuffer acbf = new StringBuffer();
    		String[] actorlist = film.getCastId().split(",");
    		for(int i=0;i<actorlist.length;i++){
    			Actor actor = _actorService.getById(Long.valueOf(actorlist[i]));
    			acbf.append(actor.getName()+",");
    		}
    		film.setCast(acbf.substring(0, acbf.length()-1));
    	}
    	System.out.println("------"+new Gson().toJson(film));
        return film;
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Filminfo update(@RequestBody Filminfo filminfo){
    	if(filminfo.getDirectorId() != null && !filminfo.getDirectorId().equals("")){	//导演
    		StringBuffer direbf = new StringBuffer();
    		String[] directorlist = filminfo.getDirectorId().split(",");
    		for(int i=0;i<directorlist.length;i++){
    			Director dire = _directorService.getById(Long.valueOf(directorlist[i]));
    			direbf.append(dire.getName()+",");
    		}
    		filminfo.setDirector(direbf.substring(0, direbf.length()-1));
    	}
    	
    	if(filminfo.getCastId() != null && !filminfo.getCastId().equals("")){	//演员
    		StringBuffer acbf = new StringBuffer();
    		String[] actorlist = filminfo.getCastId().split(",");
    		for(int i=0;i<actorlist.length;i++){
    			Actor actor = _actorService.getById(Long.valueOf(actorlist[i]));
    			acbf.append(actor.getName()+",");
    		}
    		filminfo.setCast(acbf.substring(0, acbf.length()-1));
    	}
    	_filmInfoService.update(filminfo);
        return filminfo;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return _filmInfoService.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Filminfo> list(PageTableRequest request) {
                return _filmInfoService.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
    	_filmInfoService.delete(id);
    }
    
    //region 上传图片
    @RequestMapping(value = "/upload/filmImage", method = {RequestMethod.POST})
    @ResponseBody
    public Object filmImage(@RequestParam(value="file",required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	System.out.println("file="+file);
    	Map<String,Object> map2=new HashMap<>();
        Map<String,Object> map=new HashMap<>();
    	String suffix="";
        String saveroot="";
        String returnroot="";
        String path="";
        String fileName="";
        //保存上传
        OutputStream out = null;
        InputStream fileInput=null;
        try{
            if(file!=null){
                String originalName = file.getOriginalFilename();
                suffix=originalName.substring(originalName.lastIndexOf(".")+1);//文件后缀
                returnroot=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/upload";
                //上线路径
                //onlinePath=path.getParentFile().getParentFile().getParent()+File.separator+"uploads"+File.separator;
                //saveroot=ResourceUtils.getURL("classpath:").getPath()+File.separator+"static/upload/filmImage";
        		saveroot=PropertyHolder.get().getServerPath()+"/upload";
                path=new SimpleDateFormat("yyyyMM").format(new Date());
                fileName=new Date().getTime()+new Random().nextInt(1000)+"." +suffix;//新的文件名
                File files =new File(saveroot+ File.separator +path+ File.separator);
                File targetFile = new File(files, fileName);
                if(!targetFile.getParentFile().exists()){
                	targetFile.getParentFile().mkdirs();
                }
                file.transferTo(targetFile);
                System.out.println("targetFile="+targetFile);
                
                //上传到OSS服务器
        		if(true){
        			String BUCKET="whtxcx";
        			String BUCKETPATH ="upload";
        			String filePath="/" +path+ "/"+fileName;
        			String mess = FileUploadUtils.uploadOss(saveroot,filePath,BUCKET,BUCKETPATH);
        			System.out.println("mess="+mess);
        			if(!"".equals(mess)){
        				map.put("code",-1);
        		        map.put("msg","图片上传出错："+mess);
        			}
        			map2.put("src","https://"+BUCKET+".oss-cn-hangzhou.aliyuncs.com/"+BUCKETPATH+"/"+path+"/"+fileName); 
        		}else{
        			map2.put("src",returnroot +"/" + path + "/" +fileName); 
        		}
            }
        }catch (Exception e){
        }finally{
	        try {
	            if(out!=null){
	                out.close();
	            }
	            if(fileInput!=null){
	                fileInput.close();
	            }
	        } catch (IOException e) {
	        }
        }
        map.put("code",0);
        map.put("msg","上传成功！");
        map.put("data",map2);
        System.out.println("map="+new Gson().toJson(map));
        System.out.println("map2="+new Gson().toJson(map2));
        return map;
    }
    //endregion
    
    //region 上传海报
  	@RequestMapping("/upload/file")
  	@ApiOperation(value = "上传海报")
  	public Object uploadFile(@RequestParam("stagePhoto") MultipartFile[] file,HttpServletRequest request){
  		//System.out.println("file数量="+file.length);
  		Map<String,Object> map = new HashMap();
  		String suffix = "";  //文件后缀
  		String returnroot = "";  //上传路径
  		String saveroot = "";
  		String path = "";
  		String fileName="";  //文件名
  		List<String> srcList = new ArrayList<>();
  		try {
  			String src = "";
  			if(file.length>0){
  				for(int i=0; i<file.length; i++){
  					String originalName = file[i].getOriginalFilename();  //获取文件的全名
  					suffix = originalName.substring(originalName.lastIndexOf(",")+1);  //获取文件后缀
  					// request.getScheme()  当前链接使用的协议；一般应用返回http;SSL返回https;
  					// request.getServerName()  服务器的名称，如果你的应用部署在本机那么其就返回localhost或者127.0.0.1 ，这2个是等价的
  					// request.getServerPort()  应用使用的端口号
  					// request.getContextPath()  获取应用的根目录
  					returnroot = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/upload";  //上传路径
  					saveroot=PropertyHolder.get().getServerPath()+"/upload";
  					path = new SimpleDateFormat("yyyyMM").format(new Date());
  					// fileName 时间戳+三位随机数+文件名后缀
  					fileName = new Date().getTime() + new Random().nextInt(1000)+"."+suffix;
  					// files 文件名
  					// File.separator 系统目录中的间隔符，说白了就是斜线
  					File files = new File(saveroot+ File.separator +path+ File.separator);
  					File targetFile = new File(files, fileName);  //创建新的文件  第一个参数：文件   第二个参数：文件名
  					// targetFile.getParentFile() 获取文件目录
  					// 判断文件目录是否存在
  					if(!targetFile.getParentFile().exists()){
  						//创建文件目录
  						targetFile.getParentFile().mkdirs();
  					}
  					file[i].transferTo(targetFile);  //保存文件
  					//上传到OSS服务器
  					if(true){
  						String BUCKET="whtxcx";  //储存空间
  						String BUCKETPATH ="upload";
  						String filePath="/" +path+ "/"+fileName;  //文件路径
  						String mess = FileUploadUtils.uploadOss(saveroot,filePath,BUCKET,BUCKETPATH);  //文件上传返回信息
  						//判断返回信息是否为""
  						if(!"".equals(mess)){
  							//有返回信息，说明上传失败
  							System.out.println("mess="+mess);
  							map.put("msg", mess);
  						}else{
  							src = "https://"+BUCKET+".oss-cn-hangzhou.aliyuncs.com/"+BUCKETPATH+"/"+path+"/"+fileName;
  						}
  					}else{
  						 src = returnroot +"/" + path + "/" +fileName;
  					}
  					srcList.add(src);
  					System.out.println("图片路径="+src);
  				}
  			}
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  		System.out.println("图片返回路径="+new Gson().toJson(srcList));
  		return srcList;
  	}
    //endregion
    
    //region 根据城市名称抓取影片信息
    @GetMapping(value = "/grabFilmData/{city}")
    @ApiOperation(value = "根据城市名称抓取影片信息")
    public Object grabFilmData(@PathVariable String city) {
        String UrlAddress="http://api.map.baidu.com/telematics/v3/movie";
        Map<String,Object> map=new HashMap<>();
        map.put("qt","hot_movie");
        map.put("location",city);
        map.put("ak","fCWHp1a9QdsHwfPbHZ20LGLzgpKHEGrc");
        map.put("output","json");
        String JsonStr=HttpHelper.sendGetByUrlConnection(UrlAddress, map,"UTF-8");
        //log.info("抓取影片返回："+JsonStr);
        //System.out.println(JsonStr);
        BaiduFilmInfomation baidufilm=new Gson().fromJson(JsonStr,BaiduFilmInfomation.class);
        for(Movie movie: baidufilm.getResult().getMovie()){
        	List<Filminfo> films=_filmInfoService.getFilmByFilmName(movie.getMovie_name());
        	//System.out.println(new Gson().toJson(films));
        	if(films!=null&&films.size()>0){
        		for(Filminfo film:films){
            		if(film.getVersion()==null||film.getVersion().equals("")){
            			film.setVersion(movie.getMovie_type());
            		}
            		if(film.getDuration()==null||film.getDuration().equals("")){
            			film.setDuration(movie.getMovie_length());
            		}
            		//System.out.println(movie.getMovie_release_date());
            		if(film.getPublishDate()==null||film.getPublishDate().equals("")){
            			try{
            				film.setPublishDate(new SimpleDateFormat("yyyy-MM-dd").parse(movie.getMovie_release_date()));
            			}catch(ParseException ex){}
            		}
            		if(film.getDirector()==null||film.getDirector().equals("")){//导演
            			if(movie.getMovie_director() != null){
            				String[] dlist = movie.getMovie_director().split(",");
            				StringBuffer buf = new StringBuffer();
            				for(int i=0;i<dlist.length;i++){
            					Director dire = _directorService.getByName(dlist[i]);
            					if(dire == null){
            						dire = new Director();
            						dire.setCreateTime(new Date());
            						dire.setValid(1);
            						dire.setName(dlist[i]);
            						_directorService.save(dire);
            					}
            					buf.append(dire.getId()+",");
            				}
            				film.setDirectorId(buf.substring(0, buf.length()-1));
            				film.setDirector(movie.getMovie_director());
            			}
            		}
            		
            		if(film.getCast()==null||film.getCast().equals("")){	//演员
            			if(movie.getMovie_starring() != null){
            				String[] alist = movie.getMovie_starring().split(",");
            				StringBuffer buff = new StringBuffer();
            				for(int i=0;i<alist.length;i++){
            					Actor actor = _actorService.getByName(alist[i]);
            					if(actor == null){
            						actor = new Actor();
            						actor.setCreateTime(new Date());
            						actor.setValid(1);
            						actor.setName(alist[i]);
            						_actorService.save(actor);
            					}
            					buff.append(actor.getId()+",");
            				}
            				film.setCastId(buff.substring(0, buff.length()-1));
                			film.setCast(movie.getMovie_starring());
            			}
            		}
            		
            		if(film.getScore()==null||film.getScore().equals("")){
            			film.setScore(Double.valueOf(movie.getMovie_score()));
            		}
            		if(film.getArea()==null||film.getArea().equals("")){
            			film.setArea(movie.getMovie_nation());
            		}
            		if(film.getType()==null||film.getType().equals("")){
            			film.setType(movie.getMovie_tags());
            		}
            		if(film.getImage()==null||film.getImage().equals("")){
            			film.setImage(movie.getMovie_picture());
            		}
            		_filmInfoService.update(film);
            	}
        	}
        	else
        	{
        		/*Filminfo film=new Filminfo();
        		film.setFilmCode(" ");//影片编码不能为空，暂时传空格，手动更改
        		film.setFilmName(movie.getMovie_name());
        		film.setVersion(movie.getMovie_type());
        		film.setDuration(movie.getMovie_length());
        		try {
					film.setPublishDate(new SimpleDateFormat("yyyy-MM-dd").parse(movie.getMovie_release_date()));
				} catch (ParseException e) {}
        		film.setDirector(movie.getMovie_director());
        		film.setCast(movie.getMovie_starring());
        		film.setScore(Double.valueOf(movie.getMovie_score()));
        		film.setArea(movie.getMovie_nation());
        		film.setType(movie.getMovie_tags());
        		film.setStatus(0);
        		film.setImage(movie.getMovie_picture());
        		_filmInfoService.save(film);*/
        	}
        }
        Map<String,Object> map2=new HashMap<>();
        map2.put("code",0);
        map2.put("msg","更新成功！");
        return map2;
    }
    //endregion
}
