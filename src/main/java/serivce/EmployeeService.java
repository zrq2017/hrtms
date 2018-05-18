package serivce;

import model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 接口中的方法 隐式的指定为 public abstract，变量 public abstract final
 * EmployeeService 完成有关员工相关的服务，如查询，登录，注册，删除等。
 */

public interface EmployeeService {
    //注册
    void add(Employee employee);

    // 登录
    int login(String name, String passWord);

    //查找，按用户名查找，用户id查找
    Employee  findEmployee(String name);

    //删除用户
    void delete(int id);

   //修改用户信息 ，思考：修改后的信息用什么存储（我用一个Employee实体）
    void Update(Employee employee,int id);

    //查找所有用户
    List<Employee> findAll();
}

