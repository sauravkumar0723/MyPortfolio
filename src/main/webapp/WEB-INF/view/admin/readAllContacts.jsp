<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

body{
    font-family: Arial, sans-serif;
    margin: 20px;
    background-color: #f4f4f4;
}

h1{
    text-align: center;
    color: #333;
}

a{
    text-decoration: none;
    color: white;
    background-color: #007bff;
    padding: 8px 12px;
    border-radius: 5px;
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

tr:nth-child(even){
    background-color: #f2f2f2;
}

.delete-btn{
    background-color: red;
}

.delete-btn:hover{
    background-color: darkred;
}

</style>

</head>
<body>

   <a href="${pageContext.request.contextPath}/client/home">Client Home</a> <br><br>

   <a href="${pageContext.request.contextPath}/admin/home">Admin Home</a> <br><br>
   
   <h1>All Contacts Details</h1>

   <table>

      <tr>
         <th>ID</th>
         <th>Name</th>
         <th>Email</th>
         <th>Subject</th>
         <th>Message</th>
         <th>Date Time</th>
         <th>Action</th>
      </tr>

      <c:forEach var="contact" items="${contactData}">

         <tr>

            <td>${contact.id}</td>

            <td>${contact.name}</td>

            <td>${contact.email}</td>

            <td>${contact.subject}</td>

            <td>${contact.message}</td>

            <td>${contact.datetime}</td>

            <td>
               <a class="delete-btn"
               href="${pageContext.request.contextPath}/admin/deleteContactById?id=${contact.id}">
               Delete
               </a>
            </td>

         </tr>

      </c:forEach>

   </table>
  
</body>
</html>