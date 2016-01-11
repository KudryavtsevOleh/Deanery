package com.geekhub.dao;

import com.geekhub.beans.LessonBean;
import com.geekhub.entity.Lesson;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by oleh on 31.10.15.
 */
@Repository
public class LessonDao {

    @Autowired
    private SessionFactory sessionFactory;
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void saveLesson(Lesson lesson) {
        getSession().save(lesson);
    }

    public void updateLesson(Lesson lesson) {
        getSession().update(lesson);
    }

    public void removeLesson(Lesson lesson) {
        getSession().delete(lesson);
    }

    public Lesson getLessonById(Integer id) {
        return (Lesson) getSession().get(Lesson.class, id);
    }

    public Lesson getLessonByName(String lessonName) {
        Criteria criteria = getSession().createCriteria(Lesson.class)
                .add(Restrictions.like("lessonName", lessonName));
        return (Lesson) criteria.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<Lesson> getLessons() {
        Criteria criteria = getSession().createCriteria(Lesson.class);
        return criteria.list();
    }

}
