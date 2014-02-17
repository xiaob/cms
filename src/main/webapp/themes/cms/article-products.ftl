<#include "header.ftl">
<style type="text/css">
.tab-style-1 .tab-content {
	background: none repeat scroll 0 0 #FFFFFF;
	padding: 20px 15px;
}

#bx-pager a.active img {
	border: 2px solid #0DA3E2;
}
</style>
<div class="page-container">
	<!-- BEGIN BREADCRUMBS -->
	<#include "topbar.ftl">
	<!-- END BREADCRUMBS -->
	<div class="container min-hight">
		<!-- BEGIN BLOG -->
		<div class="row">
			<#include "sidebar.ftl">
			<!-- BEGIN LEFT SIDEBAR -->
			<div class="col-xs-9">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							${folder.name}<#if isAdmin><a target="_blank" style="color: red;"
								href="${basePath}/admin/article/update.htm?articleId=${article.articleId}">[编辑]</a></#if>
						</h3>
					</div>
					<div class="panel-body">				
					<div class="row">
							<div style="height:300px;width:330px;" class="col-md-5 col-sm-5">
			                    <div class="bx-wrapper" style="max-width: 100%;"><div class="bx-viewport" style="width: 100%; overflow: hidden; position: relative; height: 300px;"><ul style="display: block; width: 515%; position: relative; transition-duration: 0.5s; transform: translate3d(-1200px, 0px, 0px);" class="products-photo"><li style="float: left; list-style: none outside none; position: relative; width: 300px;" class="bx-clone"><img src="http://localhost:8080/byvision/upload/2014/02/13/1392257554230.jpg" style="height: 300px; width: 300px;"></li>
								  <li style="float: left; list-style: none outside none; position: relative; width: 300px;"><img src="http://localhost:8080/byvision/upload/2014/02/13/1392257559352.jpg?timestamp=1392274010780" style="height: 300px; width: 300px;"></li>
								  <li style="float: left; list-style: none outside none; position: relative; width: 300px;"><img src="http://localhost:8080/byvision/upload/2014/02/13/1392257555792.jpg" style="height: 300px; width: 300px;"></li>
								  <li style="float: left; list-style: none outside none; position: relative; width: 300px;"><img src="http://localhost:8080/byvision/upload/2014/02/13/1392257554230.jpg" style="height: 300px; width: 300px;"></li>
								<li style="float: left; list-style: none outside none; position: relative; width: 300px;" class="bx-clone"><img src="http://localhost:8080/byvision/upload/2014/02/13/1392257559352.jpg?timestamp=1392274010780" style="height: 300px; width: 300px;"></li></ul></div><div class="bx-controls"></div></div>
							</div>
		                    <div id="bx-pager" class="col-md-7 col-sm-7">
		                   		<h2 style="color: #0DA3E2;">简介师说CMS</h2>
		                   		<h4 style="height:80px;"></h4>
			                    <a href="javascript:void(0);" data-slide-index="0" class="active"><img src="http://localhost:8080/byvision/upload/2014/02/13/1392257559352.jpg" style="height: 150px; width:150px;"></a>
			                    <a href="javascript:void(0);" data-slide-index="1" class=""><img src="http://localhost:8080/byvision/upload/2014/02/13/1392257555792.jpg" style="height: 150px; width:150px;"></a>
			                    <a href="javascript:void(0);" data-slide-index="2" class=""><img src="http://localhost:8080/byvision/upload/2014/02/13/1392257554230.jpg" style="height: 150px; width:150px;"></a>
							</div>					
					</div>
            		<div style="margin-top: 20px;" class="tab-style-1">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#tab-1" data-toggle="tab">产品内容</a></li>
							<li><a href="#tab-2" data-toggle="tab">产品描述</a></li>
							<li><a href="#tab-3" data-toggle="tab">资料下载</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane row-fluid fade in active" id="tab-1">
								<p></p><p>10年积累,我们是java平台的CMS系统管理的创始者，师说CMS是基于微软java平台开发的网站内容管理系统，能够以最低的成本、最少的人力投入在最短的时间内架设一个功能齐全、性能稳定、规模庞大并易于维护的网站平台。同时，师说CMS是开源免费的一款国产的开源项目管理软件，软件本身我们是不收取任何费用的，也不限制用户进行商业用途，方便学习，以及第二次开发。也具有用户自定义模板功能，用户可以选择系统默认的模板，也可以根据自己的喜好，制作出独属于自己的模板，秀出不一样的风采，亮出自己的特色。</p><p></p>
							</div>						
							<div class="tab-pane fade" id="tab-2">
								<p></p>
							</div>
							<div class="tab-pane fade" id="tab-3">
								<ul>
								</ul>
							</div>
						</div>
					</div>
					<!-- 本目录产品 -->
					<div class="row">
						<div style="height:150px;" class="col-md-12 col-sm-12">
						<div class="bx-wrapper" style="max-width: 1100px; margin: 0px auto;"><div class="bx-viewport" style="width: 100%; overflow: hidden; position: relative; height: 150px;"><ul style="display: block; width: 315%; position: relative; transition-duration: 0.5s; transform: translate3d(-1636px, 0px, 0px);" class="folder-products"><li style="float: left; list-style: none outside none; position: relative; width: 816px; margin-right: 2px;" class="bx-clone">
									<a href="http://localhost:8080/byvision/products/shishuo_cms/1.htm">
										<img src="http://localhost:8080/byvision/upload/2014/02/13/1392257559352.jpg?timestamp=1392274010793" alt="" style="height: 150px; width:150px;">
									</a>
								</li>
								<li style="float: left; list-style: none outside none; position: relative; width: 816px; margin-right: 2px;">
									<a href="http://localhost:8080/byvision/products/shishuo_cms/1.htm">
										<img src="http://localhost:8080/byvision/upload/2014/02/13/1392257559352.jpg?timestamp=1392274010793" alt="" style="height: 150px; width:150px;">
									</a>
								</li>
						<li style="float: left; list-style: none outside none; position: relative; width: 816px; margin-right: 2px;" class="bx-clone">
									<a href="http://localhost:8080/byvision/products/shishuo_cms/1.htm">
										<img src="http://localhost:8080/byvision/upload/2014/02/13/1392257559352.jpg?timestamp=1392274010793" alt="" style="height: 150px; width:150px;">
									</a>
								</li></ul></div><div class="bx-controls bx-has-controls-direction"><div class="bx-controls-direction"><a href="" class="bx-prev disabled">Prev</a><a href="" class="bx-next disabled">Next</a></div></div></div>
						</div>
					</div>
				</div>
				</div>
			</div>
			<!-- END LEFT SIDEBAR -->
		</div>
	</div>
</div>
<script type="text/javascript">
	$(function() {
		$('.products-photo').bxSlider({
			moveSlides : 1,
			responsive : true,
			controls : false,
			auto : true,
			pagerCustom : '#bx-pager'
		});
		$('.folder-products').bxSlider({
			minSlides : 6,
			maxSlides : 6,
			slideWidth : 1100,
			slideMargin : 2,
			moveSlides : 1,
			responsive : true,
			auto : true,
			pager : false
		});
	});
</script>
<#include "footer.ftl">