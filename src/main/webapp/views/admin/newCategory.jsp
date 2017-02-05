
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<link rel="stylesheet" href="css/category.css">




	<c:forEach var="category" items="${categories}">
		${category.name} 
		<a href="deleteCategory/${category.id}">delete category</a>

		<c:forEach var="product" items="${category.products}">
			${product.name}	${product.price}
			<a href="deleteProductCategory/${product.id}">delete product</a>

		</c:forEach>
		<br>
	</c:forEach>


<%-- <div class="login">
  <div class="login-triangle"></div>
  
  <h2 class="login-header">new Category</h2>

  <form:form modelAttribute="category" action="saveCategory" method="post" class="login-container">
    <p><form:input path="name"  type="text" placeholder="author name"/></p>
  
    <p><input type="submit" value="save category"></p>
  </form:form>
</div> --%>


 <form:form modelAttribute="category" action="saveCategory" method="post">
<div class="login-page">
	<div class="form">
		<div class="login-form" >

			  <p><form:input path="name"  type="text" placeholder="category name"/></p>
					 <button>Save category</button>
			
		</div>
	</div>
</div>
​</form:form>
<link rel="stylesheet" href="js/login.js">

