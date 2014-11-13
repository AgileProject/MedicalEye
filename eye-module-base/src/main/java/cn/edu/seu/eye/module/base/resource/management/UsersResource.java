package cn.edu.seu.eye.module.base.resource.management;

import cn.edu.seu.eye.module.base.annotation.WithoutAuthentication;
import cn.edu.seu.eye.module.base.entity.management.User;
import cn.edu.seu.eye.module.base.entity.management.UserRole;
import cn.edu.seu.eye.module.base.exception.NoAuthenticationException;
import cn.edu.seu.eye.module.base.presentation.Result;
import cn.edu.seu.eye.module.base.resource.BaseResource;
import cn.edu.seu.eye.module.base.service.management.IUser;
import cn.edu.seu.eye.module.base.utils.LoginUserUtil;
import com.iron.fast.beans.Criteria;
import com.iron.fast.beans.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

/**
 *
 */
@RequestMapping("/system/users")
@RestController
public class UsersResource extends BaseResource {
	@Autowired
	private IUser sysUserService;

	@RequestMapping
	@WithoutAuthentication
	public Result getAllUsers(HttpServletRequest request) {
		List<User> lstUsers = sysUserService.getListWithDetail(buildCriteria(request,User.All_FIELDS), new Order(User.ORG_NAME).asc(User.EMPLOYEE_NAME));
		Result result = new Result(lstUsers);
		return result;
	}
	
	@RequestMapping("/{userName}")
	public Result findUserInfo(@PathVariable("userName") String userName) {
		User sysUser = sysUserService.get(userName);
		if (sysUser != null) {
			return new Result(sysUser);
		} else {
			throw new RuntimeException();
		}
	}
	
	/**
	 * 新增用户
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Result create(@RequestBody User user) {
		user.setId(UUID.randomUUID().toString());
		sysUserService.insertUser(user);
		Result result = new Result(user);
		return result;
	}
	

	/**
	 * 删除用户(物理删)
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(HttpServletRequest request) {
		Criteria criteriaUser = buildCriteria(request,
				new String[] { User.LOGIN_NAME });
		Criteria criteriaUserRole = buildCriteria(request,
				new String[] { UserRole.LOGIN_NAME });
		sysUserService.deleteUser(criteriaUser,criteriaUserRole);
	}
	
	/**
	 * 删除用户(逻辑删)
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT,value = "/delete")
	public void delete(@RequestBody List<User> users) {
		sysUserService.deleteUser(users);
	}

	/**
	 * 更新用户
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody User user) {
		sysUserService.updateUser(user);
	}
	
	
	/**
	 * 修改密码
	 * @param ModifyUser
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT,value = "/modifyPassword")
	public Result changePassword(@RequestBody User ModifyUser) {
		Result result = new Result();
		User sysUser = sysUserService.get(new Criteria(User.LOGIN_NAME, ModifyUser.getLoginName()));
		if (sysUser != null && ModifyUser.getPassword().equals(sysUser.getPassword())) {
			sysUser.setPassword(ModifyUser.getModifyPassword());
			sysUserService.update(sysUser,User.PASSWORD);
            result.setData(sysUser);
		}
        else
        {
            throw new NoAuthenticationException();
        }
        return result;
	}
	
	/**
	 * 重置密码
	 * @param ModifyUser
	 * @param token
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT,value = "/resetPassword")
	public Result resetPassword(@RequestBody User ModifyUser,@CookieValue(value = LoginUserUtil.TOKEN, defaultValue = "") String token) {
		Result result = new Result();
		User loginUser = LoginUserUtil.getUser(token);
		if(loginUser != null){
			List<String> permissionList =  loginUser.getUserPermissions();
			boolean permissionStatus = false; 
			for (String permissionName : permissionList) {
				if("sys_admin".equals(permissionName)){
					permissionStatus = true;
				}
			}
			if(permissionStatus){
				User sysUser = sysUserService.get(new Criteria(User.LOGIN_NAME, ModifyUser.getPassword()));
				String defaultPassword = "123456";
				sysUser.setPassword(defaultPassword);
				sysUserService.update(sysUser,User.PASSWORD);
			}
		}
		return result;
	}

}
