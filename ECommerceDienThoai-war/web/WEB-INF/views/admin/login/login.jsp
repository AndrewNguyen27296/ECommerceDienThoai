<%-- 
    Document   : login
    Created on : Nov 21, 2017, 10:32:10 PM
    Author     : DacTien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="main-content-agile">
    <div class="sub-main-w3">	
        <form action="admin/login.php" method="post">
            <input id="email" placeholder="Email" name="Email" class="user" type="email" required=""><br>
            <input id="password" placeholder="Mật khẩu" name="Password" class="pass" type="password" required=""><br>
            <span style="color: red">${mess}</span>
            <input formaction="admin/login.php" formmethod="post" type="submit" value="">
        </form>
    </div>
</div>

<!--<script>
    $("#dangNhap").submit(function (event) {
                    event.preventDefault();
                    var email = $("#email").val();
                    var password = $("#password").val();

                    $.ajax({
                        url: "admin/login-check.php",
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
</script>-->
