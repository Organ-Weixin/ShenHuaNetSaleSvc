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

import com.boot.security.server.model.Middleware;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableResponse;
import com.boot.security.server.service.MiddlewareService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/middlewares")
public class MiddlewareController {

    @Autowired
    MiddlewareService middleS;

    @PostMapping
    @ApiOperation(value = "保存")
    public Middleware save(@RequestBody Middleware middleware) {
    	middleS.save(middleware);
        return middleware;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Middleware get(@PathVariable Long id) {
        return middleS.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Middleware update(@RequestBody Middleware middleware) {
    	middleS.update(middleware);
        return middleware;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return middleS.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Middleware> list(PageTableRequest request) {
                return middleS.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
    	middleS.delete(id);
    }
    @PostMapping("/getTitle")
    @ApiOperation(value = "渠道列表")
    public List<Middleware> getTitle() {
        return middleS.getTitle();
    }
}
