package com.revature.courses.dao;

import com.revature.courses.models.Teacher;

public interface TeacherDAO {
    // inside here we are providing the basic requirements we want our DAO to have
    // this will essentially be a list of methods that we will be implemented
    // or a specific of database

    // we could have these implemented for working with files, a SQL database, or whatever

    Teacher getByUsername(String username);

    // we need a method for teacher creation
    Teacher createTeacher(String first, String last, String username, String password);
}
