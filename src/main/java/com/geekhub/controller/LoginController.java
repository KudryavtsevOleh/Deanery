package com.geekhub.controller;

import com.geekhub.beans.ResponseBean;
import com.geekhub.beans.TeacherBean;
import com.geekhub.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * Created by oleh on 30.10.15.
 */
@Controller
public class LoginController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest req) {
        ModelAndView mav;
        Object loginTeacher = req.getSession().getAttribute("loginTeacher");
        if (null != loginTeacher) {
            mav = new ModelAndView("dashboard");
        } else {
            mav = new ModelAndView("login");
        }
        return mav;
    }

    @RequestMapping(value = "/login.action", method = RequestMethod.POST)
    @ResponseBody
    public String login(HttpServletRequest req,
                              @RequestParam(required=true) String email,
                              @RequestParam(required=true) String password) {
        TeacherBean bean = teacherService.getTeacherByEmailAndPassword(email, password);
        if (null != bean) {
            HttpSession session = req.getSession();
            session.setAttribute("loginTeacher", bean);
            return ResponseBean.SUCCESS.toString();
        }
        return ResponseBean.FAILED.toString();
    }

}
