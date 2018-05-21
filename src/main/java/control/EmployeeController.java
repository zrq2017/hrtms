package control;

import com.sun.javafx.sg.prism.NGShape;
import model.Course;
import model.Employee;

import model.Score;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;
import serivce.EmployeeService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/e")
public class EmployeeController {
    /*
    遇到的问题：@service要标注ServiceImpl，否则报错。
    思考：采用接口编程，实际调用的是实现类的方法，需要实现类的实体。
     */
    @Autowired
    private EmployeeService employeeService;

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("deleteCourse")
    public String deleteCourse(HttpServletRequest request,Map<String,Object> map,@RequestParam("id") Integer id){
        Integer j = employeeService.deleteCourse(id);
        return mycourse(request,map);
    }

    @RequestMapping("addCourse")
    public String addCourse(HttpServletRequest request,Map<String,Object> map,@RequestParam("id") Integer id){
        String msg="";
        Integer uid=((User)request.getSession().getAttribute("User")).getId();
        Integer i=employeeService.judgeMyCourse(uid,id);
        if(i==0) {
            Integer j = employeeService.addCourse(uid, id);
        }else{
            map.put("msg","已报名，无需重复报名！！");
            return course(map);
        }
        return mycourse(request,map);
    }

    @RequestMapping("mycourse")
    public String mycourse(HttpServletRequest request,Map<String, Object> map){
        Integer uid=((User)request.getSession().getAttribute("User")).getId();
        List<Score> scoreList=employeeService.findMyCourse(uid);
        map.put("scoreList",scoreList);
        return "mycourse";
    }

    @RequestMapping("course")
    public String course(Map<String,Object> map){
        List<Course> courseList=employeeService.findAllCourse();
        map.put("courseList",courseList);
        return "mycourse";
    }

    //注册
    @RequestMapping("/register")          //注册，表单参数,如何将表单参数封装成一个User对象。
    public String add(Employee employee) {
        this.employeeService.add(employee);
        return "hello";
    }
//
//    //点击登录按钮，进行登录校验。
//    /*
//    登录的3种状态，用String还是用int呢？，需要将这3种状态传到页面。
//
//     */
//    @RequestMapping("/checkLogin")
//    public String  checklogin(@RequestParam String userName, @RequestParam String passWord, Model model,Map<String,Object> map){
//        System.out.println(userName+passWord);
//        int flag=this.employeeService.login(userName,passWord);
//        if(flag==0) {
//            model.addAttribute("msg","用户不存在！");
//
//            return "Login";//将model中的信息传到首页。
//        }
//        else if(flag==1){
//
//             model.addAttribute("msg","密码错误！");
//            return "Login";
//        }
//        else{//此处应该将登录者的信息传到首页。对于前后端分离，不使用JSP页面，那么应该将数据以JSON的形式返回给客户端。
////            model.addAttribute("User","userName");
//            map.put("User","test");
//            return "Shouye";
//        }
//    }

    @RequestMapping("{url}")
    @ResponseBody
    public String url(@PathVariable("url") String url,Model model){
        model.addAttribute("message","AAAAAAAAA");
        return url;
    }
}
