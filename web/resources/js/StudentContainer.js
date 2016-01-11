/**
 * Created by oleh on 02.11.15.
 */
var StudentClass = new StudentContainer();

function StudentContainer() {

    var self = this;

    var SAVE_STUDENT_URL = "/saveStudent.action";
    var UPDATE_STUDENT_URL = "/updateStudent.action";
    var SEARCH_STUDENT_URL = "/searchStudent.action";

    self.init = function() {
        self.addStudent();
        self.update();
        self.search();
    };

    self.addStudent = function() {
        $(".saveStudent_js").click(function() {
            self.saveStudent();
        });
    };

    self.update = function() {
      $(".updateStudent_js").click(function() {
          self.updateStudent();
      });
    };

    self.search = function() {
      $(".searchStudent_js").click(function() {
          self.searchStudent();
      });
    };

    self.saveStudent = function () {
        var firstName = $(".firstName_js").val();
        var lastName = $(".lastName_js").val();
        //var birthDate = $(".birthDate_js").val();
        var recordBookNumber = $(".recordBookNumber_js").val();
        var groupId = $(".group_js option:selected").val();

        var params = {
            firstName: firstName,
            lastName: lastName,
            //birthDate: birthDate,
            recordBookNumber: recordBookNumber,
            groupId: groupId
        };

        $.post(SAVE_STUDENT_URL, params, function(response) {
            if (response == "success") {
                window.location.href = "/students.action";
            } else {
                alert("Internal Server Error!!!");
            }
        });
    };

    self.updateStudent = function () {
        var studentId = $(".studentId_js").val();
        var firstName = $(".firstName_js").val();
        var lastName = $(".lastName_js").val();
        //var birthDate = $(".birthDate_js").val();
        var recordBookNumber = $(".recordBookNumber_js").val();
        var groupId = $(".group_js option:selected").val();

        var params = {
            studentId: studentId,
            firstName: firstName,
            lastName: lastName,
            //birthDate: birthDate,
            recordBookNumber: recordBookNumber
        };

        if (groupId == undefined) {
            params.groupId = 0;
        } else {
            params.groupId = groupId;
        }

        $.post(UPDATE_STUDENT_URL, params, function(response) {
            if (response == "success") {
                window.location.href = "/students.action";
            } else {
                alert("Internal Server Error!!!");
            }
        })
    };

    self.searchStudent = function () {
        var searchString = $(".searchString_js").val();
        var searchGroup = $(".searchGroup_js option:selected").val();
        var searchTeacher = $(".searchTeacher_js option:selected").val();

        var params = {};

        if ($.isNumeric(searchString)) {
            params.searchString = "";
            params.recordBookNumber = searchString;
        } else {
            params.searchString = searchString;
        }

        params.groupId = searchGroup;
        params.teacherId = searchTeacher;

        $.post(SEARCH_STUDENT_URL, params, function(response) {
            $(".searchResult_js").html(response);
        });
    }

}