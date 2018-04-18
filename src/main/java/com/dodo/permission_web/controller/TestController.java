package com.dodo.permission_web.controller;


import com.dodo.permission_web.common.JsonData;
import com.dodo.permission_web.exception.PermissionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        log.info("hello");
        return "hello";
    }

    @RequestMapping("/hello.json")
    @ResponseBody
    public JsonData helloJson() {
        log.info("helloJson");
        return JsonData.success("helloJson");
    }

    @RequestMapping("/helloe.json")
    @ResponseBody
    public JsonData helloJsonEx() {
        log.info("helloJsonEx");
        throw new PermissionException("helloJsonEx ");
        //return JsonData.success("helloJsonEx");
    }


}
