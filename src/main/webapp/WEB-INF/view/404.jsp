<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>

<!-- error 404 -->

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>404</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
	<div class="intro">
		<h1>Oops!</h1>
		<br/>
		<h2>404 - L'identifiant <%= pageContext.findAttribute("id") %>  n'existe pas</h2>
	</div>		
</body>
</html>

