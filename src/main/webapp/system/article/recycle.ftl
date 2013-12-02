<#assign menu="article">
<#assign submenu="article_recycle">
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
               		 文章回收站
                </header>
                <div class="panel-body">
                	<div class="adv-table">
                    	<div role="grid" class="dataTables_wrapper" id="hidden-table-info_wrapper">
                            <table class="table table-striped table-advance table-hover">
                            	<thead>
                                	<tr>
                						<th>文件Id</th>
                						<th>所属目录Id</th>
                						<th>文章名称</th>
                						<th>文字图片</th>
                						<th>文章类型</th>
                						<th>时间</th>
                						<th>操作</th>
              						</tr>
                                </thead>
                            	<tbody role="alert" aria-live="polite" aria-relevant="all">
                            		<#list pageVo.list as e>
                            		<tr class="gradeA odd">
               							<td>${e.fileId}</td>
                            			<td>${e.folderId}</td>
                                    	<td>${e.name}</td>
                                    	<td>${e.picture}</td>
                                    	<td>${e.content}</td>
                                    	<td>${e.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                                    	<td>
                  							<!-- Icons -->
                  							<a href="${basePath}/admin/article/recycle?fileId=${e.fileId}&status=display" title="还原">
                  								<button class="btn btn-success btn-xs">
                  									<i class="icon-ok"></i>
                  								</button>
                  							</a>
                  							<a href="${basePath}/admin/article/delete?fileId=${e.fileId}" title="彻底删除">
                  								<button class="btn btn-danger btn-xs">
                  									<i class="icon-remove"></i>
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
