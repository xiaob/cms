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
				<form id="basicForm" action="${basePath}/admin/config/basic.json" role="form" class="form-horizontal" autocomplete="off" method="post" >
					<div class="form-group">
						<label class="col-lg-2 col-sm-2 control-label" for="inputEmail1">网站名称</label>
						<div class="col-lg-10">
							<input type="text" placeholder="网站名称" id="inputEmail1" name="sitename"
								class="form-control" value="${configMap.sitename}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 col-sm-2 control-label" for="inputEmail1">网站描述</label>
						<div class="col-lg-10">
							<input type="text" placeholder="网站描述" id="inputEmail1" name="sitedesc"
								class="form-control" value="${configMap.sitedesc}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 col-sm-2 control-label" for="inputEmail1">网站URL</label>
						<div class="col-lg-10">
							<input type="text" placeholder="网站URL" id="inputEmail1" name="siteurl"
								class="form-control"  value="${configMap.siteurl}">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 col-sm-2 control-label" for="inputEmail1">模板</label>
						<div class="col-lg-10">
							<select class="form-control m-bot15" name="template">
								 <#list templateList as template>
                                 <option value="${template}">${template}</option>
                                 </#list>
                            </select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 col-sm-2 control-label" for="inputEmail1">是否开启图片展示模块</label>
						<div class="col-lg-10">
							<input type="checkbox" name="functionPhoto" <#if configMap.function_photo=="on">checked="checked"</#if> data-toggle="switch" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 col-sm-2 control-label" for="inputEmail1">是否开启下载模块</label>
						<div class="col-lg-10">
							<input type="checkbox" name="functionDownload" <#if configMap.function_download=="on">checked="checked"</#if> data-toggle="switch" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 col-sm-2 control-label" for="inputEmail1">是否开启商品模块</label>
						<div class="col-lg-10">
							<input type="checkbox" name="functionShop" <#if configMap.function_shop=="on">checked="checked"</#if> data-toggle="switch" />
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
<script type="text/javascript">
	$(function() {
		$('#basicForm').ajaxForm({
			dataType : 'json',
			success : function(data) {
				if (data.result) {
					bootbox.alert("保存成功，将刷新页面", function() {
						window.location.reload();
					});					
				}else{
					showErrors($('#basicForm'),data.errors);
				}
			}
		});
	});	
</script>
<#include "../foot.ftl">
