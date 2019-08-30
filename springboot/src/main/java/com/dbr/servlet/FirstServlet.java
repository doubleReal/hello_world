package com.dbr.servlet;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * springboot
 * 2019/8/30 15:22
 * servlet配置
 * <servlet>
 *     <servlet-name>FirstServlet</servlet-name>
 *     <servlet-class>com.dbr.servlet.FirstServlet</servlet-class>
 * </servlet>
 * <servlet-mapping>
 *     <servlet-name>FirstServlet</servlet-name>
 *     <url-pattern>/first</url-pattern>
 * </servlet-mapping>
 * @author zhaozheng
 * @since
 **/
//注释为以前在web.xml里面的配置,现在只需要写注释
@WebServlet(name = "FirstServlet",urlPatterns = "/first")
public class FirstServlet extends HttpServlet {
    private Logger logger= LoggerFactory.getLogger(FirstServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.error("FirstServlet.......................");
    }
}
