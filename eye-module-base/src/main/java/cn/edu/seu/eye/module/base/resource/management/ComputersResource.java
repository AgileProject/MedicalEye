package cn.edu.seu.eye.module.base.resource.management;

import cn.edu.seu.eye.module.base.annotation.WithoutAuthentication;
import cn.edu.seu.eye.module.base.entity.management.Computers;
import cn.edu.seu.eye.module.base.presentation.Result;
import cn.edu.seu.eye.module.base.resource.BaseResource;
import cn.edu.seu.eye.module.base.service.management.IComputers;
import com.iron.fast.beans.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping
	@WithoutAuthentication
	public Result getAllUsers(HttpServletRequest request) {
		List<Computers> lstComputers = sysComputersService.getListWithDetail(buildCriteria(request, Computers.All_FIELDS), new Order(Computers.ComputerName));
		Result result = new Result(lstComputers);
		return result;
	}

	@RequestMapping("/{computerName}")
	public Result findUserInfo(@PathVariable("computerName") String computerName) {
		//User sysUser = sysUserService.get(userName);
		Computers sysComputer = sysComputersService.get(computerName);
		if (sysComputer != null) {
			return new Result(sysComputer);
		} else {
			throw new RuntimeException();
		}
	}
}
