package com.qf.controller;

import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("loginUser")
    @ResponseBody
    public String loginUser (User user, HttpServletRequest request) {

        System.out.println(user);

        User user1 = userService.findByEmaAndPwd(user);
        System.out.println(user1);

        if (user1 != null) {
            HttpSession session = request.getSession();
            session.setAttribute("userAccount", user1.getEmail());
            return "success";
        }
        return "false";

    }

    @RequestMapping("showMyProfile")
    public String showMyProfile (HttpServletRequest request) {

        HttpSession session = request.getSession();
        String userAccount = (String) session.getAttribute("userAccount");
        User byEma = userService.findByEma(userAccount);
        session.setAttribute("user", byEma);

        return "/before/my_profile.jsp";
    }

    @RequestMapping("insertUser")
    @ResponseBody
    public String insertUser (User user, HttpServletRequest request) {
        System.out.println(user);
        user.setCreateTime(new Date());
        System.out.println(user);
        if (userService.insertUser(user)) {
            HttpSession session = request.getSession();
            session.setAttribute("userAccount", user.getEmail());
            return "success";
        }
        return "false";
    }

    @RequestMapping("validateEmail")
    @ResponseBody
    public String validateEmail (String email, HttpServletRequest request) {
//        System.out.println(email);
        User user = new User();
        user.setEmail(email);
//        System.out.println(userService.validateEmail(user));
        if (userService.validateEmail(user)==null) {
            return "success";
        } else {
            return "false";
        }
    }

    @RequestMapping("loginOut")
    @ResponseBody
    public String loginOut (HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.removeAttribute("userAccount");
        return "success";
    }

}
