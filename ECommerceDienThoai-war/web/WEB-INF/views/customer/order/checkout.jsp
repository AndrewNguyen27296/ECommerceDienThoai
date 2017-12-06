<%-- 
    Document   : checkout
    Created on : Dec 4, 2017, 11:54:55 AM
    Author     : DacTien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>

<div class="container" style="padding-right: 20px; padding-left: 20px">
    <div class="col-sm-1"></div>
    <div class="col-sm-10">
        <div class="col-sm-6">
            <div class="col-sm-12">
                <h4 class="">Địa chỉ giao hàng</h4>
                <div  style="margin-top: 20px; margin-bottom: 20px">
                    <div class="form-group" style="border: 1px solid; border-radius: 10px">
                        <label style="width: 100%; padding: 10px; ">
                            <div style="display: inline; float: left;">
                                <input type="radio" class="w3-radio" name="diaChi" id="diaChiHienTai" checked="checked"/>
                                <span>Địa chỉ hiện tại:</span>
                            </div>
                            <div  style="display: inline; float: left; margin-left: 10px">
                                <span>${sessionScope.nguoiMua.hoTen}</span>
                                <br>
                                <span> ${sessionScope.nguoiMua.diaChi}</span>
                                <br>
                                <span> ${sessionScope.nguoiMua.soDienThoai}</span>
                            </div>
                        </label>
                    </div>
                    <div class="form-group"style="border: 1px solid; border-radius: 10px">
                        <label style="width: 100%;  padding: 10px; ">
                            <input type="radio" class="w3-radio" name="diaChi" id="diaChiKhac"  />
                            <span>Địa chỉ khác</span> 
                        </label>
                    </div>
                </div>
                <form id="my-address" style="display: none">
                    <div class="form-group  col-sm-12">
                        <label class="col-sm-3 text-right my-label">Họ tên</label>
                        <input class="form-control col-sm-7" />
                    </div>
                    <div class="form-group  col-sm-12">
                        <label class="col-sm-3 text-right my-label">Số điện thoại</label>
                        <input class="form-control col-sm-7" />
                    </div>
                    <div class="form-group  col-sm-12">
                        <label class="col-sm-3 text-right my-label">Thành phố</label>
                        <select class="form-control">
                            <option>Hồ chí minh</option>
                            <option>Hà nội</option>
                        </select>
                    </div>
                    <div class="form-group  col-sm-12">
                        <label class="col-sm-3 text-right my-label">Quận - huyện</label>
                        <select class="form-control">
                            <option>Tân Bình</option>
                            <option>Hoàn kiếm</option>
                        </select>
                    </div>
                    <div class="form-group  col-sm-12">
                        <label class="col-sm-3 text-right my-label">Phường - xã</label>
                        <select class="form-control">
                            <option>Tân Bình</option>
                            <option>Hoàn kiếm</option>
                        </select>
                    </div>
                    <div class="form-group  col-sm-12">
                        <label class="col-sm-3 text-right my-label">Địa chỉ</label>
                        <input class="form-control col-sm-7" />
                    </div>
                </form>
            </div>
            <!--        <div class="col-sm-3"></div>
                    <div class="col-sm-3"></div>-->
        </div>

        <div class="col-sm-6">
            <c:forEach var="nguoiBan" items="${listNguoiBan}" >
                <span>Shop: ${nguoiBan.hoTen}</span>
                <table id="my-shopping-cart" class="table table-striped">
                    <thead>
                        <tr>
                            <th>Tên sản phẩm</th>
                            <th>Đơn giá</th>
                            <th>Số lượng</th>
                            <th>Thành tiền</th>
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
                                    <td class="col-sm-2">
                                        ${p.soLuong}
                                    </td>
                                    <td  class="amt col-sm-2">
                                        <fmt:formatNumber type="number" value="${p.giaBan * p.soLuong}" pattern="###,###,###"/>
                                        VND
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </tbody>
                </table>
            </c:forEach>
            <h3 id="amount" style="float: right; margin-bottom: 20px">Tổng cộng: <fmt:formatNumber type="number" value="${cart.amount}" pattern="###,###,###"/> VND</h3>
            <div class="clearfix"></div>
        </div>
            <div class="clearfix"></div>
        <button class=" btn btn-lg btn-warning " style="left: 89.6%; position: relative">Xác nhận</button>
        
    </div>
    <div class="col-sm-1"></div>
</div>

<style>
    .form-control {
        width: 65%;

    }
    .my-label {
        margin-right: 5px;
    }
</style>

<script>
    $(function () {
        $('input:radio').change(function () {
            if ($("#diaChiKhac").is(":checked")) {
                $("#my-address").attr("style", "display:block");
            } else {
                $("#my-address").attr("style", "display:none");
            }
        });

    });

</script>
