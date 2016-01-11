package com.geekhub.entity;

import javax.persistence.*;

/**
 * Created by oleh on 31.10.15.
 */
@Entity
@Table(name = "LESSONS")
public class Lesson {

    @Id
    @GeneratedValue
    private Integer id;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "LESSON_NAME")
    private String lessonName;
    public String getLessonName() {
        return lessonName;
    }
    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }
}
