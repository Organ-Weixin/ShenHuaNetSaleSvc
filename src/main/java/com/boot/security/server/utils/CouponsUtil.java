package com.boot.security.server.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.boot.security.server.model.CinemaTypeEnum;
import com.boot.security.server.model.CouponsStatusEnum;
import com.boot.security.server.model.CouponsView;
import com.boot.security.server.model.GoodsOrderView;
import com.boot.security.server.model.Goodsorderdetails;
import com.boot.security.server.model.OrderView;
import com.boot.security.server.model.Orderseatdetails;
import com.boot.security.server.model.Priceplan;
import com.boot.security.server.model.Sessioninfo;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.service.impl.CouponsServiceImpl;
import com.boot.security.server.service.impl.GoodsOrderServiceImpl;
import com.boot.security.server.service.impl.OrderServiceImpl;
import com.boot.security.server.service.impl.PriceplanServiceImpl;
import com.boot.security.server.service.impl.SessioninfoServiceImpl;
import com.boot.security.server.service.impl.UserCinemaViewServiceImpl;
import com.boot.security.server.service.impl.UserInfoServiceImpl;
import com.google.gson.Gson;

public class CouponsUtil {
	OrderServiceImpl orderService = SpringUtil.getBean(OrderServiceImpl.class);
	GoodsOrderServiceImpl goodsOrderService = SpringUtil.getBean(GoodsOrderServiceImpl.class);
	CouponsServiceImpl _couponsService = SpringUtil.getBean(CouponsServiceImpl.class);
	SessioninfoServiceImpl _sessioninfoService = SpringUtil.getBean(SessioninfoServiceImpl.class);
	PriceplanServiceImpl _priceplanService = SpringUtil.getBean(PriceplanServiceImpl.class);
	UserCinemaViewServiceImpl _userCinemaViewService = SpringUtil.getBean(UserCinemaViewServiceImpl.class);
	
	//region 判断优惠券是否可使用
	public boolean CouponsCanUse(CouponsView couponsview,String CinemaCode){
		System.out.println(new Gson().toJson(couponsview));
		System.out.println("getCanUsePeriodType"+couponsview.getCouponsgroup().getCanUsePeriodType());
		boolean ifCanUse = true;
		//优惠券状态不对
		if(couponsview.getCoupons().getStatus()!=CouponsStatusEnum.Fetched.getStatusCode()){
			ifCanUse=false;
		}
		// 不在有效期范围内
		if (couponsview.getCoupons().getEffectiveDate().getTime() > new Date().getTime()
				|| couponsview.getCoupons().getExpireDate().getTime() <= new Date().getTime()) {
			ifCanUse = false;
		}
		if (couponsview.getCouponsgroup().getCanUsePeriodType() == 2) {
			Calendar c = Calendar.getInstance();
			c.setTime(new Date());
			int weekday = c.get(Calendar.DAY_OF_WEEK);// 1周日，2周一，7周六
			//不在指定周几
			if (!couponsview.getCouponsgroup().getWeekDays().contains(String.valueOf(weekday))) {
				ifCanUse = false;
			}
			if(!couponsview.getCouponsgroup().getTimePeriod().equals(null)&&!couponsview.getCouponsgroup().getTimePeriod().equals(""))
			{
				String[] timeperiods=couponsview.getCouponsgroup().getTimePeriod().split(",");
				SimpleDateFormat dateFormater = new SimpleDateFormat("HHmm");
				boolean ifintimeperiod=false;
				for(String timeperiod:timeperiods){
					int stime= Integer.parseInt(timeperiod.split("-")[0].replace(":",""));
					int etime= Integer.parseInt(timeperiod.split("-")[1].replace(":",""));
					int date= Integer.parseInt(dateFormater.format(new Date()));
					if(date>stime&&date<etime){
						ifintimeperiod = true;
						break;
					}else
					{
						continue;
					}
				}
				//不在所有的可用时间段内
				if(!ifintimeperiod){ifCanUse = false;}
			}
		}
		//如果是部分门店可用，并且当前订单的影院不在可用门店里面
		if(couponsview.getCouponsgroup().getCanUseCinemaType()==2){
			if(couponsview.getCouponsgroup().getCinemaCodes().indexOf(CinemaCode)==-1){
				ifCanUse = false;
			}
		}
		return ifCanUse;
	}
	//endregion
	
