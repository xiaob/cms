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
<title>${configMap.sitename} - 后台</title>
<!-- Bootstrap core CSS -->
<link href="${basePath}/system/css/bootstrap.min.css" rel="stylesheet">
<link href="${basePath}/system/css/bootstrap-reset.css"
	rel="stylesheet">
<!--external css-->
<link
	href="${basePath}/system/assets/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<link href="${basePath}/system/css/dropzone.css" rel="stylesheet"/>	
<!-- Custom styles for this template -->
<link href="${basePath}/system/css/style.css" rel="stylesheet">
<link href="${basePath}/system/css/style-responsive.css"
	rel="stylesheet" />

<!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
<!--[if lt IE 9]>
      <script src="${basePath}/system/js/html5shiv.js"></script>
      <script src="${basePath}/system/js/respond.min.js"></script>
    <![endif]-->

<script src="${basePath}/system/js/jquery.js"></script>
</head>
<body>
	<section id="container" class="">
		<!--header start-->
		<header class="header white-bg">
			<!--logo start-->
			<a href="${basePath}" class="logo" title="访问前台页面">
				<img src="${basePath}/system/images/logo.png" style="height: 38px;" />
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
						<a <#if menu="default">class="active"</#if> href="${basePath}/admin"> <i class="icon-home"></i> <span>首页</span></a>
					</li>
					<li class="sub-menu">
						<a href="javascript:;" <#if menu="folder">class="active"</#if>> <i class="icon-folder-open"></i> <span>目录管理</span></a>
						<ul class="sub">
							<li <#if submenu="add_folder">class="active"</#if>><a href="${basePath}/admin/folder/add">增加目录</a></li>
							<li <#if submenu="folder_list">class="active"</#if>><a href="${basePath}/admin/folder/all">目录列表</a></li>
						</ul>						
					</li>
					<li class="sub-menu">
						<a href="javascript:;" <#if menu="article">class="active"</#if>> <i class="icon-book"></i> <span>文章管理</span></a>
						<ul class="sub">
							<li <#if submenu="add_article">class="active"</#if>><a href="${basePath}/admin/file/add">增加文章</a></li>
							<li <#if submenu="article_list">class="active"</#if>><a href="${basePath}/admin/file/articleList">文章列表</a></li>
							<li <#if submenu="article_recycle">class="active"</#if>><a href="${basePath}/admin/file/recycleList">回收站</a></li>
						</ul>
					</li>
					<#if configMap.function_photo=="on">
					<li class="sub-menu ">
						<a href="javascript:;" > <i class="icon-camera-retro"></i> <span>图片管理</span></a>
						<ul class="sub">
							<li <#if submenu="">class="active"</#if>><a href="${basePath}/admin/picture/">上传图片</a></li>
							<li <#if submenu="">class="active"</#if>><a href="${basePath}/admin/picture/list">图片列表</a></li>
							<li <#if submenu="">class="active"</#if>><a href="${basePath}/admin/picture/trash">回收站</a></li>
						</ul>
					</li>
					</#if>
					<#if configMap.function_download=="on">
					<li class="sub-menu ">
						<a href="javascript:;" > <i class="icon-upload-alt"></i> <span>下载管理</span></a>
						<ul class="sub">
							<li><a href="#">上传文件</a></li>
							<li><a href="/CMS/admin/upload">上传文件</a></li>
							<li><a href="buttons.html">文件列表</a></li>
							<li><a href="widget.html">回收站</a></li>
						</ul>
					</li>
					</#if>
					<#if configMap.function_shop=="on">					
					<li class="sub-menu ">
						<a href="javascript:;" > <i class="icon-gift"></i> <span>商品管理</span></a>
						<ul class="sub">
							<li><a href="general.html">增加商品</a></li>
							<li><a href="buttons.html">商品列表</a></li>
							<li><a href="widget.html">回收站</a></li>
						</ul>
					</li>											
					</#if>
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
							<li <#if submenu="system_basic">class="active"</#if>><a href="${basePath}/admin/config/basic">基本设置</a></li>
							<li <#if submenu="add_admin">class="active"</#if>><a href="${basePath}/admin/admin/add">添加管理员</a></li>
							<li <#if submenu="admin_list">class="active"</#if>><a href="${basePath}/admin/admin/allList">管理员列表</a></li>
							<li <#if submenu="add_user">class="active"</#if>><a href="${basePath}/admin/user/add">添加用户</a></li>
							<li <#if submenu="user_list">class="active"</#if>><a href="${basePath}/admin/user/allList">用户列表</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</aside>
		<!--sidebar end-->		
