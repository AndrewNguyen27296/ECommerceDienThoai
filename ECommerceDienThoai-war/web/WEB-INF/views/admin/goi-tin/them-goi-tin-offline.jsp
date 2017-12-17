<%-- 
    Document   : them-goi-tin-offline
    Created on : Dec 17, 2017, 11:28:56 AM
    Author     : DacTien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>

<div class="row">
    <div class="col-lg-6">
        <h1 class="page-header">Thêm phiếu mua gói tin</h1>
    </div>
</div>

<div class="row">
    <form action="admin/phieu-mua-tin-offline/them-phieu-mua-tin-offline/${nguoiBan.id}.php" method="post">
        <div class="form-group">
            <label>Merchant</label>
            <input value="${nguoiBan.email}" type="text" class="form-control" disabled="" />
        </div>
        <div class="form-group">
            <label>Gói tin</label>
            <select id="goiTin" name="goiTin" class="form-control">
                <option selected value="-1">Chọn gói tin</option>
                <c:forEach var="i" items="${listGoiTin}">
                    <option value="${i.id}">${i.tenGoiTin}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label>Số tin: </label> 
            <strong id="soTin"></strong>
        </div>
        <div class="form-group">
            <label>Giá bán: </label>
            <span id="giaBan">

            </span>
            <input id="giaBanGoc" hidden="true" value="0" />
        </div>
        <!--    <div class="form-group">
                <label>Số lượng mua</label>
                <input id="soLuongMua" type="number" class="form-control" />
            </div>-->
        <h3 style="float: right">Thành tiền: <span id="thanhTien"></span></h3>
        <div class="clearfix"></div>
        <button type="submit" class="btn btn-info btn-lg" style="float: right">Xác nhận</button>
    </form>

</div>

<script>
    $('#goiTin').on('change', function (e) {
        var valueSelected = this.value;
        $.ajax({
            url: "admin/getInfoGoiTin.php",
            async: false, //block until we get a response
            data: {id: valueSelected},
            success: function (response) {
                $('#soTin').html(response.soTin);
                var value = response.giaBan;
                var num = value.toFixed(0).replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,");
                $('#giaBan').html(num + ' VND');
                $('#thanhTien').html(num + ' VND');
                // $('#giaBanGoc').val(value);
            },
            dataType: 'json'
        });
    });
//    $("#soLuongMua").change(function () {
//        var qty = $(this).val();
//        var donGia = $('#giaBanGoc').val();
//        var amount = donGia * qty;
//        var value = amount;
//        var num = value.toFixed(0).replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,");
//        $('#thanhTien').html(num + ' VND');
//    });
</script>
