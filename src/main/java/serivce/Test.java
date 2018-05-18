package serivce;

import mapper.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {
    private UserMapper userMapper;
    /*
       set方法不可以是私有的。
     */
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    private void delete(int id){
        System.out.println("参数已传入");
        this.userMapper.deleteUser(id);
    }

    public static void main(String args[]){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("Spring-mybaits.xml");
        System.out.println("ctx已生成");
        Test a=(Test)ctx.getBean("test", Test.class);
        System.out.println("Test已生成");
        a.delete(3);

        System.out.println("已删除");

    }
}
