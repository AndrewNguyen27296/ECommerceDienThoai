<%@ page pageEncoding="utf-8"%>
<%
	String view = request.getParameter("view");
	if(view.startsWith("demo/")){
		pageContext.forward("demo-layout.jsp");
	}
        else if(view.startsWith("customer/")){
		pageContext.forward("customer-layout.jsp");
	}
        else if(view.startsWith("admin/")){
		pageContext.forward("admin-layout.jsp");
	}
        else {
		pageContext.forward("blank-layout.jsp");
	}
%>