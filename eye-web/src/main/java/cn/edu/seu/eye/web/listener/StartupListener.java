package cn.edu.seu.eye.web.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;

public class StartupListener extends ContextLoaderListener {

	private ApplicationContext applicationContext;

	@Override
	public void contextInitialized(ServletContextEvent event) {
		applicationContext = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
	}
	
	

}
