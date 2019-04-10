package com.boot.security.server.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.boot.security.server.dao.SessioninfoDao;
import com.boot.security.server.model.Priceplan;
import com.boot.security.server.model.Sessioninfo;
import com.boot.security.server.model.Userinfo;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/sessioninfos")
public class SessioninfoController {

    @Autowired
    private SessioninfoDao sessioninfoDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Sessioninfo save(@RequestBody Sessioninfo sessioninfo) {
        sessioninfoDao.save(sessioninfo);

        return sessioninfo;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Sessioninfo get(@PathVariable Long id) {
        return sessioninfoDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public int update(@RequestBody Map map) {
    	Priceplan priceplan=new Priceplan();
    	priceplan.setCinemaCode(map.get("ccode").toString());
    	priceplan.setUserID(Integer.parseInt(map.get("userID").toString()));
    	priceplan.setPrice(Double.parseDouble(map.get("standardPrice").toString()));
    	String type=map.get("type").toString();
    	if("1".equals(type)){
    		priceplan.setCode(map.get("scode").toString());
    	} else {
    		priceplan.setCode(map.get("filmCode").toString());
    	}
    	
    	priceplan.setType(Integer.parseInt(map.get("type").toString()));
    	
    	Priceplan p = sessioninfoDao.selectPrice(priceplan);
    	if(p == null){
    		sessioninfoDao.addPriceplan(priceplan);
    	}
    	
        return sessioninfoDao.updatePriceplan(priceplan);
    }

    @GetMapping
    @ApiOperation(value = "排期列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return sessioninfoDao.countSession(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Sessioninfo> list(PageTableRequest request) {
                return sessioninfoDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        sessioninfoDao.delete(id);
    }
    
    @PostMapping("/getCompany")
    @ApiOperation(value = "渠道列表")
    public List<Userinfo> getCompany() {
        return sessioninfoDao.getCompany();
    }
}
