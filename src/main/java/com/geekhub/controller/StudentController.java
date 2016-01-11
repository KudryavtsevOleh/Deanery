package com.geekhub.controller;

import com.geekhub.beans.GroupBean;
import com.geekhub.beans.ResponseBean;
import com.geekhub.beans.StudentBean;
import com.geekhub.beans.TeacherBean;
import com.geekhub.entity.Group;
import com.geekhub.entity.Student;
import com.geekhub.service.GroupService;
import com.geekhub.service.StudentService;
import com.geekhub.service.TeacherService;
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
 * Created by oleh on 31.10.15.
 */
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/students.action", method = RequestMethod.GET)
    public ModelAndView studentPage() {
        ModelAndView mav = new ModelAndView("/students/students");
        List<StudentBean> students = studentService.getStudents();
        mav.addObject("students", students);
        return mav;
    }

    @RequestMapping(value = "/addStudent.action", method = RequestMethod.GET)
    public ModelAndView addStudent() {
        ModelAndView mav = new ModelAndView("/students/addStudents");
        List<GroupBean> groups = groupService.getGroups();
        mav.addObject("groups", groups);
        return mav;
    }

    @RequestMapping(value = "/searchStudents.action", method = RequestMethod.GET)
    public ModelAndView searchStudents() {
        ModelAndView mav = new ModelAndView("/students/searchStudents");
        List<GroupBean> groups = groupService.getGroups();
        List<TeacherBean> teachers = teacherService.getTeachers();
        mav.addObject("groups", groups);
        mav.addObject("teachers", teachers);
        return mav;
    }

    @RequestMapping(value = "/saveStudent.action", method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(@RequestParam(required = true) String firstName,
                              @RequestParam(required = true) String lastName,
//                              @RequestParam(required = true) Date birthDate,
                              @RequestParam(required = true) Integer recordBookNumber,
                              @RequestParam(required = true) Integer groupId) {
        try {
            Group group = groupService.getGroupById(groupId);
            studentService.saveStudent(firstName, lastName, new Date(), recordBookNumber, group);
            return ResponseBean.SUCCESS.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.FAILED.toString();
        }
    }

    @RequestMapping(value = "/updateStudent.action", method = RequestMethod.POST)
    @ResponseBody
    public String updateStudent(@RequestParam(required = true) Integer studentId,
                                @RequestParam(required = false) String firstName,
                                @RequestParam(required = false) String lastName,
//                                @RequestParam(required = false) Date birthDate,
                                @RequestParam(required = false) Integer recordBookNumber,
                                @RequestParam(required = false) Integer groupId) {
        try {
            Group group = groupService.getGroupById(groupId);
            studentService.updateStudent(studentId, firstName, lastName, new Date(), recordBookNumber, group);
            return ResponseBean.SUCCESS.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.FAILED.toString();
        }
    }

    @RequestMapping(value = "/removeStudent.action", method = RequestMethod.GET)
    public ModelAndView removeStudent(@RequestParam(required = true) Integer studentId) {
        ModelAndView mav = new ModelAndView("/students/students");
        studentService.removeStudent(studentId);
        return mav;
    }

    @RequestMapping(value = "/searchStudent.action", method = RequestMethod.POST)
    public ModelAndView searchStudents(@RequestParam(required = false) String searchString,
                                       @RequestParam(required = false) Integer recordBookNumber,
                                       @RequestParam(required = false) Integer groupId,
                                       @RequestParam(required = false) Integer teacherId) {
        ModelAndView mav = new ModelAndView("/students/searchResult");
        List<StudentBean> result = studentService.searchStudents(searchString, recordBookNumber, groupId, teacherId);
        mav.addObject("students", result);
        return mav;
    }

    @RequestMapping(value = "/getStudent.action", method = RequestMethod.GET)
    public ModelAndView getStudent(@RequestParam(required = false) Integer studentId) {
        ModelAndView mav = new ModelAndView("/students/studentPage");
        List<GroupBean> groups = groupService.getGroups();
        if (null != studentId) {
            StudentBean student = studentService.getStudentById(studentId);
            Integer studentGroup = studentService.getStudentGroupId(studentId);
            mav.addObject("student", student);
            mav.addObject("inGroup", studentGroup);
        }
        mav.addObject("groups", groups);
        return mav;
    }

}
