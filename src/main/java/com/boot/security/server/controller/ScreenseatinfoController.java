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
import com.boot.security.server.dao.ScreenseatinfoDao;
import com.boot.security.server.model.Screenseatinfo;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/screenseatinfos")
public class ScreenseatinfoController {

    @Autowired
    private ScreenseatinfoDao screenseatinfoDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Screenseatinfo save(@RequestBody Screenseatinfo screenseatinfo) {
        screenseatinfoDao.save(screenseatinfo);

        return screenseatinfo;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Screenseatinfo get(@PathVariable Long id) {
        return screenseatinfoDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Screenseatinfo update(@RequestBody Screenseatinfo screenseatinfo) {
        screenseatinfoDao.update(screenseatinfo);

        return screenseatinfo;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return screenseatinfoDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Screenseatinfo> list(PageTableRequest request) {
                return screenseatinfoDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        screenseatinfoDao.delete(id);
    }
}
