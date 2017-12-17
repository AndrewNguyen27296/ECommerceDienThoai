<%-- 
    Document   : edit
    Created on : Dec 1, 2017, 3:31:37 PM
    Author     : XinKaChu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chỉnh sửa thông tin tài khoản</title>
    </head>
    <body>
        <h2 style="text-align: center;">Chỉnh sửa thông tin tài khoản</h2>
     <span style="color: red;">${message}</span>
     <form:form id="edit" action="merchant/account/edit.php" modelAttribute="nguoiBan" cssClass="form-horizontal"  >
        <div class="form-group">
            <label class="control-label col-sm-1">Email:</label>
            <div class="col-sm-4">
                <form:input path="email" type="email" cssClass="form-control" required=""/>
                <form:hidden path="id"/>
            </div>
        </div>
            
        <div class="form-group">
            <label class="control-label col-sm-1">Mật khẩu:</label>
            <div class="col-sm-4">
                <form:input path="matKhau" type="password" cssClass="form-control" readonly="true"/>
            </div>
        </div>
            
        <div class="form-group">
            <label class="control-label col-sm-1">Họ tên:</label>
            <div class="col-sm-4">
                <form:input path="hoTen" type="text" cssClass="form-control" required=""/>
            </div>
        </div>
            
        <div class="form-group">
            <label class="control-label col-sm-1">CMND:</label>
            <div class="col-sm-4">
                <form:input path="cmnd" type="text" cssClass="form-control" readonly="true"/>
            </div>
        </div>
            
        <div class="form-group">
            <label class="control-label col-sm-1">SĐT:</label>
            <div class="col-sm-4">
                <form:input path="soDienThoai" type="text" cssClass="form-control" required="" minLength="10" maxlength="11"/>
            </div>
        </div>
        
        <div class="form-group">
            <label class="control-label col-sm-1">Địa Chỉ:</label>
            <div class="col-sm-4">
                <form:input path="diaChi" type="text" cssClass="form-control" required=""/>
            </div>
        </div>
            
        <div class="form-group">
			<button class="btn btn-primary">
				<span class="glyphicon glyphicon-save"></span> 
				Cập Nhật
			</button>
		</div>    
            
    </form:form>
     
     <!-- Chỉ được nhập số trong ô SĐT -->
     <script>
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
</script>
    </body>
    
</html>
