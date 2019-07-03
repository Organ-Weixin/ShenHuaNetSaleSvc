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
import com.boot.security.server.service.impl.MemberCardLevelServiceImpl;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.api.core.NetSaleSvcCore;
import com.boot.security.server.api.core.QueryCardLevelReply;
import com.boot.security.server.dao.MembercardlevelDao;
import com.boot.security.server.model.Membercardlevel;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/membercardlevels")
public class MembercardlevelController {

    @Autowired
    private MembercardlevelDao membercardlevelDao;
    @Autowired
    private MemberCardLevelServiceImpl memberCardLevelService;

    @PostMapping
    @ApiOperation(value = "保存")
    public Membercardlevel save(@RequestBody Membercardlevel membercardlevel) {
        membercardlevelDao.save(membercardlevel);

        return membercardlevel;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Membercardlevel get(@PathVariable Long id) {
        return membercardlevelDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Membercardlevel update(@RequestBody Membercardlevel membercardlevel) {
        membercardlevelDao.update(membercardlevel);

        return membercardlevel;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return membercardlevelDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Membercardlevel> list(PageTableRequest request) {
                return membercardlevelDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        membercardlevelDao.delete(id);
    }
    
    @PostMapping("/{cinemaCode}")
    @ApiOperation(value = "获取影院的会员卡类别")
    public QueryCardLevelReply getCardLevel(@PathVariable String cinemaCode){
    	String UserName = "MiniProgram";
    	String Password = "6BF477EBCC446F54E6512AFC0E976C41";
    	
    	return NetSaleSvcCore.getInstance().QueryCardLevel(UserName, Password, cinemaCode);
    }
    
    @RequestMapping("/changeStatus")
    @ApiOperation(value = "改变会员卡类别状态")
    public int changeStatus(@RequestParam("status") Integer status,@RequestParam("id") Long id){
    	return memberCardLevelService.changeStatus(status, id);
    }
    
    @RequestMapping("/getCanUseByCinemaCode")
    @ApiOperation(value = "通过影院编码获取启用的会员卡类别")
    public List<Membercardlevel> getCanUseByCinemaCode(@RequestParam("cinemacode") String cinemacode){
    	return memberCardLevelService.getCanUseByCinemaCode(cinemacode);
    }
    
    @RequestMapping("/updateIsOnlineOpenCard")
    @ApiOperation(value = "修改是否可线上开卡")
    public int updateIsOnlineOpenCard(@RequestParam("isonlineopencard") String isonlineopencard,@RequestParam("cinemacode") String cinemacode,
    		@RequestParam("levelcode") String levelcode){
    	//初始化该影院所有会员卡的IsOnlineOpenCard
    	int initResult = memberCardLevelService.initIsOnlineOpenCard(cinemacode);
    	int result =0;
    	if(initResult>0){
    		result = memberCardLevelService.updateIsOnlineOpenCard(Integer.valueOf(isonlineopencard), cinemacode, levelcode);
    	}
    	return result;
    }
}