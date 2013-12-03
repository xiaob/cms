<#assign menu="system">
<#assign submenu="system_basic">
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
 					修改目录
				</header>
				<div class="panel-body">
					<form id="update_folder_form" method="post" class="form-horizontal tasi-form" autocomplete="off" action="${basePath}/admin/folder/update.json">
					<fieldset>
						<div class="form-group" id="update_folderId">
							<label class="col-sm-2 col-sm-2 control-label">目录Id</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="folderId" value="${folder.folderId}">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">目录名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="folderName" value="${folder.name}"
									placeholder="目录名称" id="folderName">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">英文名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control round-input" name="folderEname" value="${folder.ename}"
									placeholder="英文名称" id="folderEname">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">父级标签</label>
							<div class="col-sm-10">
								<select class="form-control input-lg m-bot15" style="font-size:15px;width: 300px;" name="fatherId">
									<option value="0">未分类</option>
									<#list folderAll as fo>
										<option value="${fo.folderId}" <#if fo.folderId==folder.fatherId>selected</#if>>
										<#list 1..fo.level as i>
                                          		-
                                        </#list>
										${fo.name}</option>
									</#list>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">目录序列</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="sort" value="${folder.sort}"
									placeholder="序列" id="sort">
							</div>
						</div>
						
						<div class="form-group">
                        	<label class="col-sm-2 col-sm-2 control-label">目录类型</label>
                            <div class="col-sm-10">
                            	<input type="radio" name="type" value="article" <#if folder.type=="article">checked</#if>/>文章
								<input type="radio" name="type" value="photo" <#if folder.type=="photo">checked</#if>/>图片
								<input type="radio" name="type" value="download" <#if folder.type=="download">checked</#if>/>下载
								<input type="radio" name="type" value="shop" <#if folder.type=="shop">checked</#if>/>商品
                        	</div>
                        </div>
                        <div class="form-group">
                        	<label class="col-sm-2 col-sm-2 control-label">目录等级</label>
                        	<div class="col-sm-10">
                            	<input type="radio" name="rank" value="everyone" <#if folder.rank=="everyone">checked</#if>/>everyone
								<input type="radio" name="rank" value="login" <#if folder.rank=="login">checked</#if>/>login
								<input type="radio" name="rank" value="vip" <#if folder.rank=="vip">checked</#if>/>vip
								<input type="radio" name="rank" value="admin" <#if folder.rank=="admin">checked</#if>/>admin
                        	</div>
                        </div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">目录状态</label>
							<div class="col-sm-10">
								<#if folder.status=="hidden">
								<input type="radio" name="status" value="hidden" checked="checked"/>隐藏
								<input type="radio" name="status" value="display"/>显示
								<#else>
								<input type="radio" name="status" value="hidden"/>显示
								<input type="radio" name="status" value="display" checked="checked"/>隐藏
								</#if>
							</div>
						</div>
						<div class="form-group">
                        	<label class="col-sm-2 col-sm-2 control-label"></label>
                            <button class="btn btn-danger" type="submit">修改</button>
                        </div>
					</fieldset>
				</form>
				<p id="allFolder">目录已修改成功，是否<a href="${basePath}/admin/folder/all">前往查看目录</a></p>
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
		$("#update_folderId").hide();
		$("#allFolder").hide();
		$('#update_folder_form').ajaxForm({
			dataType : 'json',
			success : function(data) {
				if (data.result) {
					$("#allFolder").show();
				}else{
					showErrors($('#update_folder_form'),data.errors);
				}
			}
		});
	});	
</script>
<#include "/system/foot.ftl">