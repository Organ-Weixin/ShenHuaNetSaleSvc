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
import com.boot.security.server.dao.GoodsorderdetailsDao;
import com.boot.security.server.model.Goodsorderdetails;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/goodsorderdetailss")
public class GoodsorderdetailsController {

    @Autowired
    private GoodsorderdetailsDao goodsorderdetailsDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Goodsorderdetails save(@RequestBody Goodsorderdetails goodsorderdetails) {
        goodsorderdetailsDao.save(goodsorderdetails);

        return goodsorderdetails;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Goodsorderdetails get(@PathVariable Long id) {
        return goodsorderdetailsDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Goodsorderdetails update(@RequestBody Goodsorderdetails goodsorderdetails) {
        goodsorderdetailsDao.update(goodsorderdetails);

        return goodsorderdetails;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return goodsorderdetailsDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Goodsorderdetails> list(PageTableRequest request) {
                return goodsorderdetailsDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        goodsorderdetailsDao.delete(id);
    }
}
