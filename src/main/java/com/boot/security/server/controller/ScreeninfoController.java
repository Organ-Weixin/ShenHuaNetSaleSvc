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
import com.boot.security.server.dao.ScreeninfoDao;
import com.boot.security.server.model.Screeninfo;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/screeninfos")
public class ScreeninfoController {

    @Autowired
    private ScreeninfoDao screeninfoDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Screeninfo save(@RequestBody Screeninfo screeninfo) {
        screeninfoDao.save(screeninfo);

        return screeninfo;
    }
    //根据id查询影厅信息
    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Screeninfo get(@PathVariable Long id) {
        return screeninfoDao.getById(id);
    }
    
    @PutMapping
    @ApiOperation(value = "修改")
    public Screeninfo update(@RequestBody Screeninfo screeninfo) {
        screeninfoDao.update(screeninfo);

        return screeninfo;
    }

    //影厅信息列表
    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return screeninfoDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Screeninfo> list(PageTableRequest request) {
                return screeninfoDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        screeninfoDao.delete(id);
    }
    
    @DeleteMapping("/{ccode}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable String ccode) {
        screeninfoDao.deleteByCinemaCode(ccode);
    }
}
