<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<span>Student:</span>
<select class="student_js">
  <option value="0">--- Not selected ---</option>
  <c:forEach var="student" items="${students}">
    <option value="${student.id}">${student.firstName} ${student.lastName}</option>
  </c:forEach>
</select>