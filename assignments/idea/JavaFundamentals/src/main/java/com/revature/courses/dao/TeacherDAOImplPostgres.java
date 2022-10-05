package com.revature.courses.dao;

import com.revature.courses.models.Teacher;
import com.revature.courses.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAOImplPostgres implements TeacherDAO{
    @Override
    public Teacher getByUsername(String username) {
        return null;
    }

    @Override
    public Teacher createTeacher(String first, String last, String username, String password) {
        return null;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        Connection conn = ConnectionUtil.getConnection();

        List<Teacher> teachers = new ArrayList<>();

        //create a statement
        try {
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM teachers";
            ResultSet rs = statement.executeQuery(sql);

            // to store all of our teachers, i plan to create an empty list of teachers
            // and i will store the info inside of it

            while(rs.next()){
                int id          = rs.getInt("teacher_id");
                String first    = rs.getString("first");
                String last     = rs.getString("last");
                String username = rs.getString("username");
                String password = rs.getString("password");

                // create a teacher object
                Teacher teach = new Teacher(id,first,last,username,password);

                teachers.add(teach);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }
}
