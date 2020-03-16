package shiro;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class UserRealmDemo {
    private static Logger logger=Logger.getLogger(UserRealmDemo.class);
    public static void main(String[] args) {
        Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager=factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("zhangsan","1111");
        try {
            subject.login(token);
            if (subject.isAuthenticated()){
               logger.debug("登陆成功");
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
            logger.debug("登陆失败");
        }

        System.out.println(subject.isPermittedAll("user:add", "user:delete"));
    }
}