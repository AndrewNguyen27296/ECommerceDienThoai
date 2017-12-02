<%-- 
    Document   : view
    Created on : Dec 1, 2017, 10:49:50 PM
    Author     : DacTien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!-- SHopping-cart -->
<script src="assets/customer/js/shopping-cart.js"></script>

<div style="padding-right: 20px; padding-left: 20px">
    <table id="my-shopping-cart" class="table table-striped">
        <thead>
            <tr>
                <th>Tên sản phẩm</th>
                <th>Đơn giá</th>
                <th>Số lượng</th>
                <th>Thành tiền</th>
                <th></th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="p" items="${cart.items}"  varStatus="i"> 
                <tr>
                    <td>${p.tenMay}</td>
                    <td>
                        <fmt:formatNumber type="number" value="${p.giaBan}" pattern="###,###,###"/>
                        VND
                    </td>
                    <td>
                        <input id="soLuong" value="${p.soLuong}" type="number" style="width: 50px" data-cart-update="${p.id}" min="1" max="${soLuongs[i.index]}">
                    </td>
                    <td  class="amt">
                        <fmt:formatNumber type="number" value="${p.giaBan * p.soLuong}" pattern="###,###,###"/>
                        VND
                    </td>
                    <td>
                        <button class="btn btn-sm btn-danger" data-cart-remove="${p.id}">
                            <span class="glyphicon glyphicon-trash"></span>
                        </button>
                    </td>

                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <h3 id="amount" style="float: right; margin-bottom: 20px">Tổng cộng: <fmt:formatNumber type="number" value="${cart.amount}" pattern="###,###,###"/> VND</h3>
    <div class="clearfix"></div>
    <button class="btn btn-success" style="float: right">Tiến hành thanh toán</button>
</div>