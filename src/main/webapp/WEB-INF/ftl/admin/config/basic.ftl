<#assign menu="system">
<#assign submenu="system_basic">
<#include "../head.ftl">
<!--main content start-->
<section id="main-content">
	<section class="wrapper">
		<!-- page start-->
		<section class="panel">
			<header class="panel-heading"> 基本设置</header>
			<div class="panel-body">
				<form role="form" class="form-horizontal">
					<div class="form-group">
						<label class="col-lg-2 col-sm-2 control-label" for="inputEmail1">网站名称</label>
						<div class="col-lg-10">
							<input type="text" placeholder="网站名称" id="inputEmail1"
								class="form-control">
							<p class="help-block">Example block-level help text here.</p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 col-sm-2 control-label" for="inputEmail1">网站描述</label>
						<div class="col-lg-10">
							<input type="text" placeholder="网站描述" id="inputEmail1"
								class="form-control">
							<p class="help-block">Example block-level help text here.</p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 col-sm-2 control-label" for="inputEmail1">网站URL</label>
						<div class="col-lg-10">
							<input type="text" placeholder="网站URL" id="inputEmail1"
								class="form-control">
							<p class="help-block">Example block-level help text here.</p>
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-10">
							<button class="btn btn-danger" type="submit">保存</button>
						</div>
					</div>
				</form>
			</div>
		</section>
		<!-- page end-->
	</section>
</section>
<!--main content end-->
<#include "../foot.ftl">
