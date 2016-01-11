/**
 * Created by oleh on 28.11.15.
 */
var AttendanceClass = new AttendanceContainer();

function AttendanceContainer() {

    var self = this;

    var SAVE_ATTENDANCE_URL = "/saveAttendance.action";
    var GET_GROUP_STUDENTS_URL = "/getGroupStudents.action";
    var GET_ATTENDANCE_FOR_GROUP_URL = "/attendanceForGroup.action";
    var NOT_SELECTED_VALUE = 0;

    self.init = function() {
        self.save();
        self.getGroupStudents();
        self.getAttendanceForGroup();
    };

    self.save = function() {
        $(".save_js").click(function () {
            self.saveAttendance();
            self.getGroupStudents();
        });
    };

    self.getGroupStudents = function () {
        $(".group_js").change(function() {
            self.loadGroupStudents();
        });
    };

    self.getAttendanceForGroup = function() {
        $(".attendanceForGroup_js").click(function() {
            self.loadAttendanceForGroup();
        })
    };

    self.saveAttendance = function() {
        var studentId = $(".student_js option:selected").val();
        var lessonId = $(".lesson_js option:selected").val();
        var mark = $(".mark_js").val();
        var presents = $(".presents_js").prop("checked");

        if (studentId == NOT_SELECTED_VALUE) {
            self.errorPopup("Please, select student!!!");
            return;
        }
        if (lessonId == NOT_SELECTED_VALUE) {
            self.errorPopup("Please, select lesson!!!");
            return;
        }

        var params = {
            studentId: studentId,
            lessonId: lessonId,
            mark: mark,
            presents: presents
        };

        $.post(SAVE_ATTENDANCE_URL, params, function(response) {
           if (response = "success") {
               window.location.href = "/attendancePage.action";
           } else {
               self.errorPopup("Internal server error!!!");
           }
        });
    };

    self.loadGroupStudents = function() {
        var groupId = $(".group_js option:selected").val();
        var params = {
            groupId: groupId
        };
        $.get(GET_GROUP_STUDENTS_URL, params, function(response) {
            $(".groupStudents_js").html(response);
        });
    };

    self.loadAttendanceForGroup = function() {
        var group = $(".forGroup_js option:selected").val();
        var params = {
            groupId: group
        };
        $.get(GET_ATTENDANCE_FOR_GROUP_URL, params, function(response) {
            if (response != 0) {
                window.location.href = "/attendanceForGroupPage.action?groupId=" + response;
            } else {
                self.errorPopup("Choose group!!!");
            }
        });
    };

    self.errorPopup = function(message) {
        /*$(".errorDialog_js").dialog({
            autoOpen: false,
            show: "blind",
            hide: "explode",
            modal: true
        });
        $(".errorDialog_js").text(message);
        $(".errorDialog_js").dialog("open");*/
        alert(message);
    }

}