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
import com.boot.security.server.dao.GoodstypeDao;
import com.boot.security.server.model.Goodstype;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/goodstypes")
public class GoodstypeController {

    @Autowired
    private GoodstypeDao goodstypeDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Goodstype save(@RequestBody Goodstype goodstype) {
        goodstypeDao.save(goodstype);

        return goodstype;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Goodstype get(@PathVariable Long id) {
        return goodstypeDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Goodstype update(@RequestBody Goodstype goodstype) {
        goodstypeDao.update(goodstype);

        return goodstype;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return goodstypeDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Goodstype> list(PageTableRequest request) {
                return goodstypeDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        goodstypeDao.delete(id);
    }
}
