<#include "head.ftl">

    <!-- Bootstrap core CSS -->
    <link href="${basePath}/admin/css/bootstrap.min.css" rel="stylesheet">
    <link href="${basePath}/admin/css/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link href="${basePath}/admin/css/font-awesome.css" rel="stylesheet" />
    <link href="${basePath}/admin/css/dropzone.css" rel="stylesheet"/>
      <!-- Custom styles for this template -->
    <link href="${basePath}/admin/css/style.css" rel="stylesheet">
    <link href="${basePath}/admin/css/style-responsive.css" rel="stylesheet" />
    
<section id="main-content">
          <section class="wrapper">
              <!-- page start-->
              <section class="panel">
                  <header class="panel-heading">
                     <span style="font-weight:bold;font-size:18px;">  图片列表 </span>
                 	 <div class="btn-group">
                                  <button type="button" class="btn btn-primary dropdown-toggle btn-sm" data-toggle="dropdown">搜索<span class="caret"></span></button>
                                  <ul class="dropdown-menu" role="menu">
                                      <li><a href="#">亲人</a></li>
                                      <li><a href="#">朋友</a></li>
                                      <li><a href="#">生活</a></li>
                                      <li><a href="#">俱乐部</a></li>
                                  </ul>
                      </div>
	                  <ul class="breadcrumb" style="float:right;font-size:12px;">
	                          <li><a href="#"><i class="icon-home"></i> 图片管理</a></li>
	                          <li><a href="#">图片列表</a></li>
	                          <li class="active">所有</li>
	                   </ul>
                  </header>
                  <div class="panel-body">
                  	<div class="dropzone clickable dz-clickable dz-started">
	                    <#list filePage.list as file>
	                     <div class="dz-preview dz-processing dz-image-preview dz-success"> 
	                     	 <div class="dz-details">
	                     	 	<div data-dz-size="" class="dz-size" style="font-size:12px;">
	                     	 		<input type="checkbox" style="margin-top:2px;"><span style="padding-left:5px;">${file.name?substring(0,8)}</span>
	                     	 	</div>
	                     	 	<img data-dz-thumbnail=""  src="${file.images}"> 
	                     	 </div>
	                     	<div class="dz-error-mark delete" style="opacity: 1;"><span>✘</span></div>
	                     </div>
	                     </#list>
	                     ${filePage.pageNumHtml}
                     </div>
                     <div style="margin-top:10px;">
                     	<input type="checkbox" style="margin-top:2px;">全选
                     	<button class="btn btn-primary" type="button">批量删除</button>
                     	<div class="btn-group">
                                  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">批量修改<span class="caret"></span></button>
                                  <ul class="dropdown-menu" role="menu">
                                      <li><a href="#">亲人</a></li>
                                      <li><a href="#">朋友</a></li>
                                      <li><a href="#">生活</a></li>
                                      <li><a href="#">俱乐部</a></li>
                                  </ul>
                        </div>
                     </div>
                  </div>
              </section>
              <!-- page end-->
          </section>
      </section>
	    <!-- js placed at the end of the document so the pages load faster -->
  <!-- js placed at the end of the document so the pages load faster -->
    <script src="${basePath}/admin/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="${basePath}/admin/js/dropzone.js"></script>
    <!--common script for all pages-->
    <script src="js/common-scripts.js"></script>
	  
<#include "foot.ftl">
