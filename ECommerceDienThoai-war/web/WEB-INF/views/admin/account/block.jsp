<%-- 
    Document   : block
    Created on : Dec 16, 2017, 3:43:04 PM
    Author     : DacTien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row">
    <div class="col-lg-6">
        <h1 class="page-header">Cấu hình số lần lock</h1>
        <h4>Số lần khóa vĩnh viễn hiện tại: <strong>${cauHinh.soLanBlock}</strong> lần</h4>
    </div>
</div>

<div class="row text-center" style="margin-bottom: 20px; text-align: center;">
    <div class="input-group custom-search-form" style="display: flex;padding-left: 15px;">
        <form action="admin/block.php" method="post" style="width: 100%">
            <input name="soLanLock" class="form-control" placeholder="Nhập số lần khóa vĩnh viễn " type="text" style="width: 25%;">
            <span class="input-group-btn" style="float: left">
                <button class="btn btn-primary" type="submit">
                    Cập nhật
                </button>
            </span>
        </form>
    </div>
</div>
