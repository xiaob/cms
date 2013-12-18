<#assign menu="folder">
<#assign submenu="folder_list">
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
               		 所有目录
                </header>
                <div class="panel-body">
                	<div class="adv-table">
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
                						<th>等级</th>
                						<th>操作</th>
              						</tr>
                                </thead>
                            	<tbody role="alert" aria-live="polite" aria-relevant="all">
                            		<#list list as e>
                            		<tr class="gradeA odd">
                            			<td class="folderSort">
                            			<#list 1..e.level as i>
										—
										</#list>
                            			<input type="text" folderId="${e.folderId}" value="${e.sort}" name="sort" class="js_folder_sort" style="width:40px;">
                            			</td>
										<td><a href="${basePath}/${e.ename}.htm">${e.ename}</a></td>
                                    	<td>${e.name}</td>
                                    	<td>${e.count}</td>
                                    	<td><#if e.status="display" >显示<#else>隐藏</#if></td>
                                    	<td>
                                    	<#if e.type="article">
                                    	文章
                                    	<#elseif e.type="photo">
                                    	相册
                                    	<#elseif e.type="file">
                                    	下载
                                    	<#elseif e.type="shop">
                                    	商城
                                    	</#if>
                                    	</td>
                                    	<td>
										<#if e.rank="everyone">
                                    	所有人
                                    	<#elseif e.rank="login">
                                    	登陆用户
                                    	<#elseif e.rank="vip">
                                    	VIP
                                    	<#elseif e.rank="admin">
                                    	管理员
                                    	</#if>                                    	
                                    	</td>
                                    	<td>
                  							<!-- Icons -->
                							<a href="${basePath}/admin/folder/${e.folderId}.htm" title="修改">
                								<button class="btn btn-primary btn-xs">
                									<i class="icon-pencil"></i>
                								</button>
                							</a>
                							<a class="js_folder_delete" folderId="${e.folderId}" href="javascript:void(0);" title="删除${e.name}">
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
                           <div><button class="btn btn-info js_update_sort" type="button"><i class="icon-refresh"></i> 更新排序</button></div>
                        </div>
                  </div>
              </section>
              <!-- page end-->
          </section>
		</section>
		<!--main content end-->
		<script>
			$(function(){
				$('.js_update_sort').click(function(){
					var folderSort=new Array();
					$('.js_folder_sort').each(function(i, element){
						var folder= {};
						folder.folderId=$(element).attr('folderId');
						folder.sort=$(element).val();
						folderSort.push(folder);				
					});
					$.post("${basePath}/admin/folder/sort.json", { "sortJson": $.toJSON(folderSort)},function(data){
						if(data.result){
							bootbox.alert("更新成功", function() {
								window.location.href="${basePath}/admin/folder/page.htm";
							});
						}else{
							bootbox.alert(data.msg, function() {});
						}
					}, "json");
				});
				$('.js_folder_delete').click(function(){
					var folderId = $(this).attr('folderId')
					bootbox.dialog({
						message : "是否"+$(this).attr('title')+"文件夹",
						title : "提示",
						buttons : {
							delete : {
								label : "删除",
								className : "btn-success",
								callback : function() {
									$.post("${basePath}/admin/folder/delete.json", { "folderId": folderId},
								   	function(data){
								   		if(data.result){
								   			bootbox.alert("删除成功", function() {
												window.location.href="${basePath}/admin/folder/page.htm";
											});
								   		}else{
								   			bootbox.alert(data.msg, function() {});
								   		}
								   	}, "json");
								}
							},
							cancel : {
								label : "取消",
								className : "btn-primary",
								callback : function() {
								}
							}
						}
					});					
				});			
			});
		</script>
<#include "/system/foot.ftl">
