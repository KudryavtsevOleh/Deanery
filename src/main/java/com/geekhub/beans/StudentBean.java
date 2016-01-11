package com.geekhub.beans;

import com.geekhub.entity.Group;

import java.util.Date;

/**
 * Created by oleh on 01.11.15.
 */
public class StudentBean {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer recordBookNumber;
    private Date birthDate;
    private Group group;

    public StudentBean(Integer id, String firstName, String lastName, Integer recordBookNumber, Date birthDate, Group group) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.recordBookNumber = recordBookNumber;
        this.birthDate = birthDate;
        this.group = group;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getRecordBookNumber() {
        return recordBookNumber;
    }
    public void setRecordBookNumber(Integer recordBookNumber) {
        this.recordBookNumber = recordBookNumber;
    }

    public Group getGroup() {
        return group;
    }
    public void setGroup(Group group) {
        this.group = group;
    }

    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
