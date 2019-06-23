package com.boot.security.server.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.security.server.dao.CouponsDao;
import com.boot.security.server.dao.CouponsgroupDao;
import com.boot.security.server.model.Coupons;
import com.boot.security.server.model.CouponsStatusEnum;
import com.boot.security.server.model.CouponsView;
import com.boot.security.server.model.Goodsorders;
import com.boot.security.server.model.Orders;
import com.boot.security.server.service.CouponsService;
import com.boot.security.server.utils.DoubleUtil;

@Service
public class CouponsServiceImpl implements CouponsService{

	private static final Logger log = LoggerFactory.getLogger("adminLogger");
	@Autowired
	private CouponsDao couponsdao;
	@Autowired
	private CouponsgroupDao couponsgroupdao;
	
	@Override
	public Coupons getByCouponsCode(String couponscode) {
		
		return couponsdao.getByCouponsCode(couponscode);
	}

	@Override
	public int update(Coupons coupons) {
		
		return couponsdao.update(coupons);
	}

	@Override
	public int deleteByGroupCode(String groupcode) {
		return couponsdao.deleteByGroupCode(groupcode);
	}

	@Override
	public Coupons getById(Long id) {
		return couponsdao.getById(id);
	}

	@Override
	public List<Coupons> getByOpenID(String openid) {
		return couponsdao.getByOpenID(openid);
	}

	@Override
	public List<Coupons> getByGroupCode(String groupcode) {
		return couponsdao.getByGroupCode(groupcode);
	}

	@Override
	public List<Coupons> getCanUseByGroupCode(String groupcode) {
		return couponsdao.getCanUseByGroupCode(groupcode);
	}

	@Override
	public CouponsView getWithCouponsCode(String couponscode) {
		// TODO Auto-generated method stub
		CouponsView couponsview=new CouponsView();
		couponsview.setCoupons(couponsdao.getByCouponsCode(couponscode));
		if(couponsview.getCoupons()!=null){
			couponsview.setCouponsgroup(couponsgroupdao.getByGroupCode(couponsview.getCoupons().getGroupCode()));
		}
		return couponsview;
	}

	@Override
	public int update(CouponsView couponsview) {
		// TODO Auto-generated method stub
		couponsdao.update(couponsview.getCoupons());
		couponsgroupdao.update(couponsview.getCouponsgroup());
		return 1;//暂时
	}

	@Override
	public int changeStatus(String couponscode) {
		// TODO Auto-generated method stub
		return couponsdao.changeStatus(couponscode);
	}

	@Override
	public int changePast(Integer status) {
		// TODO Auto-generated method stub
		return couponsdao.changePast(status);
	}

	@Override
	public List<Coupons> getUserCoupons(String openid, Integer status) {
		// TODO Auto-generated method stub
		return couponsdao.getUserCoupons(openid, status);
	}

	@Override
	public List<Coupons> getByGroupCodeAndOpenId(String groupcode, String openid, Integer status) {
		// TODO Auto-generated method stub
		return couponsdao.getByGroupCodeAndOpenId(groupcode, openid, status);
	}

	@Override
	public int save(Coupons Coupons) {
		// TODO Auto-generated method stub
		return couponsdao.save(Coupons);
	}
	//把优惠价更新到订单
	public Orders updateCouponsPricetoOrder(Orders order,String CouponsCode){
		if(!"".equals(CouponsCode)&&CouponsCode!=null&&!"null".equals(CouponsCode)){
			CouponsView couponsview = getWithCouponsCode(CouponsCode);
			if(couponsview.getCoupons()!=null){
				boolean ifCanUse = true;
				//优惠券状态不对
				if(couponsview.getCoupons().getStatus()!=CouponsStatusEnum.Fetched.getStatusCode()){
					ifCanUse=false;
				}
				//如果是部分门店可用，并且当前订单的影院不在可用门店里面
				if(couponsview.getCouponsgroup().getCanUseCinemaType()==2){
					if(couponsview.getCouponsgroup().getCinemaCodes().indexOf(order.getCinemaCode())==-1){
						ifCanUse = false;
					}
				}
				//如果是代金券并且门槛金额大于当前订单总销售价
				if(couponsview.getCouponsgroup().getCouponsType()==1&&couponsview.getCouponsgroup().getThresholdAmount()>=order.getTotalSalePrice()){
					ifCanUse=false;
				}
				//如果减免类型是影片
				if(ifCanUse && couponsview.getCouponsgroup().getReductionType()==1){
					order.setCouponsCode(couponsview.getCoupons().getCouponsCode());
					order.setCouponsPrice(couponsview.getCouponsgroup().getReductionPrice());
                }else{
                	order.setCouponsPrice(0D);
                }
			}else{
				order.setCouponsPrice(0D);
			}
		}else{
			order.setCouponsPrice(0D);
		}   
		Double TotalSalePrice=DoubleUtil.sub(order.getTotalSalePrice(), order.getCouponsPrice());
		System.out.println("实际支付金额="+TotalSalePrice);
		order.setTotalSalePrice(TotalSalePrice);
		return order;
	}
    public Goodsorders updateCouponsPricetoGoodsOrder(Goodsorders order,String CouponsCode){
    	if(!"".equals(CouponsCode)&&CouponsCode!=null&&!"null".equals(CouponsCode)){
			CouponsView couponsview = getWithCouponsCode(CouponsCode);
			if(couponsview.getCoupons()!=null){
				boolean ifCanUse = true;
				//优惠券状态不对
				if(couponsview.getCoupons().getStatus()!=CouponsStatusEnum.Fetched.getStatusCode()){
					ifCanUse=false;
				}
				//如果是部分门店可用，并且当前订单的影院不在可用门店里面
				if(couponsview.getCouponsgroup().getCanUseCinemaType()==2){
					if(couponsview.getCouponsgroup().getCinemaCodes().indexOf(order.getCinemaCode())==-1){
						ifCanUse = false;
					}
				}
				//如果是代金券并且门槛金额大于当前订单总销售价
				if(couponsview.getCouponsgroup().getCouponsType()==1&&couponsview.getCouponsgroup().getThresholdAmount()>=order.getTotalSettlePrice()){
					ifCanUse=false;
				}
				//如果减免类型是卖品
				if(ifCanUse && couponsview.getCouponsgroup().getReductionType()==2){
					//如果到最后还是可以使用
					order.setCouponsCode(couponsview.getCoupons().getCouponsCode());
					order.setCouponsPrice(couponsview.getCouponsgroup().getReductionPrice());
				}else{
					order.setCouponsPrice(0D);//优惠券不可使用
				}
			}else{
				order.setCouponsPrice(0D);
			}
		}else{
			order.setCouponsPrice(0D);
		}
    	//卖品总结算价=总结算价+总服务费-优惠券金额
    	Double TotalSettlePrice=DoubleUtil.sub(DoubleUtil.add(order.getTotalSettlePrice(), order.getTotalFee()),order.getCouponsPrice());
    	order.setTotalSettlePrice(TotalSettlePrice);
    	return order;
	}

	@Override
	public List<Coupons> getUserCouponsByGroupCodes(String openid,Integer status,String groupcodes) {
		// TODO Auto-generated method stub
		return couponsdao.getUserCouponsByGroupCodes(openid, status, groupcodes);
	}
}
