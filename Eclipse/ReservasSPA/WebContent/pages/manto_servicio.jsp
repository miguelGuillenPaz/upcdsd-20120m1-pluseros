<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<div id="dv_body">
	<table style="margin: 0px 0px 0px 10px;border-left: 1px solid #CCCCCC;" width="715px" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td>
				<div id="breadcrumb">
					<ul class="crumbs">
						<li class="first"><s:a action="mantenerServicio.action" style="z-index:9;"><span></span>Mantenimiento de Servicios</s:a></li>
					</ul>
				</div>
			</td>
			<td align="right" width="" valign="middle" >&nbsp;
				<sx:a targets="process" href="" >
					<img  align="middle"width="24" height="24" src="<%= request.getContextPath() %>/images/btns/btn_add.png"/>
				<s:text name="M_Usuarios.nuevo"/> 
				</sx:a>
				| <sx:a targets="process" >
					<img align="middle" width="24" height="24" src="<%= request.getContextPath() %>/images/btns/btn_accept.png" /> 
					<s:text name="M_Usuarios.grabar"/> </sx:a>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<s:div id="div_process" cssStyle="float: right;width:96%">
					<table width="100%" border="0" cellpadding="1" cellspacing="0">
					<%--
						<tr valign="middle">
							<td align="center" width="32px" >
								<!-- 
								<img align="middle" width="24" height="24" alt="" src="<%= request.getContextPath() %>/images/icons/icon_vineta.png" >
								 -->
							</td>
							<td align="left" width=""><!-- <span class="titulo" >&nbsp; 
								<s:text name="M_Usuarios.tituloRegistro"/> </span> 	 --></td>
							<td align="right" width="" valign="middle" >&nbsp;
								<!--<sx:a targets="process" href="listarUsuarios.action" notifyTopics="/listarUsuarios" >
									<img  align="middle"width="24" height="24" src="<%= request.getContextPath() %>/images/btns/btn_add.png"/>
								<s:text name="M_Usuarios.nuevo"/> 
								</sx:a>
								| <sx:a targets="process" notifyTopics="/listarUsuarios" onclick="document.frm_Usuario.submit()" >
									<img align="middle" width="24" height="24" src="<%= request.getContextPath() %>/images/btns/btn_accept.png" /> 
									<s:text name="M_Usuarios.grabar"/> </sx:a>-->
							</td>
						</tr> 
						<tr><td colspan="3" height="20" align="left" ></td></tr>--%>
						<tr>
							<td colspan="3" height="20" align="center" >
								<span class="msg_error"><s:property value="%{#request.mensaje}" /></span>
							
								<input type="hidden" id="intCodigo_Usu" name="intCodigo_Usu" value="0">
								<table width="100%" class="tbl_Manto_Registro" style="background-color: #B7B7B7;" cellpadding="1" cellspacing="1" border="0">
									<tr>
										<td height="20" width="15%" class="label" > Descripci&oacute;n &nbsp; </td>
										<td width="30%" >&nbsp; <s:textfield required="true" cssStyle="width:230px" id="strApellido_Usu" name="strApellido_Usu" /> </td>
										<td width="15%" class="label" > Duraci&oacute;n &nbsp; </td>
										<td width="30%" >&nbsp; <s:textfield required="true" cssStyle="width:120px" id="strApellido_Usu" name="strApellido_Usu" /> horas</td>
									</tr>
									<tr>
										<td height="20" width="15%" class="label" > Foto &nbsp; </td>
										<td width="30%" >&nbsp; <s:file cssStyle="width:230px"></s:file> </td>
										<td width="15%" class="label" > &nbsp; </td>
										<td width="30%" >&nbsp; </td>
									</tr>
								</table>
							</td>
						</tr>
						<tr><td colspan="3" height="20"></td></tr>
						<tr>
							<td colspan="3">
								<table width="100%" border="0" cellspacing="0" >
									<tr class="tbl_Manto_cabecera_pie">
										<td width="30%" height="25" > Descripci&oacute;n </td>
										<td width="19%" > Duraci&oacute;n </td>
										<td width="10%" > Foto </td>
										<td width="5%" > <s:text name="M_Usuarios.estado"/> </td>
										<td width="5%" >  </td>
									</tr>
									<!-- 
									<tr class="tbl_Manto_cuerpo">
										<td height="25" > Descripci&oacute;n </td>
										<td> Nombre </td>
										<td> <img src="<%= request.getContextPath() %>/images/btns/btn_image.png"> </td>
										<td align="center" > <img src="<%= request.getContextPath() %>/images/btns/btn_check_enabled.png"> </td>
										<td align="center" > <img src="<%= request.getContextPath() %>/images/btns/btn_edit.png"> </td>
									</tr>
									 -->
									<s:if test="lstServicioDTO.size == 0">
									<tr>
										<td colspan="5" align="center" height="25">
											<span class="msj_error">No existen registros.</span>
										</td>
									</tr>
									</s:if>
									<s:else>
										<s:iterator var="servicio" value="lstServicioDTO">
											<tr class="tbl_Manto_cuerpo" >
												<td height="20"><s:property value="descripcion"/></td>
												<td><s:property value="duracion"/></td>
												<td>
													<a href="<%= request.getContextPath() %>/images/servicios/<s:property value='rutaImagen'/>" rel="facebox">
														<img src="<%= request.getContextPath() %>/images/btns/btn_image.png">
													</a>
												</td>
												<td><img src="<%= request.getContextPath() %>/images/btns/btn_check_enabled.png"></td>
												<td><img src="<%= request.getContextPath() %>/images/btns/btn_edit.png"></td>
											</tr>
										</s:iterator>
									</s:else>
									<tr><td colspan="5" height="20"></td></tr>
								</table>
															
							</td>
						</tr>
					</table>
				</s:div>
			</td>
		</tr>
	</table>
</div>