package com.qf.service.impl;

import com.qf.dao.CourseDao;
import com.qf.pojo.Course;
import com.qf.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> findAllTitle() {
        return courseDao.findAllTitle();
    }

    @Override
    public List<Course> findAllCourse() {
        return courseDao.findAllCourse();
    }

    @Override
    public void addCourse(Course course) {
        courseDao.addCourse(course);
    }

    @Override
    public void updateCourse(Course course) {
        courseDao.updateCourse(course);
    }

    @Override
    public void delete(Integer id) {
        courseDao.delete(id);
    }

    @Override
    public Course selectCourseById(Integer id) {
        return courseDao.selectCourseById(id);
    }
}
