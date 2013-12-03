<#assign menu="comment">
<#assign submenu="auditing_list_comment">
<#include "/system/head.ftl">
<style type="text/css">
.m-bot15 {
    margin-bottom: 0;
}
.form-horizontal .control-label {
    font-size: 14px;
    font-weight: 300;
    margin-top: -5px;
    text-align: left;
}
</style>
<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
              <!-- page start-->
              <div class="row">
                  <div class="col-lg-12">
                      <section class="panel">
                          <header class="panel-heading">
                            	正在审核列表
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
                                    		未审核
                                    	</td>
                                    	<td>
                  							<!-- Icons -->
                							<a href="${basePath}/admin/comment/${commentVo.commentId}" title="审核">
                								<button class="btn btn-success btn-xs">
                  									<i class="icon-ok"></i>
                  								</button>
                							</a>
                						</td>
                                	</tr>
                                	</#list>
                               	</tbody>
                              </table>
                           </div>
                        </div>
                          </div>
                      </section>
                  </div>
              </div>
              <!-- page end-->
          </section>
		</section>
		<!--main content end-->
<#include "/system/foot.ftl">