<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
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

.container{
    width: 400px;
    margin: auto;
    background-color: white;
    padding: 20px;
    border-radius: 8px;
    border: 1px solid #ccc;
}

a{
    text-decoration: none;
    background-color: #007bff;
    color: white;
    padding: 8px 12px;
    border-radius: 5px;
}

a:hover{
    background-color: #0056b3;
}

label{
    font-weight: bold;
    display: block;
    margin-bottom: 8px;
}

input[type="file"]{
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

button{
    background-color: green;
    color: white;
    border: none;
    padding: 10px 15px;
    border-radius: 5px;
    cursor: pointer;
}

button:hover{
    background-color: darkgreen;
}

.result{
    color: green;
    margin-bottom: 15px;
    font-weight: bold;
}

</style>

</head>
<body>

<a href="${pageContext.request.contextPath}/client/home">Client Home</a> <br><br>

<a href="${pageContext.request.contextPath}/admin/home">Admin Home</a> <br><br>

<div class="container">

   <div class="result">${result}</div>

    <form action="${pageContext.request.contextPath}/admin/uploadResume" method="post" enctype="multipart/form-data">

        <label>Upload Resume</label>

        <input type="file" name="resume" ><br>
           <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <button>upload</button>

    </form>

</div>

</body>
</html>