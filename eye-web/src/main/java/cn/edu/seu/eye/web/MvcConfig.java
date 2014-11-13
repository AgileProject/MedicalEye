package cn.edu.seu.eye.web;

import cn.edu.seu.eye.module.base.utils.StdDateFormat;
import cn.edu.seu.eye.web.interceptor.AuthInterceptor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "cn.edu.seu.eye" , "cn.edu.seu.eye.core" }, excludeFilters = { @ComponentScan.Filter({Service.class,Repository.class })})
public class MvcConfig extends WebMvcConfigurerAdapter {

	//
	// @Override
	// public void configureHandlerExceptionResolvers(
	// List<HandlerExceptionResolver> exceptionResolvers) {
	// exceptionResolvers.add(new HandlerException());
	// }

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AuthInterceptor());
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		// 设置jackson时间转换格式
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setDateFormat(new StdDateFormat());
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		objectMapper.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX, true);
		objectMapper.getDeserializationConfig().getDateFormat();

		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
		converters.add(mappingJackson2HttpMessageConverter);
	}

	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		exceptionResolvers.add(new HandlerException());
		super.configureHandlerExceptionResolvers(exceptionResolvers);
	}

	// @Bean
	// public ViewResolver viewResolver() {
	// InternalResourceViewResolver viewResolver = new
	// InternalResourceViewResolver();
	// viewResolver.setPrefix("/WEB-INF/jsp/");
	// viewResolver.setSuffix(".jsp");
	// return viewResolver;
	// }

	// 静态资源映射
	// @Override
	// protected void addResourceHandlers(ResourceHandlerRegistry registry) {
	// registry.addResourceHandler("/static/**").addResourceLocations(
	// "/WEB-INF/static/");
	// }

	// public class HandlerException implements HandlerExceptionResolver {
	//
	// @Override
	// public ModelAndView resolveException(HttpServletRequest request,
	// HttpServletResponse response, Object handler, Exception ex) {
	// String[] classPath = null;
	// String[] methodPath = null;
	// request.getRequestURI();
	// if(handler instanceof HandlerMethod){
	// HandlerMethod handlerMethod = (HandlerMethod)handler;
	// classPath =
	// handlerMethod.getBeanType().getAnnotation(RequestMapping.class).value();
	// methodPath =
	// handlerMethod.getMethodAnnotation(RequestMapping.class).value();
	// }
	//
	// if (ex instanceof ResourceException) {
	// ResourceException exception = (ResourceException) ex;
	// try {
	// int statusCode = exception.getStatus().value();
	// String method = request.getMethod();
	// String path = "";
	// String message=null;
	// if(classPath != null && classPath.length>0){
	// path += classPath[0];
	// }
	// if(methodPath != null && methodPath.length > 0){
	// path += methodPath[0];
	// }
	// message =
	// ResourceBundleUtil.getBundleMessage(statusCode+"."+path+"."+method);
	// if(message == null){
	// message = ResourceBundleUtil.getBundleMessage(statusCode+"."+path);
	// }
	// if(message == null){
	// message = ResourceBundleUtil.getBundleMessage(statusCode+"");
	// }
	// if(message == null){
	// message = exception.getStatus().getReasonPhrase();
	// }
	// //
	// response.sendError(statusCode,message);
	// } catch (IOException e) {
	// response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	// }
	// } else {
	// response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	// }
	// return new ModelAndView();
	// }
	//
	// }
}
