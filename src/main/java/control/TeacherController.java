package control;

import model.Course;
import model.Score;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import serivce.TeacherService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by zrq on 2018-5-19.
 */
@Controller
@RequestMapping("/t")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("saveScore")
    public String saveScore(HttpServletRequest request, Map<String,Object> map, Score score){
        Integer i=teacherService.updateScore(score);
        return addScore(request,map);
    }

    @RequestMapping("addScore")
    public String addScore(HttpServletRequest request, Map<String,Object> map){
        Integer tid=((User)request.getSession().getAttribute("User")).getId();
        List<Score> scoreList=teacherService.findMyStudent(tid);
        map.put("scoreList",scoreList);
        return "addScore";
    }

    @RequestMapping("show")
    public String show(HttpServletRequest request, Map<String,Object> map){
        Integer tid=((User)request.getSession().getAttribute("User")).getId();
        List<Course> courseList=teacherService.findMyCourse(tid);
        map.put("courseList",courseList);
        return "show";
    }

    @RequestMapping("deleteCourse")
    public String deleteCourse(Map<String,Object> map, @RequestParam("id") Integer id){
        Integer i=teacherService.deleteCourse(id);
        return choose(map);
    }

    @RequestMapping("chooseCourse")
    public String chooseCourse(HttpServletRequest request, Map<String, Object> map, @RequestParam("id") Integer id){
        Integer tid=((User)request.getSession().getAttribute("User")).getId();
        Integer i=teacherService.chooseCourse(id,tid);
        return choose(map);
    }

    @RequestMapping("choose")
    public String choose(Map<String,Object> map){
        List<Course> courseList=teacherService.findAll();
        map.put("courseList",courseList);
        return "choose";
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
