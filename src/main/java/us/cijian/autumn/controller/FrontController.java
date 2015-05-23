package us.cijian.autumn.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import us.cijian.autumn.service.WechatService;

import javax.annotation.Resource;

/**
 * Created by MurphyL on 2015/5/22.
 */
@Controller
public class FrontController {

    @RequestMapping(method = RequestMethod.GET, value = {"/", "/index"})
    public String index() {
        return "front/index";
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/login"})
    public String loginView() {
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated()) {
            return "redirect:dashboard";
        }
        return "login";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = {"/login"})
    public void loginCallback() {
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated()) {
            System.out.println("login success");
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/dashboard"})
    public String dashView() {
        return "backend/dashboard";
    }
}
