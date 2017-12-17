<%-- 
    Document   : thong-ke-doanh-thu
    Created on : Dec 18, 2017, 1:30:45 AM
    Author     : myly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>

<div class="row">
    <div class="col-lg-6">
        <h1 class="page-header">Thống kê doanh thu</h1>
    </div>
</div>

<div class="row">
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          	['Nguồn doanh thu', 'Tỉ lệ'],
                ["Gói tin tiêu chuẩn", ${items[0]}],
                ["Gói tin bạc", ${items[1]}],
                ["Gói tin vàng", ${items[2]}],
                ["Phiếu nộp phạt", ${items[3]}]
        ]);
        var options = {
          title: 'Thống kê doanh thu'
        };
        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
        chart.draw(data, options);
      }
    </script>
    
    <div id="piechart" style="width: 900px; height: 500px;"></div>
</div>
