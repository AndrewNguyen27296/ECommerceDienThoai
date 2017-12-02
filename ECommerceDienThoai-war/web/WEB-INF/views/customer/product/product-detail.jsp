<%-- 
    Document   : product-detail
    Created on : Nov 28, 2017, 11:52:01 PM
    Author     : DacTien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %> 
<script src="assets/customer/js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="assets/customer/js/jquery-ui.js" type="text/javascript"></script>
<!-- SHopping-cart -->
<script src="assets/customer/js/shopping-cart.js"></script>

<style id="nn-cart-fly">

</style>

<div style="padding-left: 10px; padding-right: 10px">
    <div class="product-detail">
        <div class="product-detail-left">
            <img id="img-product" src="assets/images/products/${sanpham.hinhAnh}">
        </div>

        <div class="product-detail-right">
            <div class="product-detail-info">
                <div class="product-detail-info-header">
                    <div class="product-detail-info-header__main">
                        <div class="product-detail-info-header__title">
                            <h3>${sanpham.tenMay}</h3>
                        </div>
                        <div class="product-detail-info-header__price">
                            <div class="product-detail-info-header__price-real-price">
                                <fmt:formatNumber type="number" value="${sanpham.giaBan}" pattern="###,###,###" /> VND
                            </div>
                        </div>
                    </div>
                </div>
                <div class="product-detail-info-body">
                    <div class="seller-left">
                        <img class="img-rounded" src="assets/images/store.png">
                    </div>
                    <div class="seller-right">
                        <span>Sản phẩm được cung cấp bởi: <a>${sanpham.idNguoiBan.hoTen}</a></span>
                        <br>
                        <span>Điểm: 4/5</span>
                    </div>
                </div>
                <div class="product-detail-info-footer">
                    <input type="hidden" name="add" id="add" value="${sanpham.id}" />
                    <button class="btn btn-danger" id="btn-add-to-cart" >Thêm vào giỏ hàng</button>
                </div>
            </div>
        </div>
    </div>
    <div class="product-tab-container">
        <div class="product-tab-header">
            <div class="product-tab-header-item">
                <div class="product-page__tab-link">THÔNG TIN SẢN PHẨM</div>
            </div>
        </div>
        <div class="product-detail-content">
            <div class="product-detail-content__description">
                ${sanpham.moTa}
            </div>
            <div class="product-detail-content__parameters">
                <table class="table table-bordered table-condensed">
                    <tr>
                        <th>Hãng</th>
                        <td>${sanpham.idHangSanXuat.tenHang}</td>
                    </tr>
                    <tr>
                        <th>Kích thước màn hình</th>
                        <td>${sanpham.kichThuocManHinh}</td>
                    </tr>
                    <tr>
                        <th>CPU</th>
                        <td>${sanpham.cpu}</td>
                    </tr>
                    <tr>
                        <th>Tốc độ CPU</th>
                        <td>${sanpham.tocDoCpu}</td>
                    </tr>
                    <tr>
                        <th>Ram</th>
                        <td>${sanpham.ram}</td>
                    </tr>
                    <tr>
                        <th>Bộ nhớ trong</th>
                        <td>${sanpham.boNhoTrong}</td>
                    </tr>
                    <tr>
                        <th>Hệ điều hành</th>
                        <td>${sanpham.heDieuHanh}</td>
                    </tr>
                    <tr>
                        <th>Camera trước</th>
                        <td>${sanpham.cameraTruoc}</td>
                    </tr>
                    <tr>
                        <th>Camera sau</th>
                        <td>${sanpham.cameraSau}</td>
                    </tr>
                    <tr>
                        <th>Dung lượng pin</th>
                        <td>${sanpham.dungLuongPin}</td>
                    </tr>
                    <tr>
                        <th>Hỗ trợ thẻ nhớ</th>
                        <td>${sanpham.theNhoNgoai}</td>
                    </tr>
                    <tr>
                        <th>Kháng nước</th>
                        <td>${sanpham.khangNuoc}</td>
                    </tr>
                    <tr>
                        <th>Bảo hành</th>
                        <td>${sanpham.baoHanh}</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</div>


