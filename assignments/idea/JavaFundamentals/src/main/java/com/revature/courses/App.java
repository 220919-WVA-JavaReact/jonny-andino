package com.revature.courses;

import com.revature.courses.models.Teacher;
import com.revature.courses.service.TeacherService;
import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class App {

    // similarly to our service layer, when we want logic done we will  need an instance of

    public static TeacherService ts = new TeacherService();

    public static void main(String[] args) {
        // inside of my app class is all of the information and logic to start and run the application
        // menu logic should be here and this should call upon the service layer to do any logic for us

        // we can start the app with some sort of menu and loop
        // we'll want to prompt the user to either log in or register

        System.out.println("Press 1 to log in. Press 2 to register");

        Scanner sc = new Scanner(System.in);

        String choice = sc.nextLine();

        if (choice.equals("1")) {
            // this is where we get login credentials

            System.out.println("Please enter your username");
            String username = sc.nextLine();
            System.out.println("Please enter a password");
            String password = sc.nextLine();

            ts.login(username,password);

            //At this point, we would call our TeacherService class to handle the logic for signing in
        } else if (choice.equals("2")) {
            // this is where we get registration credentials
            System.out.println("Please enter your First Name");
            String first = sc.nextLine();
            System.out.println("Please enter your Last Name");
            String last = sc.nextLine();
            System.out.println("Please enter your username");
            String username = sc.nextLine();
            System.out.println("Please enter a password");
            String password = sc.nextLine();

        } else {
            //
        }

    }
}
