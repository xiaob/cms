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
<title>${SYS_SITENAME} - 后台</title>
<!-- Bootstrap core CSS -->
<link href="${basePath}/system/css/bootstrap.min.css" rel="stylesheet">
<link href="${basePath}/system/css/bootstrap-reset.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${basePath}/system/css/gallery.css" />	
<!--external css-->
<link
	href="${basePath}/system/assets/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<link href="${basePath}/system/assets/fancybox/source/jquery.fancybox.css" rel="stylesheet" />	
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
                  <li>
                      <input type="text" placeholder="Search" class="form-control search">
                  </li>
                  <!-- user login dropdown start-->
                  <li class="dropdown">
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                          <img src="${SESSION_ADMIN.faceUrl}" style="width:29;height:29px;" alt="">
                          <span class="username">${SESSION_ADMIN.name}</span>
                          <b class="caret"></b>
                      </a>
                      <ul class="dropdown-menu extended logout">
                          <div class="log-arrow-up"></div>
                          <li><a href="#"><i class="icon-cog"></i> 设置</a></li>
                          <li><a href="login.html"><i class="icon-key"></i> 安全退出</a></li>
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
						<a href="javascript:;" <#if menu="folder">class="active"</#if>> <i class="icon-folder-open"></i> <span>目录</span></a>
						<ul class="sub">
							<li <#if submenu="add_folder">class="active"</#if>><a href="${basePath}/admin/folder/add">增加目录</a></li>
							<li <#if submenu="folder_list">class="active"</#if>><a href="${basePath}/admin/folder/page">目录列表</a></li>
						</ul>						
					</li>
					<li class="sub-menu">
						<a href="javascript:;" <#if menu="article">class="active"</#if>> <i class="icon-book"></i> <span>文章</span></a>
						<ul class="sub">
							<li <#if submenu="add_article">class="active"</#if>><a href="${basePath}/admin/article/add">增加文章</a></li>
							<li <#if submenu="article_list">class="active"</#if>><a href="${basePath}/admin/file/page?type=article">文章列表</a></li>
							<li <#if submenu="article_recycle">class="active"</#if>><a href="${basePath}/admin/article/page?status=hidden">回收站</a></li>
						</ul>
					</li>
					<#if SYS_FUNCTION_PHOTO=="on">
					<li class="sub-menu ">
						<a href="javascript:;" <#if menu="appendix">class="active"</#if>> <i class="icon-camera-retro"></i> <span>附件</span></a>
						<ul class="sub">
							<li <#if submenu="add_appendix">class="active"</#if>><a href="${basePath}/admin/picture/upload">上传附件</a></li>
							<li <#if submenu="photo_list">class="active"</#if>><a href="${basePath}/admin/file/page?type=photo">图片列表</a></li>
							<li><a href="${basePath}/admin/file/page?type="download"">文件列表</a></li>
							<li <#if submenu="re">class="active"</#if>><a href="${basePath}/admin/picture/trash">回收站</a></li>
						</ul>
					</li>
					</#if>
					<#if SYS_FUNCTION_SHOP=="on">					
					<li class="sub-menu ">
						<a href="javascript:;" > <i class="icon-gift"></i> <span>商品</span></a>
						<ul class="sub">
							<li><a href="general.html">增加商品</a></li>
							<li><a href="${basePath}/admin/file/page?type="shop"">商品列表</a></li>
							<li><a href="widget.html">回收站</a></li>
						</ul>
					</li>											
					</#if>
					<li class="sub-menu">
						<a href="javascript:;" <#if menu="comment">class="active"</#if>> <i class="icon-book"></i> <span>评论</span></a>
						<ul class="sub">
							<li <#if submenu="comment_list">class="active"</#if>><a href="${basePath}/admin/comment/page">所有评论</a></li>
							<li <#if submenu="auditing_list_comment">class="active"</#if>><a href="${basePath}/admin/comment/auditing/list">审核评论列表</a></li>
						</ul>
					</li>
					<li class="sub-menu">
						<a href="javascript:;" <#if menu="sdgb">class="active"</#if>> <i class="icon-book"></i> <span>主题</span></a>
						<ul class="sub">
							<li <#if submenu="utg">class="active"</#if>><a href="javascript:;">sdg</a></li>
							<li <#if submenu="dgbnhnht">class="active"</#if>><a href="javascript:;">dfh</a></li>
						</ul>
					</li>
					<li class="sub-menu">
						<a href="javascript:;" <#if menu="dfbgt">class="active"</#if>> <i class="icon-book"></i> <span>插件</span></a>
						<ul class="sub">
							<li <#if submenu="wergre">class="active"</#if>><a href="javascript:;">sdg</a></li>
							<li <#if submenu="dfhtrntr">class="active"</#if>><a href="javascript:;">dfh</a></li>
						</ul>
					</li>
					<li class="sub-menu ">
						<a href="javascript:;" <#if menu="user">class="active"</#if>> <i class="icon-signin"></i> <span>用户</span></a>
						<ul class="sub">
							<li <#if submenu="add_user">class="active"</#if>><a href="${basePath}/admin/user/add">添加用户</a></li>
							<li <#if submenu="user_list">class="active"</#if>><a href="${basePath}/admin/user/page">用户列表</a></li>
						</ul>
					</li>	
					<li class="sub-menu ">
						<a href="javascript:;"> <i class="icon-signin"></i> <span>招聘</span></a>
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
						<a href="javascript:;" <#if menu="system">class="active"</#if>> <i class="icon-cogs"></i> <span>设置</span></a>
						<ul class="sub">
							<li <#if submenu="system_basic">class="active"</#if>><a href="${basePath}/admin/config/basic">基本设置</a></li>
							<li <#if submenu="system_picture">class="active"</#if>><a href="${basePath}/admin/config/picture">图片设置</a></li>
							<li <#if submenu="add_admin">class="active"</#if>><a href="${basePath}/admin/admin/add">添加管理员</a></li>
							<li <#if submenu="admin_list">class="active"</#if>><a href="${basePath}/admin/admin/page">管理员列表</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</aside>
		<!--sidebar end-->		
