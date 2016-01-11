package com.geekhub.beans;

import com.geekhub.entity.Teacher;

/**
 * Created by oleh on 31.10.15.
 */
public class GroupBean {

    private Integer id;
    private String groupName;
    private Teacher groupTeacher;

    public GroupBean(Integer id, String groupName, Teacher groupTeacher) {
        this.id = id;
        this.groupName = groupName;
        this.groupTeacher = groupTeacher;
    }

    public GroupBean() {}

    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Teacher getGroupTeacher() {
        return groupTeacher;
    }
    public void setGroupTeacher(Teacher groupTeacher) {
        this.groupTeacher = groupTeacher;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
