<#assign menu="system">
<#assign submenu="system_basic">
<#include "../head.ftl">
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
 					修改管理员资料
				</header>
				<div class="panel-body">
					<form method="post" class="form-horizontal tasi-form" action="/CMS/admin/admin/updateAdmin.do">
					<fieldset>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">管理员Id</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="adminId" value="${admin.adminId}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">管理员名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="adminName" value="${admin.name}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">密码</label>
							<div class="col-sm-10">
								<input type="text" class="form-control round-input" name="password" value="${admin.password}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">状态</label>
							<div class="col-sm-10">
								<input type="text" class="form-control round-input" name="status" value="${admin.status}">
							</div>
						</div>
						<div class="form-group">
							<input class="button" value="修改" type="submit" style="height:35px">
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
<#include "../foot.ftl">