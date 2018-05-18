package control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zrq on 2018-5-18.
 */
@Controller
@RequestMapping
public class UrlController {

    //默认页
    @RequestMapping(value = {"home",""})
    public String index() {
        return "home";
    }

    //默认页
    @RequestMapping("common/{url}")
    public String header(@PathVariable("url") String url) {
        return "common/"+url;
    }

    @RequestMapping("{url}")
    public String url(@PathVariable("url") String url, Model model){
        model.addAttribute("message","AAAAAAAAA");
        return url;
    }

}
