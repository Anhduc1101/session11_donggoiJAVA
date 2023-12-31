<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/24/2023
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
    }

    h2 {
        color: #333;
    }

    a {
        text-decoration: none;
        color: #3498db;
    }

    a:hover {
        color: #207cca;
    }

    p {
        margin-bottom: 20px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    table, th, td {
        border: 1px solid #ddd;
    }

    th, td {
        padding: 10px;
        text-align: left;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    tr:hover {
        background-color: #e5e5e5;
    }

    td a {
        display: inline-block;
        padding: 5px 10px;
        background-color: #3498db;
        color: white;
        text-decoration: none;
    }

    td a:hover {
        background-color: #207cca;
    }

</style>

<body>
<h2>Employees List</h2>
<p>
    <a href="/EmployeeController?action=add">Add new employee</a>
</p>
<table border="1" cellspacing="0">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Phone</td>
        <td>Address</td>
        <td>Birthday</td>
        <td>Gender</td>
        <td>Salary</td>
        <td colspan="2">Action</td>
    </tr>
    <c:forEach items='${employeeList}' var="item" >
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.phone}</td>
            <td>${item.address}</td>
            <td>${item.birthday}</td>
            <td>${item.gender?"Male":"Female"}</td>
            <td>${item.salary}</td>

            <td><a href="/EmployeeController?action=edit&id=${item.id}">Edit</a></td>
            <td><a href="/EmployeeController?action=delete&id=${item.id}" onclick="return confirm('Are you sure?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
