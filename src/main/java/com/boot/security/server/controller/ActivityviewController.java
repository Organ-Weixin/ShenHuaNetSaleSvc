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
import com.boot.security.server.dao.ActivityviewDao;
import com.boot.security.server.model.Activityview;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/activityviews")
public class ActivityviewController {

    @Autowired
    private ActivityviewDao activityviewDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Activityview save(@RequestBody Activityview activityview) {
        activityviewDao.save(activityview);

        return activityview;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Activityview get(@PathVariable Long id) {
        return activityviewDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Activityview update(@RequestBody Activityview activityview) {
        activityviewDao.update(activityview);

        return activityview;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return activityviewDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Activityview> list(PageTableRequest request) {
                return activityviewDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        activityviewDao.delete(id);
    }
}
