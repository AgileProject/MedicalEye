package cn.edu.seu.eye.web;

import cn.edu.seu.eye.web.listener.StartupListener;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.Log4jConfigListener;

import javax.servlet.*;
import java.util.EnumSet;

public class AppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		ServletRegistration.Dynamic duidServlet = servletContext.addServlet("DruidStatView",StatViewServlet.class);
		duidServlet.addMapping("/druid/*");
		duidServlet.setInitParameter("resetEnable", "false");
		
		
		FilterRegistration duidFilter = servletContext.addFilter("DruidWebStatFilter", WebStatFilter.class);
		duidFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "/rest/*");
		duidFilter.setInitParameter("profileEnable", "true");
		
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(AppConfig.class,CacheConfig.class);
		servletContext.addListener(new ContextLoaderListener(rootContext));
		servletContext.addListener(Log4jConfigListener.class); 
		servletContext.addListener(StartupListener.class);

		AnnotationConfigWebApplicationContext springMvcContext = new AnnotationConfigWebApplicationContext();
		springMvcContext.register(MvcConfig.class);

//		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
//		webApplicationContext.register(AppConfig.class, MvcConfig.class, CacheConfig.class);

		DispatcherServlet dispatcherServlet = new DispatcherServlet(springMvcContext);
		ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
		dynamic.addMapping("/rest/*");

		 CharacterEncodingFilter characterEncodingFilter = new
		 CharacterEncodingFilter();
		 characterEncodingFilter.setEncoding("utf-8");
		 FilterRegistration filterRegistration =
				 servletContext.addFilter("characterEncodingFilter", characterEncodingFilter);
		 filterRegistration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),
		 false, "/");

	}
}
