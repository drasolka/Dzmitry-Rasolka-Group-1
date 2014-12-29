<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
</head>
<body>
	<c:if test="${not empty reservations}">
		<h2>Reservations list</h2>
		<table border="1">
			<tr>
				<th>Id</th>
				<th>Film</th>
				<th>Date</th>
				<th>Price</th>
				<th>Place</th>
				<th>Customer</th>
				<th>Action</th>
			</tr>
			<c:forEach var="reservation" items="${reservations}">
				<tr>
					<td>${reservation.id}</td>
					<td>${reservation.filmName}</td>
					<td><fmt:formatDate type="both" dateStyle="short"
							timeStyle="short" value="${reservation.date}" /></td>
					<td>${reservation.price}</td>
					<td>${reservation.place}</td>
					<td>${reservation.customer.firstName}&nbsp;
						${reservation.customer.lastName}</td>
					<td><a href="#" class="removeReservation"
						id="${reservation.id}">Remove reservation</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>