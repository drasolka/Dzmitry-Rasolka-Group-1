<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<body>
	<h1>Mentoring (08-spring)</h1>

	<c:choose>
		<c:when test="${empty sessions}">
			<a href="init">Initialization sample sesions</a>
		</c:when>
		<c:otherwise>
			<h2>Sessions list</h2>
			<table border="1">
				<tr>
					<th>Session id</th>
					<th>Date</th>
					<th>Price</th>
					<th>Action</th>
				</tr>
				<c:forEach var="session" items="${sessions}">
					<tr>
						<td>${session.id}</td>
						<td><fmt:formatDate type="both" dateStyle="short"
								timeStyle="short" value="${session.date}" /></td>
						<td>${session.price}</td>
						<td><a href="reserve/${session.id}">Get reservation</a></td>
					</tr>
				</c:forEach>
			</table>



			<div id="reserve">
				<jsp:include page="reservationList.jsp" />
			</div>

			<div>
				<a href="addPerson">Add new customer</a>
				<c:if test="${not empty persons}">
					<h2>Customers</h2>
					<table border="1">
						<tr>
							<th>Id</th>
							<th>Name</th>
						</tr>
						<c:forEach var="person" items="${persons}">
							<tr>
								<td>${person.id}</td>
								<td>${person.firstName}&nbsp;${person.lastName}</td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</div>
		</c:otherwise>
	</c:choose>

	<script type="text/javascript">
	
	$(document).on( "click",'.removeReservation', function() {
			var id = $(this).attr('id');
			$.ajax({
				url: "remove",
				cache: false,
				type: 'POST',
				data: {id: id},
				success: function (response)
				{
					$('#reserve').html(response);
				}
			});
			
		});
	
	</script>
</body>
</html>
