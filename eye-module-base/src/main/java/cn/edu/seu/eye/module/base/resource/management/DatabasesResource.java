package cn.edu.seu.eye.module.base.resource.management;

import cn.edu.seu.eye.module.base.annotation.WithoutAuthentication;
import cn.edu.seu.eye.module.base.entity.management.Database;
import cn.edu.seu.eye.module.base.entity.management.Hardware;
import cn.edu.seu.eye.module.base.presentation.Result;
import cn.edu.seu.eye.module.base.resource.BaseResource;
import cn.edu.seu.eye.module.base.service.management.IDatabase;
import com.iron.fast.beans.Criteria;
import com.iron.fast.beans.OP;
import com.iron.fast.beans.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by ling on 2014/12/6.
 */

@RequestMapping("/system/databases")
@RestController
public class DatabasesResource extends BaseResource {

	@Autowired
	private IDatabase sysDatabaseService;

	@RequestMapping
	@WithoutAuthentication
	public Result getAllDatabase(HttpServletRequest request) {
		List<Database> databases = sysDatabaseService.getList(buildCriteria(request, Database.All_FIELDS));
		Result result = new Result(databases);
		return result;
	}

	@RequestMapping(value = "/{computerName}")
	public Result getDataByComputerName(@PathVariable("computerName") String computerName ) {
		List<Database> databases = sysDatabaseService.getListWithDetail(new Criteria(Database.COMPUTER_NAME, OP.EQ, computerName),
				new Order(Database.COMPUTER_NAME).desc(Database.UPDATA_TIME));


		if ( databases != null) {
			return new Result( databases);
		}else {
			throw new RuntimeException();
		}
	}

	@RequestMapping(value = "/{computerName}/{updataTime}/{utilzation}")
	public Result getDataByComputerNameInTime(@PathVariable String computerName, @PathVariable Timestamp updataTime, @PathVariable String utilzation) {
		Criteria criteria = new Criteria(Hardware.COMPUTER_NAME, OP.EQ, computerName);
		criteria.add(Hardware.UPDATA_TIME, OP.LE, updataTime);
		List<Database> databases = sysDatabaseService.getListWithDetail(criteria, new Order(Hardware.COMPUTER_NAME).asc(Hardware.UPDATA_TIME));
		Database database = databases.get(0);

		Integer linkNumb = database.getLinkNumb();
		Integer databaseSize = database.getDatabaseSize();
		Float ramUsedpercent = database.getRamUtilization();

		switch (utilzation) {
			case "linkNumb":
				if (linkNumb != null) {
					return new Result(linkNumb);
				} else {
					throw new RuntimeException();
				}
			case "databaseSize":
				if (databaseSize != null) {
					return new Result(databaseSize);
				} else {
					throw new RuntimeException();
				}
			case "ramUsedpercent":
				if (ramUsedpercent != null) {
					return new Result(ramUsedpercent);
				} else {
					throw new RuntimeException();
				}
			default:
				throw new RuntimeException();
		}
	}
}
