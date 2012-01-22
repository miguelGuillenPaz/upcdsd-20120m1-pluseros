<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<script type="text/javascript">
ddaccordion.init(css_menu_options);
</script>
<div class="arrowsidemenu" style="margin-top: 5px;">
	<div class="menuheaders">
		<a href="#" title="">Reservas</a></div>
		<ul class="menucontents">
			<li><s:a action="disponibilidad.action" >Disponibilidad de Horarios</s:a></li>
			<li><a href="#">Option 01</a></li>
			<li><a href="#">Option 02</a></li>
			<li><a href="#">Option 03</a></li>
			<li><a href="#">Option 04</a></li>
			<li><a href="#">Option 05</a></li>
			<li><a href="#">Option 06</a></li>
			<li><a href="#">Option 07</a></li>
		</ul>
	<div class="menuheaders"><a href="#" title="JavaScript">Mantenimientos</a></div>
		<ul class="menucontents">
		<li><s:a action="mantenerCliente.action" >Clientes</s:a></li>
		<li><s:a action="mantenerEmpleado.action" >Empleados</s:a></li>
		<li><s:a action="mantenerServicio.action" >Servicios</s:a></li>
		</ul>
	<div><a href="#" title="Tools">Option Group 02</a></div>
</div>