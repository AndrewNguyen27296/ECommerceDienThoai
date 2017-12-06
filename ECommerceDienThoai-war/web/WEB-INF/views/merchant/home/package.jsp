<%-- 
    Document   : package
    Created on : Dec 2, 2017, 9:24:08 AM
    Author     : XinKaChu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý đăng tin</title>
    </head>
    <body>
        <h2>Số gói tin còn lại của bạn: <span style="color:red;">${soTinTon}</span></h2>
        
        
        <a href="merchant/package/purchase.php" class="btn btn-info">Mua tin</a> 
        <a href="" class="btn btn-danger">Lịch sử mua tin</a>
        <a href="" class="btn btn-warning">Các tin đã đăng</a>
    </body>
</html>
