package com.boot.security.server.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableResponse;
import com.boot.security.server.service.impl.CouponsServiceImpl;
import com.boot.security.server.service.impl.CouponsgroupServiceImpl;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.dao.CouponsDao;
import com.boot.security.server.model.Coupons;
import com.boot.security.server.model.Couponsgroup;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/couponss")
public class CouponsController {

    @Autowired
    private CouponsDao couponsDao;
    @Autowired
    private CouponsgroupServiceImpl couponsgroupService;
    @Autowired
    private CouponsServiceImpl couponsService;
    
    @PostMapping
    @ApiOperation(value = "保存")
    public Coupons save(@RequestBody Coupons coupons) {
        couponsDao.save(coupons);

        return coupons;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Coupons get(@PathVariable Long id) {
        return couponsDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Coupons update(@RequestBody Coupons coupons) {
        couponsDao.update(coupons);

        return coupons;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return couponsDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Coupons> list(PageTableRequest request) {
                return couponsDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
    	Coupons coupons = couponsDao.getById(id);
    	Couponsgroup couponsgroup = couponsgroupService.getByGroupCode(coupons.getGroupCode());
    	int i = couponsDao.delete(id);
    	if(i>0){
    		couponsgroup.setCouponsNumber(couponsgroup.getCouponsNumber()-i);
    		couponsgroup.setRemainingNumber(couponsgroup.getRemainingNumber()-i);
    		couponsgroup.setUpdateDate(new Date());
    		couponsgroupService.update(couponsgroup);
    	}
    }
}
