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
import com.boot.security.server.dao.OrdersDao;
import com.boot.security.server.model.Orders;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/orderss")
public class OrdersController {

    @Autowired
    private OrdersDao ordersDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Orders save(@RequestBody Orders orders) {
        ordersDao.save(orders);

        return orders;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Orders get(@PathVariable Long id) {
        return ordersDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Orders update(@RequestBody Orders orders) {
        ordersDao.update(orders);

        return orders;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return ordersDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Orders> list(PageTableRequest request) {
                return ordersDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        ordersDao.delete(id);
    }
}
