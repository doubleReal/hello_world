package com.dbr.pojo;
/**
 * springboot
 * 2019/8/31 15:58
 * 用户类
 * @author zhaozheng
 **/
public class Users {
    private Integer userId;
    private String userName;
    private Integer userAge;

    public Users(Integer userId, String userName, Integer userAge) {
        this.userId = userId;
        this.userName = userName;
        this.userAge = userAge;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
}
