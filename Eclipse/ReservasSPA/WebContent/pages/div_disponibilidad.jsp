<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<table style="padding: 3px;" width="100%" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td>
			<div class="div_group_top"></div>
			<div class="div_group_content">
				<span class="titulo_group">Disponibilidad de horarios</span><br><br>
				<table id="tb_disponibilidad" width="100%" border="0" cellspacing="1" align="center" style="border:1px;border-color:#CCCCCC;">
					<thead>
						<tr align="center" class="tb_titulo">
							<td height="25">Hora</td>
							<td>Lunes</td>
							<td>Martes</td>
							<td>Miercoles</td>
							<td>Jueves</td>
							<td>Viernes</td>
							<td>Sabado</td>
						</tr>
					</thead>
					<s:iterator begin="9" end="18" step="1" var="num">
						<s:iterator begin="0" end="30" step="30" var="num_2">
						<tr align="center">
							<td height="25" align="center"> <s:property value="#num" />:
								<s:if test="#num_2 == 0">00</s:if><s:else><s:property value="#num_2" /></s:else>
							</td>
							<td><s:a onclick="reservarHorario()" href="#">Reservar</s:a></td><td><s:a href="#">Reservar</s:a></td><td><s:a href="#">Reservar</s:a></td>
							<td><s:a href="#">Reservar</s:a></td><td><s:a href="#">Reservar</s:a></td><td><s:a href="#">Reservar</s:a></td>
						</tr>
						</s:iterator>
					</s:iterator>
				</table>
			</div>
			<div class="div_group_bottom"></div>
		</td>
	</tr> 
</table>