<%-- 
    Document   : post
    Created on : Dec 10, 2017, 1:54:52 PM
    Author     : XinKaChu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng tin</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="assets/merchant/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="assets/merchant/js/jquery.min.js"></script>

        <!-- Paypal library -->
        <script src="https://www.paypalobjects.com/api/checkout.js"></script>
    </head>
    <body>
        <h1 class="text-center">Đăng tin mới</h1>
        
        <!-- Hiển thị số tin tồn -->
        <p>Số gói tin còn lại của bạn: <span style="color:red;">${soTinTon}</span></p>
        
        <form action="" enctype="multipart/form-data" class="form-horizontal">
            <div class="row">
		<div class="form-group">
                    <label class="control-label col-sm-3">Tên máy: </label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" required="" name="tenMay" placeholder="Nhập tên máy..."/>
                    </div>
		</div>
            </div>
            
            <div class="row">
		<div class="form-group">
                    <label class="control-label col-sm-3">Hình ảnh: </label>
                    <div class="col-sm-5">
                        <input type="file" class="form-control" required="" name="hinhAnh"/>
                    </div>
		</div>
            </div>
        </form>
        
        
    </body>
</html>
