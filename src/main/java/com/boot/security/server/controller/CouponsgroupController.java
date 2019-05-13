package com.boot.security.server.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
import com.boot.security.server.service.impl.CouponsServiceImpl;
import com.boot.security.server.service.impl.CouponsgroupServiceImpl;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.dao.CouponsDao;
import com.boot.security.server.dao.CouponsgroupDao;
import com.boot.security.server.model.CouponGroupStatusEnum;
import com.boot.security.server.model.Coupons;
import com.boot.security.server.model.CouponsStatusEnum;
import com.boot.security.server.model.Couponsgroup;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/couponsgroups")
public class CouponsgroupController {

    @Autowired
    private CouponsgroupDao couponsgroupDao;
    @Autowired
    private CouponsDao couponsDao;
    @Autowired
    private CouponsServiceImpl couponsService;
    @Autowired
    private CouponsgroupServiceImpl couponsgroupService;

    @PostMapping
    @ApiOperation(value = "保存")
    public Couponsgroup save(@RequestBody Couponsgroup couponsgroup) throws ParseException {
    	couponsgroup.setEffectiveDate(couponsgroup.getEffectiveDate());
    	couponsgroup.setExpireDate(couponsgroup.getExpireDate());
    	couponsgroup.setGroupCode(getCharAndNumr(8));
    	couponsgroup.setStatus(CouponGroupStatusEnum.UnEnabled.getStatusCode());
    	couponsgroup.setFetchNumber(0);
    	couponsgroup.setRemainingNumber(couponsgroup.getCouponsNumber());
    	couponsgroup.setUsedNumber(0);
    	for(int i=0;i<couponsgroup.getCouponsNumber();i++){
    		Coupons coupons = new Coupons();
    		coupons.setCouponsCode(getCharAndNumr(10));
        	coupons.setCouponsName(couponsgroup.getCouponsName());
        	coupons.setEffectiveDate(couponsgroup.getEffectiveDate());
        	coupons.setExpireDate(couponsgroup.getEffectiveDate());
        	coupons.setGroupCode(couponsgroup.getGroupCode());
        	coupons.setStatus(CouponsStatusEnum.Created.getStatusCode());
    		couponsDao.save(coupons);
    	}
        couponsgroupDao.save(couponsgroup);
        return couponsgroup;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Couponsgroup get(@PathVariable Long id) {
        return couponsgroupDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Couponsgroup update(@RequestBody Couponsgroup couponsgroup) {
        couponsgroupDao.update(couponsgroup);

        return couponsgroup;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
    	String CinemaCodes = request.getParams().get("CinemaCodesList").toString();
    	String CinemaCodesList []  = CinemaCodes.split(",");
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return couponsgroupDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Couponsgroup> list(PageTableRequest request) {
            	System.out.println("接收到的cinemacodes="+request.getParams().get("CinemaCodes"));
            	if(request.getParams().get("CinemaCodes")!=null&&request.getParams().get("CinemaCodes").toString()!=""&&CinemaCodes.contains(request.getParams().get("CinemaCodes").toString())){
            		return couponsgroupDao.list(request.getParams(), request.getOffset(), request.getLimit());
            	}else{
            		System.out.println("没有接收到cinemacodes");
            		//传过去不存在的影院编码，清空list列表
            		request.getParams().put("CinemaCodes", "00000000");
            		List<Couponsgroup> list = couponsgroupDao.list(request.getParams(), request.getOffset(), request.getLimit());
                	for(int i=0; i<CinemaCodesList.length; i++){
                		list.addAll(couponsgroupService.getByCinemaCode(CinemaCodesList[i]));
                	}
                	return list;
            	}
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
    	Couponsgroup couponsgroup = couponsgroupDao.getById(id);
    	couponsService.deleteByGroupCode(couponsgroup.getGroupCode());
        couponsgroupDao.delete(id);
    }
    
    @RequestMapping("/changeStatus")
    @ApiOperation(value = "改变优惠券状态")
    public int changeStatus(@RequestParam("status") Integer status,@RequestParam("id") Long id){
    	return couponsgroupService.changeStatus(status, id);
    }
    
    public static String getCharAndNumr(int length) {
    	  String val = "";
    	  Random random = new Random();
    	  for (int i = 0; i < length; i++) {
    	   // 输出字母还是数字
    	   String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; 
    	   // 字符串
    	   if ("char".equalsIgnoreCase(charOrNum)) {
    	    // 取得大写字母还是小写字母
    	    int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; 
    	    val += (char) (choice + random.nextInt(26));
    	   } else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
    	    val += String.valueOf(random.nextInt(10));
    	   }
    	  }
    	  return val;
    	 }
    public static void main(String[] args) {
    	System.out.println(getCharAndNumr(10));
	}
}