	//region 统一进行会员卡支付优惠金额计算
	public Map<String,Double> getCouponsPrice(String CinemaCode, String LockOrderCode,String LocalOrderCode,String CouponsCodes){
		Double ticketCouponsPrice=0D;//影票优惠总金额
		Double goodsCouponsPrice=0D;//卖品优惠总金额
		Double realPayAmount=0D;//实际购票订单支付金额
		Double realGoodsPayAmount=0D;//实际卖品支付金额
		OrderView order = orderService.getOrderWidthLockOrderCode(CinemaCode, LockOrderCode);
		GoodsOrderView goodsOrder = goodsOrderService.getWithLocalOrderCode(CinemaCode,LocalOrderCode);
		//region 优惠券价格计算
		if(null!=CouponsCodes&&""!=CouponsCodes){
			String[] CouponsCodesArr=CouponsCodes.split(",");
			for(int i=0;i<CouponsCodesArr.length;i++){//为了设置到对应的座位上，这里用i循环
				String CouponsCode=CouponsCodesArr[i];
				if(!CouponsCode.equals("")&&!CouponsCode.equals(null)){
					CouponsView couponsview = _couponsService.getWithCouponsCode(CouponsCode);
					if(couponsview.getCoupons()!=null){
	                    boolean ifCanUse=CouponsCanUse(couponsview,CinemaCode);
						//如果减免类型是影片 并且购票订单存在
	                    if(order.getOrderBaseInfo()!=null&&order.getOrderSeatDetails().size()>0){
	                    	if(ifCanUse && couponsview.getCouponsgroup().getReductionType()==1&&order.getOrderBaseInfo().getFilmCode()!=null&&order.getOrderBaseInfo().getFilmCode()!="null"){
								if(!couponsview.getCouponsgroup().getFilmCodes().equals(null)&&!couponsview.getCouponsgroup().getFilmCodes().equals("")){
									if(couponsview.getCouponsgroup().getFilmCodes().indexOf(order.getOrderBaseInfo().getFilmCode())>-1){
										//当前优惠券可以使用，把券码和优惠价格更新到订单详细表
										order.getOrderSeatDetails().get(i).setConponCode(couponsview.getCoupons().getCouponsCode());
										order.getOrderSeatDetails().get(i).setConponPrice(couponsview.getCouponsgroup().getReductionPrice());
									}else{
										order.getOrderSeatDetails().get(i).setConponPrice(0D);//当前影片不在可优惠的影片列表
									}
								}else{
									//所有影片可用
									order.getOrderSeatDetails().get(i).setConponCode(couponsview.getCoupons().getCouponsCode());
									order.getOrderSeatDetails().get(i).setConponPrice(couponsview.getCouponsgroup().getReductionPrice());
								}
	                    }
						}
						//如果减免类型是卖品
						if(ifCanUse && couponsview.getCouponsgroup().getReductionType()==2&&goodsOrder.getOrderGoodsDetails()!=null&&goodsOrder.getOrderGoodsDetails().size()>0){
							if(!couponsview.getCouponsgroup().getGoodsCodes().equals(null)&&!couponsview.getCouponsgroup().getGoodsCodes().equals("")){
								//循环判断每个卖品是不是在可使用优惠的卖品里面
								for(Goodsorderdetails goodsdetail:goodsOrder.getOrderGoodsDetails()){
									if(couponsview.getCouponsgroup().getGoodsCodes().indexOf(goodsdetail.getGoodsCode())==-1){
										ifCanUse=false;
										goodsOrder.getOrderBaseInfo().setCouponsPrice(0D);
										break;
									}else{
										continue;
									}
								}
							}
							//如果到最后还是可以使用
							if(ifCanUse){
								//当前优惠券可以使用,把优惠券更新到卖品订单表
								goodsOrder.getOrderBaseInfo().setCouponsCode(couponsview.getCoupons().getCouponsCode());
								goodsOrder.getOrderBaseInfo().setCouponsPrice(couponsview.getCouponsgroup().getReductionPrice());
							}else{
								goodsOrder.getOrderBaseInfo().setCouponsPrice(0D);//优惠券不可使用
							}
						}else{
							//如果不满足影票优惠券并且购票订单存在，也不满足卖品优惠券并且卖品订单存在，则不用处理
						}
					}else{
					   //找不到优惠券，不用处理
					}
				}
			}
		}
		//endregion
		if(order.getOrderBaseInfo()!=null&&order.getOrderSeatDetails().size()>0){
			//region 购票价格计算（得到最终上报价，最终销售价，最终服务费）
			Double SubmitPrice;// 最终上报价格
			Double SalePrice;// 最终销售价格
			Double TicketFee;// 最终服务费
			int TicketCount = order.getOrderBaseInfo().getTicketCount();// 总票数
			Sessioninfo sessioninfo = _sessioninfoService.getBySessionCode(order.getOrderBaseInfo().getUserId(),
					order.getOrderBaseInfo().getCinemaCode(), order.getOrderBaseInfo().getSessionCode());
			List<Priceplan> priceplans = _priceplanService.getByCode(order.getOrderBaseInfo().getUserId(),
					order.getOrderBaseInfo().getCinemaCode(), order.getOrderBaseInfo().getFilmCode(),
					order.getOrderBaseInfo().getSessionCode());
			Usercinemaview usercinema=_userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(12L,order.getOrderBaseInfo().getCinemaCode());
			// 得到价格计划
			Priceplan priceplan = new Priceplan();
			if (priceplans.size() > 1) {
				priceplan = priceplans.stream().filter((Priceplan s) -> s.getType() == 1).collect(Collectors.toList())
						.get(0);
			} else if (priceplans.size() == 1) {
				priceplan = priceplans.get(0);
			}
			Double priceplanMemberPrice = null == priceplan.getMemberPrice() ? sessioninfo.getStandardPrice() : priceplan.getMemberPrice();
			//如果座位表中已有销售价，说明已设置会员卡折扣价
			if(order.getOrderSeatDetails().get(0).getSalePrice()!=null&&order.getOrderSeatDetails().get(0).getSalePrice()!=0){
				priceplanMemberPrice=order.getOrderSeatDetails().get(0).getSalePrice();
			}
			Double priceplanFee = null == priceplan.getTicketFee() ? 0 : priceplan.getTicketFee();
			Double priceplanAddFee = null == priceplan.getAddFee() ? 0 : priceplan.getAddFee();
			Double priceplanCinemaAllowance = null == priceplan.getCinemaAllowance() ? 0 : priceplan.getCinemaAllowance();
			Double basisSubmitPrice;//基础上报价格=标准价/最低价
			//System.out.println("====="+userCinema.getIsUseLowestPriceReport());
			if(usercinema.getIsUseLowestPriceReport()==null){
				usercinema.setIsUseLowestPriceReport(0);
			}
			if(usercinema.getIsUseLowestPriceReport()==1){
				basisSubmitPrice=sessioninfo.getLowestPrice();
			}else{
				basisSubmitPrice=sessioninfo.getStandardPrice();
			}
			//System.out.println("-----"+userCinema.getIsUseLowestPriceReport());
			if(usercinema.getCinemaType()==CinemaTypeEnum.ChenXing.getTypeCode()){
				//如果是辰星系统
				// 上报价=场次标准价+场次服务费+场次增值服务费
				SubmitPrice = basisSubmitPrice + sessioninfo.getTicketFee()+sessioninfo.getAddFee();
				// 服务费=场次服务费+场次增值服务费-场次影院补贴
				TicketFee = sessioninfo.getTicketFee() + sessioninfo.getAddFee() - sessioninfo.getCinemaAllowance();
				// 销售价=真实标准价+服务费
				SalePrice = priceplanMemberPrice + TicketFee;
			}else
			{
				//其他系统
				//上报价=场次标准价+服务费（后台设置影院服务费）
				SubmitPrice=basisSubmitPrice+priceplanFee;
				// 服务费=价格设置表服务费+价格设置表增值服务费-价格设置表影院补贴
			    TicketFee = priceplanFee + priceplanAddFee - priceplanCinemaAllowance;
			    // 销售价=真实标准价+服务费
			 	SalePrice = priceplanMemberPrice + TicketFee;
			}
			//endregion
			
			//总优惠金额=所有座位的优惠金额相加
			for(int i=0; i<order.getOrderSeatDetails().size(); i++){
				if(order.getOrderSeatDetails().get(i).getConponCode()==null||order.getOrderSeatDetails().get(i).getConponCode()==""){
					order.getOrderSeatDetails().get(i).setConponPrice(0.00);
				}
			}
			ticketCouponsPrice = order.getOrderSeatDetails().stream().mapToDouble(Orderseatdetails::getConponPrice).sum();
			
			// 更新订单信息
			// 总上报金额=上报价*总票数
			order.getOrderBaseInfo().setTotalPrice(SubmitPrice * TicketCount);
			order.getOrderBaseInfo().setTotalFee(TicketFee * TicketCount);
			order.getOrderBaseInfo().setTotalSalePrice(SalePrice * TicketCount);
			order.getOrderBaseInfo().setTotalConponPrice(ticketCouponsPrice);
			//更新订单
			orderService.Update(order);
		}
		if(goodsOrder.getOrderGoodsDetails()!=null&&goodsOrder.getOrderBaseInfo()!=null){
			if(goodsOrder.getOrderBaseInfo().getCouponsPrice()==null){
				goodsOrder.getOrderBaseInfo().setCouponsPrice(0.00);
			}
			goodsCouponsPrice=goodsOrder.getOrderBaseInfo().getCouponsPrice();
			//更新卖品订单主表
			goodsOrderService.UpdateOrderBaseInfo(goodsOrder.getOrderBaseInfo());
		}
		//实际购票金额=原始金额-优惠券优惠金额
		if(!LockOrderCode.equals(null)&&!LockOrderCode.equals("")&&!LockOrderCode.equals("null")){
			realPayAmount=order.getOrderBaseInfo().getTotalSalePrice()-ticketCouponsPrice;
		}else{
			realPayAmount = 0.0;
		}
		if(!LocalOrderCode.equals(null)&&!LocalOrderCode.equals("")&&!LocalOrderCode.equals("null")){
			realGoodsPayAmount=goodsOrder.getOrderBaseInfo().getTotalSettlePrice() - goodsCouponsPrice;
		}else{
			realGoodsPayAmount = 0.0;
		}
		Map<String,Double> map=new HashMap<String,Double>();
		map.put("realPayAmount", realPayAmount);
		map.put("realGoodsPayAmount",realGoodsPayAmount);
		if(order.getOrderBaseInfo()!=null){
		System.out.println("getTotalSalePrice"+order.getOrderBaseInfo().getTotalSalePrice());
		}
		System.out.println(new Gson().toJson(map));
		return map;
	}
	//endregion
}
