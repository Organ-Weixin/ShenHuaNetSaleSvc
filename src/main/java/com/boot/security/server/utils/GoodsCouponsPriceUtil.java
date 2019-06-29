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
	public GoodsOrderView getGoodsCouponsPrice(String LocalOrderCode){
		System.out.println("LocalOrderCode="+LocalOrderCode);
		GoodsOrderView goodsOrderView = new GoodsOrderView();
		List<Goodsorderdetails> goodsorderdetailsList = new ArrayList<Goodsorderdetails>();
		Goodsorders goodsorders = goodsOrderService.getByLocalOrderCode(LocalOrderCode);
		System.out.println("goodsorders="+goodsorders.getLocalOrderCode());
		if(goodsorders!=null){
			//获取卖品详细
			goodsorderdetailsList = goodsorderdetailsService.getByOrderId(goodsorders.getId());
			//判断是否存在优惠价格
			if(goodsorders.getCouponsPrice()!=null){
				//多个商品处理
				if(goodsorderdetailsList.size()>1){
					//得到总价格
					Double TotalSalePrice = goodsorderdetailsList.stream().collect(Collectors.summingDouble(Goodsorderdetails::getSubTotalSettleAmount));
					//处理除最后一个价格外的价格
					Double couponsPrice = 0.00;
					String dealPrice = null;
					for(int i=0; i<goodsorderdetailsList.size(); i++){
						if(i<goodsorderdetailsList.size()-1){
							//先初始化要拆分的价格
							dealPrice= new DecimalFormat("0.00").format(goodsorderdetailsList.get(i).getSubTotalSettleAmount()/TotalSalePrice*goodsorders.getCouponsPrice());
							goodsorderdetailsList.get(i).setCouponPrice(Double.parseDouble(dealPrice));
							//得到拆分完的总价格
							couponsPrice +=Double.parseDouble(dealPrice);
							//格式化拆分后的价格
							new DecimalFormat("0.00").format(goodsorderdetailsList.get(i).getCouponPrice());
						}else{
							//处理最后一个价格
							goodsorderdetailsList.get(i).setCouponPrice(goodsorders.getCouponsPrice()-couponsPrice);
						}
					}
				}
				//一个商品处理
				if(goodsorderdetailsList.size()==1){
					goodsorderdetailsList.get(0).setCouponPrice(goodsorders.getCouponsPrice());
				}
			}
			goodsOrderView.setOrderBaseInfo(goodsorders);
			goodsOrderView.setOrderGoodsDetails(goodsorderdetailsList);
		}
		return goodsOrderView;
	}
	
	/*public static void main(String[] args) {
		List<Goodsorderdetails> goodsorderdetailsList = new GoodsCouponsPriceUtil().getGoodsCouponsPrice("83efebd10d7646eabbd4227688af961e");
		for(Goodsorderdetails goodsorderdetails:goodsorderdetailsList){
			System.out.println(goodsorderdetails.getCouponPrice());
		}
	}*/
}
