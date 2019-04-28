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
import com.boot.security.server.dao.GoodsordersDao;
import com.boot.security.server.model.Goodsorders;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/goodsorderss")
public class GoodsordersController {

    @Autowired
    private GoodsordersDao goodsordersDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Goodsorders save(@RequestBody Goodsorders goodsorders) {
        goodsordersDao.save(goodsorders);

        return goodsorders;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Goodsorders get(@PathVariable Long id) {
        return goodsordersDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Goodsorders update(@RequestBody Goodsorders goodsorders) {
        goodsordersDao.update(goodsorders);

        return goodsorders;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return goodsordersDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Goodsorders> list(PageTableRequest request) {
                return goodsordersDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        goodsordersDao.delete(id);
    }
}
