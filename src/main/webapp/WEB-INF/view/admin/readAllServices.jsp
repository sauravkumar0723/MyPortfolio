<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

body{
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 20px;
}

h1{
    text-align: center;
    color: #333;
}

a{
    text-decoration: none;
    background-color: #007bff;
    color: white;
    padding: 8px 12px;
    border-radius: 5px;
    margin-right: 10px;
}

a:hover{
    background-color: #0056b3;
}

table{
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
    background-color: white;
}

th, td{
    border: 1px solid #ccc;
    padding: 10px;
    text-align: center;
}

th{
    background-color: #007bff;
    color: white;
}

img{
    width: 200px;
    height: auto;
    border-radius: 5px;
}

.delete-btn{
    background-color: red;
}

.delete-btn:hover{
    background-color: darkred;
}

.update-btn{
    background-color: green;
}

.update-btn:hover{
    background-color: darkgreen;
}

</style>

</head>
<body>

    <a href="${pageContext.request.contextPath}/client/home">Client Home</a> <br><br>

    <a href="${pageContext.request.contextPath}/admin/home">Admin Home</a> <br><br>
   
    <h1>All Services Details</h1>

    <table>

        <tr>
            <th>Image</th>
            <th>Title</th>
            <th>Description</th>
            <th>Delete</th>
            <th>Update</th>
        </tr>

        <c:forEach var="service" items="${listOfServices}">

            <tr>

                <td>
                    <img style="width: 300px; height: auto;"
                    src="${pageContext.request.contextPath}/img/services/${service.filename}" alt="">
                </td>

                <td>${service.title}</td>

                <td>${service.description}</td>

                <td>
                    <a class="delete-btn"
                    href="${pageContext.request.contextPath}/admin/deleteService?id=${service.id}&filename=${service.filename}">
                    delete
                    </a>
                </td>

                <td>
                    <a class="update-btn"
                    href="${pageContext.request.contextPath}/admin/updateService?id=${service.id}">
                    update
                    </a>
                </td>

            </tr>

        </c:forEach>

    </table>

</body>
</html>