package mapper;

import java.util.List;

import model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	//对用户的增删改查
	void save(User user);  
    void update(User user);
    void deleteUser(int id);
    User findById(int id);  
    List<User> findAll();
    User findUser(User user);
    User findByRoleNamePassword(@Param("role") String role, @Param("username") String username, @Param("password") String password);
}
