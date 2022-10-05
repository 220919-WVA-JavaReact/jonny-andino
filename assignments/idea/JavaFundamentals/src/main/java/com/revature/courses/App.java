package com.revature.courses;

import com.revature.courses.models.Teacher;
import com.revature.courses.service.CourseService;
import com.revature.courses.service.TeacherService;
import com.revature.courses.util.ConnectionUtil;

import java.sql.Connection;
import java.util.Scanner;

public class App {

    // similarly to our service layer, when we want logic done we will  need an instance of

    public static TeacherService ts = new TeacherService();
    public static CourseService cs = new CourseService();

    public static void main(String[] args) {
        // inside my app class is all the information and logic to start and run the application
        // menu logic should be here and this should call upon the service layer to do any logic for us

        // we can start the app with some sort of menu and loop
        // we'll want to prompt the user to either log in or register


        System.out.println("Press 1 to log in. Press 2 to register");

        Scanner sc = new Scanner(System.in);

        String choice = sc.nextLine();

        Teacher loggedInTeacher = null;

        if (choice.equals("1")) {
            // this is where we get login credentials
            loggedInTeacher = ts.login();
            //At this point, we would call our TeacherService class to handle the logic for signing in
        } else if (choice.equals("2")) {
            // this is where we get registration credentials
            loggedInTeacher = ts.register();
        }

        if (loggedInTeacher != null) {
            System.out.println("Press 1 to create a course, 2 to teach a course, 3 to view all courses, or 4 to view your courses");
            String subChoice = sc.nextLine();

            switch(subChoice){
                case "1":
                    cs.createCourse();
                    break;
                case "2":
                    cs.assignCourse(loggedInTeacher.getTeacherId());
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
}
