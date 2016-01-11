<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Work with groups</title>
  <link rel="stylesheet" type="text/css" href="resources/css/groups.css">
  <script src="resources/js/GroupContainer.js"></script>
  <script src="resources/js/Validation.js"></script>
  <script src="resources/js/jquery-2.1.3.min.js"></script>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
</head>
<body>
<div class="main-container">
  <div class="header-container">
    <div class="welcome-container">
      <h1>Electronic deanery</h1>
      <span>Add new group</span>
    </div>
  </div>
  <div class="body-container">
    <c:choose>
      <c:when test="${not empty group}">
        <%@ include file="updateGroupPage.jsp"%>
      </c:when>
      <c:otherwise>
        <%@ include file="addGroupPage.jsp"%>
      </c:otherwise>
    </c:choose>
    <div class="error" style="display: none;">
      <span>Invalid group name</span>
    </div>
  </div>
  <div class="errorDialog_js" style="display: none;">
    Internal server error.
  </div>
</div>
<script>
  GroupClass.init();
</script>
</body>
</html>