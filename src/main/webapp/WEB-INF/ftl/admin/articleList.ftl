<#include "head.ftl">
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
                            <table cellspacing="0" cellpadding="0" border="0" id="hidden-table-info" class="display table table-bordered dataTable" aria-describedby="hidden-table-info_info">
                            	<thead>
                                	<tr>
               							<th>
                  							<input class="check-all" type="checkbox" />
                						</th>
                						<th>文件Id</th>
                						<th>所属目录Id</th>
                						<th>文章名称</th>
                						<th>文章链接</th>
                						<th>文字图片</th>
                						<th>文章类型</th>
                						<th>时间</th>
                						<th>操作</th>
              						</tr>
                                </thead>
                            	<tbody role="alert" aria-live="polite" aria-relevant="all">
                            		<#list pageVo.list as e>
                            		<tr class="gradeA odd">
                            			<td>
                  							<input type="checkbox" name="${e_index}"/>
               							</td>
               							<td>${e.fileId}</td>
                            			<td>${e.folderId}</td>
                                    	<td>${e.name}</td>
                                    	<td><a href="">${e.url}</a></td>
                                    	<td>${e.images}</td>
                                    	<td>
                                    		${e.description}
                                    	</td>
                                    	<td>
                  							<!-- Icons -->
                  							<a href="/CMS/admin/folder/oneFolder.do?folderId=${e.folderId}" title="修改">修改</a>
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
<#include "foot.ftl">
