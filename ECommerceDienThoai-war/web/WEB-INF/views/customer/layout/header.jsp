<%-- 
    Document   : header
    Created on : Nov 16, 2017, 3:32:02 PM
    Author     : DacTien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:choose>
    <c:when test="${empty sessionScope.nguoiMua}">
        <div class="modal fade" id="myModal88" tabindex="-1" role="dialog" aria-labelledby="myModal88"
             aria-hidden="true">
            <div class="modal-dialog modal-lg" style="width: 40%;">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            &times;</button>
                    </div>
                    <div class="modal-body modal-body-sub">
                        <div class="row">
                            <div class="col-md-12 modal_body_left modal_body_left1">
                                <div class="sap_tabs">	
                                    <div id="horizontalTab" style="display: block; width: 100%; margin: 0px;">
                                        <ul>
                                            <li class="resp-tab-item" aria-controls="tab_item-0"><span>Đăng nhập</span></li>
                                            <li class="resp-tab-item" aria-controls="tab_item-1"><span>Đắng ký</span></li>
                                        </ul>		
                                        <div class="tab-1 resp-tab-content" aria-labelledby="tab_item-0">
                                            <div class="facts">
                                                <div class="register">
                                                    <form id="dangNhap" action="#" method="post">			
                                                        <input name="Email" id="nguoiMua_email" placeholder="Email" type="email" required="">						
                                                        <input name="Password" id="nguoiMua_password" placeholder="Mật khẩu" type="password" required="">										
                                                        <span id="error_dangNhap" style="color: red"></span>
                                                        <div class="sign-up">
                                                            <input type="submit" value="Đăng nhập"/>
                                                            <a href="account/forgot-password.php">Quên mật khẩu</a>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div> 
                                        </div>	 
                                        <div class="tab-2 resp-tab-content" aria-labelledby="tab_item-1">
                                            <div class="facts">
                                                <div class="register">
                                                    <form id="dangKy" method="post">			
                                                        <input placeholder="Họ Tên" name="hoTen" id="hoTen" type="text" required="">
                                                        <input placeholder="Email" name="email" id="email" type="email" required="">	
                                                        <input placeholder="Mật Khẩu" name="pasword" id="password" type="password" required="">
                                                        <input placeholder="Nhập Lại Mật Khẩu" type="password" required="" id="confirm-password">
                                                        <input placeholder="Số Điện Thoại" name="soDienThoai" id="soDienThoai" type="text" minlength="10" maxlength="11" style="margin: 1em 0 0;">	
                                                        <input placeholder="Địa Chỉ" name="diaChi" id="diaChi" type="text" required="" style="margin: 1em 0 0;">	
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
                                <script >
                                    $('#horizontalTab').easyResponsiveTabs({
                                        type: 'default', //Types: default, vertical, accordion           
                                        width: 'auto', //auto or any width like 600px
                                        fit: true   // 100% fit in a container
                                    });
                                </script>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>

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

                //AJAX thêm Người mua
                $("#dangKy").submit(function (event) {
                    event.preventDefault();
                    var hoTen = $("#hoTen").val();
                    var email = $("#email").val();
                    var password = $("#password").val();
                    var diaChi = $("#diaChi").val();
                    var soDienThoai = $("#soDienThoai").val();

                    $.ajax({
                        url: "account/register.php",
                        async: false, //block until we get a response
                        data: {hoTen: hoTen, email: email, password: password, diaChi: diaChi, soDienThoai: soDienThoai},
                        success: function (response) {
                            $("#error").html(response);
                        }
                    });
                });

                $("#dangNhap").submit(function (event) {
                    event.preventDefault();
                    var nguoiMua_email = $("#nguoiMua_email").val();
                    var nguoiMua_password = $("#nguoiMua_password").val();

                    $.ajax({
                        url: "account/login.php",
                        async: false, //block until we get a response
                        data: {nguoiMua_email: nguoiMua_email, nguoiMua_password: nguoiMua_password},
                        success: function (response) {
                            if (response == "Đăng nhập thành công") {
                                $("#error_dangNhap").html(response);
                                setTimeout(function () {// wait for 3 secs(2)
                                    window.location.replace("http://localhost:8080/ECommerceDienThoai-war/home/index.php"); // then reload the page.(3)
                                }, 3000);
                            } else
                                $("#error_dangNhap").html(response);
                        }
                    });
                });
            });
        </script>  
    </c:when>
    <c:otherwise>

    </c:otherwise>
</c:choose>

