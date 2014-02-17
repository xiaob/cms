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
	                  	<div class="panel-heading"><h3 class="panel-title">${folder.name}<#if isAdmin><a target="_blank" style="color:red;" href="${basePath}/admin/folder/update.htm?folderId=${folder.folderId}">[编辑]</a></#if></h3></div>
	                    <div class="panel-body">
						<div class="row front-team" style="margin: 0;">
							<div class="col-lg about">
                <h3>Lorem ispsum dolor emnet.</h3>
                <p>
                    Lid est laborum dolo rumes fugats untras. Etharums ser quidem rerum facilis dolores nemis omnis fugats vitaes nemo minima rerums unsers sadips amets.. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore dolore magnm aliquam quaerat voluptatem.
                </p>
                <p>
                    Aenean nibh ante, lacinia non tincidunt nec, lobortis ut tellus. Sed in porta diam. Suspendisse potenti. Donec luctus ullamcorper nulla. Duis nec velit odio.
                </p>
            </div>
            <div class="active item">
                                <img alt="" src="${TEMPLATE_PATH}/img/about_1.jpg">
                                <div class="carousel-caption">
                                    <p>Donec luctus ullamcorper nulla</p>
                                </div>
                            </div>
							<ul class="list-unstyled">
								<@shishuocms_article_page folderId="${folder.folderId}" p="${p}"
								rows="12"> <#list tag_article_page.list as article>
								<li class="col-xs-3 space-mobile widfg"
									style="width: 33%; text-align: center; border-bottom: 1px solid #DDDDDD; height: 300px; margin-bottom: 30px;">
									<div class="thumbnail" style="border-right: 1px dashed #DDDDDD">
										<#list article.attachmentList as attachment> <#if
										attachment.type == "photo" && attachment.status="display"> <a
											href="${basePath}/<#list article.folderPathList as folder>${folder.ename}/</#list>${article.articleId}.htm">
											<img style="width: 150px; height: 150px;" alt=""
											src="${basePath}${attachment.path}">
										</a> <#break> </#if> </#list>
										<h3>
											<a
												href="${basePath}/<#list article.folderPathList as folder>${folder.ename}/</#list>${article.articleId}.htm"
												style="white-space: nowrap;">${article.name}</a> <small>${article.title}</small>
										</h3>
										<div>
											<a class="btn btn-primary"
												href="${basePath}/<#list article.folderPathList as folder>${folder.ename}/</#list>${article.articleId}.htm">Detail
												<i class="fa fa-search"></i>
											</a>
										</div>
									</div>
								</li> <#if (article_index+1)%3==0>
								<div class="clearfix"></div>
								</#if> </#list>
								<div class="text-center">${tag_article_page.pageNumHtml}</div>
								</@shishuocms_article_page>
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