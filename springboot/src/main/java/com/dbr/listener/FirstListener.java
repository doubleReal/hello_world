package com.dbr.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * springboot
 * 2019/8/30 16:26
 * springBoot整合 Listener
 * <listener>
 * 	<listener-class>com.bjsxt.listener.FirstListener</listener-class>
 * </listener>
 * @author zhaozheng
 * @since
 **/
@WebListener
public class FirstListener implements ServletContextListener {
    private Logger logger= LoggerFactory.getLogger(FirstListener.class);
    @Override
    public void contextInitialized(ServletContextEvent sce) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.error("Listener...init......");
    }
}
