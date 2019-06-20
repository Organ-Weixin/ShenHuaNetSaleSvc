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
import com.boot.security.server.dao.RoomgiftsendDao;
import com.boot.security.server.model.Roomgiftsend;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/roomgiftsends")
public class RoomgiftsendController {

    @Autowired
    private RoomgiftsendDao roomgiftsendDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Roomgiftsend save(@RequestBody Roomgiftsend roomgiftsend) {
        roomgiftsendDao.save(roomgiftsend);

        return roomgiftsend;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Roomgiftsend get(@PathVariable Long id) {
        return roomgiftsendDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Roomgiftsend update(@RequestBody Roomgiftsend roomgiftsend) {
        roomgiftsendDao.update(roomgiftsend);

        return roomgiftsend;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return roomgiftsendDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Roomgiftsend> list(PageTableRequest request) {
                return roomgiftsendDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        roomgiftsendDao.delete(id);
    }
}
