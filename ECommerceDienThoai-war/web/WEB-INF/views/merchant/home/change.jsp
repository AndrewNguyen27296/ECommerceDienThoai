<%-- 
    Document   : change
    Created on : Dec 1, 2017, 7:33:04 AM
    Author     : XinKaChu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đổi mật khẩu</title>
    </head>
    <body>
    <h2 style="text-align: center;">Thay đổi mật khẩu</h2>
     <span style="color: red; margin-left: 450px;">${message}</span>
    <form class="form-horizontal" action="merchant/account/change.php" method="POST">

        <div class="form-group">
            <label class="control-label col-sm-6">Mật khẩu hiện tại:</label>
            <div class="col-sm-3">
                <input type="password" name="password" class="form-control" required="">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-6">Mật khẩu mới:</label>
            <div class="col-sm-3">
                <input type="password" name="password1" class="form-control" required="">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-6">Nhập lại mật khẩu mới:</label>
            <div class="col-sm-3">
                <input type="password" name="password2" class="form-control" required="">
            </div>
        </div>

        <div class="form-group" >
            <div class="text-center">
            <button class="btn btn-default" >
                <span class="glyphicon glyphicon-save"></span> 
                Thay đổi
            </button>
            </div>
        </div>
    </form>
    </body>
</html>
