package com.revature.courses.service;

import com.revature.courses.dao.CourseDAO;
import com.revature.courses.dao.CourseDAOImpl;
import com.revature.courses.models.Course;

import java.util.Scanner;

public class CourseService {

    Scanner sc = new Scanner(System.in);
    CourseDAO cd = new CourseDAOImpl();

    public void createCourse(){
        // menu logic to take in the user input
        System.out.println("Enter Course num: ");
        String courseNum = sc.nextLine();

        System.out.println("Enter Course Title: ");
        String title = sc.nextLine();

        System.out.println("Enter Teacher Id: ");
        int teacherId = Integer.parseInt(sc.nextLine());

        cd.createCourse(courseNum,title,teacherId);
    }

    // how do we assign a course without a teacher?
    // we take in the course num and use the logged in info to assign the course
    public void assignCourse(int teacherId){
        System.out.println("Enter course number");
        String courseNum = sc.nextLine();

        Course enroll = new Course(courseNum, teacherId);

        // now we've created a course object that has our primary key, and we have
        // our teacher id we want to update

        cd.updateCourse(enroll);
    }
}
