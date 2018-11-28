$(document).ready(function () {
	var lokacija = window.location.href;
	var splitovanaLokacija = lokacija.split('?');
	var nameValueParoviZajedno = splitovanaLokacija[1];
	var nameValueParoviRazdvojeno = nameValueParoviZajedno.split('&');
	var paymentId = nameValueParoviRazdvojeno[0].split('=')[1];
	var token = nameValueParoviRazdvojeno[1].split('=')[1];
	var payerId = nameValueParoviRazdvojeno[2].split('=')[1];
	
	var stringZaServer = paymentId + "," + token + "," + payerId;
	$.ajax({
			async: false,
			url: "http://localhost:1236/zahtev/zavrsiPlacanje",
	        type: "POST",
	        contentType: "text/plain",
	        data: stringZaServer,
	        dataType: "json",
	        crossDomain: true,
	        headers: {  'Access-Control-Allow-Origin': '*' },
	        success: function (data) {
	        	window.location.href = "http://localhost:1234/homeAdmin.html";
	        	toastr["success"]("Uspesno placanje PayPal-om!");
	        },
	        error: function (jqxhr, textStatus, errorThrown) {
	        	alert(textStatus);
	            
	        }
		});
});