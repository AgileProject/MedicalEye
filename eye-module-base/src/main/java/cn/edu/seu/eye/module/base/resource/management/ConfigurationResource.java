package cn.edu.seu.eye.module.base.resource.management;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import cn.edu.seu.eye.module.base.annotation.WithoutAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.seu.eye.module.base.entity.management.Configuration;
import cn.edu.seu.eye.module.base.presentation.Result;
import cn.edu.seu.eye.module.base.resource.BaseResource;
import cn.edu.seu.eye.module.base.service.management.IConfiguration;

@RequestMapping("/system/configurations")
@RestController
public class ConfigurationResource extends BaseResource {

	@Autowired
	private IConfiguration configurationService;

	@RequestMapping
    @WithoutAuthentication
	public Result view(HttpServletRequest request) {
		Result result = new Result(configurationService.getList(buildCriteria(request, Configuration.All_FIELDS)));
		return result;
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void edit(@RequestBody Configuration[] configurationList) {
		configurationService.batchUpdate(Arrays.asList(configurationList), Configuration.ITEM_VALUE);
	}
}
