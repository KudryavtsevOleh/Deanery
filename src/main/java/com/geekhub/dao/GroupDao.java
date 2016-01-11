package com.geekhub.dao;

import com.geekhub.beans.GroupBean;
import com.geekhub.entity.Group;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleh on 30.10.15.
 */
@Repository
public class GroupDao {

    @Autowired
    private SessionFactory sessionFactory;
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public Group getGroupById(Integer groupId) {
        return (Group) getSession().get(Group.class, groupId);
    }

    @SuppressWarnings("unchecked")
    public List<Group> getGroups() {
        Criteria criteria = getSession().createCriteria(Group.class);
        return criteria.list();
    }

    public void saveGroup(Group group) {
        getSession().save(group);
    }

    public void updateGroup(Group group) {
        getSession().update(group);
    }

    public Group getGroupByName(String name) {
        Criteria criteria = getSession().createCriteria(Group.class)
                .add(Restrictions.like("groupName", name));
        return (Group) criteria.uniqueResult();
    }

    public void removeGroup(Group group) {
        getSession().delete(group);
    }

    public Integer getTeacherByGroupId(Integer groupId) {
        Criteria criteria = getSession().createCriteria(Group.class);
        criteria.createAlias("teacher", "teacher");
        criteria.add(Restrictions.eq("id", groupId))
                .setProjection(Projections.property("teacher.id"));
        return (Integer) criteria.uniqueResult();
        /*String sql = "SELECT id FROM Teacher WHERE group.id = :id";
        Query query = getSession().createQuery(sql);
        query.setParameter("id", groupId);
        return (Integer) query.uniqueResult();*/
    }

}
