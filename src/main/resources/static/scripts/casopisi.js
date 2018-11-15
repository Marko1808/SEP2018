$(document).ready(function () {
	$.ajax({
			async: false,
			url: "http://localhost:1234/casopis/getCasopisi/",
	        type: "GET",
	        dataType: "json",
	        success: function (data) {
	        	var casopisiTable = $('#tableCasopisi');
	        	for(i=0;i<data.length;i++){
	        		var redniBr = i+1;
	        		casopisiTable.append('<tr><td>'+redniBr+'.</td><td>'+data[i].naziv+'</td><td>'+data[i].amount+'</td><td><button style=\"margin-left:15%\" class=\"btn btn-success\" onclick=\"kupi('+data[i].merchant_id+',' + data[i].amount + ',\'' + data[i].merchant_password+ '\')\">Kupi</button></td></tr>');		
	        	}
	        	
	        },
	        error: function (jqxhr, textStatus, errorThrown) {
	        	alert(textStatus);
	            
	        }
		});
});

function kupi(merchant_id,amount, merchant_password) {
	debugger;
	var data = JSON.stringify({
		"merchant_id": merchant_id,
		"amount": amount,
		"merchant_password": merchant_password
	});
	$.ajax({
		async: false,
		url: "http://localhost:1236/zahtev/posaljiZahtev",
        type: "POST",
        contentType: "application/json",
        data: data,
        crossDomain: true,
         headers: {  'Access-Control-Allow-Origin': '*' },
        success: function (data) {
        	
        	
        },
        error: function (jqxhr, textStatus, errorThrown) {
        	alert(textStatus);
            
        }
	});
}
