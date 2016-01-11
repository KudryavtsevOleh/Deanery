package com.geekhub.beans;

/**
 * Created by oleh on 31.10.15.
 */
public class LessonBean {

    private Integer id;
    private String lessonName;

    public LessonBean(String lessonName) {
        this.lessonName = lessonName;
    }

    public LessonBean(Integer id, String lessonName) {
        this.id = id;
        this.lessonName = lessonName;
    }

    public String getLessonName() {
        return lessonName;
    }
    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
