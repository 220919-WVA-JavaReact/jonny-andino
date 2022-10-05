package com.revature.courses.dao;

import com.revature.courses.models.Course;
import com.revature.courses.models.Teacher;
import com.revature.courses.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CourseDAOImpl implements CourseDAO{

    @Override
    public boolean createCourse(String courseNum, String title, Teacher teacher) {

        try (Connection conn = ConnectionUtil.getConnection()){
            String sql = "INSERT INTO courses VALUES (?,?,?) RETURNING *";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, courseNum);
            stmt.setString(2, title);
            stmt.setInt(3, teacher.getTeacherId());

            int rowsUpdated = stmt.executeUpdate();

            return ( rowsUpdated >= 0);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Course> getAllCourses() {
        return null;
    }

    @Override
    public List<Course> getCoursesByTeacherId(int id) {
        return null;
    }

    @Override
    public boolean updateCourse(Course course) {
        return false;
    }
}
