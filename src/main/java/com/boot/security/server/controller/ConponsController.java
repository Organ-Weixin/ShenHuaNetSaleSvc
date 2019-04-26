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
import com.boot.security.server.dao.ConponsDao;
import com.boot.security.server.model.Conpons;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/conponss")
public class ConponsController {

    @Autowired
    private ConponsDao conponsDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Conpons save(@RequestBody Conpons conpons) {
        conponsDao.save(conpons);

        return conpons;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Conpons get(@PathVariable Long id) {
        return conponsDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Conpons update(@RequestBody Conpons conpons) {
        conponsDao.update(conpons);

        return conpons;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return conponsDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Conpons> list(PageTableRequest request) {
                return conponsDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        conponsDao.delete(id);
    }
}
