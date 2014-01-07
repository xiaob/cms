<#assign menu="comment">
<#if statusType=="hidden">
<#assign submenu="auditing_list_comment">
<#else>
<#assign submenu="comment_list">
</#if>
<#include "/system/head.ftl">
<style type="text/css">
.pagination {
    border-radius: 4px;
    display: inline-block;
    margin: 0;
    padding-left: 0;
}
.breadcrumb > li + li:before {
    color: #CCCCCC;
    content: "| ";
    padding: 0 5px;
}
</style>
	<!--main content start-->
	<section id="main-content">
		<section class="wrapper">
        	<!-- page start-->
        	<div class="row">
                  <div class="col-lg-12">
                      <!--breadcrumbs start -->
                      <ul class="breadcrumb">
                          <li><a href="${basePath}/admin/comment/page.htm">所有评论(${allCount})</a></li>
               		 	  <li><a href="${basePath}/admin/comment/page.htm?status=display">已通过审核评论(${displayCount})</a></li>
               		 	  <li><a href="${basePath}/admin/comment/page.htm?status=hidden">审核中的评论(${hiddenCount})</a></li>
               		 	  <li><a href="${basePath}/admin/comment/page.htm?status=trash">垃圾评论(${trashCount})</a></li>
                      </ul>
                      <!--breadcrumbs end -->
                  </div>
              </div>  
            <section class="panel">
            	<header class="panel-heading">
                <#if statusType=="hidden">正在审核评论列表
                <#elseif statusType=="display">已通过审核评论列表
                <#elseif statusType=="trash">垃圾评论列表
                <#else>所有评论列表
                </#if>
                </header>
                <div class="panel-body">
                	<div class="adv-table">
                    	<div role="grid" class="dataTables_wrapper" id="hidden-table-info_wrapper">
                            <table class="table table-striped table-advance table-hover">
                            	<thead>
                                	<tr>
                						<th>评论名称</th>
                						<th>内容</th>
                						<th>状态</th>
                						<th>操作</th>
              						</tr>
                                </thead>
                            	<tbody role="alert" aria-live="polite" aria-relevant="all">
                            		<#list pageVo.list as commentVo>
                            		<tr class="gradeA odd">
                                    	<td>${commentVo.name}</td>
                                    	<td>${commentVo.content}</td>
                                    	<td>
                                    		<#if commentVo.status=="hidden">正在审核
                                    		<#elseif commentVo.status=="display">已通过审核
                                    		<#else>垃圾评论
                                    		</#if>
                                    	</td>
                                    	<td>
                                    		<a href="/byvision/admin/comment/${commentVo.commentId}.htm" title="查看详情">
                                    			编辑
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
<#include "/system/foot.ftl">
