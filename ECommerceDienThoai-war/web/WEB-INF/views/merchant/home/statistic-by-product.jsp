<%-- 
    Document   : statistic-by-product
    Created on : Dec 18, 2017, 8:38:42 PM
    Author     : DacTien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
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
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
            google.charts.load('current', {'packages': ['corechart']});
            google.charts.setOnLoadCallback(drawChart);

            function drawChart() {

                var data = google.visualization.arrayToDataTable([
                    ['Sản phẩm', 'Tỉ lệ'],
            <c:forEach var="a" items="${items}">
                    ['${a[0]}', ${a[1]}],
            </c:forEach>
                ]);

                var options = {
                    title: 'Thống kê sản phẩm'
                };

                var chart = new google.visualization.PieChart(document.getElementById('piechart'));

                chart.draw(data, options);
            }
        </script>

        <div id="piechart" style="width: 900px; height: 500px;"></div>

    </body>
</html>

