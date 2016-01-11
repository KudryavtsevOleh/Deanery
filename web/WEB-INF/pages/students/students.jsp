<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: oleh
  Date: 31.10.15
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Students</title>
  <link rel="stylesheet" type="text/css" href="resources/css/student.css">
</head>
<body>
<div class="main-container">
  <div class="header-container">
    <div class="welcome-container">
      <h1>Electronic deanery</h1>
      <span>Info about students</span><br>
      <a href="/getStudent.action">Add student</a>
      <a href="/searchStudents.action">Search student</a>
    </div>
  </div>
  <div class="body-container">
    <div class="group-container">
      <div class="student-container">
        <c:choose>
          <c:when test="${not empty students}">
            <c:forEach var="student" items="${students}">
              <div class="student-info">
                <span>${student.firstName} ${student.lastName}</span>
                <a href="/getStudent.action?studentId=${student.id}">update</a>
                  <%--<a href="/removeStudent.action?studentId=${student.id}">delete</a>--%>
              </div>
            </c:forEach>
          </c:when>
          <c:otherwise>
            <div class="empty">
              <span class="empty-result">Empty info</span>
            </div>
          </c:otherwise>
        </c:choose>
      </div>
    </div>
  </div>
</div>
</body>
</html>
