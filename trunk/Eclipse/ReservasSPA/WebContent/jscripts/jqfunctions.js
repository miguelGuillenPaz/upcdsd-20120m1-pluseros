$(document).ready(function(){
	$('a[rel*=facebox]').facebox();
	$("#usuario").focus();
	$('#datepicker').datepicker({
		inline: true,
		minDate: new Date()
	});
	$( "#dialog:ui-dialog" ).dialog( "destroy" );
});

function mostrarMensaje(str,link){
	if(str != ""){
		alert(str);
		document.location.href = link;
	}
}

function popSuscripcion(){
	
	$.get('./pages/manto_cliente.jsp?s=1', function(data){
		$(data).dialog({
			//autoOpen: false,
			minWidth: 800,
			height: 300//,
			//modal: true
		});
	});
	
}

function anularReserva(){
	if(confirm("¿Esta seguro anular la reserva?")){
		$("#frm_anularReserva").attr("action","registrarAnulacionReserva");
		$("#frm_anularReserva").submit();
	}
}

var css_menu_options = {headerclass: "menuheaders", 
                    	contentclass: "menucontents", 
                    	revealtype: "clickgo",
                    	mouseoverdelay: 200,
                    	collapseprev: true,  
                    	defaultexpanded: [0],
                    	onemustopen: false, 
                    	animatedefault: false,
                    	persiststate: true, 
                    	toggleclass: ["unselected", "selected"],
                    	togglehtml: ["none", "", ""], 
                    	animatespeed: 500, 
                    	oninit:function(expandedindices){ },
                    	onopenclose:function(header, index, state, isuseractivated){ }};

function trim(string) 
{
return string.replace(/^\s\s*/, '').replace(/\s\s*$/, '');
}

function reservarHorario(){
	$( "#dialog-confirm" ).dialog({
		resizable: false,
		height:140,
		modal: true,
		buttons: {
			"Delete all items": function() {
				$( this ).dialog( "close" );
			},
			Cancel: function() {
				$( this ).dialog( "close" );
			}
		}
	});
}

