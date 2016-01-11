<%--
  Created by IntelliJ IDEA.
  User: oleh
  Date: 30.10.15
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Dashboard</title>
  <link rel="stylesheet" type="text/css" href="resources/css/dashboard.css">
</head>
<body>
<div class="main-container">
  <div class="header-container">
    <div class="welcome-container">
      <h1>Electronic deanery</h1>
      <span>For beginning work please choose one of the item below</span>
    </div>
  </div>
  <div class="body-container">
    <div class="menu-container">
      <div class="menu-item students"><a class="link" href="/students.action">Students</a></div>
      <div class="menu-item groups"><a class="link" href="/groups.action"> Groups</a></div>
      <div class="menu-item groups"><a class="link" href="/lessons.action">Lessons</a></div>
      <div class="menu-item mark"><a class="link" href="/attendancePage.action">Attendance</a></div>
      <%--<div class="menu-item deduction-student"><a class="link" href="/deductionStudents.action">Deduction students</a></div>--%>
    </div>
  </div>
  <div class="footer-container">
    <div class="footer-info">
      Created by Oleh Kudryavcev. Group IPZ-1544
    </div>
  </div>
</div>
</body>
</html>
