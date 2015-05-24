package us.cijian.autumn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import us.cijian.autumn.constants.Privileges;
import us.cijian.autumn.constants.Role;

/**
 * Created by MurphyL on 5/24/2015.
 */
@Controller
@Role(Privileges.Owner)
@RequestMapping("/privileges")
public class PrivilegesController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String show(){
        return "backend/privileges.list";
    }

}
