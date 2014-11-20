
package cn.edu.seu.eye.module.base.utils;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import cn.edu.seu.eye.module.base.entity.management.User;

public class LoginUserUtil {

	public static final String TOKEN = "token";

	public static User getUser(String token) {
		Cache cache = SpringContextUtil.getBean("sessionCaching", Cache.class);
		Element element = cache.get(token);
		if (element != null) {
			return (User) element.getObjectValue();
		} else {
			return null;
		}
	}

	public static void putUser(String token, User sysUser) {
		Cache cache = SpringContextUtil.getBean("sessionCaching", Cache.class);
		Element element = new Element(token, sysUser);
		cache.put(element);
	}
}
