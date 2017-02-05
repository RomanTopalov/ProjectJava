<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

<link rel="stylesheet" href="css/home.css">
<link rel="stylesheet" href="css/sideBar.css">


<!-- side bar -->
<div class="container">
    <div id="sidebar">
        <ul>
        <li><a href="#"><input type="text" id="liveSearch" placeholder="search by name"></a></li>
            <li><a href="#">Home</a></li>
            <li><a href="#">Explore</a></li>
            
            <li><a href="#">Users</a></li>
               <li> <a href="#"><div class="radiocheck"><input class="radio" id="radio" type="range" name="product" min="1" max="1000" step="10">

<button id="get">get products</button>
<br></div>
<div id="products">
    <c:forEach var="product" items="${products}">
        ${product.name} ${product.price}<br>
    </c:forEach>
</div>

<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value"
       value="${_csrf.token}" />

</a></li>



        </ul>
    </div>
    <div class="main-content">
        <div class="swipe-area"></div>
        <a href="#" data-toggle=".main-content" id="sidebar-toggle">
            <span class="bar"></span>
            <span class="bar"></span>
            <span class="bar"></span>
        </a>
        <div class="content">

          
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
<div id="allProducts">
<c:forEach var="product" items="${products}">
	<div class="wrapper">
		<div class="row">
			<div class="container-item">
				<div class="item">
					<div class="item-overlay">
						<a href="#" class="item-button share share-btn"><i class="play"></i></a>
						<!-- <div class="sale-tag"><span>SALE</span></div> -->
					</div>
					<div class="item-content">
						<div class="item-top-content">
							<div class="item-top-content-inner">
								<div class="item-product">
									<div class="item-top-title"><p>Name:</p>
		




										<h2>${product.name}</h2>
									<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}"/>
<input type="hidden" name="csrf_value"
       value="${_csrf.token}"/>
									</div>
								</div>
								<div class="item-product-price">
									<span class="price-num">${product.price} $</span>
								</div>
							</div>	
						</div>
						<div class="item-add-content">
							<div class="item-add-content-inner">
								
								<div class="section"><sec:authorize access="isAuthenticated()">
									<a href="buyProduct/${product.id}" class="btn buy expand">Buy now</a>
									</sec:authorize>
															
								</div>
							</div>
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>
	</c:forEach>
	</div>
	
	

          
          
           <div class="large"></div>
       
        </div>
    </div>
</div>


<script>
$(document).ready(function() {
	  $("[data-toggle]").click(function() {
	    var toggle_el = $(this).data("toggle");
	    $(toggle_el).toggleClass("open-sidebar");
	    $('#sidebar').toggleClass('change-sidebar');
	  });
	     
	});

</script>



	       <script>
    document.getElementById('liveSearch').oninput = function () {
        var liveSearch = document.getElementById('liveSearch').value;
//        console.log(liveSearch);
        $.ajax({
            url: 'liveSearchProducts?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
            method: 'POST',
            contentType: 'application/json; charset=UTF-8',
            dataType: 'json',
            data: liveSearch,
            success: function (res) {
                var all = '';
                for (var i = 0; i < res.length; i++) {
                    all += res[i].name+ ' ' + res[i].price + '<br>';
                }
                document.getElementById('allProducts').innerHTML = all;
            }
        })
    }
</script>



<script>
    document.getElementById('get').onclick = function () {
        var check = document.getElementById('radio').value;
       $.ajax({
           url: 'sortProducts?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
           contentType: 'application/json; charset=UTF-8',
           dataTypes: 'json',
           method: "POST",
           data : check,
           success : function (res) {
               var allProducts = '';
               for(var i =0; i < res.length; i++){
                   allProducts+=res[i].name+'<br>';
               }
               document.getElementById('products').innerHTML = allProducts;
           }
       })
    }
</script>









 <%--    <div class="radiocheck"><input class="radio" id="radio" type="range" name="product" min="1" max="1000" step="10">

<button id="get">get products</button>
<br></div>
<div id="products">
    <c:forEach var="product" items="${products}">
        ${product.name} ${product.price}<br>
    </c:forEach>
</div>

<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value"
       value="${_csrf.token}" />

<script>
    document.getElementById('get').onclick = function () {
        var check = document.getElementById('radio').value;
       $.ajax({
           url: 'sortProducts?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
           contentType: 'application/json; charset=UTF-8',
           dataTypes: 'json',
           method: "POST",
           data : check,
           success : function (res) {
               var allProducts = '';
               for(var i =0; i < res.length; i++){
                   allProducts+=res[i].name+'<br>';
               }
               document.getElementById('products').innerHTML = allProducts;
           }
       })
    }
</script>



 --%>










