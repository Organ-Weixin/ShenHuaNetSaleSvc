package com.boot.security.server.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.dao.CoupondistributionrecordDao;
import com.boot.security.server.dao.TicketusersDao;
import com.boot.security.server.model.Coupondistributionrecord;
import com.boot.security.server.model.Coupons;
import com.boot.security.server.model.CouponsStatusEnum;
import com.boot.security.server.model.Couponsgroup;
import com.boot.security.server.model.Membercard;
import com.boot.security.server.model.SysUser;
import com.boot.security.server.model.Ticketusers;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableResponse;
import com.boot.security.server.service.impl.CouponsServiceImpl;
import com.boot.security.server.service.impl.CouponsgroupServiceImpl;
import com.boot.security.server.service.impl.MemberCardServiceImpl;
import com.boot.security.server.utils.UserUtil;
import com.google.gson.Gson;
import com.sun.org.apache.bcel.internal.generic.NEW;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/coupondistributionrecords")
public class CoupondistributionrecordController {

    @Autowired
    private CoupondistributionrecordDao coupondistributionrecordDao;
    @Autowired
    private CouponsServiceImpl couponsService;
    @Autowired
    private TicketusersDao ticketusersDao;
    @Autowired
    private MemberCardServiceImpl memberCardService;
    @Autowired
    private CouponsgroupServiceImpl couponsgroupService;
    @Resource
    private PlatformTransactionManager transactionManager;
    
