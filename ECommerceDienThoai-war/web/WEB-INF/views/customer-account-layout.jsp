<%-- 
    Document   : customer-account-layout
    Created on : Nov 23, 2017, 6:48:42 AM
    Author     : DacTien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" utf-8>
    <head>
        <title>DIGIWORLD</title>
        <base href="${pageContext.request.contextPath}/">
        <!-- for-mobile-apps -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Electronic Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
              SmartPhone Compatible web template, free web designs for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
            function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- //for-mobile-apps -->
        <!-- Custom Theme files -->
<!--        <link href="../../assets/customer/css/bootstrap.css" rel="stylesheet" type="text/css"/>-->
        <link href="assets/customer/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link href="assets/customer/css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link href="assets/customer/css/fasthover.css" rel="stylesheet" type="text/css" media="all" />
        <link href="assets/customer/css/popuo-box.css" rel="stylesheet" type="text/css" media="all" />
        <link href="assets/customer/css/my-css.css" rel="stylesheet" type="text/css" media="all" />

        <!-- //Custom Theme files -->
        <!-- font-awesome icons -->
        <link href="assets/customer/css/font-awesome.css" rel="stylesheet"> 
        <!-- //font-awesome icons -->
        <!-- js -->
        <script src="assets/customer/js/jquery.min.js"></script>
        <link rel="stylesheet" href="assets/customer/css/jquery.countdown.css" /> <!-- countdown --> 
        <!-- //js -->  
        <!-- web fonts --> 
        <!-- <link href='//fonts.googleapis.com/css?family=Glegoo:400,700' rel='stylesheet' type='text/css'>
        <link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'> -->
        <!-- //web fonts -->  
        <!-- start-smooth-scrolling -->
        <script type="text/javascript">
jQuery(document).ready(function ($) {
    $(".scroll").click(function (event) {
        event.preventDefault();
        $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
    });
});
        </script>
        <!-- //end-smooth-scrolling --> 
    </head> 
    <body>
        <!-- for bootstrap working -->
        <script type="text/javascript" src="assets/customer/js/bootstrap-3.1.1.min.js"></script>
        <!-- //for bootstrap working -->
        
        <!-- HEADER -->
        <jsp:include page="customer/layout/header.jsp"></jsp:include>
        
        <!-- BANNER -->
        <jsp:include page="customer/layout/banner.jsp"></jsp:include>

        <!-- NOI DUNG -->
        <div class="banner-bottom" style="padding-top: 20px; background-color: whitesmoke;">
            <div class="list-inline my-edit-accout-left">
                <ul class="list-unstyled">
                    <li class="list-group-item">
                        <a href="account/edit.php">
                            <span class="glyphicon glyphicon-user"></span>
                            Thông tin tài khoản
                        </a>
                    </li>
                    <li class="list-group-item">
                        <a href="account/change.php">
                            <span class="glyphicon glyphicon-lock"></span>   
                            Đổi mật khẩu
                        </a>
                    </li>
<!--                    <li class="list-group-item">
                        <a href="#">
                            <span class="glyphicon glyphicon-home"></span>
                            Địa chỉ
                        </a>
                    </li>-->
                    <li class="list-group-item">
                        <a href="order/history.php">
                            <span class="glyphicon glyphicon-file"></span>
                            Đơn hàng của tôi
                        </a>
                    </li>
                </ul>
            </div>
            <div class="my-edit-accout-right">
                <jsp:include page="${param.view}"></jsp:include>
            </div>
            
            <div class="clearfix"></div>
        </div>

        <!-- FOOTER -->
        <jsp:include page="customer/layout/footer.jsp"></jsp:include>
    </body>
</html>
