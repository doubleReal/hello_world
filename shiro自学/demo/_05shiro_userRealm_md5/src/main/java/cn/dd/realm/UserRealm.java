package cn.dd.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class UserRealm extends AuthorizingRealm {
    @Override
    public String getName() {
        return "userRealm";
    }

    //授权的信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
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
        String pwd="e41cd85110c7533e3f93b729b25235c3";
        String salt="sxt";
        //将从数据库查询的信息封装到SimpleAuthenticationInfo中
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(username,pwd, ByteSource.Util.bytes(salt),getName());
        return info;
    }
}

