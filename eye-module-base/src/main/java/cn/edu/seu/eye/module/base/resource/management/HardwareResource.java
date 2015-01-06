package cn.edu.seu.eye.module.base.resource.management;

import cn.edu.seu.eye.module.base.annotation.WithoutAuthentication;
import cn.edu.seu.eye.module.base.entity.management.Hardware;
import cn.edu.seu.eye.module.base.presentation.Result;
import cn.edu.seu.eye.module.base.resource.BaseResource;
import cn.edu.seu.eye.module.base.service.management.IHardware;
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

@RequestMapping("/system/hardwares")
@RestController
public class HardwareResource extends BaseResource {

	@Autowired
	private IHardware sysHardwareServce;

	@RequestMapping
	@WithoutAuthentication
	public Result getAllHardware(HttpServletRequest request) {
		List<Hardware> hardwares = sysHardwareServce.getList(buildCriteria(request,Hardware.All_FIELDS));
		Result result = new Result(hardwares);
		return result;
	}


	@RequestMapping(value = "/{computerName}")
	public Result getHardwareByComputerName(@PathVariable("computerName") String computerName ) {
		List<Hardware> hardwares = sysHardwareServce.getListWithDetail(new Criteria(Hardware.COMPUTER_NAME, OP.EQ, computerName),
				new Order(Hardware.COMPUTER_NAME).desc(Hardware.UPDATA_TIME));

//		Result result = new Result(hardwares);
//		return result;

		Hardware hardware = hardwares.get(0);

		if (hardware != null) {
			return new Result(hardware);
		}else {
			throw new RuntimeException();
		}

//		if (hardwares != null) {
//			return new Result(hardwares);
//		}else {
//			throw new RuntimeException();
//		}
	}



	@RequestMapping(value = "/all/{computerName}")
	public Result getAllHardwareByComputerName(@PathVariable("computerName") String computerName ) {
		List<Hardware> hardwares = sysHardwareServce.getListWithDetail(new Criteria(Hardware.COMPUTER_NAME, OP.EQ, computerName),
				new Order(Hardware.COMPUTER_NAME).desc(Hardware.UPDATA_TIME));

//		Result result = new Result(hardwares);
//		return result;

//		Hardware hardware = hardwares.get(0);
//
//		if (hardware != null) {
//			return new Result(hardware);
//		}else {
//			throw new RuntimeException();
//		}

		if (hardwares != null) {
			return new Result(hardwares);
		}else {
			throw new RuntimeException();
		}
	}


	@RequestMapping(value = "/{computerName}/{utilzation}")
	public Result getDataByComputerName(@PathVariable String computerName, @PathVariable String utilzation) {
		Criteria criteria = new Criteria(Hardware.COMPUTER_NAME, OP.EQ, computerName);
		List<Hardware> hardwares = sysHardwareServce.getListWithDetail(criteria,new Order(Hardware.COMPUTER_NAME).desc(Hardware.UPDATA_TIME));
		Hardware hardware = hardwares.get(0);
//      Hardware hardware = sysHardwareServce.getWithDetail(criteria);
//		Result result = new Result(hardware);
//		return result;

		switch (utilzation) {
			case "cpuUtilzation":
				Float cpuUtilzation = hardware.getCpuUtilzation();
				if (cpuUtilzation != null) {
					return new Result(cpuUtilzation);
				}else {
					throw new RuntimeException();
				}
			case "cpuRuntime":
				Float cpuRuntime = hardware.getCpuRuntime();
				if (cpuRuntime != null) {
					return new Result(cpuRuntime);
				}else {
					throw new RuntimeException();
				}
			case "processes":
				Integer processes = hardware.getProcesses();
				if (processes != null) {
					return new Result(processes);
				}else {
					throw new RuntimeException();
				}
			case "ramUsedpercent":
				Float ramUsedpercent =hardware.getRamUsedpercent();
				if (ramUsedpercent != null) {
					return new Result(ramUsedpercent);
				}else {
					throw new RuntimeException();
				}
			case "diskUtilzation":
				Float diskUtilzation = hardware.getDiskUtilzation();
				if (diskUtilzation != null) {
					return new Result(diskUtilzation);
				}else {
					throw new RuntimeException();
				}
			default:
				throw new RuntimeException();
		}
	}

	@RequestMapping(value = "/{computerName}/{updataTime}/{utilzation}")
	public Result getDataByComputerNameInTime
			(@PathVariable String computerName, @PathVariable Timestamp updataTime, @PathVariable String utilzation) {
		Criteria criteria = new Criteria(Hardware.COMPUTER_NAME, OP.EQ, computerName);
		criteria.add(Hardware.UPDATA_TIME, OP.LE, updataTime);
		//criteria.add(Hardware.CPU_UTILZATION,);
		List<Hardware> hardwares = sysHardwareServce.getListWithDetail(criteria,
				new Order(Hardware.COMPUTER_NAME).asc(Hardware.UPDATA_TIME));

		Hardware hardware = hardwares.get(0);

		switch (utilzation) {
			case "cpuUtilzation":
				Float cpuUtilzation = hardware.getCpuUtilzation();
				if (cpuUtilzation != null) {
					return new Result(cpuUtilzation);
				}else {
					throw new RuntimeException();
				}
			case "cpuRuntime":
				Float cpuRuntime = hardware.getCpuRuntime();
				if (cpuRuntime != null) {
					return new Result(cpuRuntime);
				}else {
					throw new RuntimeException();
				}
			case "processes":
				Integer processes = hardware.getProcesses();
				if (processes != null) {
					return new Result(processes);
				}else {
					throw new RuntimeException();
				}
			case "ramUsedpercent":
				Float ramUsedpercent =hardware.getRamUsedpercent();
				if (ramUsedpercent != null) {
					return new Result(ramUsedpercent);
				}else {
					throw new RuntimeException();
				}
			case "diskUtilzation":
				Float diskUtilzation = hardware.getDiskUtilzation();
				if (diskUtilzation != null) {
					return new Result(diskUtilzation);
				}else {
					throw new RuntimeException();
				}
			default:
				throw new RuntimeException();
		}
	}



}
