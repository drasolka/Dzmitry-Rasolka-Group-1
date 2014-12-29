<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<body>
	<h1>Mentoring (08-spring)</h1>

	<form:form commandName="reserveForm"
		action="addReservation/${sessionId}" method="post">

		<fieldset>
			<label for="place">Place:</label>
			<form:input path="place" />

			<label for="customerId">Customer id:</label>
			<form:input path="customerId" />

			<input type="submit" name="reserve" value="Reseve" />
		</fieldset>
	</form:form>

	<c:if test="${not empty customers}">
		<h2>Customers</h2>
		<table border="1">
			<tr>
				<th>Id</th>
				<th>Name</th>
			</tr>
			<c:forEach var="customer" items="${customers}">
				<tr>
					<td>${customer.id}</td>
					<td>${customer.firstName}&nbsp;${customer.lastName}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>
