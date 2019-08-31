package com.dbr.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * springboot
 * 2019/8/31 10:18
 * SpringBoot 文件上传
 *
 *
 * @author zhaozheng
 * @since
 **/
//@Controller
@RestController //表示该类方法下的返回值会自动做JSON格式的处理,相当于responsebody
@RequestMapping("file")
public class FileUploadController {
    private Logger logger= LoggerFactory.getLogger(FileUploadController.class);
    @RequestMapping("/fileUpload")
    public Map<String,Object> fileUpload(MultipartFile filename) throws Exception{
        //打印文件名
        logger.error(filename.getOriginalFilename());
        //保存获取的文件
        filename.transferTo(new File("D:/"+filename.getOriginalFilename()));
        Map<String,Object> map=new HashMap<>();
        map.put("msg","OK");
        return map;
    }
}
