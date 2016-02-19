<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf8">
	<title><spring:message code="label.title" /></title>
</head>
<body>
<h3><spring:message code="label.users" /></h3>
<h4><c:out value="${message}"/></h4>
<c:if test="${!empty userList}">
	<table class="data">
		<tr>
			<th><spring:message code="label.rolename" /></th>
			<th><spring:message code="label.loginname" /></th>
			<th><spring:message code="label.firstname" />, <spring:message code="label.lastname" /></th>
			<th><spring:message code="label.birthday" /></th>
			<th><spring:message code="label.phone" /></th>
			<th><spring:message code="label.email" /></th>
			<th>&nbsp;</th>
			<th>&nbsp;</th>
		</tr>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td>${roleService.getRole(loginService.getLogin(user.login_id).getRole_id()).getRole_name()}</td>
				<td>${loginService.getLogin(user.login_id).getLogin_name()}</td>
				<td>${user.user_firstname} ${user.user_lastname}</td>
				<td>${user.user_birthday}</td>
				<td>${user.user_phone}</td>
				<td>${user.user_email}</td>
				<td><a href="edit/${user.user_id}"><spring:message code="label.edit" /></a></td>
				<td><a href="delete/${user.user_id}"><spring:message code="label.delete" /></a></td>
			</tr>
		</c:forEach>
		
	</table>
</c:if>
<a href="new"><spring:message code="label.add" /></a>

<h4><spring:message code="label.login" />: <c:out value="${loginName}" /></h4>

<a href="<c:url value="/login.jsp" />"><spring:message code="label.login" /></a>
<c:out value=" / " />          
<a href="<c:url value="/logout" />"><spring:message code="label.logout" /></a>

</body>
</html>
