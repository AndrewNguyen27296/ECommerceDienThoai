<%-- 
    Document   : detail
    Created on : Dec 16, 2017, 2:45:05 PM
    Author     : DacTien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<div class="row">
    <div class="col-lg-6">
        <h1 class="page-header">Chi tiết phiếu mua hàng</h1>
    </div>
</div>
<div class="row">
    <div class="col-sm-12">
        <div class="col-sm-5">
            <table class="table">
                <tr>
                    <td class="text-right">Người nhận</td>
                    <td>
                        <input value="${phieuMuaHang.tenNguoiNhan}" type="text" class="form-control" />
                    </td>
                </tr>
                <!--                    <tr>
                                        <td class="text-right">Email</td>
                                        <td>
                                            <input value="${phieuMuaHang.email}" path="email" type="email" class="form-control"  />
                                        </td>
                                    </tr>-->
                <tr>
                    <td class="text-right">Số điện thoại</td>
                    <td>
                        <input value="${phieuMuaHang.soDienThoai}" path="soDienThoai" type="text" class="form-control" />
                    </td>
                </tr>
                <tr>
                    <td class="text-right">Địa chỉ giao</td>
                    <td>
                        <input value="${phieuMuaHang.diaChiGiao }" 
                               type="text" class="form-control" />
                    </td>
                </tr>
                <tr>
                    <td class="text-right">Quận huyện</td>
                    <td>
                        <input value="${phieuMuaHang.idQuanHuyen.tenQuanHuyen}" 
                               type="text" class="form-control" />
                    </td>
                </tr>
                <tr>
                    <td class="text-right">Tỉnh thành phố</td>
                    <td>
                        <input value="${phieuMuaHang.idThanhPho.tenThanhPho}" 
                               type="text" class="form-control" />
                    </td>
                </tr>
                <tr>
                    <td class="text-right">Tổng tiền</td>
                    <td>
                        <input value="${phieuMuaHang.tongTien}" path="soDienThoai" type="text" class="form-control" pattern="###,###,###" />
                    </td>
                </tr>
            </table>
        </div>
        <div class="col-sm-7"></div>
        <div class="col-sm-12">
            <c:forEach var="nguoiBan" items="${listNguoiBan}" >
                <span style="float: left">Shop: ${nguoiBan.hoTen} - </span>
                <div style="float: left; margin-left: 5px">
                    <span>SĐT: ${nguoiBan.soDienThoai}</span>
                    <br>
                    <span>Email: ${nguoiBan.email}</span>
                </div>
                <div class="clearfix"></div>
                <table id="my-shopping-cart" class="table table-striped" style="margin-top: 10px">
                    <thead>
                        <tr>
                            <th>Tên sản phẩm</th>
                            <th>Đơn giá</th>
                            <th>Số lượng</th>
                            <th>Thành tiền</th>
                            <th>Tình trạng</th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="p" items="${ctPhieuMuaHang}" >
                            <c:if test="${p.idNguoiBan.id == nguoiBan.id}">
                                <tr>
                                    <td class="my-tenSanPham">${p.idSanPham.tenMay}</td>
                                    <td >
                                        <fmt:formatNumber type="number" value="${p.giaBan}" pattern="###,###,###"/>
                                        VND
                                    </td>
                                    <td>${p.soLuongMua}</td>
                                    <td>
                                        <fmt:formatNumber type="number" value="${p.giaBan * p.soLuongMua}" pattern="###,###,###"/>
                                        VND
                                    </td>
                                    <c:choose>
                                        <c:when test="${p.idTinhTrang.id == 'XL'}" >
                                            <td>Đang xử lý</td>
                                        </c:when>
                                        <c:when test="${p.idTinhTrang.id == 'DG'}" >
                                            <td>Đang giao</td>
                                        </c:when>
                                        <c:when test="${p.idTinhTrang.id == 'TC'}" >
                                            <td>Thành công</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>Đã hủy</td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </tbody>
                </table>
            </c:forEach>
        </div>
    </div>
    
</div>

<style>
    th {
        text-align: center;
    }
    td {
        text-align: center;
    }

    .my-tenSanPham {
        overflow: hidden;
        text-overflow: ellipsis;
        max-width: 300px;
        white-space: nowrap;
    }
</style>
