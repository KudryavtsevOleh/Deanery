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
  <title>Add new lesson</title>
  <link rel="stylesheet" type="text/css" href="resources/css/lesson.css">
  <script src="resources/js/LessonContainer.js"></script>
  <script src="resources/js/Validation.js"></script>
  <script src="resources/js/jquery-2.1.3.min.js"></script>
</head>
<body>
<div class="main-container">
  <div class="header-container">
    <div class="welcome-container">
      <h1>Electronic deanery</h1>
      <span><c:choose><c:when test="${updateLesson}">Update lesson</c:when><c:otherwise>Add new lesson</c:otherwise></c:choose></span>
    </div>
  </div>
  <div class="body-container">
    <span>Lesson name: </span>
    <input type="text" class="lessonName_js" value="${lesson.lessonName}"><br>
    <div class="save-btn saveLesson_js">save</div>
    <span class="empty_js" style="color: #ff0000; display: none;">Input might not be empty.</span>
    <span class="error_js" style="color: #ff0000; display: none;">Write correct lesson name.</span>
    <c:choose>
      <c:when test="${lessonId eq null}">
        <c:set var="currentLessonId" value="0"/>
      </c:when>
      <c:otherwise><c:set var="currentLessonId" value="${lessonId}"/></c:otherwise>
    </c:choose>
    <input type="hidden" class="lessonId_js" value="${currentLessonId}">
  </div>
</div>
<script>
  LessonClass.init();
</script>
</body>
</html>
