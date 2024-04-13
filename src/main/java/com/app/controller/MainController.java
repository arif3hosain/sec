package com.app.controller;

import com.app.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by: arif hosain
 * Mail: arif@innoweb.co
 * Created at : 4/13/2024
 */


@Controller
public class MainController {

    @RequestMapping("/main")
    public String main( HttpServletRequest request, Model model){
        return "main";
    }
}
