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
import com.boot.security.server.dao.CinemapaymentsettingsDao;
import com.boot.security.server.model.Cinemapaymentsettings;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cinemapaymentsettingss")
public class CinemapaymentsettingsController {

    @Autowired
    private CinemapaymentsettingsDao cinemapaymentsettingsDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Cinemapaymentsettings save(@RequestBody Cinemapaymentsettings cinemapaymentsettings) {
        cinemapaymentsettingsDao.save(cinemapaymentsettings);

        return cinemapaymentsettings;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Cinemapaymentsettings get(@PathVariable Long id) {
        return cinemapaymentsettingsDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Cinemapaymentsettings update(@RequestBody Cinemapaymentsettings cinemapaymentsettings) {
        cinemapaymentsettingsDao.update(cinemapaymentsettings);

        return cinemapaymentsettings;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return cinemapaymentsettingsDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Cinemapaymentsettings> list(PageTableRequest request) {
                List<Cinemapaymentsettings> cinemapaymentsettingsList = cinemapaymentsettingsDao.list(request.getParams(), request.getOffset(), request.getLimit());
                // 将查询到的appId和appSecret去除空格
                for (Cinemapaymentsettings cinemapaymentsettings : cinemapaymentsettingsList) {
                    cinemapaymentsettings.setAppId(cinemapaymentsettings.getAppId().replace(" ", ""));
                    cinemapaymentsettings.setAppSecret(cinemapaymentsettings.getAppSecret().replace(" ", ""));
                }
                return cinemapaymentsettingsList;
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        cinemapaymentsettingsDao.delete(id);
    }
}
