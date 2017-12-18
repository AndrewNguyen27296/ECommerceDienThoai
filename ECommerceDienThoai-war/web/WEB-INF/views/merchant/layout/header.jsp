<%-- 
    Document   : header
    Created on : Nov 21, 2017, 12:39:31 AM
    Author     : XinKaChu
--%>

<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<style>
    .searchButton {
        position: absolute;  
        right: -52px;
        width: 40px;
        height: 36px;
        top: -4px;
        border: 1px solid #ff9501;
        background: #ff9501;
        text-align: center;
        color: #fff;
        border-radius: 5px;
        cursor: pointer;
        font-size: 20px;
        border: 1px solid;
        margin-right: 51px;
        margin-top: 3px;
    }
    html, body {
        font-family: 'Roboto', sans-serif;
        font-size: 96%;
    }
</style>

<!DOCTYPE html>
<!--header start here-->
<div class="header-main">

    <!-- Banner logo start -->
    <div class="logo-w3-agile" style="height: 70px;">
        <h1 style="margin-top: -11px;">
            <a href="merchant/home/index.php" style="font-size: 22px;padding-top: 20px; background: #a2d200;">
                Kênh Người Bán
            </a>
        </h1>
    </div>
    <!-- Banner logo end -->

    <div class="w3layouts-left">

        <!--search-box-->
        <div class="w3-search-box" style="height: 38px;">
            <form action="#" method="post">
                <div class="search">
                    <input type="text" class="searchTerm" placeholder="Tìm kiếm...">
                    <button type="submit" class="searchButton" style="margin-right: 50px;">
                        <i class="fa fa-search"></i>
                    </button>
                </div>
            </form>
        </div><!--//end-search-box-->
        <div class="clearfix"> </div>
    </div>
    <div class="w3layouts-right">
        <div class="profile_details_left"><!--notifications of menu start -->
            <ul class="nofitications-dropdown">
                <li class="dropdown head-dpdn">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-envelope"></i><span class="badge">3</span></a>
                    <ul class="dropdown-menu">
                        <li>
                            <div class="notification_header">
                                <h3>You have 3 new messages</h3>
                            </div>
                        </li>
                        <li><a href="#">
                                <div class="user_img"><img src="images/in11.jpg" alt=""></div>
                                <div class="notification_desc">
                                    <p>Lorem ipsum dolor</p>
                                    <p><span>1 hour ago</span></p>
                                </div>
                                <div class="clearfix"></div>	
                            </a></li>
                        <li class="odd"><a href="#">
                                <div class="user_img"><img src="images/in10.jpg" alt=""></div>
                                <div class="notification_desc">
                                    <p>Lorem ipsum dolor </p>
                                    <p><span>1 hour ago</span></p>
                                </div>
                                <div class="clearfix"></div>	
                            </a></li>
                        <li><a href="#">
                                <div class="user_img"><img src="images/in9.jpg" alt=""></div>
                                <div class="notification_desc">
                                    <p>Lorem ipsum dolor</p>
                                    <p><span>1 hour ago</span></p>
                                </div>
                                <div class="clearfix"></div>	
                            </a></li>
                        <li>
                            <div class="notification_bottom">
                                <a href="#">See all messages</a>
                            </div> 
                        </li>
                    </ul>
                </li>
                <li class="dropdown head-dpdn">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-bell"></i><span class="badge blue">3</span></a>
                    <ul class="dropdown-menu">
                        <li>
                            <div class="notification_header">
                                <h3>You have 3 new notification</h3>
                            </div>
                        </li>
                        <li><a href="#">
                                <div class="user_img"><img src="images/in8.jpg" alt=""></div>
                                <div class="notification_desc">
                                    <p>Lorem ipsum dolor</p>
                                    <p><span>1 hour ago</span></p>
                                </div>
                                <div class="clearfix"></div>	
                            </a></li>
                        <li class="odd"><a href="#">
                                <div class="user_img"><img src="images/in6.jpg" alt=""></div>
                                <div class="notification_desc">
                                    <p>Lorem ipsum dolor</p>
                                    <p><span>1 hour ago</span></p>
                                </div>
                                <div class="clearfix"></div>	
                            </a></li>
                        <li><a href="#">
                                <div class="user_img"><img src="images/in7.jpg" alt=""></div>
                                <div class="notification_desc">
                                    <p>Lorem ipsum dolor</p>
                                    <p><span>1 hour ago</span></p>
                                </div>
                                <div class="clearfix"></div>	
                            </a></li>
                        <li>
                            <div class="notification_bottom">
                                <a href="#">See all notifications</a>
                            </div> 
                        </li>
                    </ul>
                </li>	
                <li class="dropdown head-dpdn">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-tasks"></i><span class="badge blue1">9</span></a>
                    <ul class="dropdown-menu">
                        <li>
                            <div class="notification_header">
                                <h3>You have 8 pending task</h3>
                            </div>
                        </li>
                        <li><a href="#">
                                <div class="task-info">
                                    <span class="task-desc">Database update</span><span class="percentage">40%</span>
                                    <div class="clearfix"></div>	
                                </div>
                                <div class="progress progress-striped active">
                                    <div class="bar yellow" style="width:40%;"></div>
                                </div>
                            </a></li>
                        <li><a href="#">
                                <div class="task-info">
                                    <span class="task-desc">Dashboard done</span><span class="percentage">90%</span>
                                    <div class="clearfix"></div>	
                                </div>
                                <div class="progress progress-striped active">
                                    <div class="bar green" style="width:90%;"></div>
                                </div>
                            </a></li>
                        <li><a href="#">
                                <div class="task-info">
                                    <span class="task-desc">Mobile App</span><span class="percentage">33%</span>
                                    <div class="clearfix"></div>	
                                </div>
                                <div class="progress progress-striped active">
                                    <div class="bar red" style="width: 33%;"></div>
                                </div>
                            </a></li>
                        <li><a href="#">
                                <div class="task-info">
                                    <span class="task-desc">Issues fixed</span><span class="percentage">80%</span>
                                    <div class="clearfix"></div>	
                                </div>
                                <div class="progress progress-striped active">
                                    <div class="bar  blue" style="width: 80%;"></div>
                                </div>
                            </a></li>
                        <li>
                            <div class="notification_bottom">
                                <a href="#">See all pending tasks</a>
                            </div> 
                        </li>
                    </ul>
                </li>	
                <div class="clearfix"> </div>
            </ul>
            <div class="clearfix"> </div>
        </div>
        <!--notification menu end -->

        <div class="clearfix"> </div>				
    </div>
    <div class="profile_details w3l" style="height:70px;">		
        <ul>
            <li class="dropdown profile_details_drop">
                <a href="merchant/home/index.php" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false" style="margin-top:8px">
                    <div class="profile_img">	
                        <div class="user-name">
                            <span>${sessionScope.nguoiBan.hoTen}</span>
                        </div>
                        <i class="fa fa-angle-down"></i>
                        <i class="fa fa-angle-up"></i>
                        <div class="clearfix"></div>	
                    </div>	
                </a>
                <ul class="dropdown-menu drp-mnu">
                    <li> <a href="#"><i class="fa fa-cog"></i> Sửa thông tin</a> </li> 
                    <li> <a href="#"><i class="fa fa-user"></i> Đổi mật khẩu</a> </li> 
                    <li> <a href="#"><i class="fa fa-sign-out"></i> Đăng xuất</a> </li>
                </ul>
            </li>
        </ul>
    </div>

    <div class="clearfix"> </div>	
</div>
<!--header end here-->

<!-- script-for sticky-nav -->
<script>
    $(document).ready(function () {
        var navoffeset = $(".header-main").offset().top;
        $(window).scroll(function () {
            var scrollpos = $(window).scrollTop();
            if (scrollpos >= navoffeset) {
                $(".header-main").addClass("fixed");
            } else {
                $(".header-main").removeClass("fixed");
            }
        });

    });
</script>
<!-- /script-for sticky-nav -->
<!--inner block start here-->
<div class="inner-block">

</div>
<!--inner block end here-->

