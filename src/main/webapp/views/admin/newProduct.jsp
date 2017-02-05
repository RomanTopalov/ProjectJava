<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<c:forEach var="product" items="${products}">
	<div style="background-color: grey">
		${product.name} ${product.price} <a href="deleteProduct/${product.id}">delete</a>
	</div>
	<br>
</c:forEach>

<form:form modelAttribute="product" action="saveProduct" method="post">
	<form:input path="name" placeholder="name"placeholder="name" />
	<input name="count" type="number" />
	<input name="price" placeholder="price">
	
	<form:input path="description" type="text" placeholder="description" />

	<form:select path="country" items="${countriesDTOs}" itemLabel="name"
		itemValue="id">
	</form:select>

	<form:select path="category" items="${categoriesDTOs}" itemLabel="name"
		itemValue="id">
	</form:select>
	

	<button>save product</button>

</form:form>



<%-- <img src="${product.pathImage}" alt="add foto" width="100px"
	height="100px">
<br>

	<form:form
		action="./saveImageProduct?${_csrf.parameterName}=${_csrf.token}"
		method="post" enctype="multipart/form-data">
		<input type="file" name="image">
		<button>save image</button>
	</form:form>
 --%>