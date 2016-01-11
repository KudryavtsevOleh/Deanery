package com.geekhub.dao;

import com.geekhub.entity.Attendance;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by oleh on 01.11.15.
 */
@Repository
public class AttendanceDao {

    @Autowired
    private SessionFactory sessionFactory;
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void saveAttendance(Attendance attendance) {
        getSession().save(attendance);
    }

    @SuppressWarnings("unchecked")
    public List<Attendance> getAttendanceForGroup(Integer groupId) {
        Criteria criteria = getSession().createCriteria(Attendance.class);
        criteria.createAlias("student", "st")
                .createAlias("st.group", "gr")
                .add(Restrictions.eq("gr.id", groupId));
        return criteria.list();
    }

}
