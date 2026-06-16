<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Service</title>

<style>

body{
    margin:0;
    padding:0;
    font-family: Arial, sans-serif;
    background-color:#f5f5f5;
}

.container{
    width:500px;
    margin:50px auto;
    background:white;
    padding:30px;
    border-radius:10px;
    box-shadow:0px 0px 10px rgba(0,0,0,0.1);
}

a{
    text-decoration:none;
    color:white;
    background:#007bff;
    padding:8px 15px;
    border-radius:5px;
    display:inline-block;
    margin-bottom:10px;
}

a:hover{
    background:#0056b3;
}

input[type="text"],
textarea,
input[type="file"]{
    width:100%;
    padding:10px;
    margin-top:10px;
    margin-bottom:20px;
    border:1px solid #ccc;
    border-radius:5px;
    box-sizing:border-box;
}

textarea{
    height:120px;
    resize:none;
}

button{
    background:#28a745;
    color:white;
    border:none;
    padding:10px 20px;
    border-radius:5px;
    cursor:pointer;
    font-size:16px;
}

button:hover{
    background:#218838;
}

h2{
    text-align:center;
    margin-bottom:20px;
}

</style>

</head>
<body>

<div class="container">

      <h2>UPDATE SERVICE</h2>

      <a href="${pageContext.request.contextPath}/client/home">Client Home</a>
      
      <a href="${pageContext.request.contextPath}/admin/home">Admin Home</a>
      
      <form action="${pageContext.request.contextPath}/admin/updateService" method="post" enctype="multipart/form-data">

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

            <input type="hidden" name="id" value="${serviceData.id}">

            <input type="hidden" name="oldFileName"  value="${serviceData.filename}">

            <label>Service Title</label>
            <input type="text" name="title" placeholder="enter title" value="${serviceData.title}">

            <label>Description</label>
            <textarea name="description">${serviceData.description}</textarea>

            <label>Upload New File</label>
            <input type="file" name="serviceFile">

            <button type="submit">Save</button>

      </form>

</div>

</body>
</html>