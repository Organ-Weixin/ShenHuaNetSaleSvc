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
import com.boot.security.server.dao.CinemaDao;
import com.boot.security.server.model.Cinema;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cinemas")
public class CinemaController {

    @Autowired
    private CinemaDao cinemaDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Cinema save(@RequestBody Cinema cinema) {
        cinemaDao.save(cinema);

        return cinema;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Cinema get(@PathVariable Long id) {
    	Cinema c = new Cinema();
    	c = cinemaDao.getById(id);
    	System.out.println(c.getId());
    	System.out.println(c.getMId());
    	return cinemaDao.getById(id);
    }
    

    
    @PutMapping
    @ApiOperation(value = "修改")
    public Cinema update(@RequestBody Cinema cinema) {
        cinemaDao.update(cinema);

        return cinema;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return cinemaDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Cinema> list(PageTableRequest request) {
                return cinemaDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        cinemaDao.delete(id);
    }
}
