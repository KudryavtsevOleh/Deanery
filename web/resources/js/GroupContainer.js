/**
 * Created by oleh on 26.11.15.
 */
var GroupClass = new GroupContainer();

function GroupContainer() {

    var self = this;

    var SAVE_GROUP_URL = "/saveGroup.action";
    var UPDATE_GROUP_URL = "/updateGroup.action";

    self.init = function () {
        self.save();
        self.update();
    };

    self.save = function() {
        $(".submit_js").click(function() {
            self.saveGroup();
        });
    };

    self.update = function() {
        $(".updateGroup_js").click(function() {
            self.updateGroup();
        });
    };

    self.saveGroup = function () {
        var groupName = $(".groupName_js").val();
        var teacher = $(".teacher_js option:selected").val();

        /*var valid = ValidationClass.validateString(groupName);
        if (valid) {
            $(".error").show();
            return;
        }*/

        var params = {
            groupName: groupName,
            teacherId: teacher
        };

        $.post(SAVE_GROUP_URL, params, function(response) {
           if (response == "success") {
                window.location.href = "/groups.action"
           } else {
                self.showErrorDialog();
           }
        });
    };

    self.updateGroup = function() {
        var groupName = $(".groupName_js").val();
        var groupId = $(".groupId_js").val();
        var newTeacherId = $(".newTeacher option:selected").val();

        /*var valid = ValidationClass.validateString(groupName);
        if (valid) {
            $(".error_js").show();
            return;
        }*/

        var params = {
            groupName: groupName,
            teacherId: newTeacherId,
            groupId: groupId
        };

        $.post(UPDATE_GROUP_URL, params, function(response) {
            if (response == "success") {
                window.location.href = "/groups.action";
            } else {
                self.showErrorDialog();
            }
        })
    };

    self.showErrorDialog = function () {
        $(".errorDialog_js").dialog({
            autoOpen: false,
            show: "bounce",
            hide: "explode"
        });
        $(".errorDialog_js").dialog("open");
    };

}