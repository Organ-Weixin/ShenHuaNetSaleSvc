package com.boot.security.server.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.boot.security.server.utils.UserUtil;
import com.boot.security.server.dao.GoodsDao;
import com.boot.security.server.dao.GoodscomponentsDao;
import com.boot.security.server.model.Goods;
import com.boot.security.server.model.Goodscomponents;
import com.boot.security.server.model.SysUser;

import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/goodscomponentss")
public class GoodscomponentsController {

    @Autowired
    private GoodscomponentsDao goodscomponentsDao;
    @Autowired
    private GoodsDao goodsDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public Goodscomponents save(@RequestBody Goodscomponents goodscomponents) {
    	String str = new SimpleDateFormat("yyyymmddHHmmss").format(new Date());
    	int num = (int)((Math.random()*9+1)*100);
    	str = str +String.valueOf(num);
    	String[] countlist = goodscomponents.getGoodsCount().split(",");
    	
    	JSONArray jsonArray = JSONArray.fromObject(goodscomponents.getGoodsCode());
    	for(int i=0; i<jsonArray.size(); i++){
    		JSONObject obj = JSONObject.fromObject(jsonArray.get(i));
    		goodscomponents.setPackageCode(str);
    		goodscomponents.setGoodsCode(obj.get("goodCode").toString());
    		goodscomponents.setGoodsName(obj.get("goodsName").toString());
    		goodscomponents.setGoodsStandardPrice(Double.valueOf(obj.get("standardPrice").toString()));
    		goodscomponents.setGoodsSettlePrice(Double.valueOf(obj.get("settlePrice").toString()));
    		goodscomponents.setGoodsCount(countlist[i]);
    		goodscomponentsDao.save(goodscomponents);	//保存到套餐表
    	}
        
    	Goods goods = new Goods();
    	goods.setCinemaCode(goodscomponents.getCinemaCode());
    	goods.setGoodsCode(str);
    	goods.setGoodsName(goodscomponents.getPackageName());
    	goods.setGoodsType(goodscomponents.getGoodsType());
    	goods.setStandardPrice(goodscomponents.getPackageStandardPrice());
    	goods.setSettlePrice(goodscomponents.getPackageSettlePrice());
    	goods.setGoodsPic(goodscomponents.getPackagePic());
    	goods.setShowSeqNo(goodscomponents.getSort());
    	goods.setGoodsStatus(goodscomponents.getStatus());
    	goods.setIsRecommand(1);
    	goods.setIsPackage(1);
    	goods.setUpdated(new Date());
    	goodsDao.save(goods);	//保存到卖品表
    	
        return goodscomponents;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Goodscomponents get(@PathVariable Long id) {
        return goodscomponentsDao.getById(id);
    }
    
    @GetMapping("/getByPackageCode/{cinemaCode}/{packageCode}")
    @ApiOperation(value = "根据套餐编码获取")
    public List<Goodscomponents> getByPackageCode(@PathVariable String cinemaCode, @PathVariable String packageCode) {
        return goodscomponentsDao.getByPackageCode(cinemaCode, packageCode);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Goodscomponents update(@RequestBody Goodscomponents goodscomponents) {
    	String cinemaCode = goodscomponents.getCinemaCode();
    	String packageCode = goodscomponents.getPackageCode();
    	String packageName = goodscomponents.getPackageName();
    	String packagePic = goodscomponents.getPackagePic();
    	Double packageStandardPrice = goodscomponents.getPackageStandardPrice();
    	Double packageSettlePrice = goodscomponents.getPackageSettlePrice();
    	String recommend = goodscomponents.getRecommendCode();
    	Integer status = goodscomponents.getStatus();
    	Integer sort = goodscomponents.getSort();
    	
    	goodscomponentsDao.deleteByPackageCode(cinemaCode, packageCode);
    	JSONArray jsonArray = JSONArray.fromObject(goodscomponents.getGoodsCode());
    	for(int i=0; i<jsonArray.size(); i++){
    		JSONObject obj = JSONObject.fromObject(jsonArray.get(i));
    		goodscomponents.setCinemaCode(cinemaCode);
    		goodscomponents.setPackageCode(packageCode);
    		goodscomponents.setPackageName(packageName);
    		goodscomponents.setPackagePic(packagePic);
    		goodscomponents.setGoodsCode(obj.get("goodCode").toString());
    		goodscomponents.setGoodsName(obj.get("goodsName").toString());
    		goodscomponents.setGoodsCount(obj.get("count").toString());
    		goodscomponents.setGoodsStandardPrice(Double.valueOf(obj.get("standardPrice").toString()));
    		goodscomponents.setGoodsSettlePrice(Double.valueOf(obj.get("settlePrice").toString()));
    		goodscomponents.setPackageStandardPrice(packageStandardPrice);
    		goodscomponents.setPackageSettlePrice(packageSettlePrice);
    		goodscomponents.setRecommendCode(recommend);
    		goodscomponents.setStatus(status);
    		goodscomponents.setSort(sort);
    		goodscomponentsDao.save(goodscomponents);
    	}
//        goodscomponentsDao.update(goodscomponents);

        return goodscomponents;
    }

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
                return goodscomponentsDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Goodscomponents> list(PageTableRequest request) {
                return goodscomponentsDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        goodscomponentsDao.delete(id);
    }
    
    @DeleteMapping("/deleteByPackageCode/{cinemaCode}/{packageCode}")
    @ApiOperation(value = "根据套餐编码删除")
    public void deleteByPackageCode(@PathVariable String cinemaCode, @PathVariable String packageCode) {
        goodscomponentsDao.deleteByPackageCode(cinemaCode, packageCode);
    }
}
