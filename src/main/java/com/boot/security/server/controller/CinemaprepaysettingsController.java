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
import com.boot.security.server.dao.CinemaprepaysettingsDao;
import com.boot.security.server.model.Cinemaprepaysettings;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cinemaprepaysettingss")
public class CinemaprepaysettingsController {

    @Autowired
    private CinemaprepaysettingsDao cinemaprepaysettingsDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Cinemaprepaysettings save(@RequestBody Cinemaprepaysettings cinemaprepaysettings) {
        cinemaprepaysettingsDao.save(cinemaprepaysettings);

        return cinemaprepaysettings;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Cinemaprepaysettings get(@PathVariable Long id) {
        return cinemaprepaysettingsDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Cinemaprepaysettings update(@RequestBody Cinemaprepaysettings cinemaprepaysettings) {
        cinemaprepaysettingsDao.update(cinemaprepaysettings);

        return cinemaprepaysettings;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return cinemaprepaysettingsDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Cinemaprepaysettings> list(PageTableRequest request) {
                return cinemaprepaysettingsDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        cinemaprepaysettingsDao.delete(id);
    }
}
