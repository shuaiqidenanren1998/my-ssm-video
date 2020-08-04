package com.qf.dao;

import com.qf.pojo.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDao {

    public List<Course> findAllTitle();
    public List<Course> findAllCourse();
    public void addCourse(Course course);
    public void updateCourse(Course course);
    public void delete(Integer id);
    public Course selectCourseById(Integer id);

}
