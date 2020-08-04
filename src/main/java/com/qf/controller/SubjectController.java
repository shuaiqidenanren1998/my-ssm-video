package com.qf.controller;

import com.qf.pojo.Subject;
import com.qf.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @RequestMapping("selectAll")
    public String select (HttpServletRequest request) {

        List<Subject> subjects = subjectService.findAllSub();

        ServletContext servletContext = request.getSession().getServletContext();
        servletContext.setAttribute("subjectList", subjects);

        return "/before/index.jsp";
    }

    @RequestMapping("findAllSub")
    @ResponseBody
    public List<Subject> findAllSub () {
        return subjectService.findAllSub();
    }

}
