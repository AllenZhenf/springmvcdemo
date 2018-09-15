package controller;

import entity.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Allen
 * @create 2018-09-15 下午 12:33
 * @desc
 **/
@Controller
public class ConverterController {

    @RequestMapping(value="/convert",produces = {"application/x-wisely"})
    @ResponseBody
    public DemoObj convert(@RequestBody DemoObj demoObj){
        return demoObj;
    }
}
