<%-- 
    Document   : change
    Created on : Nov 24, 2017, 11:44:01 AM
    Author     : DacTien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-sm-8">
    <form id="edit" action="account/change.php" method="post" >
        <table class="table">
            <tr>
                <td class="text-right">Mật khẩu hiện tại</td>
                <td>
                    <input name="matKhau" type="password" class="form-control" />
                </td>
            </tr>
            <tr>
                <td class="text-right">Mật khẩu mới</td>
                <td>
                    <input name="matKhau1" type="password" class="form-control"  />
                </td>
            </tr>
            <tr>
                <td class="text-right">Xác nhận mật khẩu mới</td>
                <td>
                    <input name="matKhau2" type="password" class="form-control" />
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
    </form>

</div>
