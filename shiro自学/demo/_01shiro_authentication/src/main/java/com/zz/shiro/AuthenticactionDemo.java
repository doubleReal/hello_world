package com.zz.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class AuthenticactionDemo {
    public static void main(String[] args) {
        //建立工厂来读取配置文件
        Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro.ini");
        //通过工厂实例化securitymanage
        SecurityManager securityManager=factory.getInstance();
        //将securityManage部署到环境中
        SecurityUtils.setSecurityManager(securityManager);
        //通过utils获取具体的主体subject
        Subject subject=SecurityUtils.getSubject();
        //读取到的用户登陆信息
        UsernamePasswordToken token=new UsernamePasswordToken("zhangsan","1112");
        try {
            //进行用户身份验证
            subject.login(token);
            //判断是否通过验证
            if (subject.isAuthenticated()){
                System.out.println("登陆成功");
            }
        } catch (UnknownAccountException e) {
            System.out.println("登陆失败");
        }catch(IncorrectCredentialsException e ){
            System.out.println("登陆失败");
        }
    }
}
