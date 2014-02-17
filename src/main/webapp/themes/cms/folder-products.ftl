<#include "header.ftl">
<div class="page-container">
	<!-- BEGIN BREADCRUMBS -->
	<#include "topbar.ftl">
	<!-- END BREADCRUMBS -->
	<!-- BEGIN CONTAINER -->
	<div class="container min-hight">
		<!-- BEGIN BLOG -->
		<div class="row">
			<#include "sidebar.ftl">
			<!-- BEGIN LEFT SIDEBAR -->
			<div class="col-xs-9 blog-posts margin-bottom-40">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title" style="color: #0DA3E2;">
							${folder.name} <#if folder.folderList?size gt 0 && folder.level
							== 2> :&nbsp;&nbsp;&nbsp;<small> <#list folder.folderList
								as f> <a
								href="${basePath}/products/${folder.ename}/${f.ename}/index.htm">${f.name}</a>
								| </#list>
							</small> </#if>
						</h3>
					</div>
					<div class="panel-body">
						<div class="row front-team" style="margin: 0;">
							<ul class="list-unstyled">
								<li style="width: 33%; text-align: center; border-bottom: 1px solid #DDDDDD; height: 300px; margin-bottom: 30px;" class="col-xs-3 space-mobile widfg">
									<div style="border-right: 1px dashed #DDDDDD" class="thumbnail">
										  <a href="http://localhost:8080/byvision/products/shishuo_cms/1.htm">
											<img src="http://localhost:8080/byvision/upload/2014/02/13/1392257559352.jpg" alt="" style="width: 150px; height: 150px;">
										</a> 
										<h3>
											<a style="white-space: nowrap;" href="http://localhost:8080/byvision/products/shishuo_cms/1.htm">简介师说CMS</a> <small></small>
										</h3>
										<div>
											<a href="http://localhost:8080/byvision/products/shishuo_cms/1.htm" class="btn btn-primary">Detail
												<i class="fa fa-search"></i>
											</a>
										</div>
									</div>
								</li>
								<li style="width: 33%; text-align: center; border-bottom: 1px solid #DDDDDD; height: 300px; margin-bottom: 30px;" class="col-xs-3 space-mobile widfg">
									<div style="border-right: 1px dashed #DDDDDD" class="thumbnail">
										  <a href="http://localhost:8080/byvision/products/shishuo_cms/1.htm">
											<img src="http://localhost:8080/byvision/upload/2014/02/13/1392257559352.jpg" alt="" style="width: 150px; height: 150px;">
										</a> 
										<h3>
											<a style="white-space: nowrap;" href="http://localhost:8080/byvision/products/shishuo_cms/1.htm">简介师说CMS</a> <small></small>
										</h3>
										<div>
											<a href="http://localhost:8080/byvision/products/shishuo_cms/1.htm" class="btn btn-primary">Detail
												<i class="fa fa-search"></i>
											</a>
										</div>
									</div>
								</li>
								<li style="width: 33%; text-align: center; border-bottom: 1px solid #DDDDDD; height: 300px; margin-bottom: 30px;" class="col-xs-3 space-mobile widfg">
									<div style="border-right: 1px dashed #DDDDDD" class="thumbnail">
										  <a href="http://localhost:8080/byvision/products/shishuo_cms/1.htm">
											<img src="http://localhost:8080/byvision/upload/2014/02/13/1392257559352.jpg" alt="" style="width: 150px; height: 150px;">
										</a> 
										<h3>
											<a style="white-space: nowrap;" href="http://localhost:8080/byvision/products/shishuo_cms/1.htm">简介师说CMS</a> <small></small>
										</h3>
										<div>
											<a href="http://localhost:8080/byvision/products/shishuo_cms/1.htm" class="btn btn-primary">Detail
												<i class="fa fa-search"></i>
											</a>
										</div>
									</div>
								</li>
								<li style="width: 33%; text-align: center; border-bottom: 1px solid #DDDDDD; height: 300px; margin-bottom: 30px;" class="col-xs-3 space-mobile widfg">
									<div style="border-right: 1px dashed #DDDDDD" class="thumbnail">
										  <a href="http://localhost:8080/byvision/products/shishuo_cms/1.htm">
											<img src="http://localhost:8080/byvision/upload/2014/02/13/1392257559352.jpg" alt="" style="width: 150px; height: 150px;">
										</a> 
										<h3>
											<a style="white-space: nowrap;" href="http://localhost:8080/byvision/products/shishuo_cms/1.htm">简介师说CMS</a> <small></small>
										</h3>
										<div>
											<a href="http://localhost:8080/byvision/products/shishuo_cms/1.htm" class="btn btn-primary">Detail
												<i class="fa fa-search"></i>
											</a>
										</div>
									</div>
								</li>
								<li style="width: 33%; text-align: center; border-bottom: 1px solid #DDDDDD; height: 300px; margin-bottom: 30px;" class="col-xs-3 space-mobile widfg">
									<div style="border-right: 1px dashed #DDDDDD" class="thumbnail">
										  <a href="http://localhost:8080/byvision/products/shishuo_cms/1.htm">
											<img src="http://localhost:8080/byvision/upload/2014/02/13/1392257559352.jpg" alt="" style="width: 150px; height: 150px;">
										</a> 
										<h3>
											<a style="white-space: nowrap;" href="http://localhost:8080/byvision/products/shishuo_cms/1.htm">简介师说CMS</a> <small></small>
										</h3>
										<div>
											<a href="http://localhost:8080/byvision/products/shishuo_cms/1.htm" class="btn btn-primary">Detail
												<i class="fa fa-search"></i>
											</a>
										</div>
									</div>
								</li>
								<li style="width: 33%; text-align: center; border-bottom: 1px solid #DDDDDD; height: 300px; margin-bottom: 30px;" class="col-xs-3 space-mobile widfg">
									<div style="border-right: 1px dashed #DDDDDD" class="thumbnail">
										  <a href="http://localhost:8080/byvision/products/shishuo_cms/1.htm">
											<img src="http://localhost:8080/byvision/upload/2014/02/13/1392257559352.jpg" alt="" style="width: 150px; height: 150px;">
										</a> 
										<h3>
											<a style="white-space: nowrap;" href="http://localhost:8080/byvision/products/shishuo_cms/1.htm">简介师说CMS</a> <small></small>
										</h3>
										<div>
											<a href="http://localhost:8080/byvision/products/shishuo_cms/1.htm" class="btn btn-primary">Detail
												<i class="fa fa-search"></i>
											</a>
										</div>
									</div>
								</li>
								
							</ul>
						</div>
					</div>
				</div>
			</div>
			<!-- END LEFT SIDEBAR -->
		</div>
		<!-- END BEGIN BLOG -->
	</div>
	<!-- END CONTAINER -->
</div>
<#include "footer.ftl">