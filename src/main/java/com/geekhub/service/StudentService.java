package com.geekhub.service;

import com.geekhub.beans.StudentBean;
import com.geekhub.dao.StudentDao;
import com.geekhub.entity.Group;
import com.geekhub.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by oleh on 01.11.15.
 */
@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentDao dao;

    public StudentBean getStudentById(Integer id) {
        Student student = dao.getStudentById(id);
        return new StudentBean(student.getId(), student.getFirstName(), student.getLastName(), student.getRecordBookNumber(), student.getBirthDate(), student.getGroup());
    }

    public Integer getStudentGroupId(Integer id) {
        try {
            Student student = dao.getStudentById(id);
            return student.getGroup().getId();
        } catch (Exception e) {
            return 0;
        }
    }

    public List<StudentBean> getStudents() {
        List<StudentBean> result = new ArrayList<>();
        List<Student> students = dao.getStudents();
        result.addAll(students.stream().map(student -> new StudentBean(student.getId(), student.getFirstName(), student.getLastName(), student.getRecordBookNumber(), student.getBirthDate(), student.getGroup())).collect(Collectors.toList()));
        return  result;
    }

    public void removeStudentsFromGroup(List<StudentBean> students) {
        List<Student> result = new ArrayList<>();
        for (StudentBean bean : students) {
            Student student = new Student();
            fillStudentInfo(student, bean.getFirstName(), bean.getLastName(), bean.getBirthDate(), bean.getRecordBookNumber(), bean.getGroup());
            result.add(student);
        }
        dao.removeStudentsFromGroup(result);
    }

    public List<StudentBean> getStudentsFromGroup(Integer groupId) {
        List<StudentBean> result = new ArrayList<>();
        List<Student> students = dao.getStudentsFromGroup(groupId);
        if (null != students) {
            result.addAll(students.stream().map(student -> new StudentBean(
                    student.getId(),
                    student.getFirstName(),
                    student.getLastName(),
                    student.getRecordBookNumber(),
                    student.getBirthDate(),
                    student.getGroup()
            )).collect(Collectors.toList()));
        }
        return  result;
    }

    public List<StudentBean> searchStudents(String searchString, Integer recordBookNumber, Integer group, Integer teacherId) {
        List<StudentBean> result = new ArrayList<>();
        List<Student> students = dao.searchStudent(searchString, recordBookNumber, group, teacherId);
        result.addAll(students.stream().map(student -> new StudentBean(student.getId(), student.getFirstName(), student.getLastName(), student.getRecordBookNumber(), student.getBirthDate(), student.getGroup())).collect(Collectors.toList()));
        return  result;
    }

    public void saveStudent(String firstName, String lastName, Date birthDate, Integer recordBookNumber, Group group) {
        Student student = new Student();
        fillStudentInfo(student, firstName, lastName, birthDate, recordBookNumber, group);
        dao.saveStudent(student);
    }

    public void updateStudent(Integer studentId, String firstName, String lastName, Date birthDate, Integer recordBookNumber, Group group) {
        Student student = dao.getStudentById(studentId);
        fillStudentInfo(student, firstName, lastName, birthDate, recordBookNumber, group);
        dao.updateStudent(student);
    }

    private void fillStudentInfo(Student student, String firstName, String lastName, Date birthDate, Integer recordBookNumber, Group group) {
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setBirthDate(birthDate);
        student.setRecordBookNumber(recordBookNumber);
        student.setGroup(group);
    }

    public void removeStudent(Integer studentId) {
        Student student = dao.getStudentById(studentId);
        if (null != student) {
            dao.removeStudent(student);
        }
    }

}
