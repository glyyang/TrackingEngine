<%@include file="header.jsp"%>
<title>Report History</title>
</head>
<body>
<jsp:include page="navbaradmin.jsp" />
<div class="pagination">
	<c:forEach items="${vhs }" var="viewDate">
		<a href="${pageContext.request.contextPath }/toPast/${viewDate.ent_date}">
			${viewDate.ent_date }</br>
		</a>
	</c:forEach>
	<div class="row">
	<div class="col-md-2 col-sm-2 col-lg-2 space"></div>
	<div class="col-md-6 col-sm-6 col-lg-6 space">
		<a href="${pageContext.request.contextPath }/goHome">
			<button>
				Back to home
			</button>
		</a>
	</div>
	<div class="col-md-4 col-sm-4 col-lg-4 space"></div>
	</div>
</div>
</body>
</html>