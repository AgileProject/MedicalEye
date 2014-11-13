package cn.edu.seu.eye.module.base.resource.management;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.seu.eye.module.base.annotation.WithoutAuthentication;
import cn.edu.seu.eye.module.base.entity.management.Permission;
import cn.edu.seu.eye.module.base.presentation.Result;
import cn.edu.seu.eye.module.base.resource.BaseResource;
import cn.edu.seu.eye.module.base.service.management.IPermission;

@RequestMapping("/system/permissions")
@RestController
public class PermissionsResource extends BaseResource {

	@Autowired
	private IPermission sysPermissionService;

	@RequestMapping
	@WithoutAuthentication
	public Result findPermissions() {
		List<Permission> SysPermissions = sysPermissionService.getAll();
		return new Result(SysPermissions);
	}
}
