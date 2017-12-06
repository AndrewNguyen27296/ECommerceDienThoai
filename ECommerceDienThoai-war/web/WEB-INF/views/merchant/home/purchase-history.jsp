<%-- 
    Document   : purchase-history
    Created on : Dec 5, 2017, 12:19:33 AM
    Author     : XinKaChu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="assets/merchant/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="assets/merchant/js/jquery.min.js"></script>
        <title>Lịch Sử Mua Tin</title>
    </head>
    <body>
        <h1>Lịch Sử Mua Tin</h1>
        <table class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th>Gói tin</th>
                    <th>Giá bán</th>
                    <th>Ngày mua</th>
                    <th>Phương thức thanh toán</th>
                </tr>
            </thead>


            <tbody>
                <c:forEach var="row" items="${orderpackage}">
                    <tr>
                        <td> <c:out value="${orderpackage.package.name}" /> </td>
                        <td> <c:out value="${orderpackage.package.price}" /> </td>
                        <td> <c:out value="${orderpackage.date}" /> </td>
                        <td> <c:out value="${orderpackage.type}" /> </td>
                    </tr>
                </c:forEach>
            </tbody>

        </table>
    </body>
</html>
