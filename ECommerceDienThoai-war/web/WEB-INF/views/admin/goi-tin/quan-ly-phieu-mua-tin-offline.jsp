<%-- 
    Document   : quan-ly-phieu-mua-tin-offline
    Created on : Dec 17, 2017, 4:16:47 PM
    Author     : DacTien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>

<div class="row">
    <div class="col-lg-6">
        <h1 class="page-header">Quản lý phiếu mua tin tại trụ sở</h1>
    </div>
</div>

<div class="row">
    <div class="panel panel-primary filterable">
        <div class="panel-heading">
            <h3 class="panel-title">Phiếu mua tin</h3>
            <div class="pull-right">
                <button class="btn btn-default btn-xs btn-filter"><span class="glyphicon glyphicon-filter"></span> Lọc</button>
            </div>
        </div>
        <table class="table">
            <thead>
                <tr class="filters">
                    <th><input type="text" class="form-control" placeholder="Người lập phiếu" disabled></th>
                    <th><input type="text" class="form-control" placeholder="Người bán" disabled></th>
                    <th><input type="text" class="form-control" placeholder="Ngày lập phiếu" disabled></th>
                    <th><input type="text" class="form-control" placeholder="Gói tin" disabled></th>
                    <th><input type="text" class="form-control" placeholder="Số tiền" disabled></th>
<!--                    <th></th>-->
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="p">
                    <tr>
                        <td>${p.idAdmin.hoTen}</td>
                        <td>${p.idNguoiBan.email}</td>
                        <td>
                            <fmt:formatDate value="${p.ngayMua}" pattern="dd-MM-yyyy" />
                        </td>
                        <td>
                            ${p.idGoiTin.tenGoiTin}
                        </td>
                        <td>
                            <fmt:formatNumber value="${p.giaBan}" pattern="###,###,### VND" />
                        </td>
<!--                        <td>
                            <a href="admin/order/detail/${p.id}.php">Xem chi tiết</a>
                        </td>-->
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<style>
    th {
        text-align: center;
    }
    th > input {
        text-align: center;
    }
    td {
        text-align: center;
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

<script>
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