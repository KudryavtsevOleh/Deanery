/**
 * Created by oleh on 16.09.15.
 */
var TeacherClass = new TeacherContainer();

function TeacherContainer() {

    var self = this;

    var LOGIN_URL = "/login.action";
    var SUCCESS_LOGIN = "/dashboard.action";

    self.init = function() {
        self.loginTeacherClick();
        self.clearInput();
    };

    self.loginTeacherClick = function () {
      $(".submitLogin_js").click(function() {
          self.loginTeacher();
      });
    };

    self.loginTeacher = function() {
        var email = $(".email_js input").val();
        var password = $(".password_js input").val();

        if (email == "" || password == "") {
            self.showErrorDialog();
            return;
        }

        var validEmail = ValidationClass.validateEmail(email);
        if (!validEmail) {
            $(".invalidEmail_js").show();
            return;
        }

        var params = {
            email: email,
            password: password
        };

        $.post(LOGIN_URL, params, function(response) {
           if (response != "success") {
               $(".loginFailed_js").show();
           } else {
               window.location.href = SUCCESS_LOGIN;
           }
        });

    };

    self.clearInput = function() {
        $(".clearInput_js").click(function() {
            self.clearInputValues();
        });
    };

    self.showErrorDialog = function () {
        $(".errorDialog_js").dialog({
            autoOpen: false,
            show: "blind",
            hide: "explode",
            modal: true
        });
        $(".errorDialog_js").dialog("open");
    };

    self.clearInputValues = function() {
        $(".email_js input").val('');
        $(".password_js input").val('');
    };

}