package com.revature.courses.service;

import com.revature.courses.dao.TeacherDAO;
import com.revature.courses.dao.TeacherDAOImpl;
import com.revature.courses.dao.TeacherDAOImplPostgres;
import com.revature.courses.models.Teacher;

import java.util.List;
import java.util.Scanner;

public class TeacherService {
    //so the role of this class is to provide the logic for options and eventually
    //call upon the DAO to persist the information we request

    //we have logic for logging in and registering, so we should have methods to handle that

    //whenever we want to make a call to the db, we need to provide a TeacherDAOImpl instance

    TeacherDAO td = new TeacherDAOImplPostgres(); // <-- can change the implementation whenever i want
    Scanner sc = new Scanner(System.in);
    public Teacher login(){
        // the objective of this method is to call upon the DAO to get
        // the account associated with our username, then we will
        // verify the password and "log" the user in
        System.out.println("Please enter your username");
        String username = sc.nextLine();
        System.out.println("Please enter a password");
        String password = sc.nextLine();

        // step 1; call the database and find info based on the submitted username
        Teacher teach = td.getByUsername(username);
        // step 2; check the returned password of the username
        if (teach.getPassword().equals(password)) {
            System.out.println("Congrats!");
            return teach;
        } else {
            System.out.println("Invalid login");
            return null;
        }
        // and verify it matches the entered password
    }

    public Teacher register(){
        System.out.println("Please enter your First Name");
        String first = sc.nextLine();
        System.out.println("Please enter your Last Name");
        String last = sc.nextLine();
        System.out.println("Please enter your username");
        String username = sc.nextLine();
        System.out.println("Please enter a password");
        String password = sc.nextLine();

        // now that we created the DAO method, we just need to call it with the info provided.
        return td.createTeacher(first, last, username, password);
    }

    public void getAllTeachers(){
        System.out.println("using the database to return all of our teachers");
        List<Teacher> teacherList = td.getAllTeachers();
        for(Teacher teacher : teacherList){
            System.out.println(teacher);
        }
    }
}
