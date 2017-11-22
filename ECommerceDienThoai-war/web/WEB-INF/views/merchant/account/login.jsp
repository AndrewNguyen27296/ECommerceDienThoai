<%-- 
    Document   : login
    Created on : Nov 18, 2017, 4:02:54 PM
    Author     : XinKaChu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>

    <meta charset="utf-8">
    <title></title>
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


<body class="col-lg-12" style="padding: 0;">
    <div class="header col-lg-12">
        <div class="row col-lg-12">
            <div class="logo col-lg-2"></div>
            <div class="DIGIWORLD col-lg-4">DIGIWORLD</div>
            <div class="logo2 col-lg-7">Kênh Người Bán</div>
        </div>
    </div>
    <div class="col-md-12">
        <div class="col-md-6">
            <div class="col-md-12" id="slogan1">Bán hàng chuyên nghiệp
                <div class="col-md-12" id="slogan2">Quản lý shop của bạn một cách hiệu quả hơn trên DigiWorld với DigiWorld - Kênh Người bán</div>
            </div>
            <div class="col-md-12 text-center" id="bg">
                <img src="assets/merchant/images/Layer 1.png" style="width: 60%;
                     height: 250px;">
            </div>
        </div>
        <div class="col-md-6">
            <div class="container col-md-12">    
                <div id="loginbox" style="margin-top:70px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
                    <div class="panel panel-info" >
                        <div class="panel-heading">
                            <div class="panel-title">Đăng Nhập</div>
                            <div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="#">Quên mật khẩu?</a></div>
                        </div>     

                        <div style="padding-top:30px" class="panel-body" >

                            <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>

                            <form id="loginform" class="form-horizontal" role="form">

                                <div style="margin-bottom: 25px" class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                    <input id="login-username" type="text" class="form-control" name="username" value="" placeholder="tên tài khoản hoặc email">                                        
                                </div>

                                <div style="margin-bottom: 25px" class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                    <input id="login-password" type="password" class="form-control" name="password" placeholder="mật khẩu">
                                </div>



                                <div class="input-group">
                                    <div class="checkbox">
                                        <label>
                                            <input id="login-remember" type="checkbox" name="remember" value="1">
                                            Nhớ tài khoản
                                        </label>
                                    </div>
                                </div>


                                <div style="margin-top:10px" class="form-group">
                                    <!-- Button -->

                                    <div class="col-sm-12 controls">
                                        <a id="btn-login" href="#" class="btn btn-primary">Đăng nhập  </a>


                                    </div>
                                </div>


                                <div class="form-group">
                                    <div class="col-md-12 control">
                                        <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                            Không có tài khoản ? 
                                            <a  onClick="$('#loginbox').hide(); $('#signupbox').show()" style="color: red; cursor:pointer;">
                                                Đăng ký ngay!
                                            </a>
                                        </div>
                                    </div>
                                </div>    
                            </form>                        </div>                     
                    </div>  
                </div>
                <div id="signupbox" style="display:none; margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <div class="panel-title">Đăng ký</div>
                            <div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" onclick="$('#signupbox').hide(); $('#loginbox').show()" style="cursor:pointer;">Trở về Đăng nhập</a></div>
                        </div>  
                        <div class="panel-body" >
                            <form id="signupform" class="form-horizontal" role="form" modelAttribute="merchant">

                                <div id="signupalert" style="display:none" class="alert alert-danger">
                                    <p>Lỗi:</p>
                                    <span></span>
                                </div>



                                <div class="form-group">
                                    <label for="email" class="col-md-4 control-label">Email</label>
                                    <div class="col-md-8">
                                        <input path="email" type="email" class="form-control" name="email" placeholder="Địa chỉ Email">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="firstname" class="col-md-4 control-label">Họ Tên</label>
                                    <div class="col-md-8">
                                        <input path="name" type="text" class="form-control" name="firstname" placeholder="Tên" required="">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="password" class="col-md-4 control-label">Mật khẩu</label>
                                    <div class="col-md-8">
                                        <input type="password" class="form-control" name="passwd" placeholder="Mật khẩu" required="" id="password">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="password" class="col-md-4 control-label">Nhập lại Mật khẩu</label>
                                    <div class="col-md-8">
                                        <input type="password" class="form-control" name="passwd" placeholder="Nhập lại Mật khẩu" required="" id="confirm-password">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="icode" class="col-md-4 control-label">CMND</label>
                                    <div class="col-md-8">
                                        <input id="CMND" type="text" minlength="9" maxlength="12" class="form-control" name="icode" placeholder="CMND" required="">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="icode" class="col-md-4 control-label">SĐT</label>
                                    <div class="col-md-8">
                                        <input id="soDienThoai" type="text" class="form-control" name="icode" placeholder="SĐT" required="">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="icode" class="col-md-4 control-label">Địa chỉ</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" name="icode" placeholder="Địa chỉ" required="">
                                    </div>
                                </div>

                                <span id="error"></span>
                                <div class="form-group">
                                    <!-- Button -->                                        
                                    <div class="col-md-offset-3 col-md-9">
                                        <button id="btn-signup" type="button" class="btn btn-info"><i class="icon-hand-right"></i> Đăng ký</button>  
                                    </div>
                                </div>

                            </form>
                        </div>
                    </div>




                </div> 
            </div>

        </div>
    </div>
</body>

<script>
    $(function () {
        //$('#myModal88').modal('show');
        //
        //kiểm tra xác nhận password có trùng nhau hay không
        function checkPasswordMatch() {
            var password = $("#password").val();
            var confirmPassword = $("#confirm-password").val();
            if (password != confirmPassword)
                $("#error").html("Mật khẩu không trùng khớp");
            else
                $("#error").html("");
        }
        $("#password, #confirm-password").keyup(checkPasswordMatch);
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
        
        //validate email và name
        $(#merchant).validate({
            rules:{
                email:{email:true, required:true},
                name:{required:true}
            },
            messages:{
                email:{
                    email:'Không đúng định dạng email',
                    required:'Không được để trống địa chỉ email'
                },
                name:{
                    required:'Không được để trống tên'
                }
            }
        });
    });
</script>  
