package cn.edu.seu.eye.module.base.resource.management;

import cn.edu.seu.eye.module.base.annotation.WithoutAuthentication;
import cn.edu.seu.eye.module.base.entity.management.Computers;
import cn.edu.seu.eye.module.base.presentation.Result;
import cn.edu.seu.eye.module.base.resource.BaseResource;
import cn.edu.seu.eye.module.base.service.management.IComputers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by ling on 2014/12/4.
 */

@RequestMapping("/system/computers")
@RestController
public class ComputersResource extends BaseResource{
	@Autowired
	private IComputers sysComputersService;
	//映射路径eye/rest/system/computers当访问这个路径时，执行这个方法
	@RequestMapping
	@WithoutAuthentication
	public Result getAllComputers(HttpServletRequest request) {
		List<Computers> aComputers = sysComputersService.getList(buildCriteria(request, Computers.All_FIELDS));
		Result result = new Result(aComputers);
		return result;
	}

}
