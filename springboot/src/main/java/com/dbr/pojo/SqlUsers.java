package com.dbr.pojo;

import lombok.Data;

/**
 * springboot
 * 2019/9/26 10:46
 * 持久层对象
 * @author zhaozheng
 * @since
 **/
@Data
public class SqlUsers {
    private Integer id;
    private String name;
    private Integer age;
}
