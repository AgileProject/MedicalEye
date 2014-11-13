package cn.edu.seu.eye.module.base.exception;

import org.springframework.http.HttpStatus;


public class NoAuthenticationException extends ResourceException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1501693726469760281L;

	public NoAuthenticationException() {
		 this.message = "用户未认证";
	}

	@Override
	public HttpStatus getHttpStatus() {
		return HttpStatus.UNAUTHORIZED;
	}

	@Override
	public int getCode() {
		return 10002;
	}

}
