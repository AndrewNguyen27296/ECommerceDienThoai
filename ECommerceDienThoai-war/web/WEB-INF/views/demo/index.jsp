<%-- 
    Document   : index
    Created on : Nov 16, 2017, 11:11:38 AM
    Author     : XinKaChu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link href="assets/customer/css/customer-style.css" rel="stylesheet"/>
<h2>DEMO INDEX VIEWS</h2>
<c:forEach var="ad" items="${dsAdmin}">
    <p>${ad.id}</p>
</c:forEach>