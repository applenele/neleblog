package com.nele.neleblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by apple on 15/3/22.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    @ResponseBody
    public String login(String username, String password, HttpSession session) {
        if (username.equals("admin") && password.equals("123456")) {
            session.setAttribute("user", "admin");
            return "ok";
        } else {
            return "no";
        }
    }
}
