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

<c:choose>
    <c:when test="${empty cart.items}">
        <div class="text-center">Giỏ hàng rỗng</div>
    </c:when>
    <c:otherwise>
        <div style="padding-right: 20px; padding-left: 20px">
            <c:forEach var="nguoiBan" items="${listNguoiBan}" >
                <span>Shop: ${nguoiBan.hoTen}</span>
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
                            <c:if test="${p.idNguoiBan.id == nguoiBan.id}">
                                <tr>
                                    <td class="col-sm-6">${p.tenMay}</td>
                                    <td class="col-sm-2">
                                        <fmt:formatNumber type="number" value="${p.giaBan}" pattern="###,###,###"/>
                                        VND
                                    </td>
                                    <td class="col-sm-1">
                                        <input id="soLuong" value="${p.soLuong}" type="number" style="width: 50px" data-cart-update="${p.id}" min="1" max="${soLuongs[i.index]}">
                                    </td>
                                    <td  class="amt col-sm-2">
                                        <fmt:formatNumber type="number" value="${p.giaBan * p.soLuong}" pattern="###,###,###"/>
                                        VND
                                    </td>
                                    <td  class="col-sm-1">
                                        <button class="btn btn-sm btn-danger" data-cart-remove="${p.id}">
                                            <span class="glyphicon glyphicon-trash"></span>
                                        </button>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </tbody>
                </table>
            </c:forEach>


            <h3 id="amount" style="float: right; margin-bottom: 20px">Tổng cộng: <fmt:formatNumber type="number" value="${cart.amount}" pattern="###,###,###"/> VND</h3>
            <div class="clearfix"></div>
            <a id="thanhToan" class="btn btn-success" href="order/check-out.php" style="float: right">Tiến hành thanh toán</a>
        </div>
    </c:otherwise>
</c:choose>




<script>
    $("#thanhToan").click(function (e) {
        e.preventDefault();
        var temp = $("#check-dang-nhap").text();
        if (temp.replace(/\s/g, '') == "Đăngnhập") {
            alert("Vui lòng đăng nhập để tiến hành thanh toán");
            $('#myModal88').modal('show');
        } else {
            window.location = $(this).attr('href');
        }
    });
</script>