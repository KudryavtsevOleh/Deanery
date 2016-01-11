package com.geekhub.controller;

import com.geekhub.beans.*;
import com.geekhub.entity.Group;
import com.geekhub.entity.Lesson;
import com.geekhub.service.AttendanceService;
import com.geekhub.service.GroupService;
import com.geekhub.service.LessonService;
import com.geekhub.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * Created by oleh on 01.11.15.
 */
@Controller
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private LessonService lessonService;
    @Autowired
    private GroupService groupService;

    @RequestMapping(value = "/attendancePage.action", method = RequestMethod.GET)
    public ModelAndView attendancePage() {
        ModelAndView mav = new ModelAndView("/attendance/attendance");
        List<GroupBean> groups = groupService.getGroups();
        mav.addObject("groups", groups);
        return mav;
    }

    @RequestMapping(value = "/addAttendance.action", method = RequestMethod.GET)
    public ModelAndView addAttendancePage() {
        ModelAndView mav = new ModelAndView("/attendance/addAttendance");
        List<LessonBean> lessons = lessonService.getLessons();
        List<GroupBean> groups = groupService.getGroups();
        mav.addObject("lessons", lessons);
        mav.addObject("groups", groups);
        return mav;
    }

    @RequestMapping(value = "/getGroupStudents.action", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getGroupStudents(@RequestParam(required = true) Integer groupId) {
        ModelAndView mav = new ModelAndView("/attendance/groupStudents");
        List<StudentBean> students = studentService.getStudentsFromGroup(groupId);
        mav.addObject("students", students);
        return mav;
    }

    @RequestMapping(value = "/saveAttendance.action", method = RequestMethod.POST)
    @ResponseBody
    public String saveAttendance(@RequestParam(required = true) Integer studentId,
                                 @RequestParam(required = true) Integer lessonId,
//                                 @RequestParam(required = true) Date attendanceDate,
                                 @RequestParam(required = true) Integer mark,
                                 @RequestParam(required = true) Boolean presents) {
        try {
            StudentBean student = studentService.getStudentById(studentId);
            Lesson lesson = lessonService.getLessonById(lessonId);
            attendanceService.saveAttendance(student, lesson, new Date(), mark, presents);
            return ResponseBean.SUCCESS.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.FAILED.toString();
        }
    }

    @RequestMapping(value = "/attendanceForGroup.action", method = RequestMethod.GET)
    @ResponseBody
    public String getAttendanceForGroup(@RequestParam(required = true) Integer groupId) {
        return groupId.toString();
    }

    @RequestMapping(value = "/attendanceForGroupPage.action", method = RequestMethod.GET)
    public ModelAndView attendanceForGroupPage(@RequestParam(required = true) Integer groupId) {
        ModelAndView mav = new ModelAndView("/attendance/attendanceForGroup");
        List<AttendanceBean> attendances = attendanceService.getAttendanceForGroup(groupId);
        Group group = groupService.getGroupById(groupId);
        mav.addObject("attendances", attendances);
        mav.addObject("groupName", group.getGroupName());
        return mav;
    }

}
