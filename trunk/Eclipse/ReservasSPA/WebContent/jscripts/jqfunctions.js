$(document).ready(function(){
	$('#datepicker').datepicker({
		inline: true,
		minDate: new Date()
	});
	$( "#dialog:ui-dialog" ).dialog( "destroy" );
});

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

