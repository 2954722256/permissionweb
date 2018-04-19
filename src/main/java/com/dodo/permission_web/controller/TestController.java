package com.dodo.permission_web.controller;


import com.dodo.permission_web.common.ApplicationContextHelper;
import com.dodo.permission_web.common.JsonData;
import com.dodo.permission_web.dao.SysAclModuleMapper;
import com.dodo.permission_web.exception.ParamException;
import com.dodo.permission_web.exception.PermissionException;
import com.dodo.permission_web.model.SysAclModule;
import com.dodo.permission_web.param.TestVo;
import com.dodo.permission_web.utils.BeanValidator;
import com.dodo.permission_web.utils.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

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

    @RequestMapping("/validate.json")
    @ResponseBody
    public JsonData validate(TestVo vo) throws ParamException ,PermissionException{
        log.info("validate");
        try {
            Map<String, String > map = BeanValidator.validateObject(vo);
            if(null != map && map.entrySet().size() > 0){
                for(Map.Entry<String, String> entry : map.entrySet()){
                    log.info("{}->{}", entry.getKey(), entry.getValue());
//                    log.info("{}", entry.getKey());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        throw new PermissionException("helloJsonEx ");
//        return JsonData.success("test validate");
    }


    /**
     * 用于测试，对应的 ApplicationContextHelper 和 Mapper 等工具类
     * @param vo
     * @return
     * @throws ParamException
     */
    @RequestMapping("/validate2.json")
    @ResponseBody
    public JsonData validate2(TestVo vo) throws ParamException {
        log.info("validate");
        SysAclModuleMapper moduleMapper = ApplicationContextHelper.popBean(SysAclModuleMapper.class);
        SysAclModule module = moduleMapper.selectByPrimaryKey(1);
        log.info(JsonMapper.obj2String(module));
        BeanValidator.check(vo);
        return JsonData.success("test validate");
    }


}
