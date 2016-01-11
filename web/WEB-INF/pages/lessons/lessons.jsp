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
  <title>Lessons</title>
  <link rel="stylesheet" type="text/css" href="resources/css/lesson.css">
</head>
<body>
<div class="main-container">
  <div class="header-container">
    <div class="welcome-container">
      <h1>Electronic deanery</h1>
      <span>Info about lessons</span>
      <a href="/addLessonPage.action">Add new lesson</a>
    </div>
  </div>
  <div class="body-container">
    <div class="lesson-container">
      <c:if test="${not empty lessons}">
          <c:forEach var="lesson" items="${lessons}">
            <div class="lesson-item">
              <span>${lesson.lessonName}</span>
              <a href="/addLessonPage.action?lessonId=${lesson.id}">update</a>
            </div>
            <%--<div class="removeLesson_js">
              <a href="/removeLesson.action?lessonId=${lesson.id}">remove</a>
            </div>--%>
          </c:forEach>
      </c:if>
      <c:if test="${empty lessons}">
        <span class="empty-info">No info. Please add lesson</span>
      </c:if>
    </div>
  </div>
</div>
</body>
</html>