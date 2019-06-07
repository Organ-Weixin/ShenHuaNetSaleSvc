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
import com.boot.security.server.service.impl.GoodscomponentsServiceImpl;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.api.core.NetSaleSvcCore;
import com.boot.security.server.api.core.QueryGoodsReply;
import com.boot.security.server.dao.GoodsDao;
import com.boot.security.server.model.Goods;
import com.boot.security.server.model.Goodscomponents;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/goodss")
public class GoodsController {

    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private GoodscomponentsServiceImpl goodscomponentsService;

    @PostMapping
    @ApiOperation(value = "保存")
    public Goods save(@RequestBody Goods goods) {
        goodsDao.save(goods);

        return goods;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Goods get(@PathVariable Long id) {
        return goodsDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Goods update(@RequestBody Goods goods) {
    	List<Goodscomponents> goodscomponentsList = goodscomponentsService.getByPackageCode(goods.getCinemaCode(), goods.getGoodsCode());
    	if(goods.getRecommendCode()==null||goods.getRecommendCode()==""){
    		goods.setIsRecommand(0);
    		if(goodscomponentsList.size()>0){
    			goodscomponentsService.deleteByPackageCode(goods.getCinemaCode(), goods.getGoodsCode());
    		}
    	}else{
    		goods.setIsRecommand(1);
    		Goodscomponents goodscomponents = new Goodscomponents();
    		goodscomponents.setCinemaCode(goods.getCinemaCode());
    		goodscomponents.setPackageCode(goods.getGoodsCode());
    		goodscomponents.setPackageName(goods.getGoodsName());
    		goodscomponents.setPackagePic(goods.getGoodsPic());
    		goodscomponents.setGoodsCode(goods.getGoodsCode());
    		goodscomponents.setGoodsName(goods.getGoodsName());
    		goodscomponents.setGoodsCount("1");
    		goodscomponents.setGoodsStandardPrice(goods.getStandardPrice());
    		goodscomponents.setGoodsSettlePrice(goods.getSettlePrice());
    		goodscomponents.setPackageStandardPrice(goods.getStandardPrice());
    		goodscomponents.setPackageSettlePrice(goods.getSettlePrice());
    		goodscomponents.setRecommendCode(goods.getRecommendCode());
    		goodscomponents.setStatus(1);
    		goodscomponentsService.save(goodscomponents);
    	}
        goodsDao.update(goods);

        return goods;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
    	
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return goodsDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Goods> list(PageTableRequest request) {
                return goodsDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        goodsDao.delete(id);
    }
    
    @RequestMapping("/getGoodsByCinemaCode")
    @ApiOperation(value = "获取对应影院卖品")
    public List<Goods> getGoodsByCinemaCode(@RequestParam("cinemacodes") String cinemacodes){
    	System.out.println("接收到cinemacodes为"+cinemacodes);
    	return goodsDao.getGoodsByCinemaCode(cinemacodes);
    }
    
    @PostMapping("/queryGoods/{cinemacode}")
    @ApiOperation(value = "重新获取影院卖品")
    public QueryGoodsReply queryGoods(@PathVariable String cinemacode){
    	String UserName = "MiniProgram";
    	String Password = "6BF477EBCC446F54E6512AFC0E976C41";
		QueryGoodsReply reply =NetSaleSvcCore.getInstance().QueryGoods(UserName, Password, cinemacode);
		
		return reply;
    	
    }
    
}
