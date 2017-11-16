<%-- 
    Document   : index
    Created on : Nov 16, 2017, 11:27:05 AM
    Author     : XinKaChu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kênh Người Bán</title>
        <!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/	js/bootstrap.min.js"></script>

	<link rel="stylesheet" type="text/css" href="style_merchant.css">
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
				<img src="pic/Layer 1.png" style="width: 60%; height: 250px;">
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
                                        <a href="#" onClick="$('#loginbox').hide(); $('#signupbox').show()" style="color: red;">
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
                            <div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" href="#" onclick="$('#signupbox').hide(); $('#loginbox').show()">Trở về Đăng nhập</a></div>
                        </div>  
                        <div class="panel-body" >
                            <form id="signupform" class="form-horizontal" role="form">
                                
                                <div id="signupalert" style="display:none" class="alert alert-danger">
                                    <p>Lỗi:</p>
                                    <span></span>
                                </div>
                                    
                                
                                  
                                <div class="form-group">
                                    <label for="email" class="col-md-4 control-label">Email</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" name="email" placeholder="Địa chỉ Email">
                                    </div>
                                </div>
                                    
                                <div class="form-group">
                                    <label for="firstname" class="col-md-4 control-label">Tên</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" name="firstname" placeholder="Tên">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="lastname" class="col-md-4 control-label">Họ</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" name="lastname" placeholder="Họ">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="password" class="col-md-4 control-label">Mật khẩu</label>
                                    <div class="col-md-8">
                                        <input type="password" class="form-control" name="passwd" placeholder="Mật khẩu">
                                    </div>
                                </div>
                                
								<div class="form-group">
                                    <label for="password" class="col-md-4 control-label">Nhập lại Mật khẩu</label>
                                    <div class="col-md-8">
                                        <input type="password" class="form-control" name="passwd" placeholder="Nhập lại Mật khẩu">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="icode" class="col-md-4 control-label">CMND</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" name="icode" placeholder="CMND">
                                    </div>
                                </div>

								<div class="form-group">
                                    <label for="icode" class="col-md-4 control-label">SĐT</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" name="icode" placeholder="SĐT">
                                    </div>
                                </div>

								<div class="form-group">
                                    <label for="icode" class="col-md-4 control-label">Địa chỉ</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" name="icode" placeholder="Địa chỉ">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <!-- Button -->                                        
                                    <div class="col-md-offset-3 col-md-9">
                                        <button id="btn-signup" type="button" class="btn btn-info"><i class="icon-hand-right"></i> &nbsp Sign Up</button>  
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
</html>



