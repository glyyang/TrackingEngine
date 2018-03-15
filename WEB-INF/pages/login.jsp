<%@include file="header.jsp"%>
<title>Login</title>
</head>
<body>
	<div class="row">
	<div class="col-md-12 col-sm-12 col-lg-12 space"></div>
	<div class="row">
	<div class="col-md-12 col-sm-12 col-lg-12 space"></div>
	<div class="row">
	<div class="col-md-3 col-sm-3 col-lg-3 space"></div>
	<div class="row">
	<div class="col-md-6 col-sm-6 col-lg-6 space">${sessionScope.myErr }</div>
	<div class="row">
	<div class="col-md-3 col-sm-3 col-lg-3 space"></div>
	<div class="row">
		<div class="col-md-3 col-sm-3 col-lg-3"></div>
		<div class="jumbotron col-md-6 col-sm-6 col-lg-6">
		<form:form action="${pageContext.request.contextPath }/trylogin" method="post" commandName="employee">
			<div class="row"><div class="col-md-6 col-sm-6 col-lg-6" align="right">Usename: </div> <div class="col-md-6 col-sm-6 col-lg-6" align="left"><form:input path="username" maxlength="256"/>
				<br><form:errors path="username"></form:errors></div></div>
			<div class="row"><div class="col-md-6 col-sm-6 col-lg-6" align="right">Password: </div><div class="col-md-6 col-sm-6 col-lg-6" align="left"><form:input path="password" maxlength="256"/>
				<br><form:errors path="password"></form:errors></div></div>
			<div class="row" align="center"><input type="submit" name="submit" value="Submit"/></div>
		
		</form:form>
		</div>
		<div class="col-md-3 col-sm-3 col-lg-3"></div>
	</div>
</body>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</html>