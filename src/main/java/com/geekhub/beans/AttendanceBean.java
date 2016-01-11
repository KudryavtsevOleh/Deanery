package com.geekhub.beans;

import com.geekhub.entity.Lesson;
import com.geekhub.entity.Student;

import java.util.Date;

/**
 * Created by oleh on 01.11.15.
 */
public class AttendanceBean {

    private String studentFirstName;
    private String studentLastName;
    private String lesson;
    private Date attendanceDate;
    private Integer mark;
    private Boolean presents;

    public AttendanceBean(String studentFirstName, String studentLastName, String lesson, Date attendanceDate, Integer mark, Boolean presents) {
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.lesson = lesson;
        this.attendanceDate = attendanceDate;
        this.mark = mark;
        this.presents = presents;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }
    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }
    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getLesson() {
        return lesson;
    }
    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }
    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public Integer getMark() {
        return mark;
    }
    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Boolean getPresents() {
        return presents;
    }
    public void setPresents(Boolean presents) {
        this.presents = presents;
    }
}
