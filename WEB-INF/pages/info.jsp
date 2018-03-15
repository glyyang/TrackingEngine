<%@include file="header.jsp"%>
<title>Asset Warehouse Information</title>
</head>
<body>
<jsp:include page="${pgName }.jsp" />
<div class="div1">
	<div class="row">
	<div class="col-md-2 col-sm-2 col-lg-2 space"></div>
	<div class="col-md-6 col-sm-6 col-lg-6 space">
	User: ${sessionScope.employee.username }
	</div>
	<div class="col-md-4 col-sm-4 col-lg-4 space"></div>
	</div>
	<table id="dTable" class="display" cellspacing="0" width="80%">
		<thead>
			<tr class="row">
				<th class="col-md-4 col-sm-4 col-lg-4 space">
				Item Name
				</th>
				<th class="col-md-4 col-sm-4 col-lg-4 space">
				Item Quantity
				</th>
				<th class="col-md-4 col-sm-4 col-lg-4 space">
				Warehouse in
				</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${awList }" var="aw">
				<tr class="row">
					<td class="col-md-4 col-sm-4 col-lg-4 space">
					${aw.asset.name }
					</td>
					<td class="col-md-4 col-sm-4 col-lg-4 space">
					${aw.asset_quantity }
					</td>
					<td class="col-md-4 col-sm-4 col-lg-4 space">
					${aw.warehouse.name }
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
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
</div>
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js"></script>
<script>
	$(document).ready(function(){
	    $('#dTable').DataTable();
	});
</script>
</body>
</html>