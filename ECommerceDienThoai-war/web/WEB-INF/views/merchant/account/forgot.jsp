<%-- 
    Document   : forgot
    Created on : Dec 1, 2017, 11:50:38 PM
    Author     : XinKaChu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quên mật khẩu</title>
        <base href="${pageContext.request.contextPath}/">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
        <script src="assets/merchant/js/jquery.min.js" type="text/javascript"></script>
        <script src=""></script>
        <script src="assets/merchant/js/jquery.validate.min.js" type="text/javascript"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <link rel="stylesheet" type="text/css" href="">
        <link href="assets/merchant/css/style_merchant.css" rel="stylesheet" type="text/css"/>
        <link href="assets/merchant/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/merchant/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
    </head>
    
    <body>
        <div class="header col-lg-12">
            <div class="row col-lg-12">
                <div class="logo col-lg-2 pull-right">
                    <img src="assets/merchant/images/2.png" class="pull-right" alt=""/>
                </div>
                <div class="DIGIWORLD col-lg-4">DIGIWORLD</div>
                <div class="logo2 col-lg-7">Kênh Người Bán</div>
            </div>
        </div>
        
        <div class="col-md-12" style="padding: 20px">
            <h1>Quên mật khẩu</h1>
            <span style="color:red;">${message}</span>
            <form class="form-horizontal" action="merchant/account/forgot.php" method="POST">

                    <div class="form-group">
                            <label>Email:</label>
                            <input name="email" class="form-control">
                    </div>
                    <div class="form-group">
                            <button class="btn btn-info">
                                    <span class="glyphicon glyphicon-search"></span> 
                                    Lấy lại mật khẩu
                            </button>
                    </div>
            </form>
        </div>
    </body>
</html>
