package com.example.demo.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/5/5 14:02
 **/
@RestController
public class UploadController {


    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file") MultipartFile uploadFile){

        try {

            File file = new File("d://upload/"+uploadFile.getOriginalFilename());
            FileUtils.writeByteArrayToFile(file,uploadFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "upload";
    }

}
