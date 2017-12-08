<%-- 
    Document   : history
    Created on : Dec 8, 2017, 12:35:23 PM
    Author     : DacTien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>

<div class="col-sm-12">
    <table class="table table-bordered">
        <tr>
            <th>Mã đơn hàng</th>
            <th>Ngày đặt</th>
            <th>Tổng tiền</th>
            <th></th>
        </tr>
        <c:forEach var="p" items="${phieuMuaHangs}">
            <tr>
                <td>#${p.id}</td>
                <td><fmt:formatDate pattern = "dd-MM-yyyy" value = "${p.ngayDatHang}" /></td>
                <td><fmt:formatNumber pattern="###,###,###" value="${p.tongTien}" /> VND</td>
                <td>
                    <a href="order/detail/${p.id}.php">Chi tiết</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<style>
    th {
        text-align: center;
    }
</style>
