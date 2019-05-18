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
import com.boot.security.server.service.impl.RoomgiftServiceImpl;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.model.Roomgift;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/roomgifts")
public class RoomgiftController {

    @Autowired
    private RoomgiftServiceImpl roomgiftservice;

    @PostMapping
    @ApiOperation(value = "保存")
    public Roomgift save(@RequestBody Roomgift roomgift) {
    	roomgiftservice.save(roomgift);

        return roomgift;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Roomgift get(@PathVariable Long id) {
        return roomgiftservice.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Roomgift update(@RequestBody Roomgift roomgift) {
    	roomgiftservice.update(roomgift);

        return roomgift;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return roomgiftservice.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Roomgift> list(PageTableRequest request) {
                return roomgiftservice.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
    	roomgiftservice.delete(id);
    }
}
