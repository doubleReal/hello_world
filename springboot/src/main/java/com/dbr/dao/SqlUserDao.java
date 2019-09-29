package com.dbr.dao;

import com.dbr.pojo.SqlUsers;
import org.springframework.stereotype.Repository;

/**
 * springboot
 * 2019/9/26 10:57
 * 用户接口
 *
 *
 * @author zhaozheng
 * @since
 **/
@Repository
public interface SqlUserDao {
    public void insertUser(SqlUsers sqlUsers) throws Exception;
}
