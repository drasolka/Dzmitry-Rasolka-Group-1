<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<a href="/bank/account">Go to Account page</a>

<form action="addPerson.do">
    <label for="name">Person Name:</label>
    <input name="name" type="text"/>
    <input type="submit" value="Add Person"/>
</form>

<c:if test="${persons ne null}">
	<c:forEach items="${persons}" var="person">
		${person.name} <br>
	</c:forEach>
</c:if>
