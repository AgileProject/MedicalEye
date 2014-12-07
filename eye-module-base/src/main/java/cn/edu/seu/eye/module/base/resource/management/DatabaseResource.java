package cn.edu.seu.eye.module.base.resource.management;

import cn.edu.seu.eye.module.base.annotation.WithoutAuthentication;
import cn.edu.seu.eye.module.base.entity.management.Database;
import cn.edu.seu.eye.module.base.presentation.Result;
import cn.edu.seu.eye.module.base.resource.BaseResource;
import cn.edu.seu.eye.module.base.service.management.IDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by ling on 2014/12/6.
 */

@RequestMapping("/system/databases")
@RestController
public class DatabaseResource extends BaseResource {

	@Autowired
	private IDatabase sysDatabaseService;

	@RequestMapping
	@WithoutAuthentication
	public Result getAllDatabase(HttpServletRequest request) {
		List<Database> databases = sysDatabaseService.getList(buildCriteria(request, Database.All_FIELDS));
		Result result = new Result(databases);
		return result;
	}
}
