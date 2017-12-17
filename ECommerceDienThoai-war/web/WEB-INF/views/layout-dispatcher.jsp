<%@ page pageEncoding="utf-8"%>
<%
	String view = request.getParameter("view");
	if(view.startsWith("demo/")){
		pageContext.forward("demo-layout.jsp");
	}
        if(view.startsWith("merchant/account/forgot")){
		pageContext.forward("merchant/account/forgot.jsp");
        }
        else if(view.startsWith("merchant/account")){
		pageContext.forward("merchant/account/login.jsp");
        }
        else if(view.startsWith("customer/account/forgot-password")){
		pageContext.forward("customer-layout.jsp");
	}
        else if(view.startsWith("customer/account/") || view.startsWith("customer/order/history") || view.startsWith("customer/order/detail") || view.startsWith("customer/order/rating")){
		pageContext.forward("customer-account-layout.jsp");
	}
        else if(view.startsWith("customer/")){
		pageContext.forward("customer-layout.jsp");
	}
        else if(view.startsWith("admin/login")){
		pageContext.forward("admin-login-layout.jsp");
	}
        else if(view.startsWith("admin/")){
		pageContext.forward("admin-layout.jsp");
	}
        else if(view.startsWith("merchant/home")){
                pageContext.forward("merchant-layout.jsp");
        }
        else {
		pageContext.forward("blank-layout.jsp");
	}
//	else{
//		pageContext.forward("blank-layout.jsp");
//	}
%>