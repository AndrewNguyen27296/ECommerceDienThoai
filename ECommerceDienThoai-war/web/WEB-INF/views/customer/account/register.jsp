<%-- 
    Document   : login
    Created on : Dec 4, 2017, 11:29:32 PM
    Author     : DacTien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container" style="width: 100%">
    <div class="col-sm-8">
        <form action="account/forgot-password.php" method="post">
            <table class="table ">
                <tr>
                    <td class="text-right col-sm-6">Email</td>
                    <td class="col-sm-4">
                        <input name="email" type="email" class="form-control" />
                    </td>
                </tr>
                <tr>
                    <td class="text-right col-sm-6">Số điện thoại</td>
                    <td class="col-sm-4">
                        <input name="soDienThoai" type="text" class="form-control" />
                        <span style="color: red">${message}</span>
                    </td>
                </tr>
                <tr>
                    <td class="text-right col-sm-6"></td>
                    <td class="col-sm-4">
                        <button type="submit" class="btn btn-warning">Reset mật khẩu</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>ss
