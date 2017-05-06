package com.fanyank.controller;

import com.fanyank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yanfeng-mac on 2017/5/6.
 */
@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("user",userService.findById(1));
        return "index";
    }
}
