package ssm.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.UsersMapper;
import ssm.model.Position;
import ssm.model.Users;
import ssm.service.UserService;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public List<Users> getAllUsers() {
        List<Users> list=usersMapper.selectAll();
        return list;
    }

    @Override
    public Users findPwdService(String username) {
        Users users=usersMapper.findUserByName(username);
        return users;
    }

    @Override
    public List<Position> findPositionService(int userId) {
        List<Position> list=usersMapper.findPositionByRole(userId);
        return list;
    }
}
