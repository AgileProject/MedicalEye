package cn.edu.seu.eye.module.base.resource.management;

import cn.edu.seu.eye.module.base.annotation.WithoutAuthentication;
import cn.edu.seu.eye.module.base.entity.management.User;
import cn.edu.seu.eye.module.base.exception.NoAuthenticationException;
import cn.edu.seu.eye.module.base.presentation.Result;
import cn.edu.seu.eye.module.base.resource.BaseResource;
import cn.edu.seu.eye.module.base.service.management.IPermission;
import cn.edu.seu.eye.module.base.service.management.IUser;
import cn.edu.seu.eye.module.base.utils.LoginUserUtil;
import com.iron.fast.beans.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("restriction")
@RequestMapping("/authentication")
@RestController
public class AuthenticationResource extends BaseResource {

	@Autowired
	private IUser sysUserService;

	@Autowired
	private IPermission sysPermissionService;

	/**
	 * 
	 * @param loginUser
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.POST)
	@WithoutAuthentication
	public Result Login(@RequestBody User loginUser, @CookieValue(value = LoginUserUtil.TOKEN, defaultValue = "") String token, HttpServletResponse response, HttpServletRequest request) throws NoSuchAlgorithmException, IOException {
		User sysUser = sysUserService.get(new Criteria(User.LOGIN_NAME, loginUser.getLoginName()));
		Result result = null;
		if (sysUser == null || !sysUser.getPassword().equals(loginUser.getPassword())) {
			throw new NoAuthenticationException();
		} else if (sysUser.getPassword().equals(loginUser.getPassword())) {
			Map<String, List<String>> rolePermissionIdsMap = new HashMap<String, List<String>>();
			List<Map<String, Object>> rolePermission = sysPermissionService.getRolePermissionMapList(null);
			for (Map<String, Object> map : rolePermission) {
				String roleId = map.get("ROLE_ID").toString();
				String permissionId = map.get("PERMISSION_ID").toString();
				if (rolePermissionIdsMap.containsKey(roleId)) {
					List<String> permissionIdsList = rolePermissionIdsMap.get(roleId);
					permissionIdsList.add(permissionId);
				} else {
					List<String> permissionIdsList = new ArrayList<String>();
					permissionIdsList.add(permissionId);
					rolePermissionIdsMap.put(roleId, permissionIdsList);
				}
			}
			List<Map<String, Object>> userRoles = sysUserService.getUserRoleMapListByUser(sysUser.getLoginName());
			List<String> userPermissionIdList = new ArrayList<String>();
			for (Map<String, Object> map : userRoles) {
				String roleId = map.get("ROLE_ID").toString();
				if (rolePermissionIdsMap.containsKey(roleId)) {
					userPermissionIdList.addAll(rolePermissionIdsMap.get(roleId));
				}
			}
			sysUser.setUserPermissions(userPermissionIdList);
			StringBuffer value = new StringBuffer(loginUser.getLoginName());
			value.append(System.currentTimeMillis());
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] b = md.digest(value.toString().getBytes());
			BASE64Encoder be = new BASE64Encoder();
			token = be.encode(b);
			Cookie cookie = new Cookie(LoginUserUtil.TOKEN, token);
			cookie.setPath("/");
			response.addCookie(cookie);
			result = new Result(sysUser);
			result.setToken(token);
			LoginUserUtil.putUser(token, sysUser);
		}
		return result;
	}
}
