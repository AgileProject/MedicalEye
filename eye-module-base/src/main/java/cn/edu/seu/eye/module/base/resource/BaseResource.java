package cn.edu.seu.eye.module.base.resource;

import cn.edu.seu.eye.module.base.exception.ParamException;
import com.iron.fast.beans.Criteria;
import com.iron.fast.beans.OP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

public class BaseResource {
	
	private static final Logger logger = LoggerFactory
			.getLogger(BaseResource.class);

	protected int pageSize = 30;

	protected Criteria buildCriteria(HttpServletRequest request, String[] fileds) {
		Criteria criteria = new Criteria();
		for (String filed : fileds) {
			// EQ 等于
			if (request.getParameter(filed) != null)
				criteria.add(filed, request.getParameter(filed));
			// NE <>
			if (request.getParameter(filed + "_NE") != null)
				criteria.add(filed, OP.NE, request.getParameter(filed + "_NE"));
			// IN in
			if (request.getParameterValues(filed + "_IN") != null
					&& request.getParameterValues(filed + "_IN").length > 0) {
				String[] values = request.getParameterValues(filed + "_IN");
				criteria.add(filed, OP.IN, values);
			}
			// NOTIN
			if (request.getParameterValues(filed + "_NOTIN") != null
					&& request.getParameterValues(filed + "_NOTIN").length > 0) {
				String[] values = request.getParameterValues(filed + "_IN");
				criteria.add(filed, OP.NOTIN, values);
			}
			// GE >=
			if (request.getParameter(filed + "_GE") != null)
				criteria.add(filed, OP.GE, request.getParameter(filed + "_GE"));
			// LE <=
			if (request.getParameter(filed + "_LE") != null)
				criteria.add(filed, OP.LE, request.getParameter(filed + "_LE"));
			// GT >
			if (request.getParameter(filed + "_GT") != null)
				criteria.add(filed, OP.GT, request.getParameter(filed + "_GT"));
			// LT <
			if (request.getParameter(filed + "_LT") != null)
				criteria.add(filed, OP.LT, request.getParameter(filed + "_LT"));
			// BETWEEN
			if (request.getParameter(filed + "_BETWEEN") != null){
				String[] values = request.getParameterValues(filed + "_BETWEEN");
				if(values.length != 2){
					throw new ParamException();
				}
				criteria.add(filed, OP.BETWEEN, values);
			}
			// LIKE %p%
			if (request.getParameter(filed + "_LIKE") != null)
				criteria.add(filed, OP.LIKE,
						request.getParameter(filed + "_LIKE"));
			// FLIKE p%
			if (request.getParameter(filed + "_FLIKE") != null)
				criteria.add(filed, OP.FLIKE,
						request.getParameter(filed + "_FLIKE"));
			// ELIKE %p
			if (request.getParameter(filed + "_ELIKE") != null)
				criteria.add(filed, OP.ELIKE,
						request.getParameter(filed + "_ELIKE"));
			// is
			if (request.getParameter(filed + "_IS") != null)
				criteria.add(filed, OP.IS, request.getParameter(filed + "_IS"));
			// IS NOT NUL
			if (request.getParameter(filed + "_UEMPTY") != null)
				criteria.add(filed, OP.UEMPTY,
						request.getParameter(filed + "_UEMPTY"));
		}
		return criteria;
	}

	@ExceptionHandler()
	@ResponseStatus(reason = "系统错误", value = HttpStatus.INTERNAL_SERVER_ERROR)
	public String exceptionHandler(Exception e) {
		logger.error("系统错误", e);
		return e.getMessage();
	}
	
}
