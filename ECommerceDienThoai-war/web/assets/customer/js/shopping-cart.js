$(function(){
    $("#btn-add-to-cart").click(function() {
        var id = $("#add").val();
        $.ajax({
            url: "shopping-cart/add.php",
            data: {id:id},
            success: function(response){
//                alert(response);
//                paypal.minicart.redraw();
                $("#count").html(response);
            }
        });
        var img = $("#img-product");
        var src = img.attr("src");
        var css = '.nn-cart-fly {background-image: url("' + src + '");background-size: 100% 100%;}';
        $("#nn-cart-fly").html(css);
        img.effect("transfer", {to: ".w3view-cart", className: "nn-cart-fly"}, 1000);
    });
        
    $("button[data-cart-remove]").click(function(){
        var id = $(this).attr("data-cart-remove");
        $.ajax({
            url: "shopping-cart/remove.php",
            data: {id:id},
            success: function(response){
                $("#count").html(response[0]);
                var value = response[1];
                var num = value.toFixed(0).replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,");
                $("#amount").html('Tổng cộng: ' + num + ' VND');
            },
            dataType: 'json'
        });
        $(this).parents("tr").hide(300);
    });
    
    /**
     * cap nhap gio hang
     */
    $("input[data-cart-update]").change(function () {
        var id = $(this).attr("data-cart-update");
        var qty = $(this).val();
        td_amt = $(this).parents("tr").find(".amt");
        $.ajax({
            url: "shopping-cart/update.php",
            data: {id: id, qty: qty},
            success: function (response) {
                $("#count").html(response[0]);

                var value1 = response[1];
                var num1 = value1.toFixed(0).replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,");
                $("#amount").html('Tổng cộng: ' + num1 + ' VND');

                var value = response[2];
                var num = value.toFixed(0).replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,");
                td_amt.html(num + ' VND');
            },
            dataType: "json"
        });

    });
});