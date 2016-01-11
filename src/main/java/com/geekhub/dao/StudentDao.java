package com.geekhub.dao;

import com.geekhub.entity.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import java.util.List;
import java.util.Objects;

/**
 * Created by oleh on 31.10.15.
 */
@Repository
public class StudentDao {

    private static final Integer EMPTY_SEARCH_VALUE = 0;

    @Autowired
    private SessionFactory sessionFactory;
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public List<Student> getStudents() {
        Criteria criteria = getSession().createCriteria(Student.class);
        return criteria.list();
    }

    /*
    * set group to default value when group was removed
    * TODO: reactor this method and search better way to update collection of entities
    * */
    public void removeStudentsFromGroup(List<Student> students) {
        for (Student student : students) {
            getSession().update(student);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Student> getStudentsFromGroup(Integer groupId) {
        Criteria criteria = getSession().createCriteria(Student.class);
        criteria.createAlias("group", "gr")
                .add(Restrictions.eq("gr.id", groupId));
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<Student> searchStudent(String searchString, Integer recordBookNumber, Integer group, Integer teacherId) {
        Criteria criteria = getSession().createCriteria(Student.class);
        if (!StringUtils.isEmpty(searchString)) {
            criteria
                    .add((Restrictions.disjunction())
                            .add(Restrictions.like("firstName", searchString))
                            .add(Restrictions.like("lastName", searchString)));
        }
        if (!Objects.equals(group, EMPTY_SEARCH_VALUE) || !Objects.equals(teacherId, EMPTY_SEARCH_VALUE)) {
            criteria.createAlias("group", "gr");
        }
        if (null != recordBookNumber) {
            criteria.add(Restrictions.eq("recordBookNumber", recordBookNumber));
        }
        if (!Objects.equals(group, EMPTY_SEARCH_VALUE)) {
            criteria.add(Restrictions.eq("gr.id", group));
        }
        if (!Objects.equals(teacherId, EMPTY_SEARCH_VALUE)) {
            criteria.createAlias("gr.teacher", "tch")
                    .add(Restrictions.eq("tch.id", teacherId));
        }
        return criteria.list();
    }

    public void saveStudent(Student student) {
        getSession().save(student);
    }

    public void updateStudent(Student student) {
        getSession().update(student);
    }

    public void removeStudent(Student student) {
        getSession().delete(student);
    }

    public Student getStudentById(Integer id) {
        return (Student) getSession().get(Student.class, id);
    }

}
