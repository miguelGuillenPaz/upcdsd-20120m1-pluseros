<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<script type='text/javascript' src='${pageContext.request.contextPath}/dwr/engine.js'></script>
<script type='text/javascript' src='${pageContext.request.contextPath}/dwr/util.js'></script>
<script type='text/javascript' src='${pageContext.request.contextPath}/dwr/interface/ImplReservaService.js'></script>

<s:form id="frm_empleado" action="registrarEmpleado" namespace="/" enctype="multipart/form-data" >
<div id="dv_body">
	<table style="margin: 0px 0px 0px 10px;border-left: 1px solid #CCCCCC;" width="715px" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td>
				<div id="breadcrumb">
					<ul class="crumbs">
						<li class="first"><s:a action="mantenerEmpleado.action" style="z-index:9;"><span></span>Mantenimiento de Empleados</s:a></li>
					</ul>
				</div>
			</td>
			<td align="right" width="" valign="middle" >&nbsp;
				<sx:a targets="process" href="" >
					<img  align="middle"width="24" height="24" src="<%= request.getContextPath() %>/images/btns/btn_add.png"/>
				<s:text name="M_Usuarios.nuevo"/> 
				</sx:a>
				| <s:a href="#" onclick="registrarEmpleado()">
					<img align="middle" width="24" height="24" src="<%= request.getContextPath() %>/images/btns/btn_accept.png" /> 
					<s:text name="M_Usuarios.grabar"/> 
				</s:a>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<s:div id="div_process" cssStyle="float: right;width:96%">
					<table width="100%" border="0" cellpadding="1" cellspacing="0">
						<tr>
							<td colspan="3" height="20" align="center" >
								<span class="msg_error"><s:property value="%{#request.mensaje}" /></span>
							
								<input type="hidden" id="intCodigo_Usu" name="intCodigo_Usu" value="0">
								<table width="100%" class="tbl_Manto_Registro" style="background-color: #B7B7B7;" cellpadding="1" cellspacing="1" border="0">
									<tr>
										<td height="20" width="15%" class="label" > Codigo &nbsp; </td>
										<td width="30%" >&nbsp; <s:textfield disabled="true" cssStyle="width:120px" id="objEmpleadoDTO.codigo" name="objEmpleadoDTO.codigo" /> </td>
										<td width="15%" class="label" > Nombre &nbsp; </td>
										<td width="30%" >&nbsp; <s:textfield required="true" cssStyle="width:230px" id="objEmpleadoDTO.nombres" name="objEmpleadoDTO.nombres" /> </td>
									</tr>
									<tr>
										<td height="20" width="15%" class="label" > Apellido Pat. &nbsp; </td>
										<td width="30%" >&nbsp; <s:textfield cssStyle="width:230px" id="objEmpleadoDTO.apellidoPaterno" name="objEmpleadoDTO.apellidoPaterno" /> </td>
										<td width="15%" class="label" > Apellido Mat. &nbsp; </td>
										<td width="30%" >&nbsp; <s:textfield  cssStyle="width:230px" id="objEmpleadoDTO.apellidoMaterno" name="objEmpleadoDTO.apellidoMaterno" /> </td>
									</tr>
									<tr>
										<td height="20" width="15%" class="label" > Direcci&oacute;n&nbsp; </td>
										<td width="30%" colspan="3">&nbsp; <s:textfield cssStyle="width:570px" id="objEmpleadoDTO.direccion" name="objEmpleadoDTO.direccion" /> </td>
									</tr>
									<tr>
										<td height="20" width="15%" class="label" > Documento &nbsp; </td>
										<td width="30%" >&nbsp; 
											<s:select id="objEmpleadoDTO.tipoDocumentoIdentidad" name="objEmpleadoDTO.tipoDocumentoIdentidad" cssStyle="width:230px" list="#{'16':'DNI','17':'CARNET DE EXTRANJERIA','18':'PASAPORTE'}" >
											</s:select>
										 </td>
										<td width="15%" class="label" > N� Documento </td>
										<td width="30%" >&nbsp; <s:textfield cssStyle="width:120px" id="objEmpleadoDTO.nroDocumentoIdentidad" name="objEmpleadoDTO.nroDocumentoIdentidad" /> </td>
									</tr>
									<tr>
										<td height="20" width="15%" class="label" > <s:text name="M_Usuarios.mail"/> &nbsp; </td>
										<td width="30%" >&nbsp; <s:textfield  cssStyle="width:230px" id="objEmpleadoDTO.email" name="objEmpleadoDTO.email" /> </td>
										<td width="15%" class="label" > </td>
										<td width="30%" >&nbsp; </td>
									</tr>
									<tr>
										<td height="20" width="15%" class="label" > Usuario &nbsp; </td>
										<td width="30%" >&nbsp; <s:textfield cssStyle="width:120px" id="objEmpleadoDTO.usuario" name="objEmpleadoDTO.usuario" /> </td>
										<td width="15%" class="label" > Clave &nbsp; </td>
										<td width="30%" >&nbsp; <s:password  cssStyle="width:120px" id="objEmpleadoDTO.clave" name="objEmpleadoDTO.clave" /> </td>
									</tr>
									<tr>
										<td height="20" width="15%" class="label" > Departamento &nbsp; </td>
										<td width="30%" >&nbsp; 
											<s:select onchange="seleccionarDepartamento(this)" cssStyle="width:240px;text-transform: capitalize;" list="#session.lstDepartamentoDTO" listKey="id" listValue="nombre"></s:select>
										 </td>
										<td width="15%" class="label" > Provincia &nbsp; </td>
										<td width="30%" >&nbsp; 
											<s:select onchange="seleccionarProvincia(this)" cssStyle="width:240px;" list="#{'0':'Seleccione'}" id="idProvincia"></s:select> 
										</td>
									</tr>
									<tr>
										<td height="20" width="15%" class="label" > Distrito &nbsp; </td>
										<td width="30%" >&nbsp; 
											<s:select cssStyle="width:240px;" list="#{'0':'Seleccione'}" id="objEmpleadoDTO.distrito" name="objEmpleadoDTO.distrito"></s:select>
										 </td>
										<td width="15%" class="label" > Foto &nbsp; </td>
										<td width="30%" >&nbsp; <s:file id="flfoto" name="flfoto" cssStyle="width:230px"></s:file> </td>
									</tr>
								</table>
							</td>
						</tr>
						<tr><td colspan="3" height="20"></td></tr>
						<tr>
							<td colspan="3">
								<table width="100%" border="0" cellspacing="0" >
									<tr class="tbl_Manto_cabecera_pie">
										<td width="10%" height="25" > Codigo </td>
										<td width="19%" > Nombre </td>
										<td width="10%" > Usuario </td>
										<td width="15%" > <s:text name="M_Usuarios.mail"/> </td>
										<td width="3%" > <s:text name="M_Usuarios.estado"/> </td>
										<td width="3%" >  </td>
									</tr>
									
									<!-- 
									
									<tr class="tbl_Manto_cuerpo">
										<td width="10%" height="25" > Codigo </td>
										<td width="19%" > Nombre </td>
										<td width="10%" > Usuario </td>
										<td width="15%" > <s:text name="M_Usuarios.mail"/> </td>
										<td width="5%" align="center" > <img src="<%= request.getContextPath() %>/images/btns/btn_check_enabled.png"> </td>
										<td width="5%" align="center" > <img src="<%= request.getContextPath() %>/images/btns/btn_edit.png"> </td>
									</tr>
									 -->
									<tr>
										<td colspan="6" align="center" height="25">
											<span class="msj_error">No existen registros.</span>
										</td>
									</tr>
									
									<s:iterator var="usuario" value="lstE_Usuario">
										<tr class="tbl_Manto_cuerpo" >
											<td height="20">&nbsp;<s:property value="strNombre_Usu" /></td>
											<td >&nbsp;<s:property value="strApellido_Usu" /></td>
											<td >&nbsp;<s:property value="strLogin_Usu" /></td>
											<td >&nbsp;<s:property value="strMail_Usu" /></td>
											<td align="center">
												<s:if test="%{#usuario.intCodigo_Avatar != -1}">
													<a href="<%= request.getContextPath() %>/pages/getAvatar.jsp?intCodigo_Avatar=<s:property value='intCodigo_Avatar'/>" id="single_image" > <img src="<%= request.getContextPath() %>/images/btns/btn_image.png"> </a>
												</s:if>
												<s:else>
													-
												</s:else>
											</td>
											<td >&nbsp;<s:property value="objE_Rol.strDescripcion_Rol" /> </td>
											<td align="center">
												<s:if test="%{#usuario.intEstado_Usu == 1}">
													<img src="<%= request.getContextPath() %>/images/btns/btn_check_enabled.png">
												</s:if>
												<s:else>
													<img src="<%= request.getContextPath() %>/images/btns/btn_check_disabled.png">
												</s:else>
											</td>
											<td align="center" >
												<s:a href="#">  
													<img src="<%= request.getContextPath() %>/images/btns/btn_edit.png">
												</s:a> 
											</td>
										</tr>
									
									</s:iterator>
									<tr><td colspan="6" height="20"></td></tr>
								</table>
															
							</td>
						</tr>
					</table>
				</s:div>
			</td>
		</tr>
	</table>
</div>
</s:form>