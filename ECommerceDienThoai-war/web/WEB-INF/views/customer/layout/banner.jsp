<%-- 
    Document   : banner
    Created on : Nov 16, 2017, 3:33:37 PM
    Author     : DacTien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container" style="    width: 100%;
     background-color: #333333;
     /*    										position: fixed;
                                                                                     z-index: 1000;*/
     background: url(assets/customer/images/banner4.jpg);">
    <c:choose>
        <c:when test="${empty sessionScope.nguoiMua}">
            <div class="col-sm-12 log-in" style="font-size: 12px; margin-top: 5px">
                <span style="float: right; color: red;">
                    <a href="#" data-toggle="modal" data-target="#myModal88" >
                        Đăng nhập
                    </a>
                </span>
                <span style="float: left; color: red">
                    <a href="#">
                        Kênh người bán
                    </a>
                </span>
                <div class="clearfix"></div>
            </div>
        </c:when>
        <c:otherwise>
            <div class="col-sm-12 log-in" style="font-size: 12px; margin-top: 5px">
                <a style="float: right; color: white;font-size: 14px;">
                    Chào ${sessionScope.nguoiMua.hoTen}
                </a>
                <div class="clearfix"></div>
            </div>
        </c:otherwise>
    </c:choose>
    

    <div class="w3l_logo" style="margin-left: 0em; padding-top: 5px;" id="home1">
        <h1>
            <img src="assets/customer/logo/pikachu.png" style="width: 70px ">
            <span style="font-size: 30px;margin-left: -10px;font-family: fantasy;color: #fcd458">DIGIWORLD</span>
            </a>
        </h1>
    </div>
    <form>
        <input type="text" name="search" placeholder="Tìm sản phẩm" style="margin-top: 8px;height: 40px;margin-left: 100px;width: 700px;/*background-image: url('logo/search-32.png');*/padding: 12px 20px 12px 10px;" >
        <button class="btn btn-primary my-btn-search">
            <span class="glyphicon glyphicon-search"></span>
        </button>
        <div class="cart cart box_1 row my-cart" style="margin-right: 0"> 
            <!-- <ul style="float: left;color: red;margin-right: 30px;  font-size: 13px; padding-top: 3px;" class="list-unstyled">
                    <li>0 San Pham</li>
                    <li>0 VND</li>
            </ul> -->
            <form action="#" method="post" class="last"> 
                <input type="hidden" name="cmd" value="_cart" />
                <input type="hidden" name="display" value="1" />
                <button class="w3view-cart" type="submit" name="submit" value="" style="position: inherit;margin-right: 30px;"><i class="fa fa-cart-arrow-down" aria-hidden="true" ></i></button>
            </form>   
        </div>
    </form>

</div>

<div class="banner" class="banner" style="padding-top: 0">
    <div class="container" style="position: relative;">
        <img src="assets/customer/logo/smart-phone-banner-5.jpg" class="banner-img">
        <h3 class="banner-slogan" style="margin-top: auto; margin-left: 7%">
            TRẢI NGHIỆM PHONG CÁCH MUA SẮM TRỰC TUYẾN HIỆN ĐẠI VỚI 
            <span style="font-size: 2em;margin: 1em 1em 1em 2em;color: #fcd458; font-family: fantasy;">
                DIGIWORLD
            </span>
        </h3>
    </div>
</div>
