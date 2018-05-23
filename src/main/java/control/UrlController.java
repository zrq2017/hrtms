package control;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import serivce.EmployeeService;
import serivce.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by zrq on 2018-5-18.
 */
@Controller
@RequestMapping("")
public class UrlController {
    @Autowired
    private UserService userService;

    //默认页
    @RequestMapping(value = {"home",""})
    public String index() {
        return "home";
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("navMap");
        request.getSession().removeAttribute("role");
        request.getSession().removeAttribute("User");
        return "home";
    }

    //登录页面，点击登录按钮跳转到登录页面。或者默认跳转到登录页面。
    @RequestMapping(value={"{url}/Login","{url}/login"})
    public String login(){
        return "Login";
    }

    //点击登录按钮，进行登录校验。
    /**
     * 登录校验
     * @param request
     * @param url
     * @param userName
     * @param passWord
     * @param map
     * @return
     */
    @RequestMapping("{url}/checkLogin")
    public String checkLogin(HttpServletRequest request, @PathVariable("url") String url,
                             @RequestParam String userName, @RequestParam String passWord, Map<String,Object> map) {
        System.out.println(userName+passWord);
        User user=this.userService.findByRoleNamePassword(url,userName,passWord);
        if(user==null) {
            map.put("msg","用户不存在或密码错误！");
            return "Login";//将model中的信息传到首页。
        }else{//此处应该将登录者的信息传到首页。保存不同角色的功能列表
            user.setPassword("");
            Map<String,String> navMap=new TreeMap<String,String>();
            navMap.put("/info","个人信息");
            if(url.equals("employee")){
                navMap.put("/e/course","课程列表");
                navMap.put("/e/mycourse","我的课程");
                System.out.println("employee");
            }else if(url.equals("teacher")){
                navMap.put("/t/choose","授课选择");
                navMap.put("/t/show","课表详情");
                navMap.put("/t/addScore","成绩录入");
                System.out.println("teacher");
            }else if(url.equals("admin")){
                navMap.put("/a/course","课程列表");
                navMap.put("/a/score","成绩列表");
                navMap.put("/a/money","薪酬管理");
                navMap.put("/a/user","用户管理");
                System.out.println("admin");
            }
            System.out.println("path:"+request.getContextPath());
            request.getSession().setAttribute("User",user);
            request.getSession().setAttribute("role",url);
            request.getSession().setAttribute("navMap",navMap);
            return "redirect:/home";
        }
    }

    @RequestMapping("saveInfo")
    public String info(HttpServletRequest request,Map<String, Object> map,User user){
        user.setRole((String)request.getSession().getAttribute("role"));
        Integer i=userService.update(user);
        request.getSession().setAttribute("User",user);
        return "info";
    }

    //默认页，个人主页框架页面资源导入
    @RequestMapping("common/{url}")
    public String header(@PathVariable("url") String url) {
        return "common/"+url;
    }

    /**
     * 任意页面
     * @param url
     * @param model
     * @return
     */
    @RequestMapping("{url}")
    public String url(@PathVariable("url") String url, Model model){
        model.addAttribute("message","AAAAAAAAA");
        return url;
    }

}
