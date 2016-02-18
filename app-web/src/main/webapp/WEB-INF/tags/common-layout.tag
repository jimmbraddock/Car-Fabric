<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true"%>
<%@attribute name="footer" fragment="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script lang="javascript" src="./js"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/header.css" />">
</head>
<body>
	<div class="wrapper">
		<div class="foo">
			<ul>
				<li><a href="${pageContext.request.contextPath}/index.jsp">Автопарк</a></li>
				<li><a
					href="${pageContext.request.contextPath}/views/carcases.jsp">Кузова</a></li>
				<li><a
					href="${pageContext.request.contextPath}/views/engines.jsp">Двигатели</a></li>
				<li><a
					href="${pageContext.request.contextPath}/views/transmissions.jsp">КПП</a></li>
			</ul>
		</div>

			<div class="main">
				<jsp:doBody />
			</div>


		<div class="footer">&copy; Copyright 2015</div>
	</div>
</body>
</html>



