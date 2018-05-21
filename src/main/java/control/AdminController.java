package control;

import model.Course;
import model.Money;
import model.Score;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import serivce.AdminService;
import serivce.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by zrq on 2018-5-19.
 */
@Controller
@RequestMapping("/a")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;

    @RequestMapping("saveInfo")
    public String info(HttpServletRequest request,Map<String, Object> map,User user){
        user.setRole((String)request.getSession().getAttribute("role"));
        Integer i=userService.update(user);
        request.getSession().setAttribute("User",user);
        return "info";
    }

    @RequestMapping("money")
    public String money(Map<String,Object> map,Money money){
        List<Money> moneyList=adminService.findMoney(money);
        List<Course> courseList=adminService.findAll();
        map.put("moneyList",moneyList);
        map.put("courseList",courseList);
        return "money";
    }

    @RequestMapping("saveMoney")
    public String saveMoney(Map<String,Object> map,Money money){
        Integer i=adminService.updateMoney(money);
        return money(map,money);
    }

    @RequestMapping("score")
    public String score(Map<String,Object> map,Course course){
        List<Score> scoreList=adminService.findScore(course);
        List<Course> courseList=adminService.findAll();
        map.put("scoreList",scoreList);
        map.put("courseList",courseList);
        return "score";
    }

    @RequestMapping("saveCourse")
    public String saveCourse(Map<String,Object> map,Course course){
        Integer i;
        if(course.getId()!=null){
            i=adminService.updateCourse(course);
        }else{
            i=adminService.addCourse(course);
        }
        return course(map);
    }

    @RequestMapping("deleteCourse")
    public String deleteCourse(Map<String,Object> map,Integer id){
        int i=adminService.deleteCourse(id);
        return course(map);
    }

    @RequestMapping("course")
    public String course(Map<String,Object> map){
        List<Course> courseList=adminService.findAll();
        map.put("courseList",courseList);
        return "course";
    }

    /**
     * 任意页面
     * @param url
     * @return
     */
    @RequestMapping("{url}")
    public String url(@PathVariable("url") String url){
        return url;
    }

}
