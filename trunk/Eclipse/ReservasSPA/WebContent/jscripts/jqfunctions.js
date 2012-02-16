$(document).ready(function(){
	$('a[rel*=facebox]').facebox();
	$("#usuario").focus();
	$('#datepicker').datepicker({
		inline: true,
		minDate: new Date()
	});
	$( "#dialog:ui-dialog" ).dialog( "destroy" );
});

function trim(string) {
	return string.replace(/^\s\s*/, '').replace(/\s\s*$/, '');
}

function validar_requerido(field) {
	with (field) {
		if (trim(value) == null || trim(value) == "" || trim(value) == 0) {						
			alert('Datos Incompletos, favor de verificar.');
			if( !(field.type == 'hidden')){
				field.focus();
			}
			return false;
		} else {
			return true;
		}
	}
}

function validar_mail(field){
	if (field != undefined && field.value != "" ){
		re=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;					
		if(!re.exec(field.value)){
			alert('Debe ingresar una Dirección de Correo Electrónico válida para continuar.');
			field.focus();
			return false;
		}else{return true;}		
	}else {return false;}
}

function validarSoloNumeros(e) {
	opc = false;
	tecla = (document.all) ? event.keyCode : e.which;
	if (tecla == 8) {opc = true;} // tecla backspace
	if (tecla >= 48 && tecla <= 57) {opc = true;} // sólo numeros
	return opc;

}

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

function suscribirCliente(){
	if(validar_requerido(document.getElementById("objClienteDTO.nombres")) &&
	   validar_requerido(document.getElementById("objClienteDTO.apellidoPaterno")) &&
	   validar_requerido(document.getElementById("objClienteDTO.apellidoMaterno")) &&
	   validar_requerido(document.getElementById("objClienteDTO.direccion")) &&
	   validar_requerido(document.getElementById("objClienteDTO.nroDocumentoIdentidad")) &&
	   validar_requerido(document.getElementById("objClienteDTO.telefono")) &&
	   validar_requerido(document.getElementById("objClienteDTO.email")) &&
	   validar_mail(document.getElementById("objClienteDTO.email")) &&
	   validar_requerido(document.getElementById("objClienteDTO.usuario")) &&
	   validar_requerido(document.getElementById("objClienteDTO.clave")) ){
		if(confirm("¿Esta seguro registrarse?")){
			$("#frm_cliente").attr("action","suscribirCliente");
			$("#frm_cliente").submit();
		}
	}
}

function registrarEmpleado(){
	if(validar_requerido(document.getElementById("objEmpleadoDTO.nombres")) &&
	   validar_requerido(document.getElementById("objEmpleadoDTO.apellidoPaterno")) &&
	   validar_requerido(document.getElementById("objEmpleadoDTO.apellidoMaterno")) &&
	   validar_requerido(document.getElementById("objEmpleadoDTO.direccion")) &&
	   validar_requerido(document.getElementById("objEmpleadoDTO.nroDocumentoIdentidad")) &&
	   validar_requerido(document.getElementById("objEmpleadoDTO.email")) &&
	   validar_mail(document.getElementById("objEmpleadoDTO.email")) &&
	   validar_requerido(document.getElementById("objEmpleadoDTO.usuario")) &&
	   validar_requerido(document.getElementById("objEmpleadoDTO.clave")) ){
		if(confirm("¿Esta seguro registrar el empleado?")){
			$("#frm_empleado").attr("action","registrarEmpleado");
			$("#frm_empleado").submit();
		}
	}
}

function registrarCliente(){
	if(validar_requerido(document.getElementById("objClienteDTO.nombres")) &&
	   validar_requerido(document.getElementById("objClienteDTO.apellidoPaterno")) &&
	   validar_requerido(document.getElementById("objClienteDTO.apellidoMaterno")) &&
	   validar_requerido(document.getElementById("objClienteDTO.direccion")) &&
	   validar_requerido(document.getElementById("objClienteDTO.nroDocumentoIdentidad")) &&
	   validar_requerido(document.getElementById("objClienteDTO.telefono")) &&
	   validar_requerido(document.getElementById("objClienteDTO.email")) &&
	   validar_mail(document.getElementById("objClienteDTO.email")) &&
	   validar_requerido(document.getElementById("objClienteDTO.usuario")) &&
	   validar_requerido(document.getElementById("objClienteDTO.clave")) ){
		if(confirm("¿Esta seguro registrar el cliente?")){
			$("#frm_cliente").attr("action","registrarCliente");
			$("#frm_cliente").submit();
		}
	}
}

function registrarServicio(){
	if(validar_requerido(document.getElementById("objServicioDTO.descripcion")) &&
	   validar_requerido(document.getElementById("objServicioDTO.duracion"))){
			if(confirm("¿Esta seguro registrar el servicio?")){
				$("#frm_servicio").attr("action","registrarServicio");
				$("#frm_servicio").submit();
			}
		}
}

function copiaNombreArchivo(input){
	var ruta = input.value;
	var nombreArchivo = ruta.substring(ruta.lastIndexOf("\\")+1);
		
	$("#rutaImagen").attr("value",nombreArchivo);
	
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
var selec = ["Seleccione"];
function seleccionarDepartamento(dpto) {
	ImplReservaService.listarProvincias(dpto.value,function(data){
		dwr.util.removeAllOptions("idProvincia");
		dwr.util.removeAllOptions("objClienteDTO.distrito.id");
		dwr.util.addOptions("objClienteDTO.distrito.id",selec);
		dwr.util.addOptions("idProvincia",selec);
		dwr.util.addOptions("idProvincia",data,"id","nombre");
	});
}

function seleccionarProvincia(prov) {
	ImplReservaService.listarDistritos(prov.value,function(data){
		dwr.util.removeAllOptions("objClienteDTO.distrito.id");
		dwr.util.removeAllOptions("objEmpleadDTO.distrito");
		
		dwr.util.addOptions("objClienteDTO.distrito.id",selec);
		dwr.util.addOptions("objClienteDTO.distrito.id",data,"id","nombre");
		
		dwr.util.addOptions("objEmpleadoDTO.distrito",selec);
		dwr.util.addOptions("objEmpleadoDTO.distrito",data,"id","nombre");
	});
}

function buscaHorarios(){
	var picker = document.getElementsByName("picker")[0].value; 
	var id_servicio = $("#id_servicio").attr("value");
	alert(picker);
	alert(id_servicio);
	alert($("valor_picker").attr("value"));
	document.location.href="buscarPorDia.action?picker=16/02/2012&id_servicio=1";
}

function seleccionaPicker(pic){
	alert(pic);
	alert(pic.value);
	$("valor_picker").attr("value",pic.value);
}

function reservar(idS,idE,HI,HF){
	document.location.href="registrarReserva.action?id_servicio="+idS+"&id_empleado="+
							$("#lst_"+idE).attr("value")+"&horaIni="+HI+"&horaFin="+HF;
}

