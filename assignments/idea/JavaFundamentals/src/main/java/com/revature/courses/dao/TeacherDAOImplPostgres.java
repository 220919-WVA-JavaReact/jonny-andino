package com.revature.courses.dao;

import com.revature.courses.models.Teacher;
import com.revature.courses.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAOImplPostgres implements TeacherDAO{
    @Override
    public Teacher getByUsername(String username) {
        // to get by username we are going to use a prepared statement to help us
        // prevent SQL injection

        // first create a teacher object to store the information i pull back
        Teacher teach = new Teacher();

        // we're going to use a try with resources block to ensure we close the connection

        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM teachers WHERE username = ?";
            //    data we want to insert into statement goes here ^

            PreparedStatement stmt = conn.prepareStatement(sql);

            //set the individual values for the question marks
            stmt.setString(1,username);
            ResultSet rs;

            //since i am expecting one result i will handle it differently

            if ((rs = stmt.executeQuery()) != null){
                rs.next(); // iterate by one

                int id          = rs.getInt("teacher_id");
                String first    = rs.getString("first");
                String last     = rs.getString("last");
                String receivedUsername = rs.getString("username");
                String password = rs.getString("password");

                teach = new Teacher(id,first,last,receivedUsername,password);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }

        return teach;
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
