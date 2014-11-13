package cn.edu.seu.eye.module.base.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtil implements ApplicationContextAware {

	// Spring
	private static ApplicationContext applicationContext;

	/**
	 *
	 * @param applicationContext
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringContextUtil.applicationContext = applicationContext;
	}

	/**
	 * @return ApplicationContext
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 *
	 * @param name
	 * @throws BeansException
	 */
	public static <T> T getBean(String name, Class<T> cls) throws BeansException {
		return applicationContext.getBean(name, cls);
	}

	/**
	 *
	 * @param cls
	 * @throws BeansException
	 */
	public static <T> T getBean(Class<T> cls) throws BeansException {
		return applicationContext.getBean(cls);
	}

}
