<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: oleh
  Date: 31.10.15
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Student</title>
  <link rel="stylesheet" type="text/css" href="/resources/css/student.css">
  <script src="resources/js/StudentContainer.js"></script>
  <script src="resources/js/jquery-2.1.3.min.js"></script>
</head>
<body>
<div class="main-container">
  <div class="header-container">
    <div class="welcome-container">
      <h1>Electronic deanery</h1>
      <span>Info about student</span>
    </div>
  </div>
  <div class="body-container">
    <div class="student-info">
      <div class="left-block">
        <div class="info-item">
          <span>First name:</span>
          <input type="text" class="firstName_js">
        </div>
        <div class="info-item">
          <span>Last name:</span>
          <input type="text" class="lastName_js">
        </div>
        <%--<div class="info-item">
          <span>Date of birth:</span>
          <input type="date" class="birthDate_js">
        </div>--%>
      </div>
      <div class="right-block">
        <div class="info-item">
          <span>Group:</span>
          <select class="group_js">
            <option value="1">--- Not selected ---</option>
            <c:forEach var="group" items="${groups}">
              <option value="${group.id}">${group.groupName}</option>
            </c:forEach>
          </select>
        </div>
        <div class="info-item">
          <span>Record:</span>
          <input type="text" class="recordBookNumber_js">
        </div>
      </div>
    </div>
    <div class="student-action">
      <div class="add-student saveStudent_js">Save</div>
    </div>
  </div>
</div>
<script>
  StudentClass.init();
</script>
</body>
</html>
