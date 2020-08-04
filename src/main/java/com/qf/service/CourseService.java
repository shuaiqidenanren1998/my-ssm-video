package com.qf.service;

import com.qf.pojo.Course;

import java.util.List;

public interface CourseService {

    public List<Course> findAllTitle();
    public List<Course> findAllCourse();
    public void addCourse(Course course);
    public void updateCourse(Course course);
    public void delete(Integer id);
    public Course selectCourseById(Integer id);

}
