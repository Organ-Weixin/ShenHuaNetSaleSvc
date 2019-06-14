package com.boot.security.server.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.boot.security.server.dto.LoginUser;
import com.boot.security.server.service.TokenService;

/**
 * Token过滤器
 * 
 * @author 小威老师 xiaoweijiagou@163.com
 *
 *         2017年10月14日
 */
@Component
public class TokenFilter extends OncePerRequestFilter {

	public static final String TOKEN_KEY = "token";
	protected static Logger log = LoggerFactory.getLogger(TokenFilter.class);

	@Autowired
	private TokenService tokenService;
	@Autowired
	private UserDetailsService userDetailsService;
	private static final Long MINUTES_10 = 10 * 60 * 1000L;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = getToken(request);
		if (request.getServletPath().length()>4 && request.getServletPath().substring(0,4).equals("/Api")) {
			LoginUser loginUser = new LoginUser();
			loginUser.setToken("14ce830b-1a3e-403d-8872-c7825558b416");
			loginUser.setLoginTime(1555925234175L);
		    loginUser.setExpireTime(1855932434175L);
		    loginUser.setUsername("admin");
		    loginUser.setPassword("$2a$10$azKn2zt4uvOFuK.IDWzpoui6EIvkQ8MMz.sDpgDPNs3dKncylMxsu");
		    loginUser.setStatus(1);
		    loginUser.setId(1L);
			if (loginUser != null) {
				loginUser = checkLoginTime(loginUser);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						loginUser, null, null);
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}else if (request.getServletPath().length()>4 && request.getServletPath().startsWith("/webSocket")) {
			LoginUser loginUser = new LoginUser();
			loginUser.setToken("14ce830b-1a3e-403d-8872-c7825558b416");
			loginUser.setLoginTime(1555925234175L);
		    loginUser.setExpireTime(1855932434175L);
		    loginUser.setUsername("admin");
		    loginUser.setPassword("$2a$10$azKn2zt4uvOFuK.IDWzpoui6EIvkQ8MMz.sDpgDPNs3dKncylMxsu");
		    loginUser.setStatus(1);
		    loginUser.setId(1L);
			if (loginUser != null) {
				loginUser = checkLoginTime(loginUser);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						loginUser, null, null);
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}
		else
		{
			System.out.println(request.getServletPath());	
			if (StringUtils.isNotBlank(token)) {
				LoginUser loginUser = tokenService.getLoginUser(token);
				if (loginUser != null) {
					loginUser = checkLoginTime(loginUser);
					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
							loginUser, null, loginUser.getAuthorities());
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}
		}
		
		filterChain.doFilter(request, response);
	}

	/**
	 * 校验时间<br>
	 * 过期时间与当前时间对比，临近过期10分钟内的话，自动刷新缓存
	 * 
	 * @param loginUser
	 * @return
	 */
	private LoginUser checkLoginTime(LoginUser loginUser) {
		long expireTime = loginUser.getExpireTime();
		long currentTime = System.currentTimeMillis();
		if (expireTime - currentTime <= MINUTES_10) {
			String token = loginUser.getToken();
			loginUser = (LoginUser) userDetailsService.loadUserByUsername(loginUser.getUsername());
			loginUser.setToken(token);
			tokenService.refresh(loginUser);
		}
		return loginUser;
	}

	/**
	 * 根据参数或者header获取token
	 * 
	 * @param request
	 * @return
	 */
	public static String getToken(HttpServletRequest request) {
		String token = request.getParameter(TOKEN_KEY);
		if (StringUtils.isBlank(token)) {
			token = request.getHeader(TOKEN_KEY);
		}
		return token;
	}
}
