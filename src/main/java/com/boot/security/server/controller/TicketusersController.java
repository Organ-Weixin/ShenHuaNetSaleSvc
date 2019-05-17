package com.boot.security.server.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.boot.security.server.service.impl.MemberCardServiceImpl;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.dao.TicketusersDao;
import com.boot.security.server.model.Membercard;
import com.boot.security.server.model.Ticketusers;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/ticketuserss")
public class TicketusersController {

    @Autowired
    private TicketusersDao ticketusersDao;
    @Autowired
    private MemberCardServiceImpl memberCardService;

    @PostMapping
    @ApiOperation(value = "保存")
    public Ticketusers save(@RequestBody Ticketusers ticketusers) {
        ticketusersDao.save(ticketusers);

        return ticketusers;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Ticketusers get(@PathVariable Long id) {
        return ticketusersDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Ticketusers update(@RequestBody Ticketusers ticketusers) {
        ticketusersDao.update(ticketusers);

        return ticketusers;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return ticketusersDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Ticketusers> list(PageTableRequest request) {
                return ticketusersDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        ticketusersDao.delete(id);
    }
    
    @RequestMapping("/getCountUser")
    @ApiOperation(value = "获取用户数量")
    public int getCountUser(@RequestParam("customertype") Integer customertype,@RequestParam("cinemacodes") String cinemacodes,@RequestParam("mobilephone") String mobilephone){
    	Map params = new HashMap();
    	List<Ticketusers> ticketusersList = new ArrayList<Ticketusers>();
    	if(mobilephone!=null&&mobilephone!=""){
    		params.put("MobilePhone", mobilephone);
    		ticketusersList = ticketusersDao.getTicketusers(params);
    	}
    	List<Ticketusers> newTicketusersList = new ArrayList<Ticketusers>();
    	List<String> OpenIDs = new ArrayList<String>();
    	for(Ticketusers ticketusers :ticketusersList){
    		OpenIDs.add(ticketusers.getOpenID());
    	}
    	if(customertype==1){
    		params = new HashMap();
    		params.put("IsActive", "");
    		newTicketusersList = ticketusersDao.getTicketusers(params);
    	}
    	if(customertype==2){
    		List<Membercard> memberList = memberCardService.getByCinemaCodes(cinemacodes);
    		for(Membercard member:memberList){
    			OpenIDs.add(member.getOpenId());
    		}
    		Set<String> openidList = new HashSet<>();
    		//得到去除重复之后的OpenID
        	for(String openid : OpenIDs){
        		if (openidList.contains(openid)) {
        		}else{
        			openidList.add(openid);
        		}
        	}
        	return openidList.size();
    	}
    	if(customertype==3){
    		params = new HashMap();
    		params.put("IsActive", "1");
    		newTicketusersList = ticketusersDao.getTicketusers(params);
    	}
    	if(customertype==4){
    		params = new HashMap();
    		params.put("IsActive", "0");
    		newTicketusersList = ticketusersDao.getTicketusers(params);
    	}
    	for(Ticketusers ticketusers:newTicketusersList){
			OpenIDs.add(ticketusers.getOpenID());
		}
		Set<String> openidList = new HashSet<>();
    	//得到去除重复之后的OpenID
    	for(String openid : OpenIDs){
    		if (openidList.contains(openid)) {
    		}else{
    			openidList.add(openid);
    		}
    	}
    	return openidList.size();
    }
    
    @RequestMapping("/checkMobliePhone")
    @ApiOperation(value = "校验用户手机号")
    public List<Ticketusers> checkMobliePhone(@RequestParam("mobilephone") String mobilephone){
    	Map params = new HashMap();
    	params.put("MobilePhone", mobilephone);
    	return ticketusersDao.getTicketusers(params);
    }
}
