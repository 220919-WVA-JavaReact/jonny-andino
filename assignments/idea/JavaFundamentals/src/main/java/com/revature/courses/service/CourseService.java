package com.revature.courses.service;

import com.revature.courses.dao.CourseDAO;
import com.revature.courses.dao.CourseDAOImpl;
import com.revature.courses.models.Course;
import com.revature.courses.models.Teacher;

import java.util.Scanner;

public class CourseService {

    Scanner sc = new Scanner(System.in);
    CourseDAO cd = new CourseDAOImpl();

    public void createCourse(Teacher loggedInTeacher){
        // menu logic to take in the user input
        System.out.println("Enter Course num: ");
        String courseNum = sc.nextLine();

        System.out.println("Enter Course Title: ");
        String title = sc.nextLine();

        cd.createCourse(courseNum,title,loggedInTeacher);
    }

    // how do we assign a course without a teacher?
    // we take in the course num and use the logged in info to assign the course
    public void assignCourse(Teacher loggedInTeacher){
        System.out.println("Enter course number");
        String courseNum = sc.nextLine();

        Course enroll = new Course(courseNum, loggedInTeacher);

        // now we've created a course object that has our primary key, and we have
        // our teacher id we want to update

        cd.updateCourse(enroll);
    }
}
