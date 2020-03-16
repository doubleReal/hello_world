package ssm.service;

import ssm.model.Position;
import ssm.model.Users;

import java.util.List;

public interface UserService {
    public List<Users> getAllUsers();

    public Users findPwdService(String username);
    public List<Position> findPositionService(int userId);
}
