<%-- 
    Document   : purchase-detail
    Created on : Dec 18, 2017, 6:09:21 PM
    Author     : DacTien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thông tin chi tiết đơn hàng</title>
    </head>
    <body>
        <form class="form-horizontal" action="" method="POST">

            <div class="form-group">
                <label>Người Mua :</label>
                <label>${ctPhieuMuaHang.idPhieuMuaHang.tenNguoiNhan}</label>
            </div>

            <div class="form-group">
                <label>Sản Phẩm :</label>
                <label >${ctPhieuMuaHang.idSanPham.tenMay}</label>
            </div>

            <div class="form-group">
                <label>Số Lượng :</label>
                <label>${ctPhieuMuaHang.soLuongMua}</label>
            </div>

            <div class="form-group">
                <label>Thành Tiền :</label>
                <label><fmt:formatNumber value="${ctPhieuMuaHang.thanhTien}" pattern="###,###,### VND" /></label>
            </div>
            
            <div class="form-group">
                <label>Ngày Đặt :</label>
                <label><fmt:formatDate pattern="dd-MM-yyyy" value="${ctPhieuMuaHang.idPhieuMuaHang.ngayDatHang}"></fmt:formatDate></label>
            </div>

            <div class="form-group">
                <label>Ngày Giao :</label>
                <c:choose>
                    <c:when test="${ctPhieuMuaHang.ngayGiaoHang == null}">
                        <label>Chưa giao</label>
                    </c:when>
                    <c:otherwise>
                        <label><fmt:formatDate pattern="dd-MM-yyyy" value="${ctPhieuMuaHang.ngayGiaoHang}"></fmt:formatDate></label>
                    </c:otherwise>
                </c:choose>
            </div>

            <div class="form-group">
                <label>Tình Trạng :</label>
                
                    <c:choose>
                        <c:when test="${ctPhieuMuaHang.idTinhTrang.id == 'XL'}">
                            <select name="tinhTrang">
                                <option value="XL" selected="true">Đang xử lý</option>
                                <option value="DG">Đang giao</option>
                                <option value="TC">Thành công</option>
                                <option value="DH">Bị hủy</option>
                            </select>
                        </c:when>
                        <c:when test="${ctPhieuMuaHang.idTinhTrang.id == 'DG'}">
                            <select name="tinhTrang">
                                <option value="DG" selected="true">Đang giao</option>
                                <option value="TC">Thành công</option>
                                <option value="DH">Bị hủy</option>
                            </select>
                        </c:when>
                        <c:when test="${ctPhieuMuaHang.idTinhTrang.id == 'TC'}">
                            <select name="tinhTrang">
                                <option value="TC" selected="true">Thành công</option>
                            </select>
                        </c:when>
                        <c:when test="${ctPhieuMuaHang.idTinhTrang.id == 'DH'}">
                            <select name="tinhTrang">
                                <option value="DH" selected="true">Bị hủy</option>
                            </select>
                        </c:when>
                    </c:choose>
                    
            </div>

            <div class="form-group">
                <button class="btn btn-info" type="submit" formaction="merchant/bill/detail/${ctPhieuMuaHang.id}.php" formmethod="POST">
                    <span class="glyphicon glyphicon-search"></span> 
                    Cập nhật
                </button>
            </div>
        </form>
    </body>
</html>
