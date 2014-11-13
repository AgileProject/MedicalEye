package cn.edu.seu.eye.web.interceptor;

import cn.edu.seu.eye.module.base.annotation.WithoutAuthentication;
import cn.edu.seu.eye.module.base.exception.NoAuthenticationException;
import cn.edu.seu.eye.module.base.utils.LoginUserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object target, Exception arg3) throws Exception {
		logger.debug("REQUEST {}   {}   {} RESPONSE STATUS  {}", new Object[] { request.getRemoteAddr(), request.getMethod(), request.getRequestURI(), response.getStatus() });
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object target, ModelAndView modelAndView) throws Exception {
		// System.out.println(222);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object target) throws Exception {
		if (target instanceof HandlerMethod) {
			HandlerMethod bean = (HandlerMethod) target;
			WithoutAuthentication withoutAuthentication = bean.getMethod().getAnnotation(WithoutAuthentication.class);
			if (withoutAuthentication == null) {
				Cookie[] cookieList = request.getCookies();
				String token = null;
				token = getCookieValue(cookieList, LoginUserUtil.TOKEN);
				if (token == null) {
					throw new NoAuthenticationException();
				}
			}
		}
		return true;
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
