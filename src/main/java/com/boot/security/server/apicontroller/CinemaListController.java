package com.boot.security.server.apicontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.apicontroller.reply.QueryCinemasReply;
import com.boot.security.server.apicontroller.reply.ReplyExtension;
import com.boot.security.server.apicontroller.reply.QueryCinemasReply.QueryCinemasBean;
import com.boot.security.server.apicontroller.reply.QueryCinemasReply.QueryCinemasBean.CinemasReply;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.CinemaMiniProgramAccounts;
import com.boot.security.server.model.CinemaTypeEnum;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.impl.CinemaMiniProgramAccountsServiceImpl;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.UserCinemaViewServiceImpl;
import com.boot.security.server.service.impl.UserInfoServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Api/Cinema")
public class CinemaListController {
	
	@Autowired
	private UserInfoServiceImpl _userInfoService;
	
	@Autowired
	private CinemaServiceImpl _cinemaService;
	@Autowired
	private UserCinemaViewServiceImpl userCinemaViewService;
	@Autowired
	private CinemaMiniProgramAccountsServiceImpl cinemaMiniProgramAccountsService;

	@GetMapping("/QueryCinemas/{UserName}/{Password}/{AppId}")
	@ApiOperation(value = "获取影院")
	public QueryCinemasReply QueryCinemas(@PathVariable String UserName,@PathVariable String Password,@PathVariable String AppId){
		
		QueryCinemasReply cinemasReply = new QueryCinemasReply();
		//校验参数
		if(!ReplyExtension.RequestInfoGuard(cinemasReply, UserName, UserName, AppId)){
			return cinemasReply;
		}
		//获取用户信息(渠道)
        Userinfo UserInfo = _userInfoService.getByUserCredential(UserName, Password);
        if (UserInfo == null) {
        	cinemasReply.SetUserCredentialInvalidReply();
            return cinemasReply;
        }
        
        List<CinemaMiniProgramAccounts> cinemaMiniProgramlist =  cinemaMiniProgramAccountsService.getByAppId(AppId);
       QueryCinemasBean queryCinemasBean = new QueryCinemasBean();
       if(cinemaMiniProgramlist == null || cinemaMiniProgramlist.size()==0){
    	   queryCinemasBean.setCinemaCount(0);
       } else {
    	   queryCinemasBean.setCinemaCount(cinemaMiniProgramlist.size());
    	   List<CinemasReply> cinemas = new ArrayList<CinemasReply>();
    	   for(CinemaMiniProgramAccounts cinemaMini : cinemaMiniProgramlist){
    		   Cinema cinema = _cinemaService.getByCinemaCode(cinemaMini.getCinemaCode());
    		   if(cinema != null){
    			   CinemasReply cinemareply = new CinemasReply();
        		   cinemareply.setCinemaId(cinema.getId());
        		   cinemareply.setCinemaCode(cinema.getCode());
        		   cinemareply.setCinemaName(cinema.getName());
        		   
        		   Usercinemaview usercinema = userCinemaViewService.GetUserCinemaViewsByUserIdAndCinemaCode(UserInfo.getId(), cinema.getCode());
        		   cinemareply.setCinemaType(usercinema==null?"":CinemaTypeEnum.CastToEnum(usercinema.getCinemaType()).getTypeName());
        		   cinemareply.setContactName(cinema.getContactName());
        		   cinemareply.setContactMobile(cinema.getContactMobile());
        		   cinemareply.setTheaterChain(cinema.getTheaterChain()==null?"":cinema.getTheaterChain().toString());
        		   cinemareply.setProvince(cinema.getProvince());
        		   cinemareply.setCity(cinema.getCity());
        		   cinemareply.setAddress(cinema.getAddress());
        		   cinemareply.setStatus(cinema.getIsOpen()==1?"开通":"关闭");
        		   cinemareply.setLatitude(cinema.getLatitude());
        		   cinemareply.setLongitude(cinema.getLongitude());
        		   cinemareply.setOpenSnacks(cinema.getIsOpenSnacks()==1?"是":"否");
        		   cinemareply.setTicketHint(cinema.getTicketHint());
        		   cinemareply.setCinemaLabel(cinema.getCinemaLabel());
        		   cinemareply.setCinemaPhone(cinema.getCinemaPhone());
        		   cinemareply.setIsSnackDistribution(cinema.getIsSnackDistribution()==1?"是":"否");
        		   if(cinema.getOverRefundTime()!=null&&cinema.getOverRefundTime()>0){
        			   cinemareply.setOverRefundTime(cinema.getOverRefundTime());
        		   }else
        		   {
        			   cinemareply.setOverRefundTime(0);
        		   }
        		   if(cinema.getRefundFee()!=null&&cinema.getRefundFee()>0){
        			   cinemareply.setRefundFee(cinema.getRefundFee());
        		   }else{
        			   cinemareply.setRefundFee(0D);
        		   }
        		   cinemas.add(cinemareply);
    		   }
    	   }
    	   queryCinemasBean.setCinemas(cinemas);
       }
       cinemasReply.setData(queryCinemasBean);
       cinemasReply.SetSuccessReply();
       return cinemasReply;
	}
}
