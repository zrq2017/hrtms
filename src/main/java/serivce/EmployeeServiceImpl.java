package serivce;

import mapper.CourseMapper;
import mapper.EmployeeMapper;
import model.Course;
import model.Employee;

import model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private CourseMapper courseMapper;

    public EmployeeMapper getEmployeeMapper() {
        return employeeMapper;
    }

    public void setEmployeeMapper(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    //方法实现
    @Override
    //注册
    public void add(Employee employee) {

        this.employeeMapper.save(employee);

    }

    @Override
    /*
    思考：登录时，对用户名和密码进行验证并给出错误信息，用户不存在或密码错误！则该如何查询。
    我的思路：1.根据用户名找到对应用户 2.将密码与此用户的密码比较
    暂时不这样做，不做出错提示。
     */
    //登录
    public int login(String name, String passWord) {

        Employee employee=this.employeeMapper.findEmployee(name);

        if(employee==null)
            return 0;
        else {
            System.out.println("已查询到用户！");
            if(!employee.getPassword().equals(passWord)) //字符串的比较应为equals！
                return 1;
            else {
                System.out.println("已查询到对象" + employee.getName() + employee.getId());
                return 2;
            }
        }
    }

    @Override
    //查找：应该做模糊查找
    public Employee findEmployee(String name) {
        Employee employee=this.employeeMapper.findEmployee(name);
        return employee;
    }

    @Override
    //删除
    public void delete(int id) {

        this.employeeMapper.deleteEmployee(id);
    }

    @Override
    //修改
    public void Update(Employee employee,int id){
        System.out.println("修改，待定中......");

    }

    //查找所有用户
    public List<Employee> findAll(){
        return this.employeeMapper.findAll();
    }

    @Override
    public List<Course> findAllCourse() {
        return courseMapper.findAll();
    }

    @Override
    public List<Score> findMyCourse(Integer id) {
        return employeeMapper.findMyCourse(id);
    }

    @Override
    public Integer judgeMyCourse(Integer uid, Integer id) {
        return employeeMapper.judgeMyCourse(uid,id);
    }

    @Override
    public Integer addCourse(Integer uid, Integer id) {
        return employeeMapper.addCourse(uid,id);
    }

    @Override
    public Integer deleteCourse(Integer id) {
        return employeeMapper.deleteCourse(id);
    }
}
