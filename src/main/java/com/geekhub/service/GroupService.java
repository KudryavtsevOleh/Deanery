package com.geekhub.service;

import com.geekhub.beans.GroupBean;
import com.geekhub.dao.GroupDao;
import com.geekhub.entity.Group;
import com.geekhub.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by oleh on 30.10.15.
 */
@Service
@Transactional
public class GroupService {

    @Autowired
    private GroupDao dao;

    public GroupBean getGroupBeanById(Integer id) {
        Group group = dao.getGroupById(id);
        if (null != group) {
            return new GroupBean(
                    group.getId(), group.getGroupName(), group.getTeacher()
            );
        }
        return new GroupBean();
    }

    public Group getGroupById(Integer id) {
        return dao.getGroupById(id);
    }

    public void saveGroup(String groupName, Teacher teacher) {
        Group group = new Group();
        group.setGroupName(groupName);
        group.setTeacher(teacher);
        dao.saveGroup(group);
    }

    public void updateGroup(Integer groupId, String groupName, Teacher teacher) {
        Group group = dao.getGroupById(groupId);
        group.setGroupName(groupName);
        group.setTeacher(teacher);
        dao.updateGroup(group);
    }

    /*
    * return true if group with such name is already exists
    * */
    public Boolean isGroupPresent(String groupName) {
        Group group = dao.getGroupByName(groupName);
        return group != null;
    }

    public List<GroupBean> getGroups() {
        List<GroupBean> result = new ArrayList<>();
        List<Group> groups = dao.getGroups();
        result.addAll(groups.stream().map(group -> new GroupBean(group.getId(), group.getGroupName(), group.getTeacher())).collect(Collectors.toList()));
        return result;
    }

    public void removeGroup(Integer groupId) {
        Group group = dao.getGroupById(groupId);
        if (null != group) {
            dao.removeGroup(group);
        }
    }

    public Integer getTeacherIdByGroupId(Integer groupId) {
        return dao.getTeacherByGroupId(groupId);
    }

}
