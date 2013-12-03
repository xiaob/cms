<#assign menu="comment">
<#assign submenu="comment_list">
<#include "/system/head.ftl">
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
               		 所有评论
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
                                    	<td>${commentVo.status}</td>
                                    	<td>
                                    		<#if commentVo.status=="hidden">
                                    		<a href="/CMS/admin/comment/${commentVo.commentId}" title="审核">
                                    			<button class="btn btn-success btn-xs">
                  									<i class="icon-ok"></i>
                  								</button>
                                    		</a>
                                    		<#else>
                                    		<a href="/CMS/admin/comment/cancel/${commentVo.commentId}" title="撤销审核">
                                    			<button class="btn btn-danger btn-xs">
                  									<i class="icon-trash "></i>
                  								</button>
                                    		</a>
                                    		</#if>
                                    	</td>
                                	</tr>
                                	</#list>
                               	</tbody>
                              </table>
                           </div>
                        </div>
                  </div>
              </section>
              <!-- page end-->
          </section>
		</section>
		<!--main content end-->
<#include "/system/foot.ftl">
