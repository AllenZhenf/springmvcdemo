package controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author Allen
 * @create 2018-09-14 下午 5:16
 * @desc 上传文件
 **/
@Controller
public class UploadController {
    @RequestMapping(value="/upload",method = RequestMethod.POST)
    @ResponseBody
    public String upload(MultipartFile file){
        try {
            FileUtils.writeByteArrayToFile(new File("d:/upload/"+file.getOriginalFilename()),file.getBytes());
            return "ok";
        } catch (IOException e) {
            e.printStackTrace();
            return "wrong";
        }
    }
}
