package com.boot.security.server.utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.boot.security.server.model.GoodsOrderView;
import com.boot.security.server.model.Goodsorderdetails;
import com.boot.security.server.model.Goodsorders;
import com.boot.security.server.service.impl.GoodsOrderServiceImpl;
import com.boot.security.server.service.impl.GoodsorderdetailsServiceImpl;

public class GoodsCouponsPriceUtil {
	GoodsOrderServiceImpl goodsOrderService = SpringUtil.getBean(GoodsOrderServiceImpl.class);
	GoodsorderdetailsServiceImpl goodsorderdetailsService = SpringUtil.getBean(GoodsorderdetailsServiceImpl.class);
	//计算卖品优惠金额
	public GoodsOrderView getGoodsCouponsPrice(GoodsOrderView order){
		if(order.getOrderBaseInfo()!=null){
			//判断是否存在优惠价格
			if(order.getOrderBaseInfo().getCouponsPrice()!=null){
				//多个商品处理
				if(order.getOrderGoodsDetails().size()>1){
					//得到总价格
					Double TotalSalePrice = order.getOrderGoodsDetails().stream().collect(Collectors.summingDouble(Goodsorderdetails::getSubTotalSettleAmount));
					//处理除最后一个价格外的价格
					Double couponsPrice = 0.00;
					String dealPrice = null;
					for(int i=0; i<order.getOrderGoodsDetails().size(); i++){
						if(i<order.getOrderGoodsDetails().size()-1){
							//先初始化要拆分的价格
							dealPrice= new DecimalFormat("0.00").format(order.getOrderGoodsDetails().get(i).getSubTotalSettleAmount()/TotalSalePrice*order.getOrderBaseInfo().getCouponsPrice());
							order.getOrderGoodsDetails().get(i).setCouponPrice(Double.parseDouble(dealPrice));
							//得到拆分完的总价格
							couponsPrice +=Double.parseDouble(dealPrice);
							//格式化拆分后的价格
							new DecimalFormat("0.00").format(order.getOrderGoodsDetails().get(i).getCouponPrice());
						}else{
							//处理最后一个价格
							order.getOrderGoodsDetails().get(i).setCouponPrice(order.getOrderBaseInfo().getCouponsPrice()-couponsPrice);
						}
					}
				}
				//一个商品处理
				if(order.getOrderGoodsDetails().size()==1){
					order.getOrderGoodsDetails().get(0).setCouponPrice(order.getOrderBaseInfo().getCouponsPrice());
				}
			}
		}
		return order;
	}
	
	/*public static void main(String[] args) {
		List<Goodsorderdetails> goodsorderdetailsList = new GoodsCouponsPriceUtil().getGoodsCouponsPrice("83efebd10d7646eabbd4227688af961e");
		for(Goodsorderdetails goodsorderdetails:goodsorderdetailsList){
			System.out.println(goodsorderdetails.getCouponPrice());
		}
	}*/
}
