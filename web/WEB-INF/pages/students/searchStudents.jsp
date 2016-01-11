<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: oleh
  Date: 31.10.15
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Search students</title>
  <link rel="stylesheet" type="text/css" href="/resources/css/student.css">
  <script src="resources/js/StudentContainer.js"></script>
  <script src="resources/js/jquery-2.1.3.min.js"></script>
</head>
<body>
<div class="main-container">
  <div class="header-container">
    <div class="welcome-container">
      <h1>Electronic deanery</h1>
      <span>Find students</span>
    </div>
  </div>
  <div class="body-container">
    <div class="search-container">
      <div class="seacrh-text">
        <input class="search-text searchString_js" type="text" placeholder="write first, last name of student or record number" >
      </div>
      <div class="search-group">
        <select class="searchGroup_js">
          <option value="0">--- Not selected ---</option>
          <c:forEach var="group" items="${groups}">
            <option value="${group.id}">${group.groupName}</option>
          </c:forEach>
        </select>
      </div>
      <div class="search-teacher">
        <select class="searchTeacher_js">
          <option value="0">--- Not selected ---</option>
          <c:forEach var="teacher" items="${teachers}">
            <option value="${teacher.id}">${teacher.firstName} ${teacher.lastName}</option>
          </c:forEach>
        </select>
      </div>
      <div class="search-action searchStudent_js">
        <span>Search</span>
      </div>
    </div>
    <div class="result-container searchResult_js"></div>
  </div>
</div>
<script>
  StudentClass.init();
</script>
</body>
</html>
