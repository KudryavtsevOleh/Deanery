<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
  <c:when test="${not empty students}">
    <c:forEach var="student" items="${students}">
      <div class="student-item">
        <span>${student.firstName} ${student.lastName}</span>
        <a href="/getStudent.action?studentId=${student.id}">update</a>
      </div>
    </c:forEach>
  </c:when>
  <c:otherwise>
    <span class="empty-result">--- No results ---</span>
  </c:otherwise>
</c:choose>