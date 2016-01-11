<div class="group-container">
  <span>Group name:</span>
  <input class="groupName_js" type="text">
</div>
<div class="teacher-container teacher_js">
  <span>Teacher:</span>
  <select>
    <option value="0">--- Not selected ---</option>
    <c:forEach var="teacher" items="${teachers}">
      <option value="${teacher.id}">${teacher.firstName} ${teacher.lastName}</option>
    </c:forEach>
  </select>
</div>
<div class="save-group submit_js">
  Save
</div>