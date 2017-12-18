<%-- 
    Document   : post
    Created on : Dec 10, 2017, 1:54:52 PM
    Author     : XinKaChu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
        <title>Đăng tin</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="assets/merchant/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="assets/merchant/js/jquery.min.js"></script>

        <!-- Paypal library -->
        <script src="https://www.paypalobjects.com/api/checkout.js"></script>
    </head>
    <body>
        <h2 class="text-center">Đăng tin mới</h2>
        
        <!-- Hiển thị số tin tồn -->
        <p>Số gói tin còn lại của bạn: <span style="color:red;">${soTinTon}</span></p>
        
        ${message}
        <form:form action="merchant/post/new.php" method="POST" enctype="multipart/form-data" class="form-horizontal" modelAttribute="sanPham">
            <div class="col-sm-6">
            <div class="row">
		<div class="form-group">
                    <label class="control-label col-sm-3">Tên máy: </label>
                    <div class="col-sm-6">
                        <form:input type="text" cssClass="form-control" required="" path="tenMay" placeholder="Nhập tên máy..."/>
                    </div>
		</div>
            </div>
            
            <div class="row">
		<div class="form-group">
                    <label class="control-label col-sm-3">Hình ảnh: </label>
                    <div class="col-sm-6">
                        <input type="file" class="form-control" required="" name="hinhAnh"/>
                    </div>
		</div>
            </div>
            
            <div class="row">
		<div class="form-group">
                    <label class="control-label col-sm-3">Giá bán: </label>
                    <div class="col-sm-6">
                        <form:input type="text" cssClass="form-control" required="" path="giaBan"  placeholder="Nhập giá bán..."/>
                    </div>
		</div>
            </div>
            
            <div class="row">
		<div class="form-group">
                    <label class="control-label col-sm-3">Hãng sản xuất: </label>
                    <div class="col-sm-6">
                        <form:select cssClass="form-control" required="" path="hangSanXuat">
                            <c:forEach var="row" items="${hangSanXuat}">
                                <option value="${row.id}">${row.tenHang}</option>
                            </c:forEach>
                        </form:select>
                    </div>
		</div>
            </div>
            
            <div class="row">
		<div class="form-group">
                    <label class="control-label col-sm-3">Mô tả: </label>
                    <div class="col-sm-6">
                        <form:textarea rows="4" cssClass="form-control" required="" path="moTa"  placeholder="Nhập mô tả..." ></form:textarea>
                    </div>
		</div>
            </div>
            
            <div class="row">
		<div class="form-group">
                    <label class="control-label col-sm-3">Kích thước màn hình: </label>
                    <div class="col-sm-6">
                        <form:input type="text" cssClass="form-control" required="" path="kichThuocManHinh"  placeholder="Nhập kích thước..."/>
                    </div>
		</div>
            </div>
            
            <div class="row">
		<div class="form-group">
                    <label class="control-label col-sm-3">Cpu: </label>
                    <div class="col-sm-6">
                        <form:input type="text" cssClass="form-control" required="" path="cpu"  placeholder="Nhập tên cpu..."/>
                    </div>
		</div>
            </div>
            
            <div class="row">
		<div class="form-group">
                    <label class="control-label col-sm-3">Tốc độ cpu: </label>
                    <div class="col-sm-6">
                        <form:input type="text" cssClass="form-control" required="" path="tocDoCPU"  placeholder="Nhập tốc độ cpu..."/>
                    </div>
		</div>
            </div>
            </div>
            
            <div class="col-sm-6">
            <div class="row">
		<div class="form-group">
                    <label class="control-label col-sm-3">RAM: </label>
                    <div class="col-sm-6">
                        <form:input type="text" cssClass="form-control" required="" path="RAM"  placeholder="Nhập dung lượng RAM..."/>
                    </div>
		</div>
            </div>
            
            <div class="row">
		<div class="form-group">
                    <label class="control-label col-sm-3">Bộ nhớ trong: </label>
                    <div class="col-sm-6">
                        <form:input type="text" cssClass="form-control" required="" path="boNhoTrong"  placeholder="Nhập dung lượng bộ nhớ trong..."/>
                    </div>
		</div>
            </div>
            
            <div class="row">
		<div class="form-group">
                    <label class="control-label col-sm-3">Hệ điều hành: </label>
                    <div class="col-sm-6">
                        <form:input type="text" cssClass="form-control" required="" path="heDieuHanh"  placeholder="Nhập hệ điều hành..."/>
                    </div>
		</div>
            </div>
            
            <div class="row">
		<div class="form-group">
                    <label class="control-label col-sm-3">Camera trước: </label>
                    <div class="col-sm-6">
                        <form:input type="text" cssClass="form-control" required="" path="cameraTruoc"  placeholder="Nhập camera trước..."/>
                    </div>
		</div>
            </div>
            
            <div class="row">
		<div class="form-group">
                    <label class="control-label col-sm-3">Camera sau: </label>
                    <div class="col-sm-6">
                        <form:input type="text" cssClass="form-control" required="" path="cameraSau"  placeholder="Nhập camera sau..."/>
                    </div>
		</div>
            </div>
            
            <div class="row">
		<div class="form-group">
                    <label class="control-label col-sm-3">Dung lượng pin: </label>
                    <div class="col-sm-6">
                        <form:input type="text" cssClass="form-control" required="" path="dungLuongPin"  placeholder="Nhập dung lượng pin..."/>
                    </div>
		</div>
            </div>
            
            <div class="row">
		<div class="form-group">
                    <label class="control-label col-sm-3">Thẻ nhớ ngoài: </label>
                    <div class="col-sm-6">
                        <form:select cssClass="form-control" required="" path="theNhoNgoai">
                            <option>Có</option>
                            <option>Không</option>
                        </form:select>
                    </div>
		</div>
            </div>
            
            <div class="row">
		<div class="form-group">
                    <label class="control-label col-sm-3">Chống nước: </label>
                    <div class="col-sm-6">
                        <form:select cssClass="form-control" required="" path="chongNuoc">
                            <option>Có</option>
                            <option>Không</option>
                        </form:select>
                    </div>
		</div>
            </div>
            
            <div class="row">
		<div class="form-group">
                    <label class="control-label col-sm-3">Bảo hành: </label>
                    <div class="col-sm-6">
                        <form:input type="text" cssClass="form-control" required="" path="baoHanh"  placeholder="Nhập thời hạn bảo hành..."/>
                    </div>
		</div>
            </div>
            
            <div class="row">
		<div class="form-group">
                    <label class="control-label col-sm-3">Tồn kho: </label>
                    <div class="col-sm-6">
                        <form:input type="text" cssClass="form-control" required="" path="tonKho"  placeholder="Nhập số lượng sản phầm mà bạn có..."/>
                    </div>
		</div>
            </div>
            </div>
            
            <div class="text-center">
                <button class="btn btn-danger" style="width:200px" type="submit"
                        >Đăng tin</button>
            </div>
        </form:form>
        
        
        
        <script>
            //Chỉ được nhập số trong ô Giá Bán
            $("#giaBan").keydown(function (e) {
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
            
            //Chỉ được nhập số trong ô Tồn Kho
            $("#tonKho").keydown(function (e) {
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