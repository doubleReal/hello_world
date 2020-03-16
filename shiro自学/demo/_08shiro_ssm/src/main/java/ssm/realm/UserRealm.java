package ssm.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import ssm.model.Position;
import ssm.model.Users;
import ssm.service.UserService;

import java.util.List;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Override
    public String getName() {
        return "userRealm";
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取身份信息--该身份信息在认证时已设置
        System.out.println("授权");
        Users users= (Users) principalCollection.getPrimaryPrincipal();
        List<Position> positions=userService.findPositionService(users.getId());
        if (positions==null||positions.size()==0){
            return null;
        }
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        for (Position p : positions) {
            if (p.getPermission()!=null){
                info.addStringPermission(p.getPermission());
            }
        }
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("----认证----");
        String username=token.getPrincipal().toString();
        Users users=userService.findPwdService(username);
        if (users!=null){
            users.setList(userService.findPositionService(users.getId()));
        }
        return new SimpleAuthenticationInfo(users,users.getPassword(), ByteSource.Util.bytes(users.getPasswordSalt()),getName());
    }

    //清理缓存方法
    public void clearCache() {
        Subject subject= SecurityUtils.getSubject();
        super.clearCache(subject.getPrincipals());
    }
}
