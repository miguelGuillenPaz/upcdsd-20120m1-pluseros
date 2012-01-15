<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<s:form namespace="/" action="login" method="post" name="frm_login" id="frm_login">
	<table width="95%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td height="20" width="30%" align="right"><b><s:text
				name="login.usuario" /> &nbsp;</b></td>
			<td width="70%" align="left"><s:textfield cssStyle="width:120px"
				name="usuario" id="usuario" /></td>
		</tr>
		<tr>
			<td height="20" width="30%" align="right"><b><s:text
				name="login.clave" /> &nbsp;</b></td>
			<td width="70%" align="left"><s:password cssStyle="width:120px"
				name="clave" id="clave" /></td>
		</tr>
		<tr>
			<td height="5" colspan="2"></td>
		</tr>
		<tr valign="middle">
			<td height="20"></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp; <!-- <input type="button" value="Ingresar" id="btn_login" name="btn_login"/> -->
			<s:submit action="login" onclick="$('#img_load').css('display','');$('#btn_login').attr('disabled','disabled');document.getElementById('frm_login').submit();" value="Ingresar" id="btn_login" name="btn_login"></s:submit>
			<%--<sx:submit onclick="$('#img_load').css('display','');$('#btn_login').attr('disabled','disabled');" notifyTopics="/login" value="Ingresar" id="btn_login" name="btn_login" />--%>
			<img style="display: none" id="img_load" name="img_load" src="<%=request.getContextPath()%>/images/estructura/ajax-loader.gif" />
			</td>
		</tr>
		<tr>
			<td height="10" colspan="2"></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><s:a href="#">¿Olvidaste tu contraseña?</s:a><br>
				<span class="msg_error"><s:property value="strMensaje" /> </span>
			</td>
		</tr>
	</table>
</s:form>