<%-- 
    Document   : myaccount
    Created on : Nov 30, 2017, 9:10:28 AM
    Author     : XinKaChu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý tài khoản</title>
        
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="assets/merchant/css/bootstrap.min.css">
        
        <!-- jQuery library -->
        <script src="assets/merchant/js/jquery.min.js"></script>
    
    </head>
    <body>
        <h1>Thông tin tài khoản</h1>
        <form class="form-horizontal">
            <div class="form-group">
                <label class="control-label col-sm-2 ">Email:</label>
                <label class="control-label col-sm-2" style="text-align: left">${sessionScope.nguoiBan.email}</label>
            </div>
            
            <div class="form-group">
                <label class="control-label col-sm-2 ">Họ Tên:</label>
                <label class="control-label col-sm-2" style="text-align: left">${sessionScope.nguoiBan.hoTen}</label>
            </div>
            
            <div class="form-group">
                <label class="control-label col-sm-2 ">CMND:</label>
                <label class="control-label col-sm-2" style="text-align: left">${sessionScope.nguoiBan.cmnd}</label>
            </div>
            
            <div class="form-group">
                <label class="control-label col-sm-2 ">Số Điện Thoại:</label>
                <label class="control-label col-sm-2" style="text-align: left">${sessionScope.nguoiBan.soDienThoai}</label>
            </div>
            
            <div class="form-group">
                <label class="control-label col-sm-2 ">Địa Chỉ:</label>
                <label class="control-label col-sm-2" style="text-align: left">${sessionScope.nguoiBan.diaChi}</label>
            </div>
            
            <div class="form-group">
                <a href="merchant/account/edit.php" class="btn btn-warning">Sửa Thông Tin</a>
                <a href="merchant/account/change.php" class="btn btn-info">Đổi Mật Khẩu</a>
            </div>
            
        </form>
    </body>
</html>
