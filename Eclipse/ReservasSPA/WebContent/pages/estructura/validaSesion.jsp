<jsp:scriptlet>
 	if (session.getAttribute("logged") != null){
 		if( Integer.parseInt(session.getAttribute("logged").toString()) == 1){
 			response.sendRedirect("welcome");
 		}else{
 			response.sendRedirect("init");
 		}
	}else{
		response.sendRedirect("init");
	}
</jsp:scriptlet>
