package cn.bb.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.ArrayList;
import java.util.List;

public class UserRealm extends AuthorizingRealm {
    @Override
    public String getName() {
        return "userRealm";
    }

    //授权的信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username=principalCollection.getPrimaryPrincipal().toString();
        System.out.println("授权--------");
        System.out.println("username========" + username);
        //根据用户名到数据库查询对应的权限信息--模拟
        List<String> permission=new ArrayList<String>();
        permission.add("user:add");
        permission.add("user:delete");
        permission.add("user:update");
        permission.add("user:find");
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        for (String perms : permission) {
            info.addStringPermission(perms);
        }
        return info;
    }

    //完成身份认证(从数据库取数据)并且返回认证消息
    //如果身份认证失败,返回null
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户输入的用户名
        String username=(String) token.getPrincipal();
        System.out.println("username====" + username);
        //根据用户名到数据库查询密码信息---模拟
        //假定获取的密码为1111
        String pwd="1111";
        //将从数据库查询的信息封装到SimpleAuthenticationInfo中
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(username,pwd,getName());
        return info;
    }
}
