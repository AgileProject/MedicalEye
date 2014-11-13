package cn.edu.seu.eye.module.base.exception;

import cn.edu.seu.eye.module.base.presentation.Result;
import org.springframework.http.HttpStatus;

public abstract class ResourceException extends RuntimeException {

	/**
	 * 
	 */
	protected String message;

	private static final long serialVersionUID = 261581671631061006L;

	public abstract HttpStatus getHttpStatus();

	public abstract int getCode();

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Result getResult() {
		Result result = new Result();
		result.setCode(getCode());
		if (getMessage() == null)
			result.setMessage(getHttpStatus().getReasonPhrase());
		else {
			result.setMessage(getMessage());
		}
		return result;
	}
}
