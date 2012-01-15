<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<table style="padding: 3px;" width="100%" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td>
			<s:set name="lst_empleados" value="lstEmpleadoDTO"/>
			
			<div class="div_group_top"></div>
			<div class="div_group_content">
				<span class="titulo_group">Selecci&oacute;n de Profesional</span><br>
				<s:set var="index" value="1"></s:set>
				<s:hidden name="id_servicio" id="id_servicio"></s:hidden>
				<table class="tb_list" border="0" cellpadding="0" cellspacing="0" width="100%" style="margin-top: 10px;">
					<s:iterator value="#lst_empleados" var="emp" >
						<s:if test="#index == 1">
							<tr align="center">
						</s:if>
							<td>
								<sx:a href="seleccionaEmpleado.action?id_empleado=%{id_empleado}" targets="div_process">
									<img alt="" src="<%= request.getContextPath() %>/images/estructura/img_servicio.gif">
									<br><s:property value="nombre"/>
								</sx:a>
							</td>
						<s:if test="#index % 4 == 0">
							</tr>
							<tr align="center">
						</s:if>
						<s:set var="index" value="#index+1"></s:set>
					</s:iterator>
				</table>
			</div>
			<div class="div_group_bottom"></div>
		</td>
	</tr> 
</table>
