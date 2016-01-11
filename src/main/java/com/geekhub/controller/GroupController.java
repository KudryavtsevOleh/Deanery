package com.geekhub.controller;

import com.geekhub.beans.GroupBean;
import com.geekhub.beans.ResponseBean;
import com.geekhub.beans.StudentBean;
import com.geekhub.beans.TeacherBean;
import com.geekhub.entity.Group;
import com.geekhub.entity.Teacher;
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
import java.util.List;

/**
 * Created by oleh on 31.10.15.
 */
@Controller
public class GroupController {

    @Autowired
    private GroupService groupService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/groups.action", method = RequestMethod.GET)
    public ModelAndView groupPage() {
        ModelAndView mav = new ModelAndView("/groups/groups");
        List<GroupBean> groups = groupService.getGroups();
        mav.addObject("groups", groups);
        return mav;
    }

    @RequestMapping(value = "/addGroup.action", method = RequestMethod.GET)
    public ModelAndView addGroup() {
        ModelAndView mav = new ModelAndView("/groups/addGroup");
        List<TeacherBean> teachers = teacherService.getTeachers();
        mav.addObject("teachers", teachers);
        return mav;
    }

    @RequestMapping(value = "/updateGroupPage.action", method = RequestMethod.GET)
    public ModelAndView updateGroupPage(@RequestParam(required = true) Integer id) {
        ModelAndView mav = new ModelAndView("/groups/addGroup");
        GroupBean bean = groupService.getGroupBeanById(id);
        List<TeacherBean> teachers = teacherService.getTeachers();
        Integer groupTeacherId = groupService.getTeacherIdByGroupId(id);
        mav.addObject("groupTeacher", groupTeacherId);
        mav.addObject("teachers", teachers);
        mav.addObject("group", bean);
        return mav;
    }

    @RequestMapping(value = "/saveGroup.action", method = RequestMethod.POST)
    @ResponseBody
    public String saveGroup(@RequestParam(required = true) String groupName,
                            @RequestParam(required = true) Integer teacherId) {
        try {
            Teacher teacher = teacherService.getTeacherById(teacherId);
            groupService.saveGroup(groupName, teacher);
            return ResponseBean.SUCCESS.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.FAILED.toString();
        }
    }

    @RequestMapping(value = "/updateGroup.action", method = RequestMethod.POST)
    @ResponseBody
    public String updateGroup(@RequestParam(required = false) String groupName,
                              @RequestParam(required = false) Integer teacherId,
                              @RequestParam(required = true) Integer groupId) {
        try {
            Teacher teacher = teacherService.getTeacherById(teacherId);
            groupService.updateGroup(groupId, groupName, teacher);
            return ResponseBean.SUCCESS.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.FAILED.toString();
        }
    }

    @RequestMapping(value = "/removeGroup.action", method = RequestMethod.GET)
    @ResponseBody
    public String removeGroup(@RequestParam(required = true) Integer groupId) {
        try {
            groupService.removeGroup(groupId);
            List<StudentBean> students = studentService.getStudentsFromGroup(groupId);
            studentService.removeStudentsFromGroup(students);
            return ResponseBean.SUCCESS.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.FAILED.toString();
        }
    }

    @RequestMapping(value = "/viewGroup.action", method = RequestMethod.GET)
    public ModelAndView viewGroup(@RequestParam(required = true) Integer groupId) {
        ModelAndView mav = new ModelAndView("/groups/viewGroup");
        GroupBean group = groupService.getGroupBeanById(groupId);
        List<StudentBean> students = studentService.getStudentsFromGroup(groupId);
        mav.addObject("students", students);
        mav.addObject("group", group);
        return mav;
    }

}
