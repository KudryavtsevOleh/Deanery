package com.geekhub.service;

import com.geekhub.beans.AttendanceBean;
import com.geekhub.beans.StudentBean;
import com.geekhub.dao.AttendanceDao;
import com.geekhub.entity.Attendance;
import com.geekhub.entity.Lesson;
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
public class AttendanceService {

    @Autowired
    private AttendanceDao dao;

    public void saveAttendance(StudentBean student, Lesson lesson, Date attendanceDate, Integer mark, Boolean presents) {
        Attendance attendance = new Attendance();
        fillAttendanceInfo(attendance, student, lesson, attendanceDate, mark, presents);
        dao.saveAttendance(attendance);
    }

    private void fillAttendanceInfo(Attendance attendance, StudentBean student, Lesson lesson, Date attendanceDate, Integer mark, Boolean presents) {
        fillStudentInfo(attendance, student);
        attendance.setAttendanceDate(attendanceDate);
        attendance.setLesson(lesson);
        attendance.setMark(mark);
        attendance.setPresents(presents);
    }

    private void fillStudentInfo(Attendance attendance, StudentBean bean) {
        Student student = new Student();
        student.setId(bean.getId());
        student.setFirstName(bean.getFirstName());
        student.setLastName(bean.getLastName());
        student.setGroup(bean.getGroup());
        student.setRecordBookNumber(bean.getRecordBookNumber());
        student.setBirthDate(bean.getBirthDate());
        attendance.setStudent(student);
    }

    public List<AttendanceBean> getAttendanceForGroup(Integer groupId) {
        List<AttendanceBean> result = new ArrayList<>();
        List<Attendance> attendances = dao.getAttendanceForGroup(groupId);
        if (null != attendances) {
            result.addAll(attendances.stream().map(attendance -> new AttendanceBean(
                    attendance.getStudent().getFirstName(),
                    attendance.getStudent().getLastName(),
                    attendance.getLesson().getLessonName(),
                    attendance.getAttendanceDate(),
                    attendance.getMark(),
                    attendance.getPresents()
            )).collect(Collectors.toList()));
        }
        return result;
    }

}
