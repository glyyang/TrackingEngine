<%@include file="header.jsp"%>
<title>Receiving</title>
</head>
<body>
<jsp:include page="navbar.jsp" />
	<form action="${pageContext.request.contextPath }/commitReceive" method="POST">
		<c:forEach items="${rec }" var="myRec">
			<div class="row">
			<div class="col-md-2 col-sm-2 col-lg-2 space"></div>
			<div class="col-md-6 col-sm-6 col-lg-6 space">
			<input type="checkbox" name="ids" value="${ myRec.id}">Record ID: ${ myRec.id}</input>
			</div>
			<div class="col-md-4 col-sm-4 col-lg-4 space"></div>
			</div>
			<div class="row">
			<div class="col-md-2 col-sm-2 col-lg-2 space"></div>
			<div class="col-md-6 col-sm-6 col-lg-6 space">
			&nbsp;&nbsp;Items:
			</div>
			<div class="col-md-4 col-sm-4 col-lg-4 space"></div>
			</div>
			<c:forEach items="${myRec.sub_record }" var="vw">
				<div class="row">
				<div class="col-md-3 col-sm-3 col-lg-3 space"></div>
				<div class="col-md-6 col-sm-6 col-lg-6 space">
				${vw.asset.name }:
				Quantity: ${vw.quantity }
				</div>
				<div class="col-md-3 col-sm-3 col-lg-3 space"></div>
				</div>
			</c:forEach>
		</c:forEach>
		<div class="row">
		<div class="col-md-2 col-sm-2 col-lg-2 space"></div>
		<div class="col-md-6 col-sm-6 col-lg-6 space">
		<input type="submit" name="back" value="Submit"/>
		</div>
		
		<div class="col-md-4 col-sm-4 col-lg-4 space"></div>
		</div>
	</form>
</body>
</html>