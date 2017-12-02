<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: adamchudeusz
  Date: 02.12.17
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>welcome</title>
</head>
<body>
    111name ${name}!
    222salary ${salary}!
    <c:set var="bonus" scope="request" value="${salary*1.2}"/>
    333bonus ${bonus}
</body>
</html>
