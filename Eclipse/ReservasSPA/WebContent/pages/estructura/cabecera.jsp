<%@ taglib prefix="s" uri="/struts-tags" %>

<div id="dv_head">
	<table cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td>
				<img src="<%= request.getContextPath() %>/images/estructura/logo.gif" alt="" />
			</td>
			<td align="right" width="590" valign="top">
				<div style="width: 570px;padding: 10px;">
					<s:if test="%{#session.logged == 1 }">
						Hola, <span class="titulo">${objUsuarioDTO.nombre}</span>
						&nbsp; | <s:a href="logout">Cerrar Sesi&oacute;n</s:a>
					</s:if>
					<s:else>
						<a rel="facebox" href="<%= request.getContextPath() %>/pages/manto_cliente.jsp?sus=ok">Reg&iacute;strate</a>
					</s:else>
				</div>
				<img src="<%= request.getContextPath() %>/images/estructura/cabecera_1.gif" alt="" />
			</td>
		</tr>
	</table>
	
	
</div>
