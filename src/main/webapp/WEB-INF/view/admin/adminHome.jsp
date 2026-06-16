<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    background:linear-gradient(to right, #0f2027, #203a43, #2c5364);
}

.admin-panel{
    width:420px;
    background:white;
    padding:40px;
    border-radius:15px;
    box-shadow:0px 5px 20px rgba(0,0,0,0.3);
    text-align:center;
}

h1{
    margin-bottom:30px;
    color:#203a43;
}

a{
    display:block;
    text-decoration:none;
    background:#203a43;
    color:white;
    padding:12px;
    margin-bottom:15px;
    border-radius:8px;
    transition:0.3s;
    font-size:16px;
    font-weight:bold;
}

a:hover{
    background:#2c5364;
    transform:scale(1.03);
}

button{
    width:100%;
    padding:12px;
    border:none;
    border-radius:8px;
    background:#d9534f;
    color:white;
    font-size:16px;
    font-weight:bold;
    cursor:pointer;
    transition:0.3s;
}

button:hover{
    background:#c9302c;
    transform:scale(1.03);
}

</style>

</head>
<body>

<div class="admin-panel">

   <h1>ADMIN PANEL</h1>

   <a href="${pageContext.request.contextPath}/client/home">Client Home</a> <br>
   
   <a href="${pageContext.request.contextPath}/admin/readAllContacts" >Read All Contacts</a><br>
   
   <a href="${pageContext.request.contextPath}/admin/addService" >Add Services</a><br>
    
   <a href="${pageContext.request.contextPath}/admin/readAllServices" >Read All Services</a><br>
   
   <a href="${pageContext.request.contextPath}/admin/uploadResume" >upload Resume</a><br>
    
   <%-- <a href="${pageContext.request.contextPath}/logout">logout</a><br> --%>
    
    
   <form action="${pageContext.request.contextPath}/logout" method="post" >  
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" ><br>
      <button>Logout</button>
    
   </form>

</div>

</body>
</html>