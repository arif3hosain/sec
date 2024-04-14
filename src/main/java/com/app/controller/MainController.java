package com.app.controller;

import com.app.model.User;
import com.app.other.Other;
import com.app.repository.ChatRepo;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by: arif hosain
 * Created at : 4/13/2024
 */


@Controller
public class MainController {

    @Autowired
    private ChatRepo chatRepo;
    @Autowired
    private UserService userService;


    @RequestMapping("/main")
    public String main( HttpServletRequest request, Model model){
        if(!userService.isLogin(request)) return "redirect:/login";
        model.addAttribute("chat", chatRepo.getOne(1L));
        return "main";
    }
}
