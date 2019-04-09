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
import com.boot.security.server.dao.UsercinemaviewDao;
import com.boot.security.server.model.Usercinemaview;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/usercinemaviews")
public class UsercinemaviewController {

    @Autowired
    private UsercinemaviewDao usercinemaviewDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Usercinemaview save(@RequestBody Usercinemaview usercinemaview) {
        usercinemaviewDao.save(usercinemaview);

        return usercinemaview;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Usercinemaview get(@PathVariable Long id) {
        return usercinemaviewDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Usercinemaview update(@RequestBody Usercinemaview usercinemaview) {
        usercinemaviewDao.update(usercinemaview);

        return usercinemaview;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return usercinemaviewDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Usercinemaview> list(PageTableRequest request) {
                return usercinemaviewDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        usercinemaviewDao.delete(id);
    }
}
