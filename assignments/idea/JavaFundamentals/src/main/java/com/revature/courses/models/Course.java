package com.revature.courses.models;

import java.util.Objects;

public class Course {
    private String courseNum;
    private String title;
    private Teacher teacher;

    public Course(String courseNum, String title, Teacher teacher) {
        this.courseNum = courseNum;
        this.title = title;
        this.teacher = teacher;
    }

    public Course(String courseNum, Teacher teacher) {
        this.courseNum = courseNum;
        this.teacher = teacher;
    }

    public Course() {
    }

    public String getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Teacher getTeacherId() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseNum='" + courseNum + '\'' +
                ", title='" + title + '\'' +
                ", teacher=" + teacher +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return courseNum.equals(course.courseNum) && title.equals(course.title) && teacher.equals(course.teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseNum, title, teacher);
    }
}
