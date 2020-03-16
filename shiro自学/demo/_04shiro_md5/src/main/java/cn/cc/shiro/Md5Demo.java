package cn.cc.shiro;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

public class Md5Demo {
    public static void main(String[] args) {
        Md5Hash md5Hash=new Md5Hash("1111");
        System.out.println("1111====" + md5Hash.toString());
        //加盐
        md5Hash=new Md5Hash("1111","sxt");
        System.out.println("1111====" + md5Hash.toString());
        //迭代次数
        md5Hash=new Md5Hash("1111","sxt",2);
        System.out.println("1111====" + md5Hash.toString());
        SimpleHash simpleHash=new SimpleHash("md5","1111","sxt",2);
        System.out.println(simpleHash.toString());
    }
}
