<%-- 
    Document   : admin-login-layout
    Created on : Nov 21, 2017, 10:25:08 PM
    Author     : DacTien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
    <head>
        <title>DIGIWORLD WEB MASTER</title>
<!--        <link href="../../assets/admin/css/login-style.css" rel="stylesheet" type="text/css"/>-->
        <link href="assets/admin/css/login-style.css" rel="stylesheet" type="text/css" media="all"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Transparent Login Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
        
        <base href="${pageContext.request.contextPath}/">
        <!--web-fonts-->
        <link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css' />
        <!--web-fonts-->
    </head>

    <body>
        <!--header-->
        <div class="header-w3l">
            <h1>DigiWorld Web Master</h1>
        </div>
        <!--//header-->

        <!--main-->
        <jsp:include page="${param.view}"></jsp:include>
        <!--//main-->

        <!--footer-->
        <div class="footer">
            <!-- <p>&copy; 2017 Transparent Login Form. All rights reserved | Design by <a href="http://w3layouts.com">W3layouts</a></p> -->
        </div>
        <!--//footer-->

    </body>
</html>