package controller;

import entity.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Allen
 * @create 2018-09-14 下午 3:05
 * @desc
 **/
@Controller
public class AdviceController {

    @RequestMapping(value="/advice")
    public String getSomething(@ModelAttribute("msg")String msg, DemoObj obj){
        throw new IllegalArgumentException("非常抱歉,参数有误/"+"来自@ModelAttribute"+msg);
    }
}
