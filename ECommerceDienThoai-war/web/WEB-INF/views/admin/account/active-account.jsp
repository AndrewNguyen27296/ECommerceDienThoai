<%-- 
    Document   : active-account
    Created on : Nov 21, 2017, 8:19:39 PM
    Author     : DacTien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Kích hoạt tài khoản</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row text-center" style="margin-bottom: 20px; text-align: center;">
    <div class="input-group custom-search-form" style="display: flex;padding-left: 15px;">
        <input class="form-control" placeholder="Nhập email" type="text" style="width: 25%;">
        <span class="input-group-btn">
            <button class="btn btn-primary" type="button">
                <i class="fa fa-search"></i>
            </button>
        </span>
    </div>
</div>

<div class="row">
    <div class="col-lg-12">
        ${mess}
        <table class="table table-bordered table-striped">
            <tr style="text-align: center">
                <th>Email</th>
                <th>Họ tên</th>
                <th>Số CMND</th>
                <th>SĐT</th>
                <th>Địa chỉ</th>
                <th>Trạng Thái</th>
                <th></th>
            </tr>
            <c:forEach var="i" items="${list}" >
                <tr>
                    <td>${i.email}</td>
                    <td>${i.hoTen}</td>
                    <td>${i.cmnd}</td>
                    <td>${i.soDienThoai}</td>
                    <td>${i.diaChi}</td>
                    <c:choose>
                        <c:when test="${i.kichHoat == false}">
                            <td>Chưa kích hoạt</td>
                        </c:when>
                        <c:otherwise>
                            <td>Đã kích hoạt</td>
                        </c:otherwise>
                    </c:choose>
                    <td>
                        <a href="admin/active-account/${i.id}.php">Kích hoạt</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <!-- /.col-lg-12 -->
</div>


