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
import com.boot.security.server.dao.AdminorderviewDao;
import com.boot.security.server.model.Adminorderview;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/adminorderviews")
public class AdminorderviewController {

    @Autowired
    private AdminorderviewDao adminorderviewDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Adminorderview save(@RequestBody Adminorderview adminorderview) {
        adminorderviewDao.save(adminorderview);

        return adminorderview;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Adminorderview get(@PathVariable Long id) {
        return adminorderviewDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Adminorderview update(@RequestBody Adminorderview adminorderview) {
        adminorderviewDao.update(adminorderview);

        return adminorderview;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return adminorderviewDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Adminorderview> list(PageTableRequest request) {
                return adminorderviewDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        adminorderviewDao.delete(id);
    }
}
