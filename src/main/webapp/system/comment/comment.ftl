<#assign menu="comment">
<#assign submenu="auditing_comment">
<#include "/system/head.ftl">
<style type="text/css">

</style>
<!--main content start-->
	<section id="main-content">
		<section class="wrapper">
		<!-- page start-->
			<div class="row">
			<div class="col-lg-12">
			<section class="panel">
				<header class="panel-heading">
 					审核评论
				</header>
				<div class="panel-body">
						<input type="hidden" class="form-control" name="commentId" value="${comment.commentId}">
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">评论标题</label>
							<div class="col-sm-10">
								<label class="col-sm-2 col-sm-2 control-label">${comment.name}</label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">内容</label>
							<div class="col-sm-10">
								<label class="col-sm-2 col-sm-2 control-label">${comment.content}</label>
							</div>
						</div>
						<div class="form-group">
                        	<label class="col-sm-2 col-sm-2 control-label"></label>
                        	<#if comment.status=="hidden">
                        	<button class="btn btn-danger" type="submit" id="displayComment" commentId=${comment.commentId}>审核通过</button>
                        	<button class="btn btn-success" type="submit" id="trashComment" commentId=${comment.commentId}>垃圾评论</button>
                        	<#elseif comment.status=="display">
                        	<button class="btn btn-success" type="submit" id="trashComment" commentId=${comment.commentId}>垃圾评论</button>
                        	<#else>
                        	<button class="btn btn-danger" type="submit" id="displayComment" commentId=${comment.commentId}>审核通过</button>
                        	</#if>
                        </div>
				</div>
			</section>
		</div>
		</div>
<!-- page end-->
		</section>
	</section>
 <!--main content end-->
<script type="text/javascript">
	$(function() {
		$('#displayComment').click(function(){
			var commentId=$(this).attr("commentId");
			$.post("${basePath}/admin/comment/auditing.json",{'commentId':commentId},function(data){
				if(data.result){
					bootbox.alert("更新成功，将前往列表页面", function() {
						window.location.href="${basePath}/admin/comment/page.htm";
					});
				}
			});
		});
		$('#trashComment').click(function(){
			var commentId=$(this).attr("commentId");
			$.post("${basePath}/admin/comment/cancel.json",{'commentId':commentId},function(data){
				if(data.result){
					bootbox.alert("更新成功，将前往列表页面", function() {
						window.location.href="${basePath}/admin/comment/page.htm";
					});
				}
			});
		});
	});
</script>
<#include "/system/foot.ftl">
