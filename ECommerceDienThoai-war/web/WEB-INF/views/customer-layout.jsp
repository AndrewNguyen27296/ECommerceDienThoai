<%-- 
    Document   : customer-layout
    Created on : Nov 16, 2017, 4:13:16 PM
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
        
        <!-- SHopping-cart -->
        <script src="assets/customer/js/shopping-cart.js" type="text/javascript"></script>
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
        <div class="banner-bottom" style="padding-top: 20px;">
            <jsp:include page="${param.view}"></jsp:include>
        </div>

        <!-- FOOTER -->
        <jsp:include page="customer/layout/footer.jsp"></jsp:include>
        
        <!-- cart-js -->
        <script src="assets/customer/js/minicart.js"></script>
        <script>
            w3ls.render();

            w3ls.cart.on('w3sb_checkout', function (evt) {
                var items, len, i;

                if (this.subtotal() > 0) {
                    items = this.items();

                    for (i = 0, len = items.length; i < len; i++) {
                    }
                }
            });
        </script>  
        <!-- //cart-js -->   
    </body>
</html>
