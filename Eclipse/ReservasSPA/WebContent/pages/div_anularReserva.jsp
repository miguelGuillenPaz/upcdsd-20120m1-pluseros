<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<script>
// strMensajeExito
$(document).ready(function(){
	mostrarMensaje($("#strMensajeE").attr("value"),"anularReserva.action");
});
</script>

<s:div id="div_process_anulacion">
<div id="dv_body">
	<table style="margin: 0px 0px 0px 10px;border-left: 1px solid #CCCCCC;" width="715px" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td>
				<div id="breadcrumb">
					<ul class="crumbs">
						<li class="first"><s:a action="anularReserva" style="z-index:9;"><span></span>Anular Reserva</s:a></li>
					</ul>
				</div>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<s:div id="div_process" cssStyle="float: right;width:96%">
					<table width="100%" border="0" cellpadding="1" cellspacing="0">
						<tr>
							<td>
								<s:form id="frm_anularReserva" action="buscarReservaAnulacion.action">
									<table width="100%" class="tbl_Manto_Registro" style="background-color: #B7B7B7;" cellpadding="1" cellspacing="1" border="0">
										<tr valign="middle">
											<td height="20" width="15%" class="label" > N&ordm; Reserva &nbsp; </td>
											<td width="85%" colspan="3" >&nbsp; 
												<s:textfield cssStyle="width:120px" id="strCodigoReserva" name="strCodigoReserva" />
												<s:a onclick="$('#frm_anularReserva').submit()" href="#">
													<img align="middle" alt="" src="<%= request.getContextPath() %>/images/icons/icon_search.png">
													Buscar
												</s:a> &nbsp; 
												<span class="msg_error"><s:property value="strMensaje"/></span>
												<input type="hidden" value="<s:property value='strMensajeExito'/>" id="strMensajeE">
											</td>										
										</tr>
										<tr>
											<td height="25px" colspan="4" align="center">
												<div style="width: 80%; padding: 10px;margin:10px;">
												
													<table width="100%" class="tbl_Manto_Registro" style="background-color: #B7B7B7;" cellpadding="1" cellspacing="1" border="0">
														<tr>
															<td colspan="4" class="label" align="center"><center>Información de la Reserva</center></td>
														</tr>
														<tr><td colspan="4" height="5px"></td></tr>
														<tr>
															<td width="15%" class="label"> Cliente &nbsp; </td>
															<td width="85%" colspan="3">&nbsp; 
																<s:property value="objReservaDTO.cliente.nombres"/> 
																<s:property value="objReservaDTO.cliente.apellidoPaterno"/>
																<s:property value="objReservaDTO.cliente.apellidoMaterno"/>
															</td>
														</tr>
														<tr>
															<td width="15%" class="label"> Servicio &nbsp; </td>
															<td width="85%" colspan="3">&nbsp; 
																<s:property value="objReservaDTO.servicio.descripcion"/>
															</td>
														</tr>
														<tr>
															<td width="15%" class="label"> Empleado &nbsp; </td>
															<td width="85%" colspan="3">&nbsp;
																<s:property value="objReservaDTO.empleado.nombres"/>
																<s:property value="objReservaDTO.empleado.apellidoPaterno"/>
																<s:property value="objReservaDTO.empleado.apellidoMaterno"/> 
															</td>
														</tr>
														<tr>
															<td width="15%" class="label"> Hora Inicio &nbsp; </td>
															<td width="35%">&nbsp; 
																<s:property value="objReservaDTO.horaInicio"/>
															</td>
															<td width="15%" class="label"> Hora Fin &nbsp; </td>
															<td width="45%">&nbsp; 
																<s:property value="objReservaDTO.horaFin"/>
															</td>
														</tr>
													</table>
													<br>
													<sx:a onclick="anularReserva()" targets="div_process_anulacion" href="#" >
														<img  align="middle"width="24" height="24" src="<%= request.getContextPath() %>/images/btns/btn_cancel.png"/>
														Anular Reserva 
													</sx:a>
												</div>
											</td>
										</tr>
									</table>
								</s:form>
							</td>
						</tr>
					</table>
				</s:div>
			</td>
		</tr>
	</table>
</div>
</s:div>