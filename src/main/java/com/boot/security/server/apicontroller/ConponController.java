package com.boot.security.server.apicontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.apicontroller.reply.ModelMapper;
import com.boot.security.server.apicontroller.reply.QueryUserConponsReply;
import com.boot.security.server.apicontroller.reply.QueryUserConponsReply.QueryUserConponsBeans.QueryUserConponsBean;
import com.boot.security.server.apicontroller.reply.QueryUsingConponsReply;
import com.boot.security.server.apicontroller.reply.QueryUsingConponsReply.ConponData;
import com.boot.security.server.apicontroller.reply.QueryUsingConponsReply.ConponData.ConponBean;
import com.boot.security.server.apicontroller.reply.ReplyExtension;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.Coupons;
import com.boot.security.server.model.Couponsgroup;
import com.boot.security.server.model.Ticketusers;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.CouponsServiceImpl;
import com.boot.security.server.service.impl.CouponsgroupServiceImpl;
import com.boot.security.server.service.impl.TicketusersServiceImpl;
import com.boot.security.server.service.impl.UserInfoServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Api/Conpon") 
public class ConponController {
	@Autowired
	private UserInfoServiceImpl _userInfoService;
	@Autowired
	private CinemaServiceImpl _cinemaService;
	@Autowired
	private TicketusersServiceImpl _ticketusersService;
	@Autowired
	private CouponsServiceImpl _couponsService;
	@Autowired
	private CouponsgroupServiceImpl _couponsgroupService;
	
	@GetMapping("/QueryUsingConpons/{UserName}/{Password}/{CinemaCode}")
	@ApiOperation(value = "获取所有启用优惠券")
	public QueryUsingConponsReply QueryUsingConpons(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode){
		QueryUsingConponsReply reply=new QueryUsingConponsReply();
		//校验参数
		if(!ReplyExtension.RequestInfoGuard(reply, UserName, Password, CinemaCode)){
			return reply;
		}
		//获取用户渠道
		Userinfo UserInfo=_userInfoService.getByUserCredential(UserName, Password);
		if(UserInfo==null){
			reply.SetUserCredentialInvalidReply();
			return reply;
		}
		//验证影院是否存在且可访问
		Cinema cinema=_cinemaService.getByCinemaCode(CinemaCode);
		if(cinema==null){
			reply.SetCinemaInvalidReply();
			return reply;
		}
		List<Couponsgroup> coupons=_couponsgroupService.getAllUseByGroupCode(CinemaCode);
		ConponData data = new ConponData();
		if(coupons == null || coupons.size() == 0){
			data.setConponCount(0);
		} else {
			List<ConponBean> conlist = new ArrayList<ConponBean>();
			for(Couponsgroup couponsgroup : coupons){
				ConponBean  conpon = new ConponBean();
				conpon.setCinemaCode(CinemaCode);
				ModelMapper.MapFrom(couponsgroup, conpon);
				conlist.add(conpon);
			}
			data.setConponCount(conlist.size());
			data.setConpons(conlist);
		}
		reply.setData(data);
		reply.SetSuccessReply();
		return reply;
	}
	
	@GetMapping("/QueryUserConpons/{UserName}/{Password}/{CinemaCode}/{OpenID}/{Status}")
	@ApiOperation(value = "获取用户优惠券(不分页)")
	public QueryUserConponsReply QueryUserConpons(@PathVariable String UserName,@PathVariable String Password,@PathVariable String CinemaCode,@PathVariable String OpenID,@PathVariable String Status){
		QueryUserConponsReply queryUserConponsReply=new QueryUserConponsReply();
		//校验参数
		if(!ReplyExtension.RequestInfoGuard(queryUserConponsReply, UserName, Password, CinemaCode, OpenID, Status)){
			return queryUserConponsReply;
		}
		//获取用户渠道
		Userinfo UserInfo=_userInfoService.getByUserCredential(UserName, Password);
		if(UserInfo==null){
			queryUserConponsReply.SetUserCredentialInvalidReply();
			return queryUserConponsReply;
		}
		//验证影院是否存在且可访问
		Cinema cinema=_cinemaService.getByCinemaCode(CinemaCode);
		if(cinema==null){
			queryUserConponsReply.SetCinemaInvalidReply();
			return queryUserConponsReply;
		}
		//验证用户OpenId是否存在
		Ticketusers ticketusers=_ticketusersService.getByopenids(OpenID);
		if(ticketusers==null){
			queryUserConponsReply.SetOpenIDNotExistReply();
			return queryUserConponsReply;
		}
		List<Coupons> coupons=_couponsService.getByOpenID(OpenID);
		List<Couponsgroup> couponsgroup=_couponsgroupService.getByCinemaCode(CinemaCode);
		queryUserConponsReply.setData(queryUserConponsReply.new QueryUserConponsBeans());
		if(coupons==null || coupons.size()==0){
			queryUserConponsReply.getData().setConponCount(0);
		}else{
			queryUserConponsReply.getData().setConponCount(coupons.size());
			queryUserConponsReply.getData().setConponCount(couponsgroup.size());
			queryUserConponsReply.getData().setConpons(new ArrayList<QueryUserConponsBean>());
			for(Coupons coupon:coupons){
				QueryUserConponsBean queryUserConponsBean=queryUserConponsReply.getData().new QueryUserConponsBean();
				ModelMapper.MapForm(queryUserConponsBean, coupon);
				if(couponsgroup.size()!=0){
				    for (int i = 0; i < couponsgroup.size(); i++) { 
				    	Couponsgroup cou=couponsgroup.get(i);
				    String CouponsType=String.valueOf(cou.getCouponsType());
//				    System.out.println("222===="+cou.getCouponsType());
				    queryUserConponsBean.setTypeCode(CouponsType);
				    String ReductionPrice=String.valueOf(cou.getReductionPrice());
				    queryUserConponsBean.setPrice(ReductionPrice);
				    String FilmCodes=cou.getFilmCodes();
				    queryUserConponsBean.setSnackCode(FilmCodes);
				    String CinemaCodes=cou.getCinemaCodes();
				    queryUserConponsBean.setCinemaCode(CinemaCodes);
				    String Remark=cou.getRemark();
				    queryUserConponsBean.setRemark(Remark);
				    String CouponsName=cou.getCouponsName();
				    queryUserConponsBean.setTitle(CouponsName);
				    }
					}
				queryUserConponsReply.getData().getConpons().add(queryUserConponsBean);
			}
		}
		queryUserConponsReply.SetSuccessReply();
		return queryUserConponsReply;
	}
	
}
