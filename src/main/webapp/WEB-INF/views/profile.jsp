<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Your Profile</h1>
<c:out value="${spitter.username}"/>
<c:out value="${spitter.firstName}"/>
<c:out value="${spitter.lastName}"/>
</body>
</html>
