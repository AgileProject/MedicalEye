package cn.edu.seu.eye.web;

import cn.edu.seu.eye.module.base.exception.ResourceException;
import cn.edu.seu.eye.module.base.presentation.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HandlerException extends AbstractHandlerExceptionResolver {
	
	private static final Logger logger = LoggerFactory
			.getLogger(HandlerException.class);


	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		try {
			response.setCharacterEncoding("UTF-8");
			PrintWriter writer = response.getWriter();
			Result result = null;
			if(ex instanceof ResourceException){
				result = ((ResourceException) ex).getResult();
				ObjectMapper objectMapper = new ObjectMapper();
				response.setStatus(((ResourceException) ex).getHttpStatus().value());
				logger.debug(result.getMessage());
				writer.write(objectMapper.writeValueAsString(result));
			}else{
				result = new Result();
				result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
				result.setMessage("系统内部错误，请联系管理员");
				ObjectMapper objectMapper = new ObjectMapper();
				response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
				logger.error("系统错误",ex);
				writer.write(objectMapper.writeValueAsString(result));
			}
//			JsonGenerator jsonGen
			writer.flush();
		} catch (IOException e) {
			ex.printStackTrace();
		}
		return  new ModelAndView();
	}

}
