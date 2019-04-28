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
import com.boot.security.server.dao.GoodscomponentsDao;
import com.boot.security.server.model.Goodscomponents;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/goodscomponentss")
public class GoodscomponentsController {

    @Autowired
    private GoodscomponentsDao goodscomponentsDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Goodscomponents save(@RequestBody Goodscomponents goodscomponents) {
        goodscomponentsDao.save(goodscomponents);

        return goodscomponents;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Goodscomponents get(@PathVariable Long id) {
        return goodscomponentsDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Goodscomponents update(@RequestBody Goodscomponents goodscomponents) {
        goodscomponentsDao.update(goodscomponents);

        return goodscomponents;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return goodscomponentsDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Goodscomponents> list(PageTableRequest request) {
                return goodscomponentsDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        goodscomponentsDao.delete(id);
    }
}
