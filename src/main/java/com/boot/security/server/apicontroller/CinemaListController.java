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
import com.boot.security.server.model.Choosemembercardcreditrule;
import com.boot.security.server.model.Cinema;
import com.boot.security.server.model.CinemaMiniProgramAccounts;
import com.boot.security.server.model.CinemaTypeEnum;
import com.boot.security.server.model.Membercardcreditrule;
import com.boot.security.server.model.Membercardlevel;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.model.Userinfo;
import com.boot.security.server.service.impl.ChoosemembercardcreditruleServiceImpl;
import com.boot.security.server.service.impl.CinemaMiniProgramAccountsServiceImpl;
import com.boot.security.server.service.impl.CinemaServiceImpl;
import com.boot.security.server.service.impl.MemberCardLevelServiceImpl;
import com.boot.security.server.service.impl.MembercardcreditruleServiceImpl;
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
	@Autowired
	private MemberCardLevelServiceImpl memberCardLevelService;
	@Autowired
	private MembercardcreditruleServiceImpl membercardcreditruleService;
	@Autowired
	private ChoosemembercardcreditruleServiceImpl choosemembercardcreditruleService;

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
        		   //获取影院可线上开卡的会员卡
        		   Membercardlevel membercardlevel = memberCardLevelService.getCanOnlineOpenCard(cinemaMini.getCinemaCode());
        		   //获取选择会员卡规则选择
        		   if(membercardlevel!=null){
        			   Choosemembercardcreditrule choosemembercardcreditrule = choosemembercardcreditruleService.getByLevelCodeAndRuleType(cinemaMini.getCinemaCode(), membercardlevel.getLevelCode(), "1");
        			   if(choosemembercardcreditrule!=null){
            			   //获取会员卡优惠描述
            			   Membercardcreditrule membercardcreditrule = membercardcreditruleService.getByRuleCode(choosemembercardcreditrule.getRuleCode());
            			   if(membercardcreditrule!=null){
            				   cinemareply.setOfferDescription(membercardcreditrule.getOfferDescription());
            			   }
            		   }
        		   }
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
        		   cinemareply.setBusinessPic(cinema.getBusinessPic());
        		   cinemareply.setBusinessName(cinema.getBusinessName());
        		   cinemareply.setBusinessDesc(cinema.getBusinessDesc());
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
