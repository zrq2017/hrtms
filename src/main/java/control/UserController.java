package control;


import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import serivce.UserService;

/**
 * 注：此为练习之用，与项目无关！
 * 控制器接收Http请求，并调用service接口，service实现类完成具体功能。
 * SpringMVC每次调用请求处理方法的时候都会创建Model类的一个实例，若
 * 打算使用该实例，则可以在方法中添加一个model类型的参数。还可以在方法中添加
 * ModelAttribute注解类型来访问Model实例（注解方法参数或方法,前者会将输入的及显示创建的参数对象
 * 添加到Model对象中，后者会在每次Http请求前调用该方法（可以返回一个对象或一个void类型，对象会自动添加到Model)。
 * 数据绑定是将用户输入绑定到领域模型的一种特性，有了数据绑定，类型总是为Spring的HTTP请求参数，可以填充不同类型
 * 的对象属性。数据绑定使得表单对象变成多余的，为了高效的使用数据绑定，还需要Spring的表单标签库。还有一个好处
 * 当输入验证失败的时候，它会重新生成一个HTML表单（不用重新输入数据）。
 * 问题：当输入登录页面时，需要跳转到登录页面。
 * 控制器的分类在我看来应以页面来分。
 */


public class UserController {
    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "hello",method=RequestMethod.GET)
    public String printHello(ModelMap model) {
        System.out.println("Controller已被调用");
        model.addAttribute("message", "Hello Spring MVC Framework!");
        System.out.println("message已添加");
        return "hello";
    }

    @RequestMapping("register")          //注册，表单参数,如何将表单参数封装成一个User对象。
  public String add(User user) {
        this.userService.add(user);
        return "hello";
    }

   @RequestMapping(value="Login")
    public String login(){
        return "Login";
    }

    @RequestMapping("checkLogin")
    public String checklogin(@RequestParam String userName,@RequestParam String passWord){
        System.out.println(userName+passWord);
        boolean flag=this.userService.login(userName,passWord);
        if(flag==true) {
            System.out.println("true");
            return "Shouye";
        }
        else
            return "Login";
    }
    }

