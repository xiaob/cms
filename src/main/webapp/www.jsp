<#assign menu="system"> <#assign submenu="system_basic"> <#include
"../head.ftl">
<!--main content start-->
<section id="main-content">
	<section class="wrapper">
		<!-- page start-->
		<section class="panel">
			<header class="panel-heading"> Horizontal Forms </header>
			<div class="panel-body">
				<form role="form" class="form-horizontal">
					<div class="form-group">
						<label class="col-lg-2 col-sm-2 control-label" for="inputEmail1">Email</label>
						<div class="col-lg-10">
							<input type="email" placeholder="Email" id="inputEmail1"
								class="form-control">
							<p class="help-block">Example block-level help text here.</p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 col-sm-2 control-label"
							for="inputPassword1">Password</label>
						<div class="col-lg-10">
							<input type="password" placeholder="Password" id="inputPassword1"
								class="form-control">
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-10">
							<div class="checkbox">
								<label> <input type="checkbox"> Remember me
								</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-10">
							<button class="btn btn-danger" type="submit">Sign in</button>
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
