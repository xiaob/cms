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
			<div class="col-md-9 col-sm-9 blog-posts margin-bottom-40">
					<div class="panel panel-default">   
	                  	<div class="panel-heading"><h4 class="panel-title">${folder.name}<#if isAdmin><a target="_blank" style="color:red;" href="${basePath}/admin/article/add.htm?folderId=${folder.folderId}">[增加文章]</a></#if></h4></div>
	                    <div class="panel-body">
	                    <ul>
							<li>
	                    <div class="col-lg-12">
                        <div class="full-width-media-text">
                            <h4><a href="http://localhost:8080/byvision/news/shishuo_news/3.htm">师说CMS安装指南</a><span>(2014-02-13) </span></h4>
                            <p>
                                Lorem ipsum dolor sit amet, <a href="javascript:;">This is text link</a> Curabitur bibendum ornare dolor quis ullamcorper ligula sodales at....
                            </p>
                            <p>
                                ---------------------------------------------------------------------------------------------------------------------------------------------
                            </p>
                        </div>
                    </div>
                    </li>
                    <li>
	                    <div class="col-lg-12">
                        <div class="full-width-media-text">
                            <h4><a href="http://localhost:8080/byvision/news/shishuo_news/3.htm">师说CMS安装指南</a><span>(2014-02-13) </span></h4>
                            <p>
                                Lorem ipsum dolor sit amet, <a href="javascript:;">This is text link</a> Curabitur bibendum ornare dolor quis ullamcorper ligula sodales at....
                            </p>
                            <p>
                                ---------------------------------------------------------------------------------------------------------------------------------------------
                            </p>
                        </div>
                    </div>
                    </li>
                    <li>
	                    <div class="col-lg-12">
                        <div class="full-width-media-text">
                            <h4><a href="http://localhost:8080/byvision/news/shishuo_news/3.htm">师说CMS安装指南</a><span>(2014-02-13) </span></h4>
                            <p>
                                Lorem ipsum dolor sit amet, <a href="javascript:;">This is text link</a> Curabitur bibendum ornare dolor quis ullamcorper ligula sodales at....
                            </p>
                            <p>
                                ---------------------------------------------------------------------------------------------------------------------------------------------
                            </p>
                        </div>
                    </div>
                    </li>
                    </ul>
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