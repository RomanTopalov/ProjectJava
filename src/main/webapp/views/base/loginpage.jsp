<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<link rel="stylesheet" href="css/login.css">


<%-- <form:form action="loginprocesing" method="post">
    <input name="username" type="text" placeholder="login"/>
    <input name="password" type="password" placeholder="password"/>
    <button>login</button>
</form:form> --%>

<form:form action="loginprocesing" method="post">
<div class="login-page">
	<div class="form">
	  <h1 class="registration">Login</h1>
		<div class="login-form" >

			 <input name="username" type="text" placeholder="login"/>
    <input name="password" type="password" placeholder="password"/>
					 <button>Log in </button>
			
				Not registered? <a href="registration">Create an account</a>
		</div>
	</div>
</div>
​</form:form>
<link rel="stylesheet" href="js/login.js">