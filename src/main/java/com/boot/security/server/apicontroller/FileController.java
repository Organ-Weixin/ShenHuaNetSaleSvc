package com.boot.security.server.apicontroller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.boot.security.server.utils.FileUploadUtils;
import com.boot.security.server.utils.PropertyHolder;
import com.google.gson.Gson;

@RestController
@RequestMapping("/Api/File") 
public class FileController {
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
                System.out.println(targetFile);
                
                //上传到OSS服务器
        		if(true){
        			String BUCKET="whtxcx";
        			String BUCKETPATH ="upload";
        			String filePath="/" +path+ "/"+fileName;
        			String mess = FileUploadUtils.uploadOss(saveroot,filePath,BUCKET,BUCKETPATH);
        			System.out.println(mess);
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
}
