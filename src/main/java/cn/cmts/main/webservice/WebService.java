package cn.cmts.main.webservice;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.tomcat.util.buf.StringUtils;
/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/

import com.boot.security.server.api.ctms.reply.CxQueryCinemaInfoResult;
import com.boot.security.server.api.ctms.reply.MtxGetHallResult;
import com.boot.security.server.model.Usercinemaview;
import com.boot.security.server.utils.MD5Util;
import com.boot.security.server.utils.XmlToJsonUtil;
import com.google.common.base.Joiner;
import com.google.gson.Gson;

/**
 * @version 1.0 满天星接口
 */
public class WebService {
	// protected static Logger log = LoggerFactory.getLogger(WebService.class);

	private static final String TokenId = "1829";
	private static final String Token = "abcdef";

	/**
	 * 满天星接口 初始化接口链接，返回接口集
	 * 
	 * @return
	 */
	public static TicketapiPortType cinemaTss(String Url) {
		TicketapiLocator css = new TicketapiLocator();
		css.setticketapiHttpSoap11EndpointEndpointAddress(Url);
		Ticketapi cs = css;
		// 接口集
		TicketapiPortType cp;
		try {
			cp = cs.getticketapiHttpSoap11Endpoint();
			return cp;
		} catch (Exception e) {
			// log.error("cinema模块初始化失败"+e.getMessage());
		}
		return null;
	}

	/**
	 * 查询一个电影院的信息，包含了所有影厅的数量，座位数等
	 * 
	 * @param pCinemaCode
	 *            影院编码
	 * @return
	 */
	public static MtxGetHallResult GetHall(Usercinemaview userCinema) {
		try {
			String pVerifyInfo = GenerateVerifyInfo(userCinema.getDefaultUserName(), userCinema.getCinemaCode(),
					TokenId, Token, userCinema.getDefaultPassword());
			String result = WebService.cinemaTss(userCinema.getUrl()).getHall(userCinema.getDefaultUserName(),
					userCinema.getCinemaCode(), TokenId, pVerifyInfo);
			Gson gson = new Gson();
			// log.info(result);
			return gson.fromJson(XmlToJsonUtil.xmltoJson(result, "GetHallResult"), MtxGetHallResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String GenerateVerifyInfo(String... items) {
		String sourceString = Joiner.on("").join(items);
		return getMD5ofStr(sourceString.toLowerCase()).substring(8, 24).toLowerCase();
	}

	public static String getMD5ofStr(String strSrc) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(strSrc.getBytes("UTF8"));
			String result = "";
			byte[] temp;
			temp = md5.digest("".getBytes("UTF8"));
			for (int i = 0; i < temp.length; i++) {
				result += Integer.toHexString((0x000000ff & temp[i]) | 0xffffff00).substring(6);
			}
			return result;

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		Usercinemaview usercinema = new Usercinemaview();
		usercinema.setDefaultUserName("jdjm");
		usercinema.setDefaultPassword("cmts20180629jdjm");
		usercinema.setUrl("http://ticketwj.mvtapi.com:8760/ticketapi/services/ticketapi?wsdl");
		usercinema.setCinemaCode("22113901");
		MtxGetHallResult result = GetHall(usercinema);
		System.out.println(result.getGetHallResult().getHalls().getHall().get(0).getHallName());
	}

}
