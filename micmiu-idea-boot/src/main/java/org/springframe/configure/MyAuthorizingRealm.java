package org.springframe.configure;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframe.domain.SystemResources;
import org.springframe.domain.SystemRole;
import org.springframe.domain.SystemUser;
import org.springframe.mapper.SystemResourcesMapper;
import org.springframe.mapper.SystemRoleMapper;
import org.springframe.mapper.SystemUserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;


public class MyAuthorizingRealm extends AuthorizingRealm {

	private static final Logger logger = LoggerFactory.getLogger(MyAuthorizingRealm.class);

	@Autowired
	private SystemUserMapper systemUserMapper;
	@Autowired
	private SystemRoleMapper systemRoleMapper;
	@Autowired
	private SystemResourcesMapper systemResourcesMapper;
	/**
	 * 权限资源角色
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		/*
		 * 当没有使用缓存的时候，不断刷新页面的话，这个代码会不断执行， 当其实没有必要每次都重新设置权限信息，所以我们需要放到缓存中进行管理；
		 * 当放到缓存中时，这样的话，doGetAuthorizationInfo就只会执行一次了， 缓存过期之后会再次执行。
		 */
		logger.info("权限配置-->MyAuthorizingRealm.doGetAuthorizationInfo()");
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		SystemUser systemUser = (SystemUser) principals.getPrimaryPrincipal();
		SystemUser token = systemUserMapper.loadByUsername(systemUser.getUsername());
		if (null != token) {
			Collection<SystemRole> roles = systemRoleMapper.loadByUser(token.getId());
			if (roles.size() > 0) {
				for (SystemRole role : roles) {
					authorizationInfo.addRole(role.getName());
					Collection<SystemResources> resources = systemResourcesMapper.loadByRole(role.getId());
					for (SystemResources r : resources) {
						authorizationInfo.addStringPermission(r.getAuthc());
					}
				}
			}
		}
		return authorizationInfo;
	}

	
	/**
	 * 登录验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		logger.info("*************获取基于用户名和密码的令牌开始***************");
		UsernamePasswordToken passwordToken= (UsernamePasswordToken) token;
		// 获取用户的输入的账号.
		String username = passwordToken.getUsername();
		String password = passwordToken.getPassword().toString();

		System.err.println("用户名："+username+",密码:" +password);

		// 通过username从数据库中查找 User对象，如果找到，没找到.
		// 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
		SystemUser systemUsers = systemUserMapper.loadByUsername(username);
		if (systemUsers.getUsername() == null) {
			throw new UnknownAccountException();
		}
		if (!systemUsers.getEnabled()){
			throw new DisabledAccountException();
		}

		System.err.println("用户名："+systemUsers.getUsername()+",密码:" +systemUsers.getPassword());

		// 账号判断;

		// 加密方式;
		// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				systemUsers, // 用户名
				systemUsers.getPassword(), // 密码
				ByteSource.Util.bytes(systemUsers.getCredentialsSalt()), // salt=username+salt
				getName() // realm name
		);
		this.setSession("currentUser", systemUsers.getUsername());
		// 明文: 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
		// SimpleAuthenticationInfo authenticationInfo = new
		// SimpleAuthenticationInfo(
		// userInfo, //用户名
		// userInfo.getPassword(), //密码
		// getName() //realm name
		// );

		return authenticationInfo;
	}

	/**
	 * 清除缓存
	 */
	public void clearCached(){
		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		super.clearCache(principals);
	}


	private void setSession(Object key, Object value) {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			if (null != session) {
				System.err.println("当前登录用户的sessionId为:"+session.getId());
				session.setAttribute(key, value);
			}
		}
	}

}
