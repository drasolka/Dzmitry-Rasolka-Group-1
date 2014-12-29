<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<body>
	<h1>Mentoring (08-spring)</h1>

	<form:form commandName="personForm"
		action="addPerson" method="post">

		<fieldset>
			<label for="firstName">First name:</label>
			<form:input path="firstName" />

			<label for="lastName">Last name:</label>
			<form:input path="lastName" />

			<input type="submit" name="create" value="Create" />
		</fieldset>
	</form:form>

</body>
</html>
