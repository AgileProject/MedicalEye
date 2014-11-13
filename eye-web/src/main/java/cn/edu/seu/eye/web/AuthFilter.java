package cn.edu.seu.eye.web;

import cn.edu.seu.eye.module.base.entity.management.User;
import cn.edu.seu.eye.module.base.utils.LoginUserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用于网站登录拦截，和resource无关
 * 
 * @author tongchang
 *
 */
@WebFilter(filterName = "AuthFilter", urlPatterns = { "/app/partials/*", "/app/index.html" })
public class AuthFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(AuthFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Cookie[] cookieList = ((HttpServletRequest) request).getCookies();
		String token = getCookieValue(cookieList, LoginUserUtil.TOKEN);
		User user = LoginUserUtil.getUser(token);
		if (user == null) {
			((HttpServletResponse) response).sendRedirect("/air/index.html");
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		logger.debug("destroy");
	}

	private String getCookieValue(Cookie[] cookieList, String key) {
		String value = null;
		if (cookieList != null) {
			for (Cookie cookie : cookieList) {
				if (cookie.getName().equals(key)) {
					value = cookie.getValue();
				}
			}
		}
		return value;
	}

}
