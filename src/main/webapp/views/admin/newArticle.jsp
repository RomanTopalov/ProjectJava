<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

  <%@ taglib uri="http://www.springframework.org/security/tags"	prefix="sec"%>

    
<link   rel="stylesheet"  href="css/article.css">


 
 <div class="login-page">
  <div class="form">
  	<h1 class="article">Add New Post</h1>
   <sf:form modelAttribute="article" action="createArticle" method="post">
	<sf:input path="name" type="text"/>
	<input name="date" type="date">
	 
	 <p class="text_data"><sf:input path="data" /></p>

      <button>Publish</button>
    
      </sf:form>
  </div>
</div>

<link   rel="stylesheet"  href="js/article.js"> 

<%-- 	<c:forEach var="article" items="${articles}">
${article.name}
${article.dateofPublic}
${article.data}

<sec:authorize access="hasRole('ROLE_ADMIN')">
<a href="deleteArticle/${article.id}">delete</a>
</sec:authorize>
	</c:forEach> --%>
	
<c:forEach var="article" items="${articles}">
<div class="outputArticle">
 <div class="title">${article.name} <p>create by</p> userName</div>
<div class="dateOfCreate"> Date of creation :  ${article.dateofPublic}</div>
<textarea class="text1"  rows="auto">${article.data}</textarea>
<sec:authorize access="hasRole('ROLE_ADMIN')">
<a href="deleteArticle/${article.id}">delete</a>
</sec:authorize>
 </div>
	</c:forEach>

       

