package mapper;

import model.Course;
import model.Employee;
import model.Score;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Employee映射器
 * 对表Employee的增删改查接口。
 * 1.增：注册。
 * 2.删：管理员删除。
 * 3.改：更改个人信息
 * 4.查：管理员查询员工信息（特定查询，模糊查询）
 */
public interface EmployeeMapper {
    void save(Employee employee);
    void deleteEmployee(int id);
    void Update(Employee employee,int id);//更新需要两个参数，一个id，一个Employee
    Employee findEmployee(String name);
    List<Employee> findAll();
    List<Score> findMyCourse(Integer id);

    Integer judgeMyCourse(@Param("uid") Integer uid,@Param("id") Integer id);

    Integer addCourse(@Param("uid") Integer uid,@Param("id") Integer id);

    Integer deleteCourse(Integer id);
}
