<%-- 
    Document   : bill-history
    Created on : Dec 13, 2017, 8:16:06 AM
    Author     : XinKaChu
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chi tiết hóa đơn</title>
        <style>
            td{
                background-color: #fefefe;
            }
            .container {
                width: 1070px;
                padding-left: 0px;
                padding-right: 0px;
            }
            .filterable {
                margin-top: 15px;
            }
            .filterable .panel-heading .pull-right {
                margin-top: -20px;
            }
            .filterable .filters input[disabled] {
                background-color: transparent;
                border: none;
                cursor: auto;
                box-shadow: none;
                padding: 0;
                height: auto;
            }
            .filterable .filters input[disabled]::-webkit-input-placeholder {
                color: #333;
            }
            .filterable .filters input[disabled]::-moz-placeholder {
                color: #333;
            }
            .filterable .filters input[disabled]:-ms-input-placeholder {
                color: #333;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h2>Chi tiết đơn hàng</h2>
            <div class="row">
                <div class="panel panel-primary filterable">
                    <div class="panel-heading">
                        <h3 class="panel-title">Chi tiết đơn hàng</h3>
                        <div class="pull-right">
                            <button class="btn btn-default btn-xs btn-filter"><span class="glyphicon glyphicon-filter"></span>Bộ lọc</button>
                        </div>
                    </div>
                    <table class="table">
                        <thead>
                            <tr class="filters">
                                <th><input type="text" class="form-control" placeholder="Người Mua" disabled></th>
                                <th><input type="text" class="form-control" placeholder="Sản Phẩm" disabled></th>
                                <th><input type="text" class="form-control" placeholder="Số Lượng" disabled></th>
                                <th><input type="text" class="form-control" placeholder="Thành Tiền" disabled></th>
                                <th><input type="text" class="form-control" placeholder="Ngày Đặt" disabled></th>
                                <th><input type="text" class="form-control" placeholder="Thành phố" disabled></th>
                                <th><input type="text" class="form-control" placeholder="Quận" disabled></th>
                                <th><input type="text" class="form-control" placeholder="Tình Trạng" disabled></th>
                                <th><input type="text" class="form-control" placeholder="" disabled></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="ct" items="${ctPhieuMuaHang}">
                            <tr>
                                <td>${ct.idPhieuMuaHang.tenNguoiNhan}</td>
                                <td>${ct.idSanPham.tenMay}</td>
                                <td>${ct.soLuongMua}</td>
                                <td><fmt:formatNumber value="${ct.thanhTien}" pattern="###,###,### VND"/></td>
                                <td><fmt:formatDate pattern="dd-MM-yyyy" value="${ct.idPhieuMuaHang.ngayDatHang}"></fmt:formatDate></td>
                                <td>${ct.idPhieuMuaHang.idThanhPho.tenThanhPho}</td>
                                <td>${ct.idPhieuMuaHang.idQuanHuyen.tenQuanHuyen}</td>
                                <c:choose>
                                    <c:when test="${ct.idTinhTrang.id == 'XL'}">
                                        <td>Đang xử lý</td>
                                    </c:when>
                                    <c:when test="${ct.idTinhTrang.id == 'DG'}">
                                        <td>Đang giao</td>
                                    </c:when>
                                    <c:when test="${ct.idTinhTrang.id == 'DH'}">
                                        <td>Đã hủy</td>
                                    </c:when>
                                    <c:when test="${ct.idTinhTrang.id == 'TC'}">
                                        <td>Thành công</td>
                                    </c:when>
                                </c:choose>
                                <td><a href="merchant/bill/detail/${ct.id}.php" style="background-color: #fefefe;">Xem chi tiết</a></td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <script>
            //Gan search len thanh nav
            $(document).ready(function () {
                $('.filterable .btn-filter').click(function () {
                    var $panel = $(this).parents('.filterable'),
                            $filters = $panel.find('.filters input'),
                            $tbody = $panel.find('.table tbody');
                    if ($filters.prop('disabled') == true) {
                        $filters.prop('disabled', false);
                        $filters.first().focus();
                    } else {
                        $filters.val('').prop('disabled', true);
                        $tbody.find('.no-result').remove();
                        $tbody.find('tr').show();
                    }
                });

                //Search
                $('.filterable .filters input').keyup(function (e) {
                    /* Ignore tab key */
                    var code = e.keyCode || e.which;
                    if (code == '9')
                        return;
                    /* Useful DOM data and selectors */
                    var $input = $(this),
                            inputContent = $input.val().toLowerCase(),
                            $panel = $input.parents('.filterable'),
                            column = $panel.find('.filters th').index($input.parents('th')),
                            $table = $panel.find('.table'),
                            $rows = $table.find('tbody tr');
                    /* Dirtiest filter function ever ;) */
                    var $filteredRows = $rows.filter(function () {
                        var value = $(this).find('td').eq(column).text().toLowerCase();
                        return value.indexOf(inputContent) === -1;
                    });
                    /* Clean previous no-result if exist */
                    $table.find('tbody .no-result').remove();
                    /* Show all rows, hide filtered ones (never do that outside of a demo ! xD) */
                    $rows.show();
                    $filteredRows.hide();
                    /* Prepend no-result row if all rows are filtered */
                    if ($filteredRows.length === $rows.length) {
                        $table.find('tbody').prepend($('<tr class="no-result text-center"><td colspan="' + $table.find('.filters th').length + '">No result found</td></tr>'));
                    }
                });
            });
        </script>
    </body>
</html>
