<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Registration</title>
  <link rel="stylesheet" type="text/css" href="resources/css/groups.css">
</head>
<body>
<div class="main-container">
  <div class="header-container">
    <div class="welcome-container">
      <h1>Electronic deanery</h1>
      <span>Info about group</span>
      <a href="/addGroup.action">Add new group</a>
    </div>
  </div>
  <div class="body-container">
    <div class="group-container">
      <c:choose>
        <c:when test="${not empty groups}">
          <ul>
            <c:forEach var="group" items="${groups}">
              <li><a href="/updateGroupPage.action?id=${group.id}">${group.groupName}</a></li>
            </c:forEach>
          </ul>
        </c:when>
        <c:otherwise>
          <div class="empty">
            <span class="empty-groups">Empty info</span>
          </div>
        </c:otherwise>
      </c:choose>
    </div>
  </div>
</div>
</body>
</html>