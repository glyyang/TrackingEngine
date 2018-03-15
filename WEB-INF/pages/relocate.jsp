<%@include file="header.jsp"%>
<title>Relocating</title>
</head>
<body>
<jsp:include page="navbar.jsp" />
	<div class="row">
	<div class="col-md-3 col-sm-3 col-lg-3 space"></div>
	<div class="row">
	<div class="col-md-6 col-sm-6 col-lg-6 space">${myErr }</div>
	<div class="row">
	<div class="col-md-3 col-sm-3 col-lg-3 space"></div>
	<div class="row">
	<form action="${pageContext.request.contextPath }/createRelocation" method="post">
		<div class="row">
		<div class="col-md-2 col-sm-2 col-lg-2 space"></div>
		<div class="col-md-6 col-sm-6 col-lg-6 space">
		Ware House name: <select  name="warehouse">
			<c:forEach items="${relo }" var="re">
				<option>${re.name }</option>
			</c:forEach>
		</select>		
		</div>
		<div class="col-md-4 col-sm-4 col-lg-4 space"></div>
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
		<input type="submit" name="delivery" value="Asset Relocation"/>
		</div>
		
		<div class="col-md-4 col-sm-4 col-lg-4 space"></div>
		</div>
		<div class="row">
	</div>
	</form>
</body>
</html>