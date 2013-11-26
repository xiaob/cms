<#assign menu="comment">
<#assign submenu="auditing_comment">
<#include "/admin/head.ftl">
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
					<form method="post" class="form-horizontal" autocomplete="off" action="${basePath}/admin/comment/auditing">
					<fieldset>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">评论Id</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="commentId" value="${comment.commentId}">
							</div>
						</div>
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
                        	<button class="btn btn-danger" type="submit">审核</button>
                        </div>
					</fieldset>
				</form>
				</div>
			</section>
		</div>
		</div>
<!-- page end-->
		</section>
	</section>
 <!--main content end-->
<#include "/admin/foot.ftl">