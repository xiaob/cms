<#assign menu="article">
<#if status=="trash">
<#assign submenu="article_recycle">
<#else><#assign submenu="article_list">
</#if>
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
               		 <#if status=="display">已发布文章列表
               		 <#elseif status=="hidden">草稿列表
               		 <#elseif status=="init">初始化文章列表
               		 <#else>回收站
               		 </#if>
                </header>
                <div class="panel-body">
                	<ul class="subsubsub">
						<li class="arrticle_status"><a href="${basePath}/admin/article/page.htm?status=display">已发布</a>（${displayCount}）</li>
						<li class="arrticle_status"><a href="${basePath}/admin/article/page.htm?status=hidden">隐藏</a>（${hiddenCount}）</li>
						<li class="arrticle_status"><a href="${basePath}/admin/article/page.htm?status=trash">垃圾文章</a>（${trashCount}）</li>
						<li class="arrticle_status"><a href="${basePath}/admin/article/page.htm?status=init">初始化文章列表</a>（${initCount}）</li>
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
                						<th>最后更新时间</th>
                						<th>操作</th>
              						</tr>
                                </thead>
                            	<tbody role="alert" aria-live="polite" aria-relevant="all">
                            		<#list pageVo.list as e>
                            		<tr class="gradeA odd">
                            			<td class="articleId">${e.articleId}</td>
               							<td><a href="${basePath}/<#list e.folderPathList as folders>${folders.ename}/</#list>${e.articleId}.htm">${e.name}</a>&nbsp;-
               								<#if e.status=="display">公开
                                    		<#else>隐藏
                                    		</#if>
               							</td>
                            			<td>${e.folder.name}</td>
                                    	<td>${e.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                                    	<td>
                  							<!-- Icons -->
                  							<a href="${basePath}/admin/article/update.htm?articleId=${e.articleId}" title="修改">
                  								编辑
                  							</a>
                  							 | 
                  							<a href="javascript:void(0);" class="js_article_update_status" fileid="${e.articleId}" title="把【${e.name}】放进回收站">
                  								删除
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
		var status= "trash";
		bootbox.dialog({
			message : "是否"+$(this).attr('title'),
			title : "提示",
				buttons : {
				delete : {
					label : "确定",
					className : "btn-success",
					callback : function() {
					$.post("${basePath}/admin/article/status/update.json", { 
						"fileId": fileId,
						"status": status},
						function(data){
							window.location.reload();
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
