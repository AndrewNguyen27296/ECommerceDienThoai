<%-- 
    Document   : rating
    Created on : Dec 15, 2017, 1:47:47 PM
    Author     : DacTien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<script src="js/shopping-cart.js"></script>

<div class="col-sm-12">
    <c:choose>
        <c:when test="${empty rating}">
            <div class="text-center">Không có sản phẩm nào để đánh giá</div>
        </c:when>
        <c:otherwise>
            <h4>Đánh giá sản phẩm</h4>
            <table class="table" >
                <thead>
                    <tr>
                        <th>Tên SP</th>
                        <!--                <th>Ngày mua</th>-->
                        <th>Giá</th>
                        <th>Số lượng mua</th>
                        <th>Người bán</th>
                        <th>Đánh giá</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="l" items="${rating}">
                        <tr>
                            <td>${l.idSanPham.tenMay}</td>
                            <!--                    <td>
                            <fmt:formatDate value="${l.idPhieuMuaHang.ngayDatHang}" pattern="dd-MM-yyyy" />
                        </td>-->
                            <td>
                                <fmt:formatNumber value="${l.idSanPham.giaBan}" pattern="###,###,### VND"/>
                            </td>
                            <td>${l.soLuongMua}</td>
                            <!--                <td>
                                                <a class="btn" data-cart-add="">Thêm vào
                                                    <i class="icon-shopping-cart" style="font-size: 20px"></i>
                                                </a>
                                            </td>-->
                            <td>${l.idSanPham.idNguoiBan.hoTen}</td>
                            <td>
                                <select name="rating" style="width: 60px">
                                    <option value="1" selected="">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                </select>
                            </td>
                            <td>
                                <button class="btn btn-sm btn-warning my-ratting-button" data-id-merchant="${l.idNguoiBan.id}" 
                                        data-rating="1" data-id-CT-PMH="${l.id}">
                                    Xác nhận
                                </button>
                            </td>
                        </tr>

                    </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
</div>

<style>
    th {
        text-align: center;
    }
</style>

<script>
    $(function () {
        $("select").change(function () {
            var rating = $(this).val();
            //alert(rating);
            button = $(this).parents("tr").find(".my-ratting-button");
            button.attr("data-rating", rating);
        });

        /**
         * xoa khoi gio hang
         */
        $("button[data-id-merchant]").click(function () {
            var idNguoiBan = $(this).attr("data-id-merchant");
            var rating = $(this).attr("data-rating");
            var idCT_PHM = $(this).attr("data-id-CT-PMH")
            $.ajax({
                url: "order/rated.php",
                async: false,
                data: {idNguoiBan: idNguoiBan, rating: rating, idCT_PhieuMuaHang: idCT_PHM},
                success: function (response) {
                    $(this).parents("tr").hide(300);
                }
            });
        });
    });
</script>
