<%-- 
    Document   : detail
    Created on : Dec 8, 2017, 11:11:50 AM
    Author     : DacTien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<div class="container">
    <div class="col-sm-12">
        <legend>Chi tiết đơn hàng</legend>
        <div class="col-sm-5">
            <form id="edit" action="account/edit.php" modelAttribute="nguoiMua" >
                <table class="table">
                    <tr>
                        <td class="text-right">Họ tên</td>
                        <td>
                            <input value="${phieuMuaHang.tenNguoiNhan}" type="text" class="form-control" />
                        </td>
                    </tr>
                    <tr>
                        <td class="text-right">Email</td>
                        <td>
                            <input value="${phieuMuaHang.email}" path="email" type="email" class="form-control"  />
                        </td>
                    </tr>
                    <tr>
                        <td class="text-right">Số điện thoại</td>
                        <td>
                            <input value="${phieuMuaHang.soDienThoai}" path="soDienThoai" type="text" class="form-control" />
                        </td>
                    </tr>
                    <tr>
                        <td class="text-right">Tổng tiền</td>
                        <td>
                            <input value="${phieuMuaHang.tongTien}" path="soDienThoai" type="text" class="form-control" />
                        </td>
                    </tr>
                </table>
            </form>
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
                                    <td>${p.idTinhTrang.tenMoTa}</td> 
                                    <c:if test="${p.idTinhTrang.id == 'TC' || p.idTinhTrang.id == 'DH'}">
                                        <td>
                                            <a href="#">
                                                Đánh giá
                                            </a>
                                        </td> 
                                    </c:if>
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

    .my-tenSanPham {
        overflow: hidden;
        text-overflow: ellipsis;
        max-width: 300px;
        white-space: nowrap;
    }
</style>
