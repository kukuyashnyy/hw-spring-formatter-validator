<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <style>
        label {
            display: inline-block;
            width: 100px;
        }
        .error {
            color: red;
        }
    </style>
</head>
<body>
<form:form modelAttribute="user" method="post">
    <div>
        <form:label path="login"><fmt:message key="Login"/> </form:label>
        <form:input path="login" required="required"/>
        <form:errors path="login" cssClass="error"/>
    </div>
    <div>
        <form:label path="password">Password</form:label>
        <form:input path="password"/>
        <form:errors path="password" cssClass="error"/>
    </div>
    <div>
        <form:label path="confirmPassword">Confirm password</form:label>
        <form:input path="confirmPassword"/>
        <form:errors path="confirmPassword" cssClass="error"/>
    </div>
    <input type="submit"/>
</form:form>

</body>
</html>
