<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:common-layout>
    <jsp:body>
        <div id="car"></div>
        <div id="carcase"></div>
        <div id="engine"></div>
        <div id="transmission"></div>
    
    
       	<script type="text/javascript">
		getCar();
		function getCar() {
			$.ajax({
				type : 'GET',
				url : '${pageContext.request.contextPath}/park/cars/' + GetURLParameter('car'),
				dataType : "json", // data type of response
				success : function(data) {
						$('#car').text(data.name);
						$('#carcase').text(data.carcase);
						$('#engine').text(data.engine);
						$('#transmission').text(data.transmission);
				}
			});
		}

		function GetURLParameter(sParam)
		
			{
		
			    var sPageURL = window.location.search.substring(1);
		
			    var sURLVariables = sPageURL.split('&');
		
			    for (var i = 0; i < sURLVariables.length; i++)
		
			    {
		
			        var sParameterName = sURLVariables[i].split('=');
		
			        if (sParameterName[0] == sParam)
		
			        {
		
			            return sParameterName[1];
		
			        }
		
			    }
		
			}
	</script>
    
    </jsp:body>
</t:common-layout>
