package us.cijian.autumn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import us.cijian.autumn.service.WechatService;

import javax.annotation.Resource;

/**
 * Created by MurphyL on 2015/5/22.
 */
@Controller
public class SkillController {


    @Resource
    private WechatService service;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String harvest() {
        service.getAllSettings();
        return "index";
    }

}
