package com.revature.courses.dao;

import com.revature.courses.models.Course;

import java.util.List;

public class CourseDAOImpl implements CourseDAO{
    @Override
    public Course createCourse(String courseNum, String title, int teacherId) {
        System.out.println("Called the createCourse method.");
        return null;
    }

    @Override
    public List<Course> getAllCourses() {
        System.out.println("Called the getAllCourses method.");
        return null;
    }

    @Override
    public List<Course> getCoursesByTeacherId(int id) {
        System.out.println("Called the getCoursesByTeacherId method.");
        return null;
    }

    @Override
    public boolean updateCourse(Course course) {
        System.out.println("Called the updateCourse method.");
        return false;
    }
}
