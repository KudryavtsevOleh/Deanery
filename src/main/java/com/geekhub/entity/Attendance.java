package com.geekhub.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by oleh on 31.10.15.
 */
@Entity
@Table(name = "ATTENDANCE")
public class Attendance {

    @Id
    @GeneratedValue
    private Integer id;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STUDENT_ID")
    private Student student;
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LESSON_ID")
    private Lesson lesson;
    public Lesson getLesson() {
        return lesson;
    }
    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    @Column(name = "ATTENDANCE_DATE")
    private Date attendanceDate;
    public Date getAttendanceDate() {
        return attendanceDate;
    }
    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    @Column(name = "MARK")
    private Integer mark;
    public Integer getMark() {
        return mark;
    }
    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Column(name = "PRESENTS")
    private Boolean presents;
    public Boolean getPresents() {
        return presents;
    }
    public void setPresents(Boolean presents) {
        this.presents = presents;
    }
}
