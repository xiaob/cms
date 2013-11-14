<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Mosaddek">
<meta name="keyword"
	content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<link rel="shortcut icon" href="img/favicon.png">
<title>FlatLab - Flat & Responsive Bootstrap Admin Template</title>
<!-- Bootstrap core CSS -->
<link href="${basePath}/default/css/bootstrap.min.css" rel="stylesheet">
<link href="${basePath}/default/css/bootstrap-reset.css"
	rel="stylesheet">
<!--external css-->
<link
	href="${basePath}/default/assets/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<!-- Custom styles for this template -->
<link href="${basePath}/default/css/style.css" rel="stylesheet">
<link href="${basePath}/default/css/style-responsive.css"
	rel="stylesheet" />

<!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
<!--[if lt IE 9]>
      <script src="${basePath}/default/js/html5shiv.js"></script>
      <script src="${basePath}/default/js/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<section id="container" class="">
		<!--header start-->
		<header class="header white-bg">
			<!--logo start-->
			<a href="#" class="logo"><img
				src="${basePath}/default/images/logo.png" style="height: 38px;" /></a>
			<!--logo end-->
			<div class="nav notify-row" id="top_menu">
				<!--  notification goes here -->
			</div>
			<div class="top-nav ">

              <ul class="nav pull-right top-menu">
                  <!-- user login dropdown start-->
                  <li class="dropdown">
                      <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                          <img alt="" src="${basePath}/default/img/avatar1_small.jpg">
                          <span class="username">Jhon Doue</span>
                          <b class="caret"></b>
                      </a>
                      <ul class="dropdown-menu extended logout">
                          <div class="log-arrow-up"></div>
                          <li><a href="#"><i class=" icon-suitcase"></i>Profile</a></li>
                          <li><a href="#"><i class="icon-cog"></i> Settings</a></li>
                          <li><a href="#"><i class="icon-bell-alt"></i> Notification</a></li>
                          <li><a href="login.html"><i class="icon-key"></i> Log Out</a></li>
                      </ul>
                  </li>
                  <!-- user login dropdown end -->
              </ul>
          
			</div>
		</header>
		<!--header end-->
		<!--sidebar start-->
		<aside>
			<div id="sidebar" class="nav-collapse ">
				<!-- sidebar menu goes here-->
				<ul class="sidebar-menu" id="nav-accordion">
					<li class="">
						<a href="index.html"> <i class="icon-home"></i> <span>首页</span></a>
					</li>
					<li class="">
						<a href="index.html"> <i class="icon-th"></i> <span>目录管理</span></a>
					</li>
					<li class="sub-menu ">
						<a href="javascript:;"> <i class="icon-book"></i> <span>文档管理</span></a>
						<ul class="sub">
							<li><a href="general.html">General</a></li>
							<li><a href="buttons.html">Buttons</a></li>
							<li><a href="widget.html">Widget</a></li>
							<li><a href="slider.html">Slider</a></li>
							<li><a href="nestable.html">Nestable</a></li>
							<li><a href="font_awesome.html">Font Awesome</a></li>
						</ul>
					</li>
					<li class="sub-menu ">
						<a href="javascript:;"> <i class="icon-book"></i> <span>系统管理</span></a>
						<ul class="sub">
							<li><a href="general.html">General</a></li>
							<li><a href="buttons.html">Buttons</a></li>
							<li><a href="widget.html">Widget</a></li>
							<li><a href="slider.html">Slider</a></li>
							<li><a href="nestable.html">Nestable</a></li>
							<li><a href="font_awesome.html">Font Awesome</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</aside>
		<!--sidebar end-->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
				<!-- page start-->
				Page content goes here
				<!-- page end-->
			</section>
		</section>
		<!--main content end-->
	</section>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="${basePath}/default/js/jquery.js"></script>
	<script src="${basePath}/default/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="${basePath}/default/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="${basePath}/default/js/jquery.scrollTo.min.js"></script>
	<script src="${basePath}/default/js/jquery.nicescroll.js"
		type="text/javascript"></script>
	<script src="${basePath}/default/js/respond.min.js"></script>

	<!--common script for all pages-->
	<script src="${basePath}/default/js/common-scripts.js"></script>


</body>
</html>
