function buttonPayClick() {
	pan = $('#form-PAN').val();
	securityCode = $('#form-securityCode').val();
	expirationDate=$('#form-expirationDate').val();
	cardHolderName=$('#form-cardHolderName').val();
	
	if(!pan || !securityCode || !expirationDate || !cardHolderName) {
		toastr["error"]('Fill in all required entry fields!');
		return;
	}
	var url = window.location.href;
	var paymentId = url.split('=')[1];
	
	var data = JSON.stringify({
		"pan": pan,
		"securityCode": securityCode,
		"expirationDate": expirationDate,
		"cardHolderName": cardHolderName,
		"paymentId":paymentId
	});
	$.ajax({
		async: false,
		url: "http://localhost:1234/casopis/kupiCasopis",
        type: "POST",
        contentType: "application/json",
        data: data,
        success: function (data) {
        	window.location.href = data.url;
        },
        error: function (jqXHR, textStatus, errorThrown) {
            toastr["error"](jqXHR.responseText);
        }
    });
}

