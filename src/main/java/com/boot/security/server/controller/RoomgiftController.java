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
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableResponse;
import com.boot.security.server.service.impl.CouponsgroupServiceImpl;
import com.boot.security.server.service.impl.RoomgiftServiceImpl;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.model.Couponsgroup;
import com.boot.security.server.model.Roomgift;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/roomgifts")
public class RoomgiftController {

    @Autowired
    private RoomgiftServiceImpl roomgiftservice;
    @Autowired
    private CouponsgroupServiceImpl couponsgroupService;

    @PostMapping
    @ApiOperation(value = "保存")
    public Roomgift save(@RequestBody Roomgift roomgift) {
    	//如果发放的是优惠券，更新优惠券已发放数量
    	if("2".equals(roomgift.getGiftType())){
    		Couponsgroup couponsgroup = couponsgroupService.getByGroupCode(roomgift.getGiftCode());
    		if(couponsgroup!=null){
    			int issuednumber = couponsgroup.getIssuedNumber() + roomgift.getGroupNumber() * roomgift.getSendNumber();
    			couponsgroupService.updateIssuedNumber(issuednumber, roomgift.getGiftCode());
    		}
    	}
    	roomgiftservice.save(roomgift);

        return roomgift;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Roomgift get(@PathVariable Long id) {
        return roomgiftservice.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Roomgift update(@RequestBody Roomgift roomgift) {
    	//如果发放的是优惠券，更新优惠券已发放数量
    	if("2".equals(roomgift.getGiftType())){
    		Couponsgroup couponsgroup = couponsgroupService.getByGroupCode(roomgift.getGiftCode());
    		//先找到修改前的数量
    		Roomgift roomgiftE = roomgiftservice.getById(roomgift.getId());
    		if(roomgiftE!=null&&couponsgroup!=null){
    			//修改前的数量
    			int passNumber = roomgiftE.getGroupNumber() * roomgiftE.getSendNumber();
    			//要修改的数量
    			int nowNumber = roomgift.getGroupNumber() * roomgift.getSendNumber();
    			//最终数量：减去之前的数量，加上要修改的数量
    			int issuednumber = couponsgroup.getIssuedNumber() - passNumber + nowNumber;
    			couponsgroupService.updateIssuedNumber(issuednumber, roomgift.getGiftCode());
    		}
    	}
    	roomgiftservice.update(roomgift);

        return roomgift;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return roomgiftservice.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Roomgift> list(PageTableRequest request) {
                return roomgiftservice.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
    	//删除时候把优惠券中的可使用数量加回去
    	Roomgift roomgift = roomgiftservice.getById(id);
    	if(roomgift!=null){
    		//获取该优惠券
    		Couponsgroup couponsgroup = couponsgroupService.getByGroupCode(roomgift.getGiftCode());
    		if(couponsgroup!=null){
    			//把放映厅设置的数量减回去
    			int issuedNumber = couponsgroup.getIssuedNumber() - roomgift.getGroupNumber() * roomgift.getSendNumber();
    			couponsgroup.setIssuedNumber(issuedNumber);
    		}
    	}
    	roomgiftservice.delete(id);
    }
}
