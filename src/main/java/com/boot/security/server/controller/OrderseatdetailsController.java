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
import com.boot.security.server.dao.OrderseatdetailsDao;
import com.boot.security.server.model.Orderseatdetails;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/orderseatdetailss")
public class OrderseatdetailsController {

    @Autowired
    private OrderseatdetailsDao orderseatdetailsDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Orderseatdetails save(@RequestBody Orderseatdetails orderseatdetails) {
        orderseatdetailsDao.save(orderseatdetails);

        return orderseatdetails;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Orderseatdetails get(@PathVariable Long id) {
        return orderseatdetailsDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Orderseatdetails update(@RequestBody Orderseatdetails orderseatdetails) {
        orderseatdetailsDao.update(orderseatdetails);

        return orderseatdetails;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return orderseatdetailsDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Orderseatdetails> list(PageTableRequest request) {
                return orderseatdetailsDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        orderseatdetailsDao.delete(id);
    }
}
