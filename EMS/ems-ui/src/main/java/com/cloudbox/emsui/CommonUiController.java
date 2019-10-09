package com.cloudbox.emsui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonUiController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    String gethomepage(){
        return "index";
    }
}
