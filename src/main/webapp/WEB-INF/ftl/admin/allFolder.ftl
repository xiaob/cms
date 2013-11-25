<#assign menu="folder">
<#assign submenu="folder_list">
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
                		<form id="update_sort_form" method="post" class="form-horizontal tasi-form" action="${basePath}/admin/folder/update/sort.json">
						<fieldset>
                    	<div role="grid" class="dataTables_wrapper" id="hidden-table-info_wrapper">
                            <table class="table table-striped table-advance table-hover">
                            	<thead>
                                	<tr>
                                		<th>顺序</th>
                						<th>英文名称</th>
                						<th>名称</th>
                						<th>文件数</th>
                						<th>状态</th>
                						<th>类型</th>
                						<th>所属板块</th>
                						<th>等级</th>
                						<th>操作</th>
              						</tr>
                                </thead>
                            	<tbody role="alert" aria-live="polite" aria-relevant="all">
                            		<#list list as e>
                            		<tr class="gradeA odd">
                            			<td class="folderSort"><input type="text" value="${e.sort}" name="sort" class="txt" style="width:40px;">
                            			</td>
										<td>
										<#list 1..e.level as i>
										————
										</#list>
                                    	${e.ename}</td>
                                    	<td>${e.name}</td>
                                    	<td>${e.count}</td>
                                    	<td>${e.status}</td>
                                    	<td>${e.type}</td>
                                    	<td>${e.template}</td>
                                    	<td>${e.rank}</td>
                                    	<td>
                  							<!-- Icons -->
                							<a href="${basePath}/admin/folder/${e.folderId}" title="修改">
                								<button class="btn btn-primary btn-xs">
                									<i class="icon-pencil"></i>
                								</button>
                							</a>
                							<a href="${basePath}/admin/folder/delete/${e.folderId}" title="删除">
                  								<button class="btn btn-danger btn-xs">
                  									<i class="icon-trash "></i>
                  								</button>
                  							</a>
                						</td>
                                	</tr>
                                	</#list>
                               	</tbody>
                              </table>
                           </div>
                           <div class="form-group">
                        	<label class="col-sm-2 col-sm-2 control-label"></label>
                            <button class="btn btn-danger" type="submit">提交</button>
                        </div>
						</fieldset>
						</form>
                        </div>
                  </div>
              </section>
              <!-- page end-->
          </section>
		</section>
		<!--main content end-->
<script type="text/javascript">
	$(function() {
		$('#update_sort_form').ajaxForm({
			dataType : 'json',
			success : function(data) {
				if (data.result) {
					bootbox.alert("修改成功，将刷新页面", function() {
						window.location.reload();
					});
				}else{
					showErrors($('#update_sort_form'),data.errors);
				}
			}
		});
	});	
</script>
<#include "foot.ftl">
