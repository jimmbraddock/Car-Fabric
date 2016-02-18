<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:common-layout>
	<jsp:body>
        <div id="car"></div>
        <div id="carcase">
        <form action="servleturl" method="post">
	      <select name="Кузова" id="free_carcases">
	      </select>
          <input type="submit">
        </form>
        
        </div>
        <div id="engine"></div>
        <div id="transmission"></div>
       	<script type="text/javascript">
 	                      var k = new Array();
                        k['id'] = parseInt(GetURLParameter("car"));
			var car = CarResource
					.lookupCarById({id: k["id"]});
			$('#car').text(car.name);
			$('#engine').text(car.engine);
			$('#transmission').text(car.transmission);
			var carcases = CarcaseResources
					.getFreeCarcases();
			for (var i = 0; i < carcases.length; i++) {
				if (car.carcase == carcases[i].id) {
					$('#free_carcases')
							.append(
									'<option selected value="'+carcases[i].serialNumber+'">'
											+ carcases[i].serialNumber
											+ '</option>');
				} else {
					$('#free_carcases')
							.append(
									'<option value="'+carcases[i].serialNumber+'">'
											+ carcases[i].serialNumber
											+ '</option>');
				}
			}

			function GetURLParameter(sParam) {
				var sPageURL = window.location.search
						.substring(1);
				var sURLVariables = sPageURL.split('&');
				for (var i = 0; i < sURLVariables.length; i++) {
					var sParameterName = sURLVariables[i]
							.split('=');
					if (sParameterName[0] == sParam) {
						return sParameterName[1];
					}
				}
			}
		</script>
    </jsp:body>
</t:common-layout>
