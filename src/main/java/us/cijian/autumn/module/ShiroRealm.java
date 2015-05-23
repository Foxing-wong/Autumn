package us.cijian.autumn.module;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import us.cijian.autumn.mapper.UserMapper;
import us.cijian.autumn.pojo.User;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MurphyL on 2015/5/23.
 */
public class ShiroRealm extends AuthorizingRealm {

    private static Logger logger = LoggerFactory.getLogger(ShiroRealm.class.getName());

    @Autowired
    private UserMapper userMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 用户需要提供 principals (身份)和 credentials(证明)给 shiro,从而应用能验证用户身份
        // 最常见的 principals 和 credentials 组合就是用户名/密码了
        String username = (String) principals.getPrimaryPrincipal();
        // Authentication 成功后查询用户授权信息.
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        User user = getUserByName(username);
        if (null != user) {
            info.addRole(user.getPrincipal());
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername(); // 通过表单接收的用户名
        if (username.equals("test")) {
            throw new LockedAccountException("Account is locked"); //帐号锁定
        }
        User user = getUserByName(username);
        // 取得预先定义的用户名密码对
        return new SimpleAuthenticationInfo(username, user.getPassword(), getName());
    }

    private User getUserByName(String userName) {
        return userMapper.getByName(userName);
    }

}