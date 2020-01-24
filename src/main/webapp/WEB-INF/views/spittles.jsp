<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="spittleForm">
        <h1>Spit it out...</h1>
        <form method="POST" name="spittleForm">
            <textarea name="message" cols="80" rows="5"></textarea><br/>
            <input type="submit" value="Add" />
        </form>
    </div>
    <div class="listTitle">
        <h1>Recent Spittles</h1>
        <ul class="spittleList">
            <c:forEach items="${spittleList}" var="spittle" >
                <li id="spittle_<c:out value="spittle.id"/>">
                    <div class="spittleMessage">
                        <c:out value="${spittle.message}" />
                    </div>
                    <div>
                        <span class="spittleTime"><c:out value="${spittle.time}" /></span>
                        <span class="spittleLocation">
                            (<c:out value="${spittle.latitude}" />,
                            <c:out value="${spittle.longitude}" />)</span>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</body>
</html>









