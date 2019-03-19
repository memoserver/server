package com.memo.server.controller;

import com.memo.server.HelloOSS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@Controller
public class PhotoController {

    private static final Logger logger = LoggerFactory.getLogger(PhotoController.class);

    @RequestMapping("/greeting")
    public String greeting() {
        return "index";
    }
    //文件上传相关代码

    @RequestMapping(value = "upload")
    @ResponseBody
    public String upload(@RequestParam("test") MultipartFile file) {
        if (file.isEmpty()) {
            return "文件为空";
        }
        HelloOSS oss = new HelloOSS();
        oss.openOss();
        // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        String filePath = "Image/photo/" + fileName;
        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
        try {
            File t = File.createTempFile("tmp", null);
            file.transferTo(t);
            oss.uploadImageFile(t, filePath);
            String url = oss.getUrl(filePath);
            oss.downloadImage("Image/photo/32.txt");
            oss.clossOss();
            return filePath;

        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";

    }

    //文件下载相关代码
    @RequestMapping("/download")
    public String openObject(String key) throws IOException {
        key = "Image/photo/32.txt";
        HelloOSS oss = new HelloOSS();
        oss.openOss();
        String urlstring = oss.getUrl(key);
        System.out.println(urlstring);
        URL url = new URL(urlstring);
        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
        oss.clossOss();
        return null;
    }
}