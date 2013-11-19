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
<link href="${basePath}/admin/css/bootstrap.min.css" rel="stylesheet">
<link href="${basePath}/admin/css/bootstrap-reset.css"
	rel="stylesheet">
<!--external css-->
<link
	href="${basePath}/admin/assets/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<link href="${basePath}/admin/css/dropzone.css" rel="stylesheet"/>	
<!-- Custom styles for this template -->
<link href="${basePath}/admin/css/style.css" rel="stylesheet">
<link href="${basePath}/admin/css/style-responsive.css"
	rel="stylesheet" />

<!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
<!--[if lt IE 9]>
      <script src="${basePath}/admin/js/html5shiv.js"></script>
      <script src="${basePath}/admin/js/respond.min.js"></script>
    <![endif]-->
    
</head>

<body>

	<section id="container" class="">
		<!--header start-->
		<header class="header white-bg">
			<!--logo start-->
			<a href="${basePath}" class="logo" title="访问前台页面">
				<img src="${basePath}/admin/images/logo.png" style="height: 38px;" />
			</a>
			<!--logo end-->
			<div class="nav notify-row" id="top_menu">
				<!--  notification goes here -->
			</div>
			<div class="top-nav ">

              <ul class="nav pull-right top-menu">
                  <!-- user login dropdown start-->
                  <li class="dropdown">
                      <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                          <img alt="" src="${basePath}/admin/img/avatar1_small.jpg">
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
						<a  class="active" href="${basePath}/admin"> <i class="icon-home"></i> <span>首页</span></a>
					</li>
					<li class="sub-menu">
						<a href="javascript:;"> <i class="icon-folder-open"></i> <span>目录管理</span></a>
						<ul class="sub">
							<li><a href="/CMS/admin/folder/addFolder.do">增加目录</a></li>
							<li><a href="/CMS/admin/folder/allFolder.do">目录列表</a></li>
						</ul>						
					</li>
					<li class="sub-menu">
						<a href="javascript:;"> <i class="icon-book"></i> <span>文章管理</span></a>
						<ul class="sub">
							<li><a href="/CMS/admin/file/addArticle.do">增加文章</a></li>
							<li><a href="/CMS/admin/file/articleList.do">文章列表</a></li>
							<li><a href="/CMS/admin/file/recycleList.do">回收站</a></li>
						</ul>
					</li>
					<li class="sub-menu ">
						<a href="javascript:;"> <i class="icon-camera-retro"></i> <span>图片管理</span></a>
						<ul class="sub">
							<li><a href="general.html">上传图片</a></li>
							<li><a href="buttons.html">图片列表</a></li>
							<li><a href="widget.html">回收站</a></li>
						</ul>
					</li>
					<li class="sub-menu ">
						<a href="javascript:;"> <i class="icon-upload-alt"></i> <span>下载管理</span></a>
						<ul class="sub">
							<li><a href="/CMS/admin/upload">上传文件</a></li>
							<li><a href="buttons.html">文件列表</a></li>
							<li><a href="widget.html">回收站</a></li>
						</ul>
					</li>
					<li class="sub-menu ">
						<a href="javascript:;"> <i class="icon-gift"></i> <span>商品管理</span></a>
						<ul class="sub">
							<li><a href="general.html">增加商品</a></li>
							<li><a href="buttons.html">商品列表</a></li>
							<li><a href="widget.html">回收站</a></li>
						</ul>
					</li>
					<li class="sub-menu ">
						<a href="javascript:;"> <i class="icon-shopping-cart"></i> <span>订单管理</span></a>
						<ul class="sub">
							<li><a href="general.html">增加商品</a></li>
							<li><a href="buttons.html">商品列表</a></li>
							<li><a href="widget.html">回收站</a></li>
						</ul>
					</li>										
					<li class="sub-menu ">
						<a href="javascript:;"> <i class="icon-group"></i> <span>用户管理</span></a>
						<ul class="sub">
							<li><a href="/CMS/admin/user/addUser.do">添加用户</a></li>
							<li><a href="buttons.html">Buttons</a></li>
							<li><a href="widget.html">Widget</a></li>
							<li><a href="slider.html">Slider</a></li>
							<li><a href="nestable.html">Nestable</a></li>
							<li><a href="font_awesome.html">Font Awesome</a></li>
						</ul>
					</li>
					<li class="sub-menu ">
						<a href="javascript:;"> <i class="icon-signin"></i> <span>招聘管理</span></a>
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
						<a href="javascript:;" <#if menu="system">class="active"</#if>> <i class="icon-cogs"></i> <span>系统管理</span></a>
						<ul class="sub">
							<li  <#if submenu="system_basic">class="active"</#if>><a href="${basePath}/admin/config/basic">基本设置</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</aside>
		<!--sidebar end-->		
