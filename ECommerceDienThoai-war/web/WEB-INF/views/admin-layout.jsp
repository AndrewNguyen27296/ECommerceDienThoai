<%-- 
    Document   : admin-layout
    Created on : Nov 21, 2017, 6:51:44 PM
    Author     : DacTien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>DIGIWORLD WEB MASTER</title>
        <base href="${pageContext.request.contextPath}/">

        <!-- Bootstrap Core CSS -->
        <link href="assets/admin/css/bootstrap.min.css" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="assets/admin/css/metisMenu.min.css" rel="stylesheet">

        <!-- Timeline CSS -->
        <link href="assets/admin/css/timeline.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="assets/admin/css/startmin.css" rel="stylesheet">

        <!-- Morris Charts CSS -->
        <link href="assets/admin/css/morris.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="assets/admin/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <!-- js -->
        <script src="assets/customer/js/jquery.min.js"></script>
<!--        <script src="assets/admin/js/excel-bootstrap-table-filter-bundle.js" type="text/javascript"></script>
        <link rel="stylesheet" href="asset/admin/css/excel-bootstrap-table-filter-style.css">-->
<!--        <script src="//code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap4.min.js"></script>-->
        
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>

        <div id="wrapper" style="height: 725px;">

            <!-- Navigation -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <div class="navbar-header">
                    <a class="navbar-brand" href="index.html">DIGIWORLD WEB MASTER</a>
                </div>

                <ul class="nav navbar-right navbar-top-links">
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-user fa-fw"></i> ${sessionScope.admin.hoTen} <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <!-- /.navbar-top-links -->

                <div class="navbar-default sidebar" role="navigation">
                    <div class="sidebar-nav navbar-collapse">
                        <ul class="nav in" id="side-menu">
                            <li class="sidebar-search">
                                <div class="input-group custom-search-form">
                                    <input class="form-control" placeholder="Search..." type="text">
                                    <span class="input-group-btn">
                                        <button class="btn btn-primary" type="button">
                                            <i class="fa fa-search"></i>
                                        </button>
                                </span>
                                </div>
                                <!-- /input-group -->
                            </li>
                            <li>
                                <a href="admin/active-account.php"><i class="glyphicon glyphicon-home" style="margin-right: 5px"></i>Quản lý Merchant</a>
                            </li>
                            <li>
                                <a href="admin/locked-account.php"><i class="glyphicon glyphicon-lock" style="margin-right: 5px"></i>Quản lý Merchant bị tạm khóa</a>
                            </li>
                            <li class="">
                                <a href="admin/manage-customer.php"><i class="glyphicon glyphicon-user" style="margin-right: 5px"></i>Quản lý Customer</a>
                            </li>
                            <li>
                                <a href="admin/order.php"><i class="glyphicon glyphicon-shopping-cart" style="margin-right: 5px"></i>Quản lý phiếu mua hàng</a>
                            </li>
                            <li>
                                <a href="admin/phieu-mua-tin-offline.php"><i class="glyphicon glyphicon-file" style="margin-right: 5px"></i>Quản lý phiếu mua tin onine</a>
                            </li>
                            <li>
                                <a href="admin/phieu-mua-tin-offline.php"><i class="glyphicon glyphicon-file" style="margin-right: 5px"></i>Quản lý phiếu mua tin tại trụ sở</a>
                            </li>
                            <li>
                                <a href="admin/phieu-nop-phat.php"><i class="glyphicon glyphicon-file" style="margin-right: 5px"></i>Quản lý phiếu nộp phạt</a>
                            </li>
                            <li>
                                <a href="admin/danh-gia.php"><i class="glyphicon glyphicon-file" style="margin-right: 5px"></i>Quản lý đánh giá</a>
                            </li>
                            <li>
                                <a href="admin/thong-ke-doanh-thu.php"><i class="glyphicon glyphicon-stats" style="margin-right: 5px"></i>Thống kê doanh thu</a>
                            </li>
                            <li>
                                <a href="admin/block.php"><i class="glyphicon glyphicon-cog" style="margin-right: 5px"></i>Cấu hình số lần khóa vĩnh viễn</a>
                            </li>
                            
<!--                            <li>
                                <a href="forms.html"><i class="fa fa-edit fa-fw"></i> Forms</a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-wrench fa-fw"></i> UI Elements<span class="fa arrow"></span></a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-sitemap fa-fw"></i> Multi-Level Dropdown<span class="fa arrow"></span></a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-files-o fa-fw"></i> Sample Pages<span class="fa arrow"></span></a>
                            </li>-->
                        </ul>
                    </div>
                </div>
            </nav>

            <div id="page-wrapper" style="min-height: 725px;">
                <jsp:include page="${param.view}"></jsp:include>
            </div>
            <!-- /#page-wrapper -->

        </div>
        <!-- /#wrapper -->

        <!-- jQuery -->
        <script src="assets/admin/js/jquery.min.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="assets/admin/js/bootstrap.min.js"></script>

        <!-- Metis Menu Plugin JavaScript -->
        <script src="assets/admin/js/metisMenu.min.js"></script>

        <!-- Morris Charts JavaScript -->
        <script src="assets/admin/js/raphael.min.js"></script>
        <script src="assets/admin/js/morris.min.js"></script>
        <script src="assets/admin/js/morris-data.js"></script>

        <!-- Custom Theme JavaScript -->
        <script src="assets/admin/js/startmin.js"></script>

    </body>
</html>

