<%@include file="header.jsp"%>
<title>Manager Home</title>
</head>
<body>
<jsp:include page="navbaradmin.jsp" />

	<div class="row">
	<div class="col-md-3 col-sm-3 col-lg-3 space"></div>
	<div class="col-md-6 col-sm-6 col-lg-6 space">
		<a href="${pageContext.request.contextPath }/getCurrent">
			<button>Check Current report</button>
		</a>
	</div>
	<div class="col-md-3 col-sm-3 col-lg-3 space"></div>
	</div>
		
	<div class="row">
	<div class="col-md-3 col-sm-3 col-lg-3 space"></div>
	<div class="col-md-6 col-sm-6 col-lg-6 space">
		<a href="${pageContext.request.contextPath }/toPast">
			<button>Check past report</button>
		</a>
	</div>
	<div class="col-md-3 col-sm-3 col-lg-3 space"></div>
	</div>

</body>
</html>