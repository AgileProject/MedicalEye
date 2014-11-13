package cn.edu.seu.eye.module.base.exception;

import org.springframework.http.HttpStatus;

public class ParamException extends ResourceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6318600849630886691L;

	@Override
	public HttpStatus getHttpStatus() {
		return HttpStatus.BAD_REQUEST;
	}
	
	public ParamException(){
		this.message = "请确认参数设置是否正确";
	}

	@Override
	public int getCode() {
		return 10000;
	}

}
