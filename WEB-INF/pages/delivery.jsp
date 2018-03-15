<%@include file="header.jsp"%>
<title>Delivering</title>
</head>
<body>
<jsp:include page="navbar.jsp" />
	<div class="row">
		<div class="col-md-3 col-sm-3 col-lg-3 space"></div>
		<div class="col-md-6 col-sm-6 col-lg-6 space">
			${myErr }
		</div>
		<div class="col-md-3 col-sm-3 col-lg-3 space"></div>
	</div>
	<form action="${pageContext.request.contextPath }/createDelivery" method="post">
		<div class="row">
			<div class="col-md-3 col-sm-3 col-lg-3 space"></div>
			<div class="col-md-9 col-sm-9 col-lg-9 space">
				Delivery Destination: <input type="text" name="destination"/>
			</div>
		</div>
		<c:forEach items="${sessionScope.employee.warehouse.asset_warehouses }" var="vw">
			<div class="row">
			<div class="col-md-3 col-sm-3 col-lg-3 space"></div>
			<div class="col-md-6 col-sm-6 col-lg-6 space">
			${vw.asset.name }: <input type="hidden" name="assets" value="${vw.asset.name }"/>
			Quantity: <input type="text" name="quantities" value="0"/>
			</div>
			<div class="col-md-3 col-sm-3 col-lg-3 space"></div>
			</div>
		</c:forEach>
		<div class="row">
		<div class="col-md-2 col-sm-2 col-lg-2 space"></div>
		<div class="col-md-6 col-sm-6 col-lg-6 space">
		<input type="submit" name="delivery" value="Asset Delivery"/>
		</div>
		<div class="col-md-4 col-sm-4 col-lg-4 space"></div>
		</div>
	</form>
</body>
</html>