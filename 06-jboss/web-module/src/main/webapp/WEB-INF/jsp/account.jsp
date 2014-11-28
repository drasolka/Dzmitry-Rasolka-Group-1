<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<a href="/bank/person">Go to Person page</a>

<form action="addAccount.do">
    <label for="name">Person Name:</label>
    <input name="name" type="text"/>
  	<br>
  	 <label for="amount">Amount:</label>
    <input name="amount" type="text"/>
  
    <input type="submit" value="Create Account"/>
</form>

<c:if test="${accounts ne null}">
	<c:forEach items="${accounts}" var="account">
		${account.owner.name} - ${account.amount}<br> 
	</c:forEach>
</c:if>
