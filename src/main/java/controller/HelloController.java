package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @create 2018-09-06 上午 11:51
 * @desc
 **/
@Controller
public class HelloController {

    @RequestMapping(value="/hello")
    public String hello(){
        return "hell";
    }
}
