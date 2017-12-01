<%-- 
    Document   : merchant-layout
    Created on : Nov 21, 2017, 12:24:44 AM
    Author     : XinKaChu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <base href="${pageContext.request.contextPath}/">

        <title>Kênh Người Bán</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Pooled Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- Bootstrap Core CSS -->
        <link href="assets/merchant/css/bootstrap.min_1.css" rel='stylesheet' type='text/css' />
        <!-- Custom CSS -->
        <link href="assets/merchant/css/style.css" rel='stylesheet' type='text/css' />
        <link rel="stylesheet" href="css/morris_1.css" type="text/css"/>
        <!-- Graph CSS -->
        <link href="assets/merchant/css/font-awesome.css" rel="stylesheet"> 
        <!-- jQuery -->
        <script src="assets/merchant/js/jquery-2.1.4.min.js"></script>
        <!-- //jQuery -->
        <link href='//fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400' rel='stylesheet' type='text/css'/>
        <link href='//fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
        <!-- lined-icons -->
        <link rel="stylesheet" href="assets/merchant/css/icon-font.min.css" type='text/css' />
        <!-- //lined-icons -->
        
        <!-- script-for sticky-nav -->
		<script>
		$(document).ready(function() {
			 var navoffeset=$(".header-main").offset().top;
			 $(window).scroll(function(){
				var scrollpos=$(window).scrollTop(); 
				if(scrollpos >=navoffeset){
					$(".header-main").addClass("fixed");
				}else{
					$(".header-main").removeClass("fixed");
				}
			 });
			 
		});
		</script>
		<!-- /script-for sticky-nav -->
    </head>
    <body>
        <div class="page-container">
            <div class="left-content">
                <div class="mother-grid-inner">
                    <!--Header -->
                    <jsp:include page="merchant/layout/header.jsp" />
                </div>
                <div class="featured">
                    <div class="container">
                    <!--Body -->
                    <jsp:include page="${param.view}" />
                    </div>
                </div>
            </div>
                    
                <div>
                    <!-- Sidebar -->
                    <jsp:include page="merchant/layout/sidebar.jsp" />  
                    
                </div>
        </div>
    </body>
</html>
            