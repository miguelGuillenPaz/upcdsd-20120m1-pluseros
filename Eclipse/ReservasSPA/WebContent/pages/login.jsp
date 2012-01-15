<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<div id="dv_body">
	<table width="100%" >
		<tr>
			<td width="13" style="background-image: url(<%= request.getContextPath() %>/images/border_top_left.jpg); background-repeat:repeat-x" height="674"></td>
			<td width="901">

               <div class="body_login">
               	<div class="div_login">
                   	<s:div id="process" cssStyle="padding:50px 20px 30px 30px;">
                   		<jsp:include page="/pages/div_login.jsp"></jsp:include>	
                     </s:div>
                   </div>
               </div>

         </td>
			<td width="13" style="background-image: url(<%= request.getContextPath() %>/images/border_top_right.jpg); background-repeat:no-repeat"></td>
		</tr>
	</table>
</div>