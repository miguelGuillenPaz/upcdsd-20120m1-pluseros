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
						Bienvenido, <span class="titulo">alderfg</span>
					</s:if>
					<s:else>
						<s:a href="#">Reg&iacute;strate</s:a>
					</s:else>
				</div>
				<img src="<%= request.getContextPath() %>/images/estructura/cabecera_1.gif" alt="" />
			</td>
		</tr>
	</table>
	
	
</div>