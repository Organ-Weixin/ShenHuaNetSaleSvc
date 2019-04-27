package com.boot.security.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableResponse;
import com.boot.security.server.service.impl.OrderServiceImpl;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.model.Orders;
import com.boot.security.server.model.Userinfo;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/orderss")
public class OrdersController {

    @Autowired
    OrderServiceImpl ordersS;


    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Orders get(@PathVariable Long id) {
    	System.out.println(ordersS.getById(id));
        return ordersS.getById(id);
    }
    
    @RequestMapping("/getCompany")
    public List<Userinfo> getCompany(){
    	return ordersS.queryCompany();
    }
    
    @RequestMapping("/queryOrders")
    public List<Orders> queryOrders(){
    	List<Orders> list = ordersS.queryOrders();
    	return list;
    }

    @RequestMapping("/list")
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return ordersS.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Orders> list(PageTableRequest request) {
                return ordersS.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
    	ordersS.delete(id);
    }
}
