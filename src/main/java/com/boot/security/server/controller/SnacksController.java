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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableResponse;
import com.boot.security.server.service.impl.SnacksServiceImpl;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.dao.SnacksDao;
import com.boot.security.server.model.Snacks;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/snackss")
public class SnacksController {

    @Autowired
    private SnacksDao snacksDao;
    @Autowired
    private SnacksServiceImpl snacksService;

    @PostMapping
    @ApiOperation(value = "保存")
    public Snacks save(@RequestBody Snacks snacks) {
        snacksDao.save(snacks);

        return snacks;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Snacks get(@PathVariable Long id) {
        return snacksDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Snacks update(@RequestBody Snacks snacks) {
        snacksDao.update(snacks);

        return snacks;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return snacksDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Snacks> list(PageTableRequest request) {
                return snacksDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        snacksDao.delete(id);
    }
    
    @RequestMapping("/getByCinemaCode")
    public List<Snacks> getByCinemaCode(@RequestParam("cinemacode") String cinemacode){
    	return snacksService.getByCinemaCode(cinemacode);
    }
}
