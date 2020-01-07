<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet"
        type="text/css"
        href="<s:url value="/resources/style.css" />" >

<title>
    The main page
</title>

</head>
<body>

    <div id="header">
        <t:insertAttribute name="header" />
    </div>

    <div id="footer">
        <t:insertAttribute name="footer" />
    </div>

    <div id="pbody">
        <t:insertAttribute name="body" />
    </div>

</body>
</html>
