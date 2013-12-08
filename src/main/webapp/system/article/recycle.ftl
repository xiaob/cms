<#assign menu="article">
<#assign submenu="article_recycle">
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
               		 文章回收站
                </header>
                <div class="panel-body">
                	<div class="adv-table">
                    	<div role="grid" class="dataTables_wrapper" id="hidden-table-info_wrapper">
                            <table class="table table-striped table-advance table-hover">
                            	<thead>
                                	<tr>
                						<th>所属目录</th>
                						<th>文章名称</th>
                						<th>文章图片</th>
                						<th>时间</th>
                						<th>操作</th>
              						</tr>
                                </thead>
                            	<tbody role="alert" aria-live="polite" aria-relevant="all">
                            		<#list pageVo.list as e>
                            		<tr class="gradeA odd">
               							<td class="articleId">${e.fileId}</td>
                            			<td>${e.folder.name}</td>
                                    	<td>${e.name}</td>
                                    	<td>
                                    		<#if e.picture=="no_exist">无配图
                                    		<#else>有配图
                                    		</#if>
                                    	</td>
                                    	<td>${e.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                                    	<td>
                  							<!-- Icons -->
                  							<a class="article_update_status" fileId="${e.fileId}" title="还原${e.name}文章">
                  								<button class="btn btn-success btn-xs">
                  									<i class="icon-share-sign"></i>
                  								</button>
                  							</a>
                  							<a class="js_article_delete" fileId="${e.fileId}" title="彻底删除${e.name}文章">
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
<script>
$(function(){
	$('.articleId').hide();
	$('.article_update_status').click(function(){
		var fileId = $(this).attr('fileId');
		var status= "display";
		bootbox.dialog({
			message : "是否"+$(this).attr('title'),
			title : "提示",
				buttons : {
				delete : {
					label : "确定",
					className : "btn-success",
					callback : function() {
					$.post("${basePath}/admin/file/status/update.json", { 
						"fileId": fileId,
						"status": status},
						function(data){
							if(data.result){
								bootbox.dialog({
									message : "操作成功",
									title : "提示",
									buttons : {
										delete : {
											label : "返回回收站",
											className : "btn-success",
											callback : function() {
												window.location.href="${basePath}/admin/article/page?status=hidden"
											}
										},
										cancel : {
											label : "返回文章列表",
											className : "btn-primary",
											callback : function() {
												window.location.href="${basePath}/admin/file/page?type=article";
											}
										}
									}
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
		
	$('.js_article_delete').click(function(){
		var fileId = $(this).attr('fileId')
		bootbox.dialog({
			message : "是否"+$(this).attr('title')+"文件",
			title : "提示",
				buttons : {
				delete : {
					label : "删除",
					className : "btn-success",
					callback : function() {
					$.post("${basePath}/admin/file/delete.json", { "fileId": fileId},
						function(data){
							if(data.result){
								bootbox.dialog({
									message : "删除成功",
									title : "提示",
									buttons : {
										delete : {
											label : "继续清理",
											className : "btn-success",
											callback : function() {
												$.post("${basePath}/admin/folder/delete.json", { "folderId": folderId},
											   	function(data){
											   		if(data.result){
											   			window.location.reload();
											   		}else{
											   			bootbox.alert(data.msg, function() {});
											   		}
											   	}, "json");
											}
										},
										cancel : {
											label : "返回文章列表",
											className : "btn-primary",
											callback : function() {
												window.location.href="${basePath}/admin/file/page?type=article";
											}
										}
									}
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
