<%-- 
    Document   : login
    Created on : Nov 21, 2017, 10:32:10 PM
    Author     : DacTien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="main-content-agile">
    <div class="sub-main-w3">	
        <form action="#" method="post">
            <input id="email" placeholder="Email" name="Name" class="user" type="email" required=""><br>
            <input id="password" placeholder="Mật khẩu" name="Password" class="pass" type="password" required=""><br>
            <span id="error_dangNhap" style="color: red"></span>
            <input type="submit" value="">
        </form>
    </div>
</div>

<script>
    $("#dangNhap").submit(function (event) {
                    event.preventDefault();
                    var email = $("#email").val();
                    var password = $("#password").val();

                    $.ajax({
                        url: "admin/login.php",
                        async: false, //block until we get a response
                        data: {email: email, password: password},
                        success: function (response) {
                            if (response == "Đăng nhập thành công") {
                                $("#error_dangNhap").html(response);
                            } else
                                $("#error_dangNhap").html(response);
                            }
                    });
    });
</script>
