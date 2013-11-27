<#assign menu="article">
<#assign submenu="article_list">
<#include "/admin/head.ftl">
<style type="text/css">
.pagination {
    border-radius: 4px;
    display: inline-block;
    margin: 0;
    padding-left: 0;
}

</style>
	<!--main content start-->
	<section id="main-content">
		<section class="wrapper">
        	<!-- page start-->
            <section class="panel">
            	<header class="panel-heading">
               		 所有文章列表
                </header>
                <div class="panel-body">
                	<div class="adv-table">
                    	<div role="grid" class="dataTables_wrapper" id="hidden-table-info_wrapper">
                            <table class="table table-striped table-advance table-hover">
                            	<thead>
                                	<tr>
                                		<th>文章Id</th>
										<th>文章名称</th>
                						<th>所属目录Id</th>
                						<th>文字图片</th>
                						<th>文章状态</th>
                						<th>时间</th>
                						<th>操作</th>
              						</tr>
                                </thead>
                            	<tbody role="alert" aria-live="polite" aria-relevant="all">
                            		<#list pageVo.list as e>
                            		<tr class="gradeA odd">
                            			<td>${e.fileId}</td>
               							<td>${e.name}</td>
                            			<td>${e.folderId}</td>
                                    	<td>${e.picture}</td>
                                    	<td>${e.status}</td>
                                    	<td>${e.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                                    	<td>
                  							<!-- Icons -->
                  							<a href="${basePath}/admin/article/one?fileId=${e.fileId}" title="修改">
                  								<button class="btn btn-primary btn-xs">
                  									<i class="icon-pencil"></i>
                  								</button>
                  							</a>
                  							<a href="${basePath}/admin/article/recycle?fileId=${e.fileId}&status=hidden" title="回收站">
                  								<button class="btn btn-danger btn-xs">
                  									<i class="icon-trash "></i>
                  								</button>
                  							</a>
                						</td>
                                	</tr>
                                	</#list>
                               	</tbody>
                              </table>
                              <div style="height: 30px;">
                             	<div class="pagination">${pageVo.pageNumHtml} </div>
                              </div>
                           </div>
                        </div>
                  </div>
              </section>
              <!-- page end-->
          </section>
		</section>
		<!--main content end-->
<#include "/admin/foot.ftl">
