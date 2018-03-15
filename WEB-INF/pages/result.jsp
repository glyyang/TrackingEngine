<%@include file="header.jsp"%>
<title>Show Action Report</title>
</head>
<body>
<jsp:include page="navbar.jsp" />
<div class="div1">
	<div class="row">
		<div class="col-md-2 col-sm-2 col-lg-2 space"></div>
		<div class="col-md-6 col-sm-6 col-lg-6 space">
		Record id: ${rec.id }
		</div>
		<div class="col-md-4 col-sm-4 col-lg-4 space"></div>
	</div>
	
	<div class="row">
		<div class="col-md-2 col-sm-2 col-lg-2 space"></div>
		<div class="col-md-6 col-sm-6 col-lg-6 space">
		Date time generated: ${rec.dateOut }
		</div>
		<div class="col-md-4 col-sm-4 col-lg-4 space"></div>
	</div>
	
	<div class="row">
		<div class="col-md-2 col-sm-2 col-lg-2 space"></div>
		<div class="col-md-6 col-sm-6 col-lg-6 space">
		Destination warehouse: ${rec.endWareHouse.name }
		</div>
		<div class="col-md-4 col-sm-4 col-lg-4 space"></div>
	</div>
	
	<div class="row">
		<div class="col-md-2 col-sm-2 col-lg-2 space"></div>
		<div class="col-md-6 col-sm-6 col-lg-6 space">
		Sent by: ${rec.employee.username }
		</div>
		<div class="col-md-4 col-sm-4 col-lg-4 space"></div>
	</div>
	<table id="dTable" class="display" cellspacing="0" width="80%">
	<thead>
	<tr class="row">
		<th class="col-md-3 col-sm-3 col-lg-3 space">
		Record id
		</th>
		<th class="col-md-3 col-sm-3 col-lg-3 space">
		Item name
		</th>
		<th class="col-md-3 col-sm-3 col-lg-3 space">
		Item price
		</th>
		
		<th class="col-md-3 col-sm-3 col-lg-3 space">
		Item quantity
		</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${rec.sub_record }" var="srec">
		<tr class="row">
			<td class="col-md-3 col-sm-3 col-lg-3 space">
			${srec.id }
			</td>
			<td class="col-md-3 col-sm-3 col-lg-3 space">
			${srec.asset.name }
			</td>
			<td class="col-md-3 col-sm-3 col-lg-3 space">
			${srec.asset.price } dollars
			</td>
			
			<td class="col-md-3 col-sm-3 col-lg-3 space">
			${srec.quantity }
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
	<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js"></script>
	<script>
		$(document).ready(function() {
		    $('#dTable').DataTable();
		} );
	</script>
</body>
</html>