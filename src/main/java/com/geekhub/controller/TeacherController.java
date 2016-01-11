package com.geekhub.controller;

import com.geekhub.beans.GroupBean;
import com.geekhub.beans.ResponseBean;
import com.geekhub.beans.TeacherBean;
import com.geekhub.entity.Group;
import com.geekhub.service.GroupService;
import com.geekhub.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by oleh on 01.11.15.
 */
@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private GroupService groupService;

    @RequestMapping(value = "/teachers.action", method = RequestMethod.GET)
    public ModelAndView teachersPage() {
        ModelAndView mav = new ModelAndView("/teacher/teachers");
        List<TeacherBean> teachers = teacherService.getTeachers();
        mav.addObject("teachers", teachers);
        return mav;
    }

    @RequestMapping(value = "/saveTeacher.action", method = RequestMethod.POST)
    @ResponseBody
    public String saveTeacher(@RequestParam(required = false) String email,
                              @RequestParam(required = false) String password,
                              @RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String lastName,
                              @RequestParam(required = false) String position,
                              @RequestParam(required = false) Integer groupId) {
        try {
            Group group = groupService.getGroupById(groupId);
            teacherService.saveTeacher(email, password, firstName, lastName, position, group);
            return ResponseBean.SUCCESS.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.FAILED.toString();
        }
    }

    @RequestMapping(value = "/updateTeacher.action", method = RequestMethod.POST)
    @ResponseBody
    public String updateTeacher(@RequestParam(required = true) Integer teacherId,
                                @RequestParam(required = false) String email,
                                @RequestParam(required = false) String password,
                                @RequestParam(required = false) String firstName,
                                @RequestParam(required = false) String lastName,
                                @RequestParam(required = false) String position,
                                @RequestParam(required = false) Integer groupId) {
        try {
            Group group = groupService.getGroupById(groupId);
            teacherService.updateTeacher(teacherId, email, password, firstName, lastName, position, group);
            return ResponseBean.SUCCESS.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.FAILED.toString();
        }
    }

}
