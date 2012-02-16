<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<s:form id="frm_disponibilidad" action="buscarPorDia" namespace="/">
<table style="padding: 3px;" width="100%" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td>
			<s:set name="lst_reservas" value="lstReservaDTO"/>
			<s:set name="lst_empleados" value="lstPosiblesEmpleados"/>
			
			<div class="div_group_top"></div>
			<div class="div_group_content">
				<span class="titulo_group">Selecci&oacute;n de Profesional</span>
				<div style="float: right;margin-right: 10px;" >
					<sx:datetimepicker id="picker" name="picker" value="<s:property value='picker'/>" startDate="%{'today'}"></sx:datetimepicker>
					
					<sx:submit  targets="div_process" value="Buscar"></sx:submit>
				</div>
												
				<s:set var="index" value="0"></s:set>
				<s:hidden name="id_servicio" id="id_servicio"></s:hidden>
				
				<table id="tb_disponibilidad" width="100%" border="0" cellspacing="1" align="center" style="border:1px;border-color:#CCCCCC;">
					<thead>
						<tr align="center" class="tb_titulo">
							<td width="20%" height="25">Hora Inicio</td>
							<td width="20%">Hora Fin</td>
							<td width="35%">Especialista</td>
							<td width="25%"></td>
						</tr>
					</thead>
					<s:iterator value="#lst_reservas" var="res" >
						<s:set var="lst_E" value="#lst_empleados[#index]" ></s:set>
						<tr>
							<td align="center" ><s:property value="horaInicio"/></td>
							<td align="center"><s:property value="horaFin"/></td>
							<td align="center">
								<s:select id="lst_%{#index}" cssStyle="width:80%" list="#lst_E" listKey="id" listValue="nombres+' '+apellidoPaterno+' '+apellidoMaterno" ></s:select>
							</td>
							<td align="center">
								<s:a href="#" onclick="reservar(%{id_servicio},%{#index},'%{horaInicio}','%{horaFin}')" >Reservar</s:a>
							</td>
						</tr>
						<s:set var="index" value="#index+1"></s:set>
					</s:iterator>
				</table>
			</div>
			<div class="div_group_bottom"></div>
		</td>
	</tr> 
</table>
</s:form>
