package com.qf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.pojo.Course;
import com.qf.pojo.Subject;
import com.qf.service.CourseService;
import com.qf.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private SubjectService subjectService;

    @RequestMapping("findAllTitle")
    @ResponseBody
    public List<Course> findAllTitle () {
        return courseService.findAllTitle();
    }

    @RequestMapping("course/{subjectId}")
    public String course (@PathVariable String subjectId, Model model) {

        int id = Integer.parseInt(subjectId);

        Subject subject = subjectService.selectSubject(id);
        model.addAttribute("subject", subject);

        return "/before/course.jsp";
    }

    @RequestMapping("findAllCourse")
    @ResponseBody
    public Map findAllCourse (Integer page, Integer limit) {

        PageHelper.startPage(page, limit);

        List<Course> courses = courseService.findAllCourse();

        PageInfo<Course> pageInfo = new PageInfo<>(courses);

        Map<String, Object> map = new HashMap();

        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageInfo.getTotal());
        map.put("data", pageInfo.getList());

        return map;
    }

    @RequestMapping("addCourse")
    @ResponseBody
    public void addCourse (Course course) {
        System.out.println(course);
        courseService.addCourse(course);
    }

    @RequestMapping("updateCourse")
    @ResponseBody
    public void updateCourse (Course course) {
        System.out.println(course);
        courseService.updateCourse(course);
    }

    @RequestMapping("delete")
    @ResponseBody
    public void delete (Integer id) {
        courseService.delete(id);
    }

}
