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
import com.boot.security.server.dao.ActivityDao;
import com.boot.security.server.model.Activity;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/activitys")
public class ActivityController {

    @Autowired
    private ActivityDao activityDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Activity save(@RequestBody Activity activity) {
        activityDao.save(activity);

        return activity;
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Activity get(@PathVariable Long id) {
        return activityDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Activity update(@RequestBody Activity activity) {
        activityDao.update(activity);

        return activity;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return activityDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Activity> list(PageTableRequest request) {
                return activityDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        activityDao.delete(id);
    }
}
