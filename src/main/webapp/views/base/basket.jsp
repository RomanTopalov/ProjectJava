<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<link rel="stylesheet" href="css/home.css">
<link rel="stylesheet" href="js/home.js">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>


<div
	style="background-color: #16aa56; text-align: center; border-radius: 10px">
	<h2>your basked</h2>
</div>




<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>


<c:forEach var="product" items="${products}">
	<div class="wrapper">
		<div class="row">
			<div class="container-item">
				<div class="item">
					<div class="item-overlay">
						<a href="#" class="item-button share share-btn"><i
							class="play"></i></a>
						<!-- <div class="sale-tag"><span>SALE</span></div> -->
					</div>
					<div class="item-content">
						<div class="item-top-content">
							<div class="item-top-content-inner">
								<div class="item-product">
									<div class="item-top-title">
										<p>Name:</p>

										<h2>${product.name}</h2>

									</div>
								</div>
								<div class="item-product-price">
									<span class="price-num">${product.price} $</span>
								</div>
							</div>
						</div>
						<div class="item-add-content">
							<div class="item-add-content-inner">

								<div class="section">
									<a href="deleteFromOrder/${product.id}" class="btn buy expand">delete
										from Basket</a>
								

								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</c:forEach>

<c:if test="${empty products}">
	<div style="text-align: center">
		<h2>you have an empty basket</h2>
	</div>
</c:if>

<%-- <c:forEach var="product" items="${products}">
    ${product.name}  ${product.price} 
    <a href="deleteFromOrder/${product.id}">delete From Cookie</a>

	<div class="popup" onclick="myFunction()">
		get order
		<div class="popuptext" id="myPopup"></div>
	</div>
	<br>
</c:forEach> --%>

<div>
<c:forEach var="product" items="${products}">
    ${product.name} ${product.price}
    <a href="deleteFromOrder/${product.id}">delete</a>
	<a href="getOrder/${product.id}">get order</a>
	<br>
</c:forEach>
</div>







<script>
	function myFunction() {
		var popup = document.getElementById('myPopup');
		popup.classList.toggle('show');
	}
</script>

<script src="/js/popup.js"></script>

