<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<div id="dv_body">
	<table style="margin: 0px 0px 0px 10px;border-left: 1px solid #CCCCCC;" width="715px" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td>
				<div id="breadcrumb">
					<ul class="crumbs">
						<li class="first"><a href="#" style="z-index:9;"><span></span>Disponibilidad Horarios</a></li>
						<li><a href="#" style="z-index:8;">Option 01</a></li>
						<li><a href="#" style="z-index:7;">Option 02</a></li>
						<li><a href="#" style="z-index:6;">Option 03</a></li>
					</ul>
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<s:div id="div_process" cssStyle="float: right;width:97%">
					<table style="padding: 3px;" width="100%" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td>
								<!-- <div id="datepicker"></div> -->
								<div class="div_group_top"></div>
								<div class="div_group_content">
									<span class="titulo_group">Selección de Servicios</span><br>
									<table class="tb_list" border="0" cellpadding="0" cellspacing="0" width="100%" style="margin-top: 10px;">
										<tr align="center">
											<td>
												<sx:a href="seleccionaServicio.action?id_servicio=123" targets="div_process">
													<img alt="" src="<%= request.getContextPath() %>/images/estructura/img_servicio.gif">
													<br>Servicio 01
												</sx:a>
											</td>
											<td>
												<img alt="" src="<%= request.getContextPath() %>/images/estructura/img_servicio.gif">
												<br>Servicio 02
											</td>
											<td>
												<img alt="" src="<%= request.getContextPath() %>/images/estructura/img_servicio.gif">
												<br>Servicio 03
											</td>
											<td>
												<img alt="" src="<%= request.getContextPath() %>/images/estructura/img_servicio.gif">
												<br>Servicio 04
											</td>
										</tr>
										<tr align="center">
											<td>
												<img alt="" src="<%= request.getContextPath() %>/images/estructura/img_servicio.gif">
												<br>Servicio 05
											</td>
											<td>
												<img alt="" src="<%= request.getContextPath() %>/images/estructura/img_servicio.gif">
												<br>Servicio 06
											</td>
											<td>
												<img alt="" src="<%= request.getContextPath() %>/images/estructura/img_servicio.gif">
												<br>Servicio 07
											</td>
											<td>
												<img alt="" src="<%= request.getContextPath() %>/images/estructura/img_servicio.gif">
												<br>Servicio 08
											</td>
										</tr>
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