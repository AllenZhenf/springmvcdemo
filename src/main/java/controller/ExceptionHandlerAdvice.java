package controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Allen
 * @create 2018-09-14 下午 2:52
 * @desc  全局异常捕捉必须跟controller在同一个包
 **/
@ControllerAdvice //声明一个控制器建言，@ControllerAdvice组合了@Component注解,自动注册为bean
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value=Exception.class) //拦截所有的exception  value属性可以设置过滤条件
    public ModelAndView exception(Exception exception, WebRequest request){
        ModelAndView modelAndView=new ModelAndView("error");
        modelAndView.addObject("errorMessage",exception.getMessage());
        return modelAndView;
    }

    @ModelAttribute //注解将键值对添加到全局，所有注解的@RequestMapping的方法可获得此键值对
    public void addAttributes(Model model){
        model.addAttribute("msg","额外信息");
    }

    @InitBinder  //定制WebDataBinder 用来自动绑定前台请求参数到model中
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");
    }
}
