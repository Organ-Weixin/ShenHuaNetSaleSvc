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
import com.boot.security.server.dao.SessioninfoviewDao;
import com.boot.security.server.model.Sessioninfoview;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/sessioninfoviews")
public class SessioninfoviewController {

    @Autowired
    private SessioninfoviewDao sessioninfoviewDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Sessioninfoview save(@RequestBody Sessioninfoview sessioninfoview) {
        sessioninfoviewDao.save(sessioninfoview);

        return sessioninfoview;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Sessioninfoview get(@PathVariable Long id) {
        return sessioninfoviewDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Sessioninfoview update(@RequestBody Sessioninfoview sessioninfoview) {
        sessioninfoviewDao.update(sessioninfoview);

        return sessioninfoview;
    }

    @GetMapping
    @ApiOperation(value = "排期视图列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return sessioninfoviewDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Sessioninfoview> list(PageTableRequest request) {
                return sessioninfoviewDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        sessioninfoviewDao.delete(id);
    }
}
