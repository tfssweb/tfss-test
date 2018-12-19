package com.zhongziyue.video.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @Value("${videos.vpath}")
    private String vpath;

    @Value("${videos.rpath}")
    private String rpath;

//    @RequestMapping("/")
//    @ResponseBody
//    public String test() {
//        System.out.println(vpath);
//        System.out.println(rpath);
//        return "Hello!";
//    }
}