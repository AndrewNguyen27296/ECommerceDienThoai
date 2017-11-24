<%-- 
    Document   : edit
    Created on : Nov 23, 2017, 6:46:27 AM
    Author     : DacTien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!--<div class="list-inline my-edit-accout-left">
    <ul class="list-unstyled">
        <li class="list-group-item">
            <a href="#">Thông tin tài khoản</a>
        </li>
        <li class="list-group-item">
            <a href="#">Đổi mật khẩu</a>
        </li>
        <li class="list-group-item">
            <a href="#">Địa chỉ</a>
        </li>
        <li class="list-group-item">
            <a href="#">Đơn hàng của tôi</a>
        </li>
    </ul>
</div>
<div class="my-edit-accout-right">
    
</div>
<div class="clearfix"></div>-->
<h3>Hồ sơ của tôi</h3>
<div style="margin-top: 5px; font-size: 15px">
    Quản lý thông tin hồ sơ để bảo mật tài khoản
</div>
<hr>

<div class="col-sm-8">
    <form:form id="edit" action="account/edit.php" modelAttribute="nguoiMua" >
        <table class="table">
            <tr>
                <td class="text-right">Họ tên</td>
                <td>
                    <form:input path="hoTen" type="text" cssClass="form-control" />
                    <form:hidden path="id"/>
                </td>
            </tr>
            <tr>
                <td class="text-right">Email</td>
                <td>
                    <form:input path="email" type="email" cssClass="form-control"  />
                </td>
            </tr>
            <tr>
                <td class="text-right">Số điện thoại</td>
                <td>
                    <form:input path="soDienThoai" type="text" cssClass="form-control" maxlength="11" minLength="10"/>
                    <span style="color: red">${message}</span>
                </td>
            </tr>
            <tr>
                <td class="text-right"></td>
                <td>
                    <button type="submit" class="btn btn-danger">Cập nhật</button>
                </td>
            </tr>
        </table>
    </form:form>
</div>

<script>
    $("#soDienThoai").keydown(function (e) {
                    // Allow: backspace, delete, tab, escape, enter and .
                    if ($.inArray(e.keyCode, [8]) !== -1 ||
                            // Allow: home, end, left, right
                                    (e.keyCode >= 35 && e.keyCode <= 39)) {
                        // let it happen, don't do anything
                        return;
                    }
                    // Ensure that it is a number and stop the keypress
                    if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
                        e.preventDefault();
                    }
                });
</script>