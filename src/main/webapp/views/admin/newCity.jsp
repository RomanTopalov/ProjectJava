<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<link rel="stylesheet" href="css/city.css">

<form:form modelAttribute="city" action="saveCity" method="post">
	<div class="login-page">
	<div class="form">
		<div class="login-form" >
	
	<form:input path="name" placeholder="city name"/>
	
	<form:select path="country" items="${countries}" itemLabel="name" itemValue="id" style=" width: 100px; height=20px"  >
	</form:select>
	<br>
	<button style=" margin-top: 20px;">save city</button>
		</div>
	</div>
</div>
</form:form>


