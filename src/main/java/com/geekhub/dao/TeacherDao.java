package com.geekhub.dao;

import com.geekhub.beans.TeacherBean;
import com.geekhub.entity.Teacher;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by oleh on 30.10.15.
 */
@Repository
public class TeacherDao extends HibernateDao {

    public Teacher getTeacherByEmailAndPassword(String email, String password) {
        Criteria criteria = getSession().createCriteria(Teacher.class);
        criteria.add(Restrictions.eq("email", email))
                .add(Restrictions.eq("password", password));
        return (Teacher) criteria.uniqueResult();
    }

    public Teacher getTeacherById(Integer id) {
        return (Teacher) getSession().get(Teacher.class, id);
    }

    public void saveTeacher(Teacher teacher) {
        getSession().save(teacher);
    }

    public void updateTeacher(Teacher teacher) {
        getSession().update(teacher);
    }

    @SuppressWarnings("unchecked")
    public List<Teacher> getTeachers() {
        Criteria criteria = getSession().createCriteria(Teacher.class);
        return criteria.list();
    }

}
