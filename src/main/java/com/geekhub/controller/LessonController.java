package com.geekhub.controller;

import com.geekhub.beans.LessonBean;
import com.geekhub.beans.ResponseBean;
import com.geekhub.entity.Lesson;
import com.geekhub.service.LessonService;
import com.geekhub.service.StudentService;
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
public class LessonController {

    @Autowired
    private LessonService lessonService;
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/lessons.action", method = RequestMethod.GET)
    public ModelAndView showLessons() {
        ModelAndView mav = new ModelAndView("/lessons/lessons");
        List<LessonBean> lessons = lessonService.getLessons();
        mav.addObject("lessons", lessons);
        return mav;
    }

    @RequestMapping(value = "/saveLesson.action", method = RequestMethod.POST)
    @ResponseBody
    public String saveLesson(@RequestParam(required = true) String lessonName) {
        Boolean isLessonPresent = lessonService.isLessonPresent(lessonName);
        if (Boolean.TRUE.equals(isLessonPresent)) {
            return ResponseBean.FAILED.toString();
        }
        lessonService.saveLesson(lessonName);
        return ResponseBean.SUCCESS.toString();
    }

    @RequestMapping(value = "/removeLesson.action", method = RequestMethod.GET)
    public ModelAndView removeLesson(@RequestParam(required = true) Integer lessonId) {
        ModelAndView mav = new ModelAndView("/lessons/lessons");
        lessonService.removeLesson(lessonId);
        return mav;
    }

    @RequestMapping(value = "/updateLesson.action", method = RequestMethod.POST)
    @ResponseBody
    public String updateLesson(@RequestParam(required = false) String lessonName,
                               @RequestParam(required = true) Integer lessonId) {
        try {
            lessonService.updateLesson(lessonName, lessonId);
            return ResponseBean.SUCCESS.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.FAILED.toString();
        }
    }

    @RequestMapping(value = "/addLessonPage.action", method = RequestMethod.GET)
    public ModelAndView updateLessonPage(@RequestParam(required = false) Integer lessonId) {
        ModelAndView mav = new ModelAndView("/lessons/addLesson");
        if (null != lessonId) {
            Lesson lesson = lessonService.getLessonById(lessonId);
            mav.addObject("lesson", new LessonBean(lesson.getLessonName()));
            mav.addObject("updateLesson", true);
        }
        mav.addObject("lessonId", lessonId);
        return mav;
    }

}
