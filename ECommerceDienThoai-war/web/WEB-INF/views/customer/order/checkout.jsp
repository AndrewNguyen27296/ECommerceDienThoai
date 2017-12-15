<%-- 
    Document   : checkout
    Created on : Dec 4, 2017, 11:54:55 AM
    Author     : DacTien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>

<div class="container" style="padding-right: 20px; padding-left: 20px">
    <!--    <div class="col-sm-1"></div>-->
    <div class="col-sm-12">
        <form action="order/check-out.php" method="post">
            <div class="col-sm-12">
                <div class="col-sm-5">
                    <h4 class="">Địa chỉ giao hàng</h4>
                    <div  style="margin-top: 20px; margin-bottom: 20px">
                        <div class="form-group" style="border: 1px solid; border-radius: 10px">
                            <label style="width: 100%; padding: 10px; ">
                                <div style="display: inline; float: left;">
                                    <input type="radio" class="w3-radio" name="radioDiaChi" value="diaChiHienTai" id="diaChiHienTai" checked="checked"/>
                                    <span>Địa chỉ hiện tại:</span>
                                </div>
                                <div  style="display: inline; float: left; margin-left: 10px">
                                    <span>${sessionScope.nguoiMua.hoTen}</span>
                                    <br>
                                    <span> ${sessionScope.nguoiMua.diaChi}, 
                                        ${sessionScope.nguoiMua.idQuanHuyen.tenQuanHuyen}, 
                                        ${sessionScope.nguoiMua.idThanhPho.tenThanhPho} 
                                    </span>
                                    <br>
                                    <span> ${sessionScope.nguoiMua.soDienThoai}</span>
                                </div>
                            </label>
                        </div>
                        <div class="form-group"style="border: 1px solid; border-radius: 10px">
                            <label style="width: 100%;  padding: 10px; ">
                                <input type="radio" class="w3-radio" name="radioDiaChi" value="diaChiKhac" id="diaChiKhac"  />
                                <span>Địa chỉ khác</span> 
                            </label>
                        </div>

                        <div id="my-address" style="display: none;margin-top: 20px;">
                            <div class="form-group  col-sm-12">
                                <label class="col-sm-3 text-right my-label">Họ tên</label>
                                <input name="hoTen" value="" class="form-control col-sm-7" />
                            </div>
                            <div class="form-group  col-sm-12">
                                <label class="col-sm-3 text-right my-label">Số điện thoại</label>
                                <input name="soDienThoai" value="" class="form-control col-sm-7" />
                            </div>
                            <div class="form-group  col-sm-12">
                                <label class="col-sm-3 text-right my-label">Tỉnh - Thành</label>
                                <select id="thanhPho" name="thanhPho" class="form-control">
                                    <option selected value="-1">Chọn thành phố</option>
                                    <option value="1">Hồ Chí Minh</option>
                                </select>
                            </div>
                            <div class="form-group  col-sm-12">
                                <label class="col-sm-3 text-right my-label">Quận - huyện</label>
                                <select id="quanHuyen" name="quanHuyen" class="form-control">
                                    <option selected value="-1">Chọn quận huyện</option>
                                </select>
                            </div>
                            <!--                        <div class="form-group  col-sm-12">
                                                        <label class="col-sm-3 text-right my-label">Phường - xã</label>
                                                        <select name="phuongXa" class="form-control">
                                                            <option value="1">Phường Bến Nghé</option>
                                                            <option>Hoàn kiếm</option>
                                                        </select>
                                                    </div>-->
                            <div class="form-group  col-sm-12">
                                <label class="col-sm-3 text-right my-label">Địa chỉ</label>
                                <input name="diaChi" value="" class="form-control col-sm-7" placeholder="Số nhà, tên đường" />
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-7">
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
            </div>

            <div class="clearfix"></div>
            <button type="submit" class=" btn btn-lg btn-warning " style="left: 89.6%; position: relative; margin-bottom: 10px">Xác nhận</button>
        </form>
    </div>
    <!--    <div class="col-sm-1"></div>-->
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

        $('#thanhPho').on('change', function (e) {
            var valueSelected = this.value;
            $.ajax({
                url: "order/get-quan-huyen.php",
                async: false, //block until we get a response
                data: {idThanhPho: valueSelected},
                success: function (response) {
                    var select = document.getElementById('quanHuyen');
                    $(select).empty();

                    // Add options
                    for (var i = 0; i < response.length; i++) {
                        var obj = response[i];
                        $(select).append('<option value=' + obj[0] + '>' + obj[1] + '</option>');
                    }

                },
                dataType: 'json'
            });
        });



    });

</script>
