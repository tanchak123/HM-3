package com.ithillel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
public class DefaultController {

    @RequestMapping("/jsp")
    public String main(Model model) {
        System.out.println("HELLO FROM CONTROLLER::" + System.getProperty("user.dir"));
        return "/WEB-INF/views/asd.jsp";
    }
}
