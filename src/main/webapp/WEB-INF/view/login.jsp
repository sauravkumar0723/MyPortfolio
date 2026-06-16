<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin login page</title>

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
    background:linear-gradient(to right, #1d2671, #c33764);
}

form{
    background:white;
    padding:35px;
    border-radius:12px;
    width:350px;
    box-shadow:0px 5px 15px rgba(0,0,0,0.3);
}

h2{
    text-align:center;
    margin-bottom:20px;
    color:white;
    position:absolute;
    top:80px;
}

label{
    display:block;
    margin-top:15px;
    margin-bottom:6px;
    font-weight:bold;
    color:#333;
}

input[type="text"],
input[type="password"]{
    width:100%;
    padding:12px;
    border:1px solid #ccc;
    border-radius:8px;
    outline:none;
    transition:0.3s;
}

input[type="text"]:focus,
input[type="password"]:focus{
    border-color:#1d2671;
    box-shadow:0px 0px 5px rgba(29,38,113,0.5);
}

button{
    width:100%;
    padding:12px;
    margin-top:20px;
    border:none;
    border-radius:8px;
    background:#1d2671;
    color:white;
    font-size:16px;
    cursor:pointer;
    transition:0.3s;
}

button:hover{
    background:#c33764;
}

.error{
    color:red;
    text-align:center;
    margin-bottom:10px;
    font-size:14px;
}

</style>

</head>
<body>

        <h2>ADMIN LOGIN PAGE</h2>
       
     <%
        if(request.getParameter("error")!=null) {
      %>	
            <p class="error">Invalid username Or Password</p>
      <%
             }
      %>
     
        
        <form action="/doLogin" method="post">

               <label>Username</label>
               <input type="text" name="user" placeholder="Enter username"><br>

               <label>Password</label>
               <input type="password" name="pass" placeholder="Enter Password"><br>

               <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" placeholder="Enter Password"><br>

               <button>login</button>
        
        
        </form>
       
</body>
</html>