<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:common-layout>
    <jsp:body>
	<input type="submit" id="qwe" value="Gets Cars" />
	<br />
	<br />

	<ul id="cars" style="display: table-row;"></ul>

	<script type="text/javascript">
		var cars = CarResource.getCars();
		for (var i = 0; i < cars.length; i++) {
			$('#cars').append('<li><a href="${pageContext.request.contextPath}/views/car.jsp?car='+cars[i].id+'">'+cars[i].name+'</a></li>');
		}
	</script>
    </jsp:body>
</t:common-layout>