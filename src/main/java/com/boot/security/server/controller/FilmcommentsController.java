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
import com.boot.security.server.dao.FilmcommentsDao;
import com.boot.security.server.model.Filmcomments;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/filmcommentss")
public class FilmcommentsController {

    @Autowired
    private FilmcommentsDao filmcommentsDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Filmcomments save(@RequestBody Filmcomments filmcomments) {
        filmcommentsDao.save(filmcomments);

        return filmcomments;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Filmcomments get(@PathVariable Long id) {
        return filmcommentsDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Filmcomments update(@RequestBody Filmcomments filmcomments) {
        filmcommentsDao.update(filmcomments);

        return filmcomments;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return filmcommentsDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Filmcomments> list(PageTableRequest request) {
                return filmcommentsDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        filmcommentsDao.delete(id);
    }
}
