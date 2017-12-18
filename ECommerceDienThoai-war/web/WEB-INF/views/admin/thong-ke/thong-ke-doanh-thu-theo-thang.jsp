<%-- 
    Document   : thong-ke-doanh-thu-theo-thang
    Created on : Dec 18, 2017, 4:31:20 PM
    Author     : myly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
    google.charts.load('current', {'packages': ['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {
        var data = google.visualization.arrayToDataTable([
            ['Tháng', 'Mua tin online', 'Mua tin tại trụ sở', 'Nộp phạt'],
            ['T1', ${list1[0]}, ${list1[1]}, ${list1[2]}],
            ['T2', ${list2[0]}, ${list2[1]}, ${list2[2]}],
            ['T3', ${list3[0]}, ${list3[1]}, ${list3[2]}],
            ['T4', ${list4[0]}, ${list4[1]}, ${list4[2]}],
            ['T5', ${list5[0]}, ${list5[1]}, ${list5[2]}],
            ['T6', ${list6[0]}, ${list6[1]}, ${list6[2]}],
            ['T7', ${list7[0]}, ${list7[1]}, ${list7[2]}],
            ['T8', ${list8[0]}, ${list8[1]}, ${list8[2]}],
            ['T9', ${list9[0]}, ${list9[1]}, ${list9[2]}],
            ['T10', ${list10[0]}, ${list10[1]}, ${list10[2]}],
            ['T11', ${list11[0]}, ${list11[1]}, ${list11[2]}],
            ['T12', ${list12[0]}, ${list12[1]}, ${list12[2]}]
        ]);

        var options = {
            title: 'Company Performance',
            curveType: 'function',
            legend: {position: 'bottom'}
        };

        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

        chart.draw(data, options);
    }
</script>-->
<div class="row">
    <div class="col-lg-6">
        <h1 class="page-header">Thống kê doanh thu theo tháng</h1>
    </div>
</div>

<div class="row">
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
        google.charts.load('current', {'packages': ['line']});
        google.charts.setOnLoadCallback(drawChart);

        function drawChart() {

            var data = new google.visualization.DataTable();
            data.addColumn('number', 'Tháng');
            data.addColumn('number', 'Mua tin online');
            data.addColumn('number', 'Mua tin tại trụ sở');
            data.addColumn('number', 'Phiếu nộp phạt');

            data.addRows([
                [1, ${list1[0]}, ${list1[1]}, ${list1[2]}],
                [2, ${list2[0]}, ${list2[1]}, ${list2[2]}],
                [3, ${list3[0]}, ${list3[1]}, ${list3[2]}],
                [4, ${list4[0]}, ${list4[1]}, ${list4[2]}],
                [5, ${list5[0]}, ${list5[1]}, ${list5[2]}],
                [6, ${list6[0]}, ${list6[1]}, ${list6[2]}],
                [7, ${list7[0]}, ${list7[1]}, ${list7[2]}],
                [8, ${list8[0]}, ${list8[1]}, ${list8[2]}],
                [9, ${list9[0]}, ${list9[1]}, ${list9[2]}],
                [10, ${list10[0]}, ${list10[1]}, ${list10[2]}],
                [11, ${list11[0]}, ${list11[1]}, ${list11[2]}],
                [12, ${list12[0]}, ${list12[1]}, ${list12[2]}]
            ]);

            var options = {
                chart: {
                    title: 'Thống kê doanh thu theo tháng',
                    subtitle: ''
                },
                width: 900,
                height: 500
            };

            var chart = new google.charts.Line(document.getElementById('linechart_material'));

            chart.draw(data, google.charts.Line.convertOptions(options));
        }
    </script>

    <div id="linechart_material" style="width: 1000px; height: 500px"></div>
</div>