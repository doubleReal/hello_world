package com.dbr.springboot.controller;

import com.dbr.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * springboot
 * 2019/9/10 16:15
 * Thymeleaf入门案例
 * @author zhaozheng
 * @since
 **/
@Controller
public class DemoController {
    @RequestMapping("thymeleaf")
    public String showInfo(Model model, HttpServletRequest request, HttpServletResponse response){
        model.addAttribute("msg","Thymeleaf showing");
        model.addAttribute("key",new Date());
        model.addAttribute("sex","男");
        model.addAttribute("id","1");
        List<Users> list = new ArrayList<>();
        list.add(new Users(1,"张三",20));
        list.add(new Users(2,"李四",22));
        list.add(new Users(3,"王五",24));
        model.addAttribute("list", list);
        Map<String, Users> map = new HashMap<>();
        map.put("u1", new Users(1,"张三",20));
        map.put("u2", new Users(2,"李四",22));
        map.put("u3", new Users(3,"王五",24));
        model.addAttribute("map", map);
        request.setAttribute("req", "HttpServletRequest");
        request.getSession().setAttribute("sess", "HttpSession");
        request.getSession().getServletContext().setAttribute("app", "Application");
        return "index";
    }
}
