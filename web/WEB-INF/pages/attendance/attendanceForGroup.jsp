<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Attendance for group ${group.groupName}</title>
  <link rel="stylesheet" type="text/css" href="resources/css/attendance.css">
</head>
<body>
<div class="main-container">
  <div class="header-container">
    <div class="welcome-container">
      <h1>Electronic deanery</h1>
    </div>
  </div>
  <div class="body-container">
    <div class="attendance-header">
      <b>First Name | Last Name | Lesson | Attendance Date | Mark | Presents</b>
    </div>
    <div class="attendance-item">
      <c:forEach var="attendance" items="${attendances}">
        <div>
          ${attendance.studentFirstName} | ${attendance.studentLastName} | ${attendance.lesson} | ${attendance.attendanceDate} | ${attendance.mark} | ${attendance.presents}
        </div>
      </c:forEach>
    </div>
  </div>
</div>
</body>
</html>