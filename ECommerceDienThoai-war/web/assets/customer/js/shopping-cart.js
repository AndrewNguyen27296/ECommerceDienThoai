$(function(){
    $("#btn-add-to-cart").click(function() {
        var id = $("#add").val();
        $.ajax({
            url: "shopping-cart/add.php",
            data: {id:id},
            success: function(response){
                alert(response);
                paypal.minicart.redraw();
            }
        });
    });
        
    $("button[data-cart-remove]").click(function(){
        var id = $(this).attr("data-cart-remove");
        var idx = $(this).attr("data-sbmincart-idx");
        $.ajax({
            url: "shopping-cart/remove.php",
            data: {id:id},
            success: function(response){
                alert(response);
                paypal.minicart.redraw();
                //$(window).trigger('resize');
                //redraw();
            }
        });
    });
});