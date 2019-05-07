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
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.dao.CouponsgroupDao;
import com.boot.security.server.model.Couponsgroup;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/couponsgroups")
public class CouponsgroupController {

    @Autowired
    private CouponsgroupDao couponsgroupDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Couponsgroup save(@RequestBody Couponsgroup couponsgroup) {
        couponsgroupDao.save(couponsgroup);

        return couponsgroup;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Couponsgroup get(@PathVariable Long id) {
        return couponsgroupDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Couponsgroup update(@RequestBody Couponsgroup couponsgroup) {
        couponsgroupDao.update(couponsgroup);

        return couponsgroup;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return couponsgroupDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Couponsgroup> list(PageTableRequest request) {
                return couponsgroupDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        couponsgroupDao.delete(id);
    }
}
