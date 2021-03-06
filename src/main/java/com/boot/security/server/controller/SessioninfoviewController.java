package com.boot.security.server.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableResponse;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.utils.UserUtil;
import com.boot.security.server.api.core.NetSaleSvcCore;
import com.boot.security.server.api.core.QuerySessionReply;
import com.boot.security.server.dao.PriceplanDao;
import com.boot.security.server.dao.SessioninfoviewDao;
import com.boot.security.server.dao.UserinfoDao;
import com.boot.security.server.model.Priceplan;
import com.boot.security.server.model.SysUser;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.modelView.Sessioninfoview;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/sessioninfoviews")
public class SessioninfoviewController {

	@Autowired
    private UserinfoDao userinfodao;
	@Autowired
    private PriceplanDao priceplanDao;
    @Autowired
    private SessioninfoviewDao sessioninfoviewDao;
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Sessioninfoview get(@PathVariable Long id) {
        return sessioninfoviewDao.getById(id);
    }

    @GetMapping
    @ApiOperation(value = "排期视图列表")
    public PageTableResponse list(PageTableRequest request) {
    	//获取当前登陆人信息
    	SysUser sysuser = UserUtil.getLoginUser();
    	request.getParams().put("id", sysuser.getId());
    	request.getParams().put("roleId", sysuser.getRoleId());
    	
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return sessioninfoviewDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Sessioninfoview> list(PageTableRequest request) {
                return sessioninfoviewDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @PutMapping
    @ApiOperation(value = "修改价格")
    public int update(@RequestBody Map<String,Object> map) {
    	System.out.println("22222"+map);
    	Priceplan priceplan=new Priceplan();
    	priceplan.setCinemaCode(map.get("cinemaCode").toString());
    	priceplan.setUserID(Integer.parseInt(map.get("userID").toString()));
    	priceplan.setPrice(Double.parseDouble(map.get("standardPrice").toString()));
    	priceplan.setTicketFee(Double.parseDouble(map.get("ticketFee").toString()));
    	priceplan.setAddFee(Double.parseDouble(map.get("addFee").toString()));
    	priceplan.setCinemaAllowance(Double.parseDouble(map.get("cinemaAllowance").toString()));
    	priceplan.setMemberPrice(Double.parseDouble(map.get("memberPrice").toString()));
    	String type=map.get("type").toString();
    	if("1".equals(type)){
    		priceplan.setCode(map.get("scode").toString());
    	} else {
    		priceplan.setCode(map.get("filmCode").toString());
    	}
    	
    	priceplan.setType(Integer.parseInt(map.get("type").toString()));
    	
    	Priceplan p = priceplanDao.selectPrice(priceplan);
    	if(p == null){
    		priceplanDao.save(priceplan);
    	} else {
    		priceplanDao.updatePriceplan(priceplan);
    	}
    	
        return 1;
    }
    
    @PostMapping("/getCompany")
    @ApiOperation(value = "渠道列表")
    public List<Userinfo> getCompany() {
        return userinfodao.getCompany();
    }
    
    
    @PostMapping("/getNewSession")
    @ApiOperation(value = "重新获取排期")
    public QuerySessionReply getNewSession(@RequestBody Map<String,Object> map){
    	String UserName = "MiniProgram";
    	String Password = "6BF477EBCC446F54E6512AFC0E976C41";

    	redisTemplate.delete("sessioninfo:"+map.get("cinemaCode"));//清该影院的redis排期
        redisTemplate.delete("oneDaySchedule:"+map.get("cinemaCode"));

    	try {
			QuerySessionReply reply =NetSaleSvcCore.getInstance().QuerySession(UserName, Password, map.get("cinemaCode").toString(), map.get("beginDate").toString(), map.get("endDate").toString());
			return reply;
    	} catch (ParseException e1) {
			e1.printStackTrace();
			return new QuerySessionReply();
		}
    }
}
