package com.boot.security.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableResponse;
import com.boot.security.server.service.impl.CinemaMiniProgramAccountsServiceImpl;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.MemberCardServiceImpl;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.utils.UserUtil;
import com.boot.security.server.dao.CinemaDao;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.CinemaMiniProgramAccounts;
import com.boot.security.server.model.SysUser;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cinemas")
public class CinemaController {

    @Autowired
    private CinemaDao cinemaDao;
    @Autowired
    private CinemaServiceImpl cinemaService;
    @Autowired
    private CinemaMiniProgramAccountsServiceImpl cinemaMiniProgramAccountsService;
    @Autowired
    private MemberCardServiceImpl memberCardService;

    @PostMapping
    @ApiOperation(value = "保存")
    public Cinema save(@RequestBody Cinema cinema) {
        cinemaDao.save(cinema);

        return cinema;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Cinema get(@PathVariable Long id) {
    	return cinemaDao.getById(id);
    }
    
    @PutMapping
    @ApiOperation(value = "修改")
    public Cinema update(@RequestBody Cinema cinema) {
        cinemaDao.update(cinema);

        return cinema;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return cinemaDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Cinema> list(PageTableRequest request) {
                return cinemaDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }
    
    @GetMapping("/cinemaGoodsList")
    @ApiOperation(value = "卖品影院列表")
    public PageTableResponse cinemaGoodslist(PageTableRequest request) {
    	//获取当前登陆人信息
    	SysUser sysuser = UserUtil.getLoginUser();
    	request.getParams().put("id", sysuser.getId());
    	request.getParams().put("roleId", sysuser.getRoleId());
    	
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return cinemaDao.goodscount(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Cinema> list(PageTableRequest request) {
                return cinemaDao.goodslist(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        cinemaDao.delete(id);
    }
    
    @GetMapping("/getCinemas")
    @ApiOperation(value = "获取登陆用户影院")
    public List<Cinema> getCinemas() {
    	//获取当前登陆人信息
    	SysUser sysuser = UserUtil.getLoginUser();
    	
    	return cinemaDao.getCinemasByUser(sysuser.getRoleId(),sysuser.getId());
    }
    
    @RequestMapping("/changeGeneralStore")
    @ApiOperation(value ="会员卡门店通用")
    public void changeGeneralStore(@RequestParam("isgeneralstore")String isgeneralstore,@RequestParam("cinemacode")String cinemacode){
    	CinemaMiniProgramAccounts cinemaMiniProgramAccounts = cinemaMiniProgramAccountsService.getByCinemaCode(cinemacode);
    	String cinemacodes = "";
    	if(cinemaMiniProgramAccounts!=null){
    		List<CinemaMiniProgramAccounts> cinemaMiniProgramAccountsList = cinemaMiniProgramAccountsService.getByAppId(cinemaMiniProgramAccounts.getAppId());
    		if(cinemaMiniProgramAccountsList.size()>0){
    			for(int i=0; i<cinemaMiniProgramAccountsList.size(); i++){
    				cinemacodes +=cinemaMiniProgramAccountsList.get(i).getCinemaCode()+",";
    			}
    		}
    	}
    	int result = cinemaService.changeGeneralStore(Integer.valueOf(isgeneralstore), cinemacodes.substring(0,cinemacodes.length()-1));
    	if(result>0&&isgeneralstore.equals("1")){
    		memberCardService.changeMemberCinemaCode(cinemacodes.substring(0,cinemacodes.length()-1), cinemacodes.substring(0,cinemacodes.length()-1));
    	}else{
    		memberCardService.changeMemberCinemaCode(null, cinemacodes.substring(0,cinemacodes.length()-1));
    	}
    }
}