    @PostMapping
    @ApiOperation(value = "保存")
    public Coupondistributionrecord save(@RequestBody Coupondistributionrecord coupondistributionrecord,HttpServletRequest request) throws ParseException {
    	//获取当前登陆人信息
    	SysUser sysuser = UserUtil.getLoginUser();
    	
    	Couponsgroup couponsgroup = couponsgroupService.getByGroupCode(coupondistributionrecord.getGroupCode());
    	List<Ticketusers> customerList = new ArrayList<Ticketusers>();
    	//根据顾客类型获取顾客列表
    	Map params = new HashMap();
    	List<String> openIDs = new ArrayList<>();
    	//所有顾客
    	if(coupondistributionrecord.getCustomerType()==1){
    		params.put("IsActive", "");
    		params.put("CinemaCode",sysuser.getCinemaCode());
    		customerList = ticketusersDao.getTicketusers(params);
    		for(int i=0; i<customerList.size();i++){
    			openIDs.add(customerList.get(i).getOpenID());
    		}
    		System.out.println("params"+new Gson().toJson(params));
    		System.out.println("所有顾客"+new Gson().toJson(customerList));
    	}
    	
    	//会员
    	if(coupondistributionrecord.getCustomerType()==2){
    		System.out.println("cinemacodes："+sysuser.getCinemaCode());
    		List<Membercard> membercardList = memberCardService.getByCinemaCodes(sysuser.getCinemaCode());
    		System.out.println("membercardList:"+new Gson().toJson(membercardList));
    		for(int i=0; i<membercardList.size();i++){
    			openIDs.add(membercardList.get(i).getOpenId());
    		}
    		System.out.println("会员"+new Gson().toJson(membercardList));
    	}
    	
    	//活跃用户
    	if(coupondistributionrecord.getCustomerType()==3){
    		System.out.println("活跃用户");
    		params.put("IsActive", "1");
    		params.put("CinemaCode",sysuser.getCinemaCode());
    		customerList = ticketusersDao.getTicketusers(params);
    		for(int i=0; i<customerList.size();i++){
    			openIDs.add(customerList.get(i).getOpenID());
    		}
    		System.out.println("活跃用户"+new Gson().toJson(customerList));
    	}
    	
    	//非活跃用户
    	if(coupondistributionrecord.getCustomerType()==4){
    		params.put("IsActive", "0");
    		params.put("CinemaCode",sysuser.getCinemaCode());
    		customerList = ticketusersDao.getTicketusers(params);
    		for(int i=0; i<customerList.size();i++){
    			openIDs.add(customerList.get(i).getOpenID());
    		}
    		System.out.println("非活跃用户"+new Gson().toJson(customerList));
    	}
    	//指定用户
    	if(coupondistributionrecord.getOpenID()!=null&&coupondistributionrecord.getOpenID()!=""){
    		params = new HashMap<>();
    		params.put("CinemaCode",sysuser.getCinemaCode());
    		params.put("MobilePhone", coupondistributionrecord.getOpenID());
    		List<Ticketusers> ticketusersList = ticketusersDao.getTicketusers(params);
    		String openid = "";
    		for(Ticketusers ticketusers :ticketusersList){
    			openid += ticketusers.getOpenID()+",";
    			openIDs.add(ticketusers.getOpenID());
        	}
    		if(coupondistributionrecord.getOpenID()!=null&&coupondistributionrecord.getOpenID()!=""){
    			coupondistributionrecord.setOpenID(openid.substring(0,openid.length()-1));
    		}
    		System.out.println("指定用户"+new Gson().toJson(ticketusersList));
    	}
    	
    	DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = transactionManager.getTransaction(defaultTransactionDefinition);
    	if(openIDs.size()>0){
    		try {
    			for(int i=0; i<coupondistributionrecord.getIssuedNumber(); i++){
/*        			Coupons coupons = couponsService.getById(couponsList.get(i).getId());
        			if(couponsgroup.getValidityType()==2){
        				Calendar c = Calendar.getInstance();
        				c.add(Calendar.DAY_OF_MONTH, couponsgroup.getEffectiveDays());
        				coupons.setEffectiveDate(new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(c.getTime())));
        				c.add(Calendar.DAY_OF_MONTH, couponsgroup.getValidityDays());
        				coupons.setExpireDate(new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(c.getTime())));
            		}
        			coupons.setReceiveDate(new Date());
        			coupons.setOpenID(openIDs.get(i%openIDs.size()));
        			coupons.setStatus(CouponsStatusEnum.Fetched.getStatusCode());
        			couponsService.update(coupons);*/
    				Coupons coupons = new Coupons();
					//优惠券编码--13位时间戳加5位随机数
					String couponsCode = String.valueOf(new Date().getTime());
		    		couponsCode+=(int)((Math.random()*9+1)*10000);
					coupons.setCouponsCode(couponsCode);
					coupons.setCinemaCode(sysuser.getCinemaCode());
					coupons.setCouponsName(couponsgroup.getCouponsName());
					coupons.setGroupCode(couponsgroup.getGroupCode());
					coupons.setStatus(CouponsStatusEnum.Fetched.getStatusCode());
					coupons.setOpenID(openIDs.get(i%openIDs.size()));
					coupons.setCreateDate(new Date());
					couponsService.save(coupons);
        		}
    			//已发放数量
    			couponsgroup.setIssuedNumber(couponsgroup.getIssuedNumber()+coupondistributionrecord.getIssuedNumber());
    			//已领取数量
    			couponsgroup.setFetchNumber(couponsgroup.getFetchNumber()+coupondistributionrecord.getIssuedNumber());
    			//剩余数量
    			couponsgroup.setRemainingNumber(couponsgroup.getRemainingNumber()-coupondistributionrecord.getIssuedNumber());
    			couponsgroup.setUpdateDate(new Date());
    			couponsgroupService.update(couponsgroup);
    			transactionManager.commit(status);
    			coupondistributionrecord.setStatus(1);
    			coupondistributionrecord.setCinemaCode(sysuser.getCinemaCode());
			} catch (Exception e) {
				transactionManager.rollback(status);
				coupondistributionrecord.setIssuedNumber(0);
				coupondistributionrecord.setStatus(0);
				coupondistributionrecord.setCinemaCode(sysuser.getCinemaCode());
				e.printStackTrace();
			}
    	}else{
    		coupondistributionrecord.setCinemaCode(sysuser.getCinemaCode());
    		coupondistributionrecord.setIssuedNumber(0);
    		coupondistributionrecord.setStatus(0);
    	}
        coupondistributionrecordDao.save(coupondistributionrecord);

        return coupondistributionrecord;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public Coupondistributionrecord get(@PathVariable Long id) {
        return coupondistributionrecordDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public Coupondistributionrecord update(@RequestBody Coupondistributionrecord coupondistributionrecord) {
        coupondistributionrecordDao.update(coupondistributionrecord);

        return coupondistributionrecord;
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
                return coupondistributionrecordDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<Coupondistributionrecord> list(PageTableRequest request) {
                return coupondistributionrecordDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        coupondistributionrecordDao.delete(id);
    }
}
