package com.revature.courses.service;

import com.revature.courses.dao.TeacherDAO;
import com.revature.courses.dao.TeacherDAOImpl;
import com.revature.courses.models.Teacher;

public class TeacherService {
    //so the role of this class is to provide the logic for options and eventually
    //call upon the DAO to persist the information we request

    //we have logic for logging in and registering, so we should have methods to handle that

    //whenever we want to make a call to the db, we need to provide a TeacherDAOImpl instance

    TeacherDAO td = new TeacherDAOImpl(); // <-- can change the implementation whenever i want

    public void login(String username, String password){
        // the objective of this method is to call upon the DAO to get
        // the account associated with our username, then we will
        // verify the password and "log" the user in

        // step 1; call the database and find info based on the submitted username
        Teacher teach = td.getByUsername(username);
        // step 2; check the returned password of the username
        if (teach.getPassword().equals(password)) {
            System.out.println("Congrats!");
        } else {
            System.out.println("Invalid login");
        }
        // and verify it matches the entered password
    }
}
