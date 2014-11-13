package cn.edu.seu.eye.module.base.presentation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.iron.fast.beans.Page;
import com.iron.fast.beans.PageList;

@JsonInclude(Include.NON_NULL)
public class Result {

	public Result() {

	}

	public Result(Object data) {
		handleData(data);
	}

	@SuppressWarnings("rawtypes")
	private void handleData(Object data) {
		if (data instanceof PageList) {
			this.data = ((PageList) data).getList();
			this.page = ((PageList) data).getPage();
		} else {
			this.data = data;
		}
	}

	private Object data;

	private Page page;

	private Integer code;
	
	private String message;

	private String token;
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		handleData(data);
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}