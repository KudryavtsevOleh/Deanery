package com.geekhub.service;

import com.geekhub.beans.LessonBean;
import com.geekhub.dao.LessonDao;
import com.geekhub.entity.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by oleh on 31.10.15.
 */
@Service
@Transactional
public class LessonService {

    @Autowired
    private LessonDao dao;

    public void saveLesson(String lessonName) {
        Lesson lesson = new Lesson();
        lesson.setLessonName(lessonName);
        dao.saveLesson(lesson);
    }

    public void updateLesson(String lessonName, Integer lessonId) {
        Lesson lesson = dao.getLessonById(lessonId);
        lesson.setLessonName(lessonName);
        dao.updateLesson(lesson);
    }

    public void removeLesson(Integer lessonId) {
        Lesson lesson = dao.getLessonById(lessonId);
        if (null != lesson) {
            dao.removeLesson(lesson);
        }
    }

    public Lesson getLessonById(Integer lessonId) {
        return dao.getLessonById(lessonId);
    }

    public List<LessonBean> getLessons() {
        List<LessonBean> result = new ArrayList<>();
        List<Lesson> lessons = dao.getLessons();
        result.addAll(lessons.stream().map(lesson -> new LessonBean(lesson.getId(), lesson.getLessonName())).collect(Collectors.toList()));
        return result;
    }

    /*
    * return true if lesson with such name is already exists
    * */
    public Boolean isLessonPresent(String lessonName) {
        Lesson lesson = dao.getLessonByName(lessonName);
        return lesson != null;
    }

}
