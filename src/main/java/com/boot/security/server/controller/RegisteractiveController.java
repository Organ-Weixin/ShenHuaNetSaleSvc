package com.boot.security.server.controller;

import java.util.ArrayList;
import java.util.Date;
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
import com.boot.security.server.service.impl.RegisteractiveServiceImpl;
import com.boot.security.server.service.impl.RegisteractivecouponsServiceImpl;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.dao.RegisteractiveDao;
import com.boot.security.server.model.Registeractive;
import com.boot.security.server.model.Registeractivecoupons;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/registeractives")
public class RegisteractiveController {

    @Autowired
    private RegisteractiveDao registeractiveDao;
    @Autowired
    private RegisteractiveServiceImpl registeractiveService;
    @Autowired
    private RegisteractivecouponsServiceImpl registeractivecouponsService;

    @PostMapping
    @ApiOperation(value = "保存")
    public Registeractive save(@RequestBody Registeractive registeractive) {
    	registeractive.setCreatedTime(new Date());
    	String RegisterActiveCode = String.valueOf(new Date().getTime()/1000);
    	RegisterActiveCode += (int)((Math.random()*9+1)*100);
    	registeractive.setRegisterActiveCode(RegisterActiveCode);
    	String GroupCodesArr []  = registeractive.getGroupCodes().split(",");
    	String CouponNamesArr [] = registeractive.getCouponsName().split(",");
    	String GiveNumbersArr [] = registeractive.getGiveNumber().split(",");
    	List<String> groupCodes = new ArrayList<>();
    	for(int i=0; i<GroupCodesArr.length; i++){
    		groupCodes.add(GroupCodesArr[i]);
    	}
    	List<String> couponNames = new ArrayList<>();
    	for(int i=0; i<CouponNamesArr.length; i++){
    		couponNames.add(CouponNamesArr[i]);
    	}
    	List<String> giveNumbers = new ArrayList<>();
    	for(int i=0; i<GiveNumbersArr.length; i++){
    		giveNumbers.add(GiveNumbersArr[i]);
    	}
    	int result = 0;
    	for(int i=0; i<groupCodes.size(); i++){
    		Registeractivecoupons registeractivecoupons = new Registeractivecoupons();
    		registeractivecoupons.setRegisterActiveCode(registeractive.getRegisterActiveCode());
    		registeractivecoupons.setGroupCode(groupCodes.get(i));
    		registeractivecoupons.setCouponsName(couponNames.get(i));
    		registeractivecoupons.setGiveNumber(Integer.valueOf(giveNumbers.get(i)));
    		result = registeractivecouponsService.save(registeractivecoupons);
    	}
    	if(result>0){
    		registeractiveDao.save(registeractive);
    		return registeractive;
    	}else{
    		return null;
    	}
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Registeractive get(@PathVariable Long id) {
        return registeractiveDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Registeractive update(@RequestBody Registeractive registeractive) {
    	registeractivecouponsService.deleteByRegisterActiveCode(registeractive.getRegisterActiveCode());
    	registeractive.setUpdatedTime(new Date());
    	String GroupCodesArr []  = registeractive.getGroupCodes().split(",");
    	String CouponNamesArr [] = registeractive.getCouponsName().split(",");
    	String GiveNumbersArr [] = registeractive.getGiveNumber().split(",");
    	List<String> groupCodes = new ArrayList<>();
    	for(int i=0; i<GroupCodesArr.length; i++){
    		groupCodes.add(GroupCodesArr[i]);
    	}
    	List<String> couponNames = new ArrayList<>();
    	for(int i=0; i<CouponNamesArr.length; i++){
    		couponNames.add(CouponNamesArr[i]);
    	}
    	List<String> giveNumbers = new ArrayList<>();
    	for(int i=0; i<GiveNumbersArr.length; i++){
    		giveNumbers.add(GiveNumbersArr[i]);
    	}
    	int result = 0;
    	for(int i=0; i<groupCodes.size(); i++){
    		Registeractivecoupons registeractivecoupons = new Registeractivecoupons();
    		registeractivecoupons.setRegisterActiveCode(registeractive.getRegisterActiveCode());
    		registeractivecoupons.setGroupCode(groupCodes.get(i));
    		registeractivecoupons.setCouponsName(couponNames.get(i));
    		registeractivecoupons.setGiveNumber(Integer.valueOf(giveNumbers.get(i)));
    		result = registeractivecouponsService.save(registeractivecoupons);
    	}
    	if(result>0){
    		registeractiveDao.update(registeractive);
    		return registeractive;
    	}else{
    		return null;
    	}

    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return registeractiveDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Registeractive> list(PageTableRequest request) {
                return registeractiveDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        registeractiveDao.delete(id);
    }
    
    @RequestMapping("/getByCinemaCode")
    @ApiOperation(value = "列表(不分页)")
    public Registeractive getByCinemaCode(@RequestParam("cinemacode") String cinemacode){
    	return registeractiveService.getByCinemaCode(cinemacode);
    }
    
    @RequestMapping("/getByRegisterActiveCode")
    @ApiOperation(value = "登陆人对应的活动优惠券列表")
    public List<Registeractivecoupons> getByRegisterActiveCode(@RequestParam("registerActiveCode") String registerActiveCode){
    	return registeractivecouponsService.getByRegisterActiveCode(registerActiveCode);
    }
}
