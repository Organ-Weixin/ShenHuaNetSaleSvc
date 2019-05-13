package com.boot.security.server.controller;
/**
 * 后台管理--卖品订单管理
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableResponse;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.utils.UserUtil;
import com.boot.security.server.dao.GoodsorderdetailsviewDao;
import com.boot.security.server.dao.GoodsordersDao;
import com.boot.security.server.model.Goodsorders;
import com.boot.security.server.model.SysUser;
import com.boot.security.server.modelView.Goodsorderdetailsview;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/goodsorderdetailsviews")
public class GoodsorderdetailsviewController {

    @Autowired
    private GoodsorderdetailsviewDao goodsorderdetailsviewDao;
    @Autowired
    private GoodsordersDao goodsordersDao;

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
    	//获取当前登陆人信息
    	SysUser sysuser = UserUtil.getLoginUser();
    	request.getParams().put("id", sysuser.getId());
    	request.getParams().put("roleId", sysuser.getRoleId());
    	
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return goodsorderdetailsviewDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Goodsorderdetailsview> list(PageTableRequest request) {
                return goodsorderdetailsviewDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }
    
    @GetMapping("/updateStatus/{orderId}")
    @ApiOperation(value = "修改卖品订单状态")
    public int updateStatus(@PathVariable Long orderId) {
    	Goodsorders goodsorder = goodsordersDao.getById(orderId);
    	goodsorder.setOrderStatus(10);
    	
        return goodsordersDao.update(goodsorder);
    }
    
}
