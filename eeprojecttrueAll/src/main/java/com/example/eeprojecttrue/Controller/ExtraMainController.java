package com.example.eeprojecttrue.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExtraMainController {

    @RequestMapping(value = "/portfoliotwo.html")
    public String tests() {
        return "portfoliotwo";
    }

}