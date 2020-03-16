package ssm.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ssm.model.Position;
import ssm.model.Users;
import ssm.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/userIndex")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/show")
    public String showUsers(Model model){
        List<Users> list=userService.getAllUsers();
        model.addAttribute("list",list);
        return "index";
    }
    @RequestMapping(value = {"/","/toLogin"})
    public ModelAndView toLogin(){
        return new ModelAndView("login");
    }
    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request){
        ModelAndView mv=null;
        String className= (String) request.getAttribute("shiroLoginFailure");
            mv=new ModelAndView("login");
            if (UnknownAccountException.class.getName().equals(className)){
                mv.addObject("msg","用户名或密码错误");

            }else if (IncorrectCredentialsException.class.getName().equals(className)){
                mv.addObject("msg","用户名或密码错误");
            }else{
                mv.addObject("msg","系统错误");
            }

        return mv;
    }

    @RequestMapping("/index")
    public ModelAndView index(HttpSession session){
        Subject subject= SecurityUtils.getSubject();
        Users users= (Users) subject.getPrincipal();
        session.setAttribute("users",users);
        return new ModelAndView("index");
    }

    @RequestMapping("/refuse")
    public ModelAndView refuse(){
        return new ModelAndView("refuse");
    }

    @RequestMapping("/userList")
    @RequiresPermissions("userIndex:userList")
    public String userList(Model model){
        return "position";
    }
}
