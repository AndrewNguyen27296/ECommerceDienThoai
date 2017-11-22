<%@ page pageEncoding="utf-8"%>
<%
	String view = request.getParameter("view");
	if(view.startsWith("demo/")){
		pageContext.forward("demo-layout.jsp");
	}
        if(view.startsWith("merchant/account")){
		pageContext.forward("merchant/account/login.jsp");
	}
//	else{
//		pageContext.forward("blank-layout.jsp");
//	}
%>