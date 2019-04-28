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
import com.boot.security.server.dao.GoodsDao;
import com.boot.security.server.model.Goods;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/goodss")
public class GoodsController {

    @Autowired
    private GoodsDao goodsDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Goods save(@RequestBody Goods goods) {
        goodsDao.save(goods);

        return goods;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Goods get(@PathVariable Long id) {
        return goodsDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Goods update(@RequestBody Goods goods) {
        goodsDao.update(goods);

        return goods;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return goodsDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Goods> list(PageTableRequest request) {
                return goodsDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        goodsDao.delete(id);
    }
}
