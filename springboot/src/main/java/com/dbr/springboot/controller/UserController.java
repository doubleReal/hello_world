package com.dbr.springboot.controller;

import com.dbr.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * springboot
 * 2019/8/31 15:55
 * springboot整合JSP
 * @author zhaozheng
 * @since 2019/8/31
 **/
@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("showUser")
    public String showUser(Model model){
        List<Users> list=new ArrayList<Users>();
        list.add(new Users(1,"张三",20));
        list.add(new Users(2,"李四",22));
        list.add(new Users(3,"王五",24));
        model.addAttribute("list",list);
        return "userList";
    }
}
