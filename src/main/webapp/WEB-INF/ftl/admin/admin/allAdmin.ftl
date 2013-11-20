<#assign menu="system">
<#assign submenu="admin_list">
<#include "../head.ftl">
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
               		 所有管理员列表
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
                						<th>管理员Id</th>
                						<th>管理员名称</th>
                						<th>密码</th>
                						<th>状态</th>
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
                            			<td>${e.adminId}</td>
                                    	<td>${e.name}</td>
                                    	<td>${e.password}</td>
                                    	<td>${e.status}</td>
                                    	<td>${e.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                                    	<td>
                  							<!-- Icons -->
                							<a href="/CMS/admin/admin/one?adminId=${e.adminId}" title="修改">
                								<button class="btn btn-primary btn-xs">
                									<i class="icon-pencil"></i>
                								</button>
                							</a>
                							<a href="/CMS/admin/admin/delete?adminId=${e.adminId}" title="删除">
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
<#include "../foot.ftl">
