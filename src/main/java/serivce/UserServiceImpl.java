package serivce;

import mapper.UserMapper;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 解决一疑惑，web项目，在服务器启动的时候加载了配置文件并创建了对象。那如何从容器中取对象（还需要取吗，依赖注入）
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired        //注解注入
    private UserMapper userMapper;

    @Autowired
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void add(User user) {
         this.userMapper.save(user);
    }

    @Override
    public Boolean login(String userName, String passWord) {
        System.out.println(userName);
        this.user.setUsername(userName);
        this.user.setPassword(passWord);
        User user=this.userMapper.findUser(this.user);
        if(user==null)
        return false;
        else {
            System.out.println("已查询到对象"+user.getUsername()+user.getId());
            return true;
        }
    }

    @Override
    public User findUser(String userName) {

        return null;
    }

    @Override
    public void delete(int id) {

        this.userMapper.deleteUser(id);
    }

    //根据用户名密码及身份标识查询
    @Override
    public User findByRoleNamePassword(String role, String username, String password) {
        return userMapper.findByRoleNamePassword(role,username,password);
    }
}
