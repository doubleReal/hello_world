package com.dbr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//加此表示springboot的启动类
//启动器不能放在其他包的同级包和下级包下,启动器只会寻找自己包及包下的文件
@SpringBootApplication
@ServletComponentScan //在springboot启动时会扫描@WebServlet,并将该类实例化
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
