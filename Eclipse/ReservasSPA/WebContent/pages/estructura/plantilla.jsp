<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<sx:head debug="false" />
<head>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css" />
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/jscripts/jquery-ui/css/smoothness/ui.css" />
<link href="<%= request.getContextPath() %>/jscripts/facebook/facebox.css" media="screen" rel="stylesheet" type="text/css" />
<script src="<%= request.getContextPath() %>/jscripts/jquery-1.7.1.min.js" type="text/javascript"></script>
<script src="<%= request.getContextPath() %>/jscripts/facebook/facebox.js" type="text/javascript"></script>
<script src="<%= request.getContextPath() %>/jscripts/jquery-ui/ui.js" type="text/javascript"></script>
<script src="<%= request.getContextPath() %>/jscripts/ddaccordion.js" type="text/javascript"></script>
<script src="<%= request.getContextPath() %>/jscripts/jqfunctions.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="shortcut icon" href="<%= request.getContextPath() %>/images/favicon.ico" type="image/x-icon" />
<title>
	Elisa's SPA - <tiles:insertAttribute name="title" />
</title>
</head>
<tiles:insertAttribute name="checkUser" />
<body>
<!-- -
	<div id="dialog-confirm" title="Mensaje de Confirmaci&oacute;n">
		<p><span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>These items will be permanently deleted and cannot be recovered. Are you sure?</p>
	</div> -->
	<div id="dv_main">
		<table width="100%" border="0" style="background: #FFFFFF">
			<tr>
				<td>
					<img src="<%= request.getContextPath() %>/images/estructura/border_top_left.jpg" alt="" />
				</td>
				<td valign="top">
					<table border="0">
						<tr>
							<td colspan="2">
								<tiles:insertAttribute name="header" />
							</td>
						</tr>
						<tr>
							<td colspan="2" height="5" style="border-bottom: 1px double #CCCCCC;" ></td>
						</tr>
						<tr>
							<td colspan="2" height="3"></td>
						</tr>
						<tr>
							<td width="180px" valign="top"><tiles:insertAttribute name="body_left" /></td>
							<td width="725px" valign="top"><tiles:insertAttribute name="body" /></td>
						</tr>
					</table>
				</td>
				<td>
					<img src="<%= request.getContextPath() %>/images/estructura/border_top_right.jpg" alt="" />
				</td>
			</tr>
			<tr>
				<td></td>
				<td><tiles:insertAttribute name="footer" /></td>
				<td></td>
			</tr>
		</table>
	</div>
</body>
</html>