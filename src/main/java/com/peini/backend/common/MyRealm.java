package com.peini.backend.common;

import com.peini.backend.dao.AccountDao;
import com.peini.backend.entity.Role;
import com.peini.backend.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

@Slf4j
public class MyRealm extends AuthorizingRealm {

    @Resource
    private AccountDao accountDao;

    public MyRealm() {
        setName("SampleRealm");
        setCredentialsMatcher(new HashedCredentialsMatcher());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Long userId = (Long) principals.fromRealm(getName()).iterator().next();
        User user = accountDao.findById(userId);
        if( user != null ) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            for( Role role : user.getRoles() ) {
                info.addRole(role.getName());
                info.addStringPermissions( role.getPermissions() );
            }
            return info;
        } else {
            return null;
        }
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        User user = accountDao.findByUserName(usernamePasswordToken.getUsername());
        if( user != null ) {
            log.info("user",user);
            return new SimpleAuthenticationInfo(user.getId(), user.getPassword(), getName());
        } else {
            log.warn("Can not find User:"+usernamePasswordToken.getUsername());
            return null;
        }
    }
}
