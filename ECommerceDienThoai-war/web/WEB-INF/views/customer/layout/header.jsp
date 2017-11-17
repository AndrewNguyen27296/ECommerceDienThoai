<%-- 
    Document   : header
    Created on : Nov 16, 2017, 3:32:02 PM
    Author     : DacTien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="modal fade" id="myModal88" tabindex="-1" role="dialog" aria-labelledby="myModal88"
     aria-hidden="true">
    <div class="modal-dialog modal-lg" style="width: 40%;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;</button>
                <h4 class="modal-title" id="myModalLabel">Don't Wait, Login now!</h4>
            </div>
            <div class="modal-body modal-body-sub">
                <div class="row">
                    <div class="col-md-12 modal_body_left modal_body_left1">
                        <div class="sap_tabs">	
                            <div id="horizontalTab" style="display: block; width: 100%; margin: 0px;">
                                <ul>
                                    <li class="resp-tab-item" aria-controls="tab_item-0"><span>Sign in</span></li>
                                    <li class="resp-tab-item" aria-controls="tab_item-1"><span>Sign up</span></li>
                                </ul>		
                                <div class="tab-1 resp-tab-content" aria-labelledby="tab_item-0">
                                    <div class="facts">
                                        <div class="register">
                                            <form action="#" method="post">			
                                                <input name="Email" placeholder="Email Address" type="text" required="">						
                                                <input name="Password" placeholder="Password" type="password" required="">										
                                                <div class="sign-up">
                                                    <input type="submit" value="Sign in"/>
                                                </div>
                                            </form>
                                        </div>
                                    </div> 
                                </div>	 
                                <div class="tab-2 resp-tab-content" aria-labelledby="tab_item-1">
                                    <div class="facts">
                                        <div class="register">
                                            <form action="account/register.php" method="post">			
                                                <input placeholder="Họ Tên" name="hoTen" type="text" required="">
                                                <input placeholder="Email" name="email" type="email" required="">	
                                                <input placeholder="Mật Khẩu" name="pasword" type="password" required="" id="password">
                                                <input placeholder="Nhập Lại Mật Khẩu" type="password" required="" id="confirm-password">
                                                <input id="phoneNumber" placeholder="Số Điện Thoại" name="soDienThoai" type="text" minlength="10" maxlength="11" style="margin: 1em 0 0;">	
                                                <input placeholder="Địa Chỉ" name="diaChi" type="text" required="" style="margin: 1em 0 0;">	
                                                <span id="error" style="color: red"></span>
                                                <div class="sign-up">
                                                    <input type="submit" value="Tạo Tài Khoản"/>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div> 			        					            	      
                            </div>	
                        </div>
                        <script src="assets/customer/js/easyResponsiveTabs.js" type="text/javascript"></script>
                        <script type="text/javascript">
                            $(document).ready(function () {
                                $('#horizontalTab').easyResponsiveTabs({
                                    type: 'default', //Types: default, vertical, accordion           
                                    width: 'auto', //auto or any width like 600px
                                    fit: true   // 100% fit in a container
                                });
                            });
                        </script>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

<script>
//		$('#myModal88').modal('show');

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
$("#phoneNumber").keydown(function (e) {
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
</script>  
