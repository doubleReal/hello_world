package com.dbr.springboot.controller;

import com.dbr.pojo.SqlUsers;
import com.dbr.service.SqlUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * springboot
 * 2019/9/26 15:55
 *
 *
 *
 * @author zhaozheng
 * @since
 **/
@Controller
@RequestMapping("/sqlUser")
public class SqlUserController {
    @Autowired
    public SqlUserService sqlUserService;

    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }

    @RequestMapping("/addUser")
    public String addUser(SqlUsers sqlUsers){
        try {
            sqlUserService.addUser(sqlUsers);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "OK";
    }
}
