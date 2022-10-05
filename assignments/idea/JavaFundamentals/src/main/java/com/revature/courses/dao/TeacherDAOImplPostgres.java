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
        // here we're going to add a teacher to the db

        //create blank teacher
        Teacher teach = new Teacher();
        try(Connection conn = ConnectionUtil.getConnection()){
            // inside of here is where we write and execute our sql statement
            String sql = "INSERT INTO teachers (\"first\", \"last\", \"username\", \"password\") VALUES (?,?,?,?) RETURNING *" ;
            // set individual values
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, first);
            stmt.setString(2, last);
            stmt.setString(3, username);
            stmt.setString(4, password);

            ResultSet rs;

            if ((rs = stmt.executeQuery()) != null){
                rs.next();

                int id = rs.getInt("teacher_id");
                String receivedFirst    = rs.getString("first");
                String receivedLast     = rs.getString("last");
                String receivedUsername = rs.getString("username");
                String receivedPassword = rs.getString("password");

                teach = new Teacher(id, receivedFirst, receivedLast, receivedUsername, receivedPassword);
            }

        } catch(SQLException e){
            System.out.println("couldn't add user to db");
            e.printStackTrace();
        }

        return teach;
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
