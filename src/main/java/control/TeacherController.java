package control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zrq on 2018-5-19.
 */
@Controller
@RequestMapping("/t")
public class TeacherController {

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
