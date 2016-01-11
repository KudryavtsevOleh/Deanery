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
  <%--<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">--%>
  <script src="resources/js/AttendanceContainer.js"></script>
  <script src="resources/js/jquery-2.1.3.min.js"></script>
  <%--<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>--%>
</head>
<body>
<div class="main-container">
  <div class="header-container">
    <div class="welcome-container">
      <h1>Electronic deanery</h1>
    </div>
  </div>
  <div class="body-container">
    <div class="left-container">
      <div class="group">
        <span>Group:</span>
        <select class="group_js">
          <option value="0">--- Not selected ---</option>
          <c:forEach var="group" items="${groups}">
            <option value="${group.id}">${group.groupName}</option>
          </c:forEach>
        </select>
      </div>
      <div class="student groupStudents_js">
        <%@include file="groupStudents.jsp"%>
      </div>
      <div class="lesson">
        <span>Lesson:</span>
        <select class="lesson_js">
          <option value="0" selected>--- Not selected ---</option>
          <c:forEach var="lesson" items="${lessons}">
            <option value="${lesson.id}">${lesson.lessonName}</option>
          </c:forEach>
        </select>
      </div>
    </div>
    <div class="right-container">
      <div class="mark">
        <span>Mark:</span>
        <select class="mark_js">
          <c:forEach var="mark" begin="2" end="5">
            <option value="${mark}">${mark}</option>
          </c:forEach>
        </select>
      </div>
      <div class="presents">
        <span>Presents:</span>
        <input type="checkbox" class="presents_js">
      </div>
    </div>
    <div class="btn save_js">
      Save
    </div>
  </div>
</div>
<script>
  AttendanceClass.init();
</script>
</body>
</html>