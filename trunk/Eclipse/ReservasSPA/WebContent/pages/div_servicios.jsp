<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<div id="dv_body">
	<table style="margin: 0px 0px 0px 10px;border-left: 1px solid #CCCCCC;" width="715px" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td>
				<div id="breadcrumb">
					<ul class="crumbs">
						<li class="first"><s:a action="disponibilidad.action" style="z-index:9;"><span></span>Selecci&oacute;n de Servicios</s:a></li>
						<li><a href="#" style="z-index:8;">Selecci&oacute;n de Profesional</a></li>
						<li><a href="#" style="z-index:7;">Disponibilidad de Horarios</a></li>
					</ul>
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<s:div id="div_process" cssStyle="float: right;width:97%;">
					<s:set name="lst_servicios" value="lstServicioDTO"/>
				
					<table style="padding: 3px;" width="100%" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td>
								<!-- <div id="datepicker"></div> -->
								<div class="div_group_top"></div>
								<div class="div_group_content">
									<span class="titulo_group">Selección de Servicios</span><br>
									<table class="tb_list" border="0" cellpadding="0" cellspacing="0" width="100%" style="margin-top: 10px;">
										<s:set var="index" value="1"></s:set>
										<s:iterator value="#lst_servicios" var="serv" >
											<s:if test="#index == 1">
												<tr align="center">
											</s:if>
												<td>
													<sx:a href="seleccionaServicio.action?id_servicio=%{id}" targets="div_process">
														<img alt="" src="<%= request.getContextPath() %>/images/servicios/${rutaImagen}">
														<br><s:property value="descripcion"/>
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
				</s:div>
			</td>
		</tr>
	</table>
</div>