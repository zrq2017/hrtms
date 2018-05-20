package control;

import model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import serivce.AdminService;

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
