
function promeniAktivan(idKompanije){
	$("#modalPromenaAktivnog").modal('toggle');
}
function postaviAktivan(idKompanije){

	var noviAktivanCenovnik = new Object();
	noviAktivanCenovnik.idKompanije = idKompanije;
	noviAktivanCenovnik.id = $("#cenovniciSelect").find(':selected').attr('id');
	//ajax
	$.ajax({
		async: false,
		url: "http://localhost:1234/cenovnik/promeniAktivan",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(noviAktivanCenovnik),
        dataType: "json",
        success: function (data) {
        	toastr["success"]("Uspesno promenjen aktivan cenovnik.");
        	$("#modalPromenaAktivnog").modal('toggle');
        	$("#tableCenovnici").find("tr:gt(0)").remove();
        	$("#cenovniciSelect").empty();
        	document.getElementById("cenovniciSelect").value = "";
        	var paragrafAktivanCenovnik = $("#aktivanCenovnikP");
        	paragrafAktivanCenovnik.innerHTML = "";
        	
        	var tableCenovnici = $("#tableCenovnici");
        	var selectAktivanCenovnik = $("#cenovniciSelect");
        	for(i=0;i<data.length;i++){
        		var brojStavki = data[i].stavkaCenovnikaDTO.length;
        		var aktivan;
        		var paragrafAktivanCenovnik = $("#aktivanCenovnikP");
        		if(data[i].aktivan){
        			paragrafAktivanCenovnik.innerHTML = "Trenutno aktivan cenovnik je cenovnik sa id-em: " + data[i].id + ".";
        			aktivan = "Da";
        		}else{
        			selectAktivanCenovnik.append('<option id=\"'+data[i].id+'\" value=\"'+data[i].id+'\">'+data[i].id+'</option>');
	        		
        			aktivan = "Ne";
        		}
        		var rbr = i+1;
        		tableCenovnici.append('<tr><td>'+rbr+'</td><td>'+data[i].datumPocetkaVazenja+'</td><td>'+brojStavki+'</td><td>'+aktivan+'</td><td><button style=\"margin-left:15%\" class=\"btn btn-default\" onclick=\"prikaziCenovnikAdminu('+data[i].id+')\">Prikazi cenovnik</button></td></tr>');
        		
        	}
        	
        },
        error: function (jqxhr, textStatus, errorThrown) {
        	top.location.href = "index.html";
            
        }
	});
	
}

function logout() {
    $.ajax({
    	url: "http://localhost:1234/radnik/logout",
        type: "POST",
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        success: function () {
                top.location.href = "index.html";

        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}