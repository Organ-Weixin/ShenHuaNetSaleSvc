package com.boot.security.server.controller;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableResponse;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.utils.ExcelUtil;
import com.boot.security.server.utils.UserUtil;
import com.boot.security.server.dao.GoodsorderdetailsviewDao;
import com.boot.security.server.dao.GoodsordersDao;
import com.boot.security.server.model.GoodsOrderStatusEnum;
import com.boot.security.server.model.Goodsorders;
import com.boot.security.server.model.SysUser;
import com.boot.security.server.modelView.Goodsorderdetailsview;

import io.swagger.annotations.ApiOperation;
/**
 * 后台管理--卖品订单管理
 */
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
    
    @PostMapping("/exportExcel/{orderStatus}")
    @ApiOperation(value = "导出数据到excel")
    public int exportExcel(@PathVariable Integer orderStatus,HttpServletResponse response) {
    	//获取当前登陆人信息
    	SysUser sysuser = UserUtil.getLoginUser();
    	Map<String,Object> param = new HashMap<String,Object>();
    	param.put("id", sysuser.getId());
    	param.put("roleId", sysuser.getRoleId());
    	if(orderStatus == 0){
    		orderStatus = null;
    	}
    	param.put("OrderStatus", orderStatus);
    	
    	int count = goodsorderdetailsviewDao.count(param);
    	List<Goodsorderdetailsview> list = goodsorderdetailsviewDao.list(param, 0, count);
    	if (list != null) {
    		String fileName = "卖品订单管理";
			String[] headers = {"#","影院名称","取单号","卖品名称","数量","销售金额","小计","创建时间","手机号码","状态"};
			
			List<Object[]> datas = new ArrayList<>(list.size());
			for (Goodsorderdetailsview goodsview : list) {
				Object[] objects = new Object[headers.length];
				int i=0;
				objects[0] = i++;
				objects[1] = goodsview.getCinemaName();
				objects[2] = goodsview.getPickUpCode();
				objects[3] = goodsview.getGoodsName();
				objects[4] = goodsview.getGoodsCount();
				objects[5] = goodsview.getSettlePrice();
				objects[6] = goodsview.getSubTotalSettleAmount();
				objects[7] = goodsview.getCreated();
				objects[8] = goodsview.getMobilePhone();
				objects[9] = GoodsOrderStatusEnum.getNameByCode(goodsview.getOrderStatus());
				 
				datas.add(objects);
			}
			
			ExcelUtil.excelExport(fileName, headers,datas, response);
		}
    	return count;
    }
}
