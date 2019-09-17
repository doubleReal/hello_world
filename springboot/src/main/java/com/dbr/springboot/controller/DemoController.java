package com.dbr.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

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
    public String showInfo(Model model){
        model.addAttribute("msg","Thymeleaf showing");
        model.addAttribute("key",new Date());
        return "index";
    }
}
