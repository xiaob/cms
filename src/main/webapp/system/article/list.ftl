<#assign menu="article">
<#assign submenu="article_list">
<#include "/system/head.ftl">
<style type="text/css">
.pagination {
    border-radius: 4px;
    display: inline-block;
    margin: 0;
    padding-left: 0;
}

.howto, .nonessential, #edit-slug-box, .form-input-tip, .subsubsub {
    color: #666666;
}

.subsubsub {
    float: left;
    font-size: 12px;
    list-style: none outside none;
    margin: 8px 0 5px;
    padding: 0;
}

.form-group{
	width:100%;
}

.count{
	position:absolute ;
	right:0px;
}

.arrticle_status{
	float:left;
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
                	<ul class="subsubsub">
						<li class="arrticle_status"><a class="current" href="${basePath}/admin/file/page.htm?type=article">全部</a>（${allCount}）|</li>
						<li class="arrticle_status"><a href="${basePath}/admin/file/type/page.htm?type=article&status=display">已发布</a>（${displayCount}） |</li>
						<li class="arrticle_status"><a href="${basePath}/admin/file/type/page.htm?type=article&status=priv">私有</a>（${privCount}） |</li>
						<li class="arrticle_status"><a href="${basePath}/admin/file/type/page.htm?type=article&status=secret">密码保护</a>（${secretCount}）|</li>
						<li class="arrticle_status"><a href="${basePath}/admin/file/type/page.htm?type=article&status=draft">草稿</a>（${draftCount}） </li>
					</ul>
				</div>
                <div class="panel-body">
                	<div class="adv-table">
                    	<div role="grid" class="dataTables_wrapper" id="hidden-table-info_wrapper">
                            <table class="table table-striped table-advance table-hover">
                            	<thead>
                                	<tr>
										<th>文章名称</th>
                						<th>所属目录</th>
                						<th>时间</th>
                						<th>操作</th>
              						</tr>
                                </thead>
                            	<tbody role="alert" aria-live="polite" aria-relevant="all">
                            		<#list pageVo.list as e>
                            		<tr class="gradeA odd">
                            			<td class="articleId">${e.fileId}</td>
               							<td><a href="${basePath}/${e.folder.ename}/${e.fileId}.htm">${e.name}</a>&nbsp;-
               								<#if e.status=="display">公开
                                    		<#elseif e.status=="draft">草稿
                                    		<#elseif e.status=="priv">私有的
                                    		<#elseif e.status=="secret">密码保护
                                    		</#if>
               							</td>
                            			<td>${e.folder.name}</td>
                                    	<td>${e.createTime?string("yyyy-MM-dd HH:mm:ss")}${e.timeType}</td>
                                    	<td>
                  							<!-- Icons -->
                  							<a href="${basePath}/admin/article/update.htm?fileId=${e.fileId}" title="修改">
                  								<button class="btn btn-primary btn-xs">
                  									<i class="icon-pencil"></i>
                  								</button>
                  							</a>
                  							<a class="js_article_update_status" fileid="${e.fileId}" title="把${e.name}放进回收站">
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
<script>
$(function(){
	$(".articleId").hide();
	$('.js_article_update_status').click(function(){
		var fileId = $(this).attr('fileId');
		var status= "hidden";
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
											label : "前往回收站",
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
});
</script>
<#include "/system/foot.ftl">
