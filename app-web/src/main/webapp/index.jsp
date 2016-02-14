<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:common-layout>
    <jsp:body>
	<input type="submit" id="qwe" value="Gets Cars" />
	<br />
	<br />

	<ul id="cars" style="display: table-row;"></ul>

	<script type="text/javascript">
		findAll()
		function findAll() {
			console.log('findAll');

			$.ajax({
				type : 'GET',
				url : '${pageContext.request.contextPath}/park/cars',
				dataType : "json", // data type of response
				success : function(data) {
					for (var i = 0; i < data.length; i++) {
						$('#cars').append('<li><a href="${pageContext.request.contextPath}/views/car.jsp?car='+data[i].id+'">'+data[i].name+'</a></li>');
					}
					console.log("Ura");
				}
			});
		}
	</script>
    </jsp:body>
</t:common-layout>