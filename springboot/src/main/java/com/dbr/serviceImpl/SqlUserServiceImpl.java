package com.dbr.serviceImpl;

import com.dbr.dao.SqlUserDao;
import com.dbr.pojo.SqlUsers;
import com.dbr.service.SqlUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * springboot
 * 2019/9/26 11:30
 *
 *
 *
 * @author zhaozheng
 * @since
 **/
@Service
@Transactional //由spring负责数据库的提交和回滚,保证原子性,要么全部提交,要么全部回滚
public class SqlUserServiceImpl implements SqlUserService {
    @Autowired
    private SqlUserDao sqlUserDao;

    @Override
    public void addUser(SqlUsers sqlUsers) throws Exception{
        try {
            sqlUserDao.insertUser(sqlUsers);
        } catch (Exception e) {
            throw e;
        }
    }
}
