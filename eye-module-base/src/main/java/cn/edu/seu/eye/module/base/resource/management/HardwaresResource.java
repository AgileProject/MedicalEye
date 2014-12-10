package cn.edu.seu.eye.module.base.resource.management;

import cn.edu.seu.eye.module.base.annotation.WithoutAuthentication;
import cn.edu.seu.eye.module.base.entity.management.Hardware;
import cn.edu.seu.eye.module.base.presentation.Result;
import cn.edu.seu.eye.module.base.resource.BaseResource;
import cn.edu.seu.eye.module.base.service.management.IHardware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by ling on 2014/12/6.
 */

@RequestMapping("/system/hardwares")
@RestController
public class HardwaresResource extends BaseResource {

	@Autowired
	private IHardware sysHardwareServce;

	@RequestMapping
	@WithoutAuthentication
	public Result getAllHardware(HttpServletRequest request) {
		List<Hardware> hardwares = sysHardwareServce.getList(buildCriteria(request,Hardware.All_FIELDS));
		Result result = new Result(hardwares);
		return result;
	}

}
