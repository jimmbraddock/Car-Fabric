<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:common-layout>
	<jsp:body>
        <div id="car"></div>
        <div id="params">
        
	      <select name="Кузова" id="free_carcases">
	      </select>
	      <select name="Двигатели" id="free_engines">
	      </select>
	      <select name="КПП" id="free_transmissions">
	      </select>
          <button id="btnSave">Сохранить</button>
        
        </div>
        
       	<script type="text/javascript">
			var car = CarResource
					.lookupCarById({id: parseInt(GetURLParameter("car"))});
			$('#car').text(car.name);
			
			var carcases = CarcaseResources.getFreeCarcases();
			carcases.push(car.carcase);
			fillBricks('free_carcases', carcases);

			var transmissions = TransmissionResource.getFreeTransmissions();
			transmissions.push(car.transmission);
			fillBricks('free_transmissions', transmissions);

			var engines = EngineResource.getFreeEngines();
			engines.push(car.engine);
			fillBricks('free_engines', engines);


			function fillBricks(selectName, entities) {
				var entitySN = "";
				if (selectName == 'free_carcases') {
					entitySN = car.carcase.serialNumber;
				} else if (selectName == 'free_transmissions') {
					entitySN = car.transmission.serialNumber;
				} else if (selectName == 'free_engines') {
					entitySN = car.engine.serialNumber;
				}
				for (var i = 0; i < entities.length; i++) {
					if (entitySN == entities[i].serialNumber) {
						$('#' + selectName).append(
										'<option selected value="'+entities[i].id+'">'
												+ entities[i].serialNumber
												+ '</option>');
					} else {
						$('#' + selectName).append(
										'<option value="'+entities[i].id+'">'
												+ entities[i].serialNumber
												+ '</option>');
					}
				}
			}

			function GetURLParameter(sParam) {
				var sPageURL = window.location.search.substring(1);
				var sURLVariables = sPageURL.split('&');
				for (var i = 0; i < sURLVariables.length; i++) {
					var sParameterName = sURLVariables[i].split('=');
					if (sParameterName[0] == sParam) {
						return sParameterName[1];
					}
				}
			}


			$('#btnSave').click(function() {
				car.carcase = CarcaseResources.getCarcase({id: parseInt($("#free_carcases option:selected" ).val())});
				car.engine = EngineResource.getEngine({id: parseInt($("#free_engines option:selected" ).val())});
				car.transmission = TransmissionResource.getTransmission({id: parseInt($("#free_transmissions option:selected" ).val())});
				CarResource.updateCar({$entity: car, id: car.id});				
				return false;
			});
		</script>
    </jsp:body>
</t:common-layout>
