/**
 * Created by oleh on 30.10.15.
 */
var ValidationClass = new ValidationContainer();

function ValidationContainer() {

    var self = this;

    self.validateEmail = function(email) {
        var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
        return re.test(email);
    };

    self.validatePassword = function(password) {
        var re = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}/;
        return re.test(password);
    };

    self.validateString = function(text) {
        var re = /[a-z], [A-Z]/;
        return !re.test(text);
    }

}