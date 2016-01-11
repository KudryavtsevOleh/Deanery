/**
 * Created by oleh on 01.11.15.
 */
var LessonClass = new LessonContainer();

function LessonContainer() {

    var self = this;

    var UPDATE_LESSON_URL = "/updateLesson.action";
    var SAVE_LESSON_URL = "/saveLesson.action";
    var CREATE_LESSON_ID = 0;

    self.init = function () {
      self.save();
    };

    self.save = function() {
      $(".saveLesson_js").click(function() {
          self.saveLesson();
      });
    };

    self.saveLesson = function () {
        var lessonName = $(".lessonName_js").val();
        var lessonId = $(".lessonId_js").val();

        if (lessonName == "") {
            $(".empty_js").show();
            return;
        }

        var isValid = ValidationClass.validateString(lessonName);
        if (!isValid) {
            $(".error_js").show();
            return;
        }

        var params = {
            lessonName: lessonName
        };

        var url = SAVE_LESSON_URL;
        if (lessonId != CREATE_LESSON_ID) {
            params.lessonId = lessonId;
            url = UPDATE_LESSON_URL;
        }

        $.post(url, params, function(response) {
           if (response == "success") {
               window.location.href = "/lessons.action";
           } else {
               alert("Internal Server Error!!!");
           }
        });
    }

}