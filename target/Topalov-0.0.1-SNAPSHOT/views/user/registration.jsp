<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>

<link rel="stylesheet" href="css/registration.css"/>


	<div class="login-page">
  <div class="form">
  <h1 class="registration">Registration</h1>
  <form:form modelAttribute="user" action="registration" method="post">
  
<div style="text-align: center; color: red; margin: 5px">
							<label for="Name">${usernameException}</label>
						</div>
      <form:input path="name" type="text" placeholder=" login" />
      <div style="text-align: center; color: red; margin: 5px">
							<label for="password">${passwordException}</label>
						</div>
      <form:input path="password" type="password" placeholder="Password"/>
      
      <div style="text-align: center; color: red; margin: 5px">
							<label for="email">${emailException}</label>
						</div>
       <form:input path="email" type="email" placeholder="email"/>
       
       <div style="text-align: center; color: red; margin: 5px">
							<label for="phone">${phoneException}</label>
						</div>
						<form:input path="phone" type="text"
							class="validate[required,custom[password]] feedback-input"
							id="phone" placeholder="phone" />
      <button>Registered</button>
      </form:form>
  </div>
</div>
​ <link   rel="stylesheet"  href="js/registration.js">

