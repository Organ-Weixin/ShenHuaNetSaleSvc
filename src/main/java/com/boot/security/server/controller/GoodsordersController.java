package com.boot.security.server.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.Cinemamessage;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.CinemamessageServiceImpl;
import com.boot.security.server.utils.SendMobileMessage;
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
import com.boot.security.server.dao.GoodsordersDao;
import com.boot.security.server.model.Goodsorders;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/goodsorderss")
public class GoodsordersController {

    @Autowired
    private GoodsordersDao goodsordersDao;

    @Autowired
    private CinemaServiceImpl _cinemaService;

    @Autowired
    private CinemamessageServiceImpl cinemamessageService;

    SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");

    @PostMapping
    @ApiOperation(value = "保存")
    public Goodsorders save(@RequestBody Goodsorders goodsorders) {
        goodsordersDao.save(goodsorders);

        return goodsorders;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Goodsorders get(@PathVariable Long id) {
        return goodsordersDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Goodsorders update(@RequestBody Goodsorders goodsorders) {
        goodsordersDao.update(goodsorders);

        return goodsorders;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return goodsordersDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Goodsorders> list(PageTableRequest request) {
                return goodsordersDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        goodsordersDao.delete(id);
    }

    @GetMapping("/refresh/{cinemaCode}")
    public Map refresh(@PathVariable Long cinemaCode) {
        HashMap resultMap = new HashMap<>();
        //展示两天之内的订单
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,-2);
        Date d=cal.getTime();
        List<Goodsorders> orderList = goodsordersDao.getRecentOrderByCinemaCode(cinemaCode, d);

        resultMap.put("totalCount",orderList.size());
        resultMap.put("orderList",orderList);

        return resultMap;
    }

    @GetMapping("/arriveOK/{id}")
    public Map arriveOK(@PathVariable Long id) {

        HashMap<Object, Object> resultMap = new HashMap<>();

        //更新订单状态为已配送完毕
        goodsordersDao.updateOrderStatus(id,10);

        //发送短信提醒客户取餐
        try{
            Goodsorders goodsorders=goodsordersDao.getById(id);
            Cinemamessage cinemamessage=cinemamessageService.getByMessageType("2");
            Cinema cinema = _cinemaService.getByCinemaCode(goodsorders.getCinemaCode());
            String batchNum=UUID.randomUUID().toString().replace("-","");
            String smsContent=cinema.getSmsSignId() + cinemamessage.getMessageContent();
            SendMobileMessage.sendMessage(cinema.getSmsAccount(),cinema.getSmsPwd(), goodsorders.getMobilePhone(), smsContent, batchNum);
            resultMap.put("mussage","success");
        }catch (Exception e) {
            resultMap.put("message","success");
        }

        return resultMap;
    }

}
