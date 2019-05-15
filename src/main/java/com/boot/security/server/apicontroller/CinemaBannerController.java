package com.boot.security.server.apicontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.apicontroller.reply.QueryBannerReply;
import com.boot.security.server.apicontroller.reply.ReplyExtension;
import com.boot.security.server.apicontroller.reply.QueryBannerReply.BannerData;
import com.boot.security.server.apicontroller.reply.QueryBannerReply.BannerData.BannerBean;
import com.boot.security.server.model.Banner;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.impl.BannerServiceImpl;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.UserInfoServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Api/Banner")
public class CinemaBannerController {

	@Autowired
	private UserInfoServiceImpl _userinfoService;
	@Autowired
	private CinemaServiceImpl _cinemaService;
	@Autowired
	private BannerServiceImpl bannerService;
	
	@GetMapping("/QueryBanner/{UserName}/{Password}/{CinemaCode}")
	@ApiOperation(value = "获取图片")
	public QueryBannerReply QueryBanner(@PathVariable String UserName, @PathVariable String Password,@PathVariable String CinemaCode) {
		QueryBannerReply reply = new QueryBannerReply();
		//校验参数
		if(!ReplyExtension.RequestInfoGuard(reply, UserName, Password, CinemaCode)){
			return reply;
		}
		//获取用户渠道
		Userinfo UserInfo=_userinfoService.getByUserCredential(UserName, Password);
		if(UserInfo == null){
			reply.SetUserCredentialInvalidReply();
			return reply;
		}
		//验证影院是否存在且可访问
		Cinema cinema=_cinemaService.getByCinemaCode(CinemaCode);
		if(cinema==null){
			reply.SetCinemaInvalidReply();
			return reply;
		}
		List<Banner> banners = bannerService.getByCodeAndDate(CinemaCode);
		BannerData data = new BannerData();
		if(banners == null || banners.size() == 0){
			data.setCount(0);
		} else {
			List<BannerBean> bannerlist = new ArrayList<BannerBean>();
			for(Banner ban : banners){
				BannerBean bannerinfo = new BannerBean();
				bannerinfo.setCinemaCode(ban.getCinemaCode());
				bannerinfo.setTitle(ban.getTitle());
				bannerinfo.setImage(ban.getImage());
				bannerinfo.setLinkUrl(ban.getLinkUrl());
				bannerlist.add(bannerinfo);
			}
			data.setCount(banners.size());
			data.setImages(bannerlist);
		}
		reply.setData(data);
		reply.SetSuccessReply();
		return reply;
	}
}
