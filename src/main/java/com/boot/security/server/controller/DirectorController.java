package com.boot.security.server.controller;

import java.util.Date;
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
import com.boot.security.server.dao.DirectorDao;
import com.boot.security.server.model.Director;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/directors")
public class DirectorController {

    @Autowired
    private DirectorDao directorDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Director save(@RequestBody Director director) {
    	director.setCreateTime(new Date());
    	director.setValid(1);
    	director.setVersion(0);
        directorDao.save(director);

        return director;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Director get(@PathVariable Long id) {
        return directorDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Director update(@RequestBody Director director) {
    	director.setModifyTime(new Date());
        directorDao.update(director);

        return director;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return directorDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Director> list(PageTableRequest request) {
                return directorDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        directorDao.delete(id);
    }
}
