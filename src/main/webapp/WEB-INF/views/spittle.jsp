<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="spittleView">
        <div class="SpittleMessage>"><c:out value="${spittle.message} " /></div>
    </div>
    <div>
        <span class="spittleTime"><c:out value="${spittle.time}" /></span>
<%--        <span class="spittleLocation">--%>
<%--            (<c:out value="${spittle.latitude}" />,--%>
<%--            <c:out value="${spittle.longitude}" />)</span>--%>
    </div>

</body>
</html>
