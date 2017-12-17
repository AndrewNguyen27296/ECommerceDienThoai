<%-- 
    Document   : forgot-password
    Created on : Dec 3, 2017, 12:24:11 AM
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
</div>


<script>
    $(function () {
        //ô nhập SĐT chỉ được nhập số
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
    });
</script>  
