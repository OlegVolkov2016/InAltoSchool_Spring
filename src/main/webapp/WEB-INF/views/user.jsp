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

<a href="<c:url value="/logout" />">
	<spring:message code="label.logout" />
</a>
   
<h2><spring:message code="label.title" /></h2>
<h4><c:out value="${message}" /></h4>
<form:form method="post" action="add" commandName="loginuser">

	<table>
	<tr>
		<td><form:label path="role_name">
				<spring:message code="label.rolename" />
			</form:label></td>
			<td><form:select path="role_name">
				<c:set var="select"><spring:message code="label.roleselect"/></c:set>
				<form:option value="NONE" label="${select}"/>
				<c:forEach items="${roleList}" var="role">
					<form:option value="${role.role_name}" label="${role.role_name}"/>
				</c:forEach>
			</form:select></td>
		</tr>
		<tr>
			<td><form:label path="login_name">
				<spring:message code="label.loginname" />
			</form:label></td>
			<td><form:input path="login_name" /></td>
		</tr>
		<tr>
			<td><form:label path="login_password">
				<spring:message code="label.loginpassword" />
			</form:label></td>
			<td><form:input type="password" path="login_password" /></td>
		</tr>
				<tr>
			<td><form:label path="login_password_repeat">
				<spring:message code="label.loginpasswordrepeat" />
			</form:label></td>
			<td><form:input type="password" path="login_password_repeat" /></td>
		</tr>
		<tr>
			<td><form:label path="login_question">
				<spring:message code="label.loginquestion" />
			</form:label></td>
			<td><form:input path="login_question" /></td>
		</tr>
		<tr>
			<td><form:label path="login_answer">
				<spring:message code="label.loginanswer" />
			</form:label></td>
			<td><form:input type="password" path="login_answer" /></td>
		</tr>
		<tr>
			<td><form:label path="user_firstname">
				<spring:message code="label.firstname" />
			</form:label></td>
			<td><form:input path="user_firstname" /></td>
		</tr>
		<tr>
			<td><form:label path="user_lastname">
				<spring:message code="label.lastname" />
			</form:label></td>
			<td><form:input path="user_lastname" /></td>
		</tr>
		<tr>
			<td><form:label path="user_birthday">
				<spring:message code="label.birthday" />
			</form:label></td>
			<td><form:input path="user_birthday" /></td>
		</tr>
		<tr>
			<td><form:label path="user_address">
				<spring:message code="label.address" />
			</form:label></td>
			<td><form:input path="user_address" /></td>
		</tr>
		<tr>
			<td><form:label path="user_phone">
				<spring:message code="label.phone" />
			</form:label></td>
			<td><form:input path="user_phone" /></td>
		</tr>
		<tr>
			<td><form:label path="user_email">
				<spring:message code="label.email" />
			</form:label></td>
			<td><form:input path="user_email" /></td>
		</tr>
		<tr>
			<td><form:label path="user_skype">
				<spring:message code="label.skype" />
			</form:label></td>
			<td><form:input path="user_skype" /></td>
		</tr>
		<tr>
			<td><form:label path="user_details">
				<spring:message code="label.details" />
			</form:label></td>
			<td><form:input path="user_details" /></td>
		</tr>
		<tr>
			<c:if test="${loginuser.login_name == null}">
				<td colspan="2"><input type="submit"
					value="<spring:message code="label.add"/>" /></td>
			</c:if>
			<c:if test="${loginuser.login_name != null}">
				<td colspan="2"><input type="submit"
					value="<spring:message code="label.save"/>" /></td>
			</c:if>
		</tr>
	</table>
</form:form>
</body>
</html>