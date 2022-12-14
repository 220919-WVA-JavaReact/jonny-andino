package com.revature.courses.dao;

import com.revature.courses.models.Course;
import com.revature.courses.models.Teacher;

import java.util.List;

public interface CourseDAO {
    // this is where i define the methods i want the dao to use to interact with some db

    // create a course method
    boolean createCourse(String courseNum, String title, Teacher teacher);

    // read all course methods
    List<Course> getAllCourses();

    // let's add an extra method to get courses by a teacher
    List<Course> getCoursesByTeacherId(int id);

    // update some course
    boolean updateCourse(Course course);

}
