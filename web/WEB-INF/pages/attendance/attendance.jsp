<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: oleh
  Date: 31.10.15
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Attendance actions</title>
  <link rel="stylesheet" type="text/css" href="resources/css/attendance.css">
  <script src="resources/js/AttendanceContainer.js"></script>
  <script src="resources/js/jquery-2.1.3.min.js"></script>
</head>
<body>
<div class="main-container">
  <div class="header-container">
    <div class="welcome-container">
      <h1>Electronic deanery</h1>
      <span>You can do the following actions</span>
    </div>
  </div>
  <div class="body-container">
    <div class="btn add-attendance">
      <a href="/addAttendance.action">Add attendance</a>
    </div>
    <div class="btn attendance-for-group attendanceForGroup_js">
      Show for group
    </div>
    <select class="forGroup_js">
      <option value="0">--- Not selected ---</option>
      <c:forEach var="group" items="${groups}">
        <option value="${group.id}">${group.groupName}</option>
      </c:forEach>
    </select>
  </div>
</div>
<script>
  AttendanceClass.init();
</script>
</body>
</html>