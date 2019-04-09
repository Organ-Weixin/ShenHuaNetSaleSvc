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
import com.boot.security.server.dao.UserinfoDao;
import com.boot.security.server.model.Userinfo;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/userinfos")
public class UserinfoController {

    @Autowired
    private UserinfoDao userinfoDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Userinfo save(@RequestBody Userinfo userinfo) {
        userinfoDao.save(userinfo);

        return userinfo;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Userinfo get(@PathVariable Long id) {
        return userinfoDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Userinfo update(@RequestBody Userinfo userinfo) {
        userinfoDao.update(userinfo);

        return userinfo;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return userinfoDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Userinfo> list(PageTableRequest request) {
                return userinfoDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        userinfoDao.delete(id);
    }
}
