<div class="group-container">
  <span>Group name:</span>
  <input class="groupName_js" type="text" value="${group.groupName}">
</div>
<div class="teacher-container teacher_js">
  <span>Teacher:</span>
  <select class="newTeacher">
    <option value="0">--- Not selected ---</option>
    <c:forEach var="teacher" items="${teachers}">
      <option value="${teacher.id}" <c:if test="${groupTeacher eq teacher.id}">selected="selected" </c:if>>${teacher.firstName} ${teacher.lastName}</option>
    </c:forEach>
  </select>
</div>
<div class="save-group updateGroup_js">
  Update
</div>
<input type="hidden" class="groupId_js" value="${group.id}"/>