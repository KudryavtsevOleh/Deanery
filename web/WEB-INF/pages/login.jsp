<%--
  Created by IntelliJ IDEA.
  User: oleh
  Date: 30.10.15
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login</title>
  <link rel="stylesheet" type="text/css" href="resources/css/login.css">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="resources/js/LoginContainer.js"></script>
  <script src="resources/js/Validation.js"></script>
  <script src="resources/js/jquery-2.1.3.min.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
</head>
<body>
<div class="main-container">
  <div class="header-container">
    <div class="welcome-container">
      <h1>Electronic deanery</h1>
    </div>
  </div>
  <div class="body-container">
    <div class="login-container">
      <div class="label-container">
        <div class="label email">
          <label class="loginEmail_js">Email: </label>
        </div>
        <div class="label password">
          <label class="loginPassword_js">Password: </label>
        </div>
      </div>
      <div class="input-container">
        <div class="input email_js"><input type="email"></div>
        <div class="input password_js"><input type="password"></div>
      </div>
      <div class="error-message">
        <label class="invalidEmail_js" style="display: none">Invalid email</label>
      </div>
      <div class="submit-login">
        <div class="submit-btn submitLogin_js">
          <span>login</span>
        </div>
        <div class="clear-btn clearInput_js">
          <span>clear</span>
        </div>
      </div>
      <div class="login-failed loginFailed_js" style="display: none;">
        <span class="error-message">
          Invalid email or password. Please retry.
        </span>
      </div>
    </div>
  </div>
  <div class="footer-container">
    <div class="footer-info">
      Created by Oleh Kudryavcev. Group PZS-1544
    </div>
  </div>
</div>
<div class="errorDialog_js" style="display: none;">
  <span>Please, fill all required fields! Email and password!</span>
</div>
<script>
  TeacherClass.init();
</script>
</body>
</html>
