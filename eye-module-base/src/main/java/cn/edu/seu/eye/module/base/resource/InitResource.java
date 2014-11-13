package cn.edu.seu.eye.module.base.resource;

import cn.edu.seu.eye.module.base.presentation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/init")
public class InitResource {

	
	@Autowired
	private IInitService initService;

	@RequestMapping
	public Result init() {
		Result result = new Result();
		result.setData(true);
		initService.init();
		return result;
	}
}
