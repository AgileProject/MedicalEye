package cn.edu.seu.eye.module.base.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends ResourceException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -754592641316815578L;

	public NotFoundException(){
		this.message = "未找到相关资源";
	}
	
	@Override
	public HttpStatus getHttpStatus() {
		return HttpStatus.NOT_FOUND;
	}

	@Override
	public int getCode() {
		return 10001;
	}
}
