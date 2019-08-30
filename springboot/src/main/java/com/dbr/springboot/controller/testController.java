package com.dbr.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * springboot
 * 2019/8/29 9:28
 * 测试
 * @author zhaozheng
 * @since
 **/
@Controller
@RequestMapping("test")
public class testController {
    @RequestMapping("hello")
    @ResponseBody
    public String helloWorld() {
        return "Hello World!";
    }
}
