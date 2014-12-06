package cn.edu.seu.eye.module.base.resource.management;

/**
 * Created by DL on 2014/12/4.
 */
import cn.edu.seu.eye.module.base.annotation.WithoutAuthentication;
import cn.edu.seu.eye.module.base.entity.management.Computer;
import cn.edu.seu.eye.module.base.exception.NoAuthenticationException;
import cn.edu.seu.eye.module.base.presentation.Result;
import cn.edu.seu.eye.module.base.resource.BaseResource;
import cn.edu.seu.eye.module.base.service.management.IComputer;
import com.iron.fast.beans.Criteria;
import com.iron.fast.beans.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@RequestMapping("/system/computers")
@RestController
public class ComputersResource extends BaseResource {
    @Autowired
    private IComputer sysComputerService;

    @RequestMapping
    @WithoutAuthentication
    public Result getAllComputers(HttpServletRequest request) {
        List<Computer> lstComputers = sysComputerService.getAll();
        Result result = new Result(lstComputers);
        return result;
    }

}
