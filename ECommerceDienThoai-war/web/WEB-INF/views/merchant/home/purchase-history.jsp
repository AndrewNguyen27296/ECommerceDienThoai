<%-- 
    Document   : purchase-history
    Created on : Dec 5, 2017, 12:19:33 AM
    Author     : XinKaChu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
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
                <!-- biến được đặt là row . items dựa theo model.AddAttribute("phieuMuaTin") -->
                <c:forEach var="row" items="${phieuMuaTin}">
                    <tr>
                        
                        <!-- idGoiTin và tenGoiTin dựa theo database và entities -->
                        <td> ${row.idGoiTin.tenGoiTin} </td>
                        
                        <td>
                            <f:formatNumber type="number" value="${row.idGoiTin.giaBan}" pattern="###,###,###"/> VNĐ
                        </td>
                        
                            
                       
                        
                        <td> ${row.ngayMua} </td>
                        
                        <!-- Nếu 0 hiển thị : Paypal
                             Nếu 1 hiển thị : Trực tiếp
                        -->
                        <c:choose>
                            <c:when test="${row.phuongThucThanhToan == 0}">
                                <td>Paypal</td>
                            </c:when>
                            <c:otherwise>
                                <td>Trực tiếp</td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </c:forEach>
            </tbody>

        </table>
    </body>
</html>
