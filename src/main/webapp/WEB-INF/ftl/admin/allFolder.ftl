<#assign menu="system">
<#assign submenu="system_basic">
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
               		 所有目录
                </header>
                <div class="panel-body">
                	<div class="adv-table">
                    	<div role="grid" class="dataTables_wrapper" id="hidden-table-info_wrapper">
                            <table class="table table-striped table-advance table-hover">
                            	<thead>
                                	<tr>
               							<th>
                  							<input class="check-all" type="checkbox" />
                						</th>
                						<th>目录Id</th>
                						<th>父类Id</th>
                						<th>顶栏Id</th>
                						<th>英文名称</th>
                						<th>名称</th>
                						<th>文件数</th>
                						<th>状态</th>
                						<th>类型</th>
                						<th>所属板块</th>
                						<th>序列</th>
                						<th>等级</th>
                						<th>操作</th>
              						</tr>
                                </thead>
                            	<tbody role="alert" aria-live="polite" aria-relevant="all">
                            		<#list pageVo.list as e>
                            		<tr class="gradeA odd">
                            			<td>
                  							<input type="checkbox" name="${e_index}"/>
               							</td>
                            			<td>${e.folderId}</td>
                                    	<td>${e.fatherId}</td>
                                    	<td>${e.topId}</td>
                                    	<td>${e.ename}</td>
                                    	<td>${e.name}</td>
                                    	<td>${e.count}</td>
                                    	<td>${e.status}</td>
                                    	<td>
                                    		<#if e.type==0>
                                    			文章
                                    		<#elseif e.type==1>
                                    			下载
                                    		<#elseif e.type==2>
                                    			商品
                                    		<#elseif e.type==3>
                                    			图片
                                    		</#if>
                                    	</td>
                                    	<td>${e.template}</td>
                                    	<td>${e.sort}</td>
                                    	<td>${e.rank}</td>
                                    	<td>
                  							<!-- Icons -->
                							<a href="/CMS/admin/folder/oneFolder.do?folderId=${e.folderId}" title="修改"><button class="btn btn-primary btn-xs"><i class="icon-pencil"></i></button></a>
                						</td>
                                	</tr>
                                	</#list>
                               	</tbody>
                              </table>
                              <div style="height: 30px;">
                             	<div class="pagination">${pageVo.pageNumHtml} </div>
                              </div>
                           </div>
                           <form method="post">
    							<textarea mce_editable="true"></textarea>
							</form>
                        </div>
                  </div>
              </section>
              <!-- page end-->
          </section>
		</section>
		<!--main content end-->
<#include "foot.ftl">
