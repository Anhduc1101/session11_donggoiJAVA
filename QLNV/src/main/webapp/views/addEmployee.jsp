<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/24/2023
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<body>
<p>
    <a href="/EmployeeController">Back to employee list</a>
</p>
<h1 class="text-center text-danger">Thêm mới nhân viên</h1>
<form action="<%=request.getContextPath()%>/EmployeeController" method="POST">
    <input type="hidden" name="action" value="add">
    <div class="form-group">
        <label for="name">name: </label>
        <input type="text" class="form-control" id="name" name="em_name">
    </div>
    <div class="form-group">
        <label for="phone">phone: </label>
        <input type="text" class="form-control" id="phone" name="em_phone">
    </div>
    <div class="form-group">
        <label for="address">address: </label>
        <input type="text" class="form-control" id="address" name="em_address">
    </div>
    <div class="form-group">
        <label for="birthday">birthday: </label>
        <input type="date" class="form-control" id="birthday" name="em_birthday">
    </div>
    <div class="form-group">
        <label>sex: </label>
        <select name="em_gender" >
            <option value="true">Nam</option>
            <option value="false">Nữ</option>
        </select>
    </div>
    <div class="form-group">
        <label for="salary">salary: </label>
        <input type="text" class="form-control" id="salary" name="em_salary">
    </div>
    <button type="submit" class="btn btn-primary">Add</button>
</form>
</body>
</html>