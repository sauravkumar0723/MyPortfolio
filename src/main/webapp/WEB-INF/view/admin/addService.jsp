<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial, sans-serif;
}

body{
    min-height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    background:linear-gradient(to right, #1f4037, #99f2c8);
}

.container{
    width:450px;
    background:white;
    padding:35px;
    border-radius:15px;
    box-shadow:0px 5px 20px rgba(0,0,0,0.3);
}

h1{
    text-align:center;
    margin-bottom:25px;
    color:#1f4037;
}

a{
    display:inline-block;
    text-decoration:none;
    color:white;
    background:#1f4037;
    padding:10px 15px;
    border-radius:8px;
    margin-bottom:15px;
    transition:0.3s;
    font-size:14px;
}

a:hover{
    background:#14532d;
}

label{
    display:block;
    margin-top:15px;
    margin-bottom:8px;
    font-weight:bold;
    color:#333;
}

input[type="text"],
textarea,
input[type="file"]{
    width:100%;
    padding:12px;
    border:1px solid #ccc;
    border-radius:8px;
    outline:none;
    font-size:15px;
}

textarea{
    height:120px;
    resize:none;
}

input[type="text"]:focus,
textarea:focus{
    border-color:#1f4037;
    box-shadow:0px 0px 5px rgba(31,64,55,0.4);
}

button{
    width:100%;
    padding:12px;
    margin-top:20px;
    border:none;
    border-radius:8px;
    background:#1f4037;
    color:white;
    font-size:16px;
    font-weight:bold;
    cursor:pointer;
    transition:0.3s;
}

button:hover{
    background:#14532d;
}

.error{
    color:red;
    font-size:14px;
    margin-top:5px;
}

.result{
    color:green;
    margin-bottom:15px;
    font-weight:bold;
    text-align:center;
}

</style>

</head>
<body>

<div class="container">

<h1>ADD SERVICES</h1>
    
<a href="${pageContext.request.contextPath}/client/home">Client Home</a> <br>

<a href="${pageContext.request.contextPath}/admin/home">Admin Home</a> <br>

<div class="result">${result}</div>

<form action="${pageContext.request.contextPath}/admin/addService" method="post" enctype="multipart/form-data">
            
    <c:forEach var="err" items="${errors}">
        <c:if test="${err.field=='title'}"> 
            <div class="error">${err.defaultMessage}</div>
        </c:if>
    </c:forEach>

    <label>Service Title</label>
    <input type="text" name="title" placeholder="enter tittle"><br>
            
    <c:forEach var="err" items="${errors}">
        <c:if test="${err.field=='description'}"> 
            <div class="error">${err.defaultMessage}</div>
        </c:if>
    </c:forEach>
                       
    <label>Description</label>
    <textarea name="description">Enter Description...</textarea><br>
            
    <div class="error">${fileError}</div><br>

    <label>Upload Service File</label>
    <input type="file" name="serviceFile">
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <button>save</button>

</form>

</div>
          
</body>
</html>