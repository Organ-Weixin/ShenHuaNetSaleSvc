package com.boot.security.server.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.boot.security.server.model.CouponsStatusEnum;
import com.boot.security.server.model.CouponsView;

public class CouponsUtil {
	
	//region 判断优惠券是否可使用
	public static boolean CouponsCanUse(CouponsView couponsview,String CinemaCode){
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
}
