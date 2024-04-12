package com.app.controller;

import com.app.model.User;
import com.app.repository.UserRepository;
import com.app.service.UserService;
import com.app.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by: arif hosain
 * Mail: arif@innoweb.co
 * Created at : 4/12/2024
 */

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, @ModelAttribute("login") User login,
                        @RequestParam(value = "check", required = false) boolean check,
                        HttpServletRequest request) {
        if (check) {
            login.setUsername((String) request.getSession().getAttribute("username"));
        }
        model.addAttribute("validUser", check);
        return "login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginAccess(Model model, @ModelAttribute("login") User login, HttpServletRequest request) {
        User user = userRepository.findByUsername(login.getUsername());
        if (isNotEmpty(login.getPassword())) {
            System.out.println("---1");
            if (user.getPassword().equalsIgnoreCase(login.getPassword())) {
                System.out.println("login success");
                return "redirect:/welcome";
            } else {
                System.out.println("pass not matched>>>>>>>>>>>>>>"+request.getSession().getAttribute("username"));
                model.addAttribute("error", "Incorrect Password, Try Again.");
                model.addAttribute("validUser", request.getSession().getAttribute("username") != null ? true : false);
                return "login";
            }
        } else
            if (user != null ) {
            System.out.println("---2");
            request.getSession().setAttribute("username", login.getUsername());
            return "redirect:/login?check=true";
        } else {
            System.out.println("---3");
            model.addAttribute("error", "Username doesn't matched.");
            return "login";
        }

    }


    public static boolean isNotEmpty(String str) {
        if (str == null) return false;
        if(str.trim().equals("")) return false;
        return str.trim().length() > 0;
    }
}
