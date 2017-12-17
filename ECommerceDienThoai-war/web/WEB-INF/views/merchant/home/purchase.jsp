<%-- 
    Document   : purchase
    Created on : Dec 3, 2017, 12:23:20 PM
    Author     : XinKaChu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="assets/merchant/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="assets/merchant/js/jquery.min.js"></script>

        <!-- Paypal library -->
        <script src="https://www.paypalobjects.com/api/checkout.js"></script>

        <title>Thanh toán gói tin</title>
    </head>
    <body>
        <h1>Mua Gói Tin</h1>
        <form class="form-horizontal" >
            <div class="form-group">
                <div class="control-label col-sm-3">
                    Chọn gói tin bạn muốn mua:
                </div>
            </div>

            <div class="form-group" >
                <div class="radio">
                    <label>
                        <input type="radio" name="package" id="goi1">
                        Gói cơ bản - 100k/5 tin
                    </label>
                </div>

                <div class="radio">
                    <label>
                        <input type="radio" name="package" checked="true" id="goi2">
                        Gói mặc định - 200k/10 tin
                    </label>
                </div>

                <div class="radio">
                    <label>
                        <input type="radio" name="package" id="goi3">
                        Gói nâng cao - 300k/15 tin
                    </label>
                </div>

                <div id="paypal-button-container"></div>
            </div>
        </form>

        <!-- Nhúng script paypal -->
        <script>

            // Render the PayPal button
            
            //TEST BUTTON
            /*document.getElementById("paypal-button-container").onclick = function (){
            var checkbox = document.getElementsById("goi1"); {
            if (checkbox.checked === true){
            env: 'sandbox',
                    style: {
                    label: 'paypal',
                            size: 'medium', // small | medium | large | responsive
                            shape: 'rect', // pill | rect
                            color: 'blue', // gold | blue | silver | black
                            tagline: false
                    },
                    client: {
                    sandbox: 'AZDxjDScFpQtjWTOUtWKbyN_bDt4OgqaF4eYXlewfBP4-8aqX3PiV8e1GWU6liB2CUXlkA59kJXE7M6R',
                            production: '${sessionScope.nguoiBan.id}'
                    },
                            
                     
             payment: function (data, actions) {
                return actions.payment.create({
                    payment: {
                        transactions: [
                            {
                                amount: {total: '0.01', currency: 'USD'}
                            }
                        ]
                    }
                });
             },
             onAuthorize: function (data, actions) {
                return actions.payment.execute().then(function () {
                window.alert('Payment Complete!');
                });
             }
            }
            };
            };*/
            paypal.Button.render({
             // Set your environment
             
             env: 'sandbox', // sandbox | production
             
             // Specify the style of the button
             
             style: {
             label: 'paypal',
             size: 'medium', // small | medium | large | responsive
             shape: 'rect', // pill | rect
             color: 'blue', // gold | blue | silver | black
             tagline: false
             },
             // PayPal Client IDs - replace with your own
             // Create a PayPal app: https://developer.paypal.com/developer/applications/create
             
             client: {
             sandbox: 'AZDxjDScFpQtjWTOUtWKbyN_bDt4OgqaF4eYXlewfBP4-8aqX3PiV8e1GWU6liB2CUXlkA59kJXE7M6R',
             production: '${sessionScope.nguoiBan.id}'
             },
             
             
             
             payment: function (data, actions) {
             return actions.payment.create({
             payment: {
             transactions: [
             {
             amount: {total: '0.01', currency: 'USD'}
             }
             ]
             }
             });
             },
             onAuthorize: function (data, actions) {
             return actions.payment.execute().then(function () {
             window.alert('Payment Complete!');
             });
             }
             
             }, '#paypal-button-container')

        </script>
    </body>
</html>
