package com.geekhub.service;

import com.geekhub.beans.GroupBean;
import com.geekhub.beans.TeacherBean;
import com.geekhub.dao.TeacherDao;
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
public class TeacherService {

    @Autowired
    private TeacherDao dao;

    public TeacherBean getTeacherByEmailAndPassword(String email, String password) {
        Teacher teacher = dao.getTeacherByEmailAndPassword(email, password);
        if (teacher != null) {
            return new TeacherBean(
                    teacher.getId(),
                    teacher.getEmail(),
                    teacher.getPassword(),
                    teacher.getFirstName(),
                    teacher.getLastName(),
                    teacher.getPosition(),
                    teacher.getGroup()
            );
        }
        return null;
    }

    public Teacher getTeacherById(Integer id) {
        return dao.getTeacherById(id);
    }

    public void saveTeacher(String email, String password, String firstName, String lastName, String position, Group group) {
        Teacher teacher = new Teacher();
        fillTeacherInfo(teacher, email, password, firstName, lastName, position, group);
        dao.saveTeacher(teacher);
    }

    public void updateTeacher(Integer teacherId, String email, String password, String firstName, String lastName, String position, Group group) {
        Teacher teacher = dao.getTeacherById(teacherId);
        fillTeacherInfo(teacher, email, password, firstName, lastName, position, group);
        dao.updateTeacher(teacher);
    }

    private void fillTeacherInfo(Teacher teacher, String email, String password, String firstName, String lastName, String position, Group group) {
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacher.setEmail(email);
        teacher.setPassword(password);
        teacher.setPosition(position);
        teacher.setGroup(group);
    }

    public List<TeacherBean> getTeachers() {
        List<TeacherBean> result = new ArrayList<>();
        List<Teacher> teachers = dao.getTeachers();
        result.addAll(teachers.stream().map(teacher -> new TeacherBean(
                        teacher.getId(),
                        teacher.getFirstName(),
                        teacher.getLastName(),
                        teacher.getPosition()
                )
        ).collect(Collectors.toList()));
        return result;
    }

}
