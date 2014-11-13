package cn.edu.seu.eye.module.base.resource.management;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.seu.eye.module.base.entity.management.Role;
import cn.edu.seu.eye.module.base.entity.management.RolePermission;
import cn.edu.seu.eye.module.base.presentation.Result;
import cn.edu.seu.eye.module.base.resource.BaseResource;
import cn.edu.seu.eye.module.base.service.management.IRole;
import com.iron.fast.beans.Criteria;
import com.iron.fast.beans.Order;

@RequestMapping("/system/roles")
@RestController
public class RoleResource extends BaseResource {
	@Autowired
	private IRole roleService;

	@RequestMapping
	public Result getRoles(HttpServletRequest request) {
		List<Role> roles = roleService.getListWithDetail(buildCriteria(request,Role.All_FIELDS),new Order(Role.ORG_NAME));
		return new Result(roles);
	}
	
	/**
	 * 新增角色
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Result create(@RequestBody Role role) {
		role.setId(UUID.randomUUID().toString());
		roleService.insertRole(role);
		Result result = new Result(role);
		return result;
	}
	
	/**
	 * 删除角色（物理删）
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(HttpServletRequest request) {
		Criteria criteriaR = buildCriteria(request,
				new String[] { Role.ID });
		Criteria criteriaRP = buildCriteria(request,
				new String[] { RolePermission.ROLE_ID });
		roleService.deleteRole(criteriaR,criteriaRP);
	}
	
	/**
	 * 删除角色（逻辑删）
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT,value = "/delete")
	public void deleteRole(@RequestBody List<Role> roles) {
		roleService.deleteRole(roles);
	}

	/**
	 * 更新角色
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody Role role) {
		roleService.updateRole(role);
	}

}
