package serivce;
import model.User;

/**
 * 接口中的方法 隐式的指定为 public abstract，变量 public abstract final
 * userService 完成有关user的服务，如查询，登录，注册，删除等。
 */
public interface UserService {

    //注册
    void add(User user);
    int update(User user);
    // 登录
    Boolean login(String username, String password);
    //查找，按用户名查找，用户id查找
    User  findUser(String username);
    //删除用户
    void delete(int id);
    //根据用户名密码及身份标识查询
    User findByRoleNamePassword(String role,String username,String password);
}
