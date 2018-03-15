<%@include file="header.jsp"%>
<title>Worker Home</title>
</head>
<body>
<jsp:include page="navbar.jsp" />

	<div class="row">
	<div class="col-md-3 col-sm-3 col-lg-3 space"></div>
	<div class="col-md-6 col-sm-6 col-lg-6 space">
		<a href="${pageContext.request.contextPath }/toRelocation">
			<button>Asset Relocation</button>
		</a>
	</div>
	<div class="col-md-3 col-sm-3 col-lg-3 space"></div>
	</div>
	
	<div class="row">
	<div class="col-md-3 col-sm-3 col-lg-3 space"></div>
	<div class="col-md-6 col-sm-6 col-lg-6 space">
		<a href="${pageContext.request.contextPath }/toDelivery">
			<button>Asset Delivery</button>
		</a>
	</div>
	<div class="col-md-3 col-sm-3 col-lg-3 space"></div>
	</div>	
	
	<div class="row">
	<div class="col-md-3 col-sm-3 col-lg-3 space"></div>
	<div class="col-md-6 col-sm-6 col-lg-6 space">
		<a href="${pageContext.request.contextPath }/createReceive">
			<button>Asset Receiving</button>
		</a>
	</div>
	<div class="col-md-3 col-sm-3 col-lg-3 space"></div>
	</div>
		
	<div class="row">
	<div class="col-md-3 col-sm-3 col-lg-3 space"></div>
	<div class="col-md-6 col-sm-6 col-lg-6 space">
		<a href="${pageContext.request.contextPath }/viewWH">
			<button>View Warehouse</button>
		</a>
	</div>
	<div class="col-md-3 col-sm-3 col-lg-3 space"></div>
	</div>
</body>
</html>