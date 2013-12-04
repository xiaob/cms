<#assign menu="folder">
<#assign submenu="update_folder">
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
								<input type="text" class="form-control" name="folderEname" value="${folder.ename}"
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
                                	<label class="checkbox-inline">
                                    	<input type="radio" value="article" name="type" <#if folder.type=="article">checked</#if>>
                                        	文章
                                		</label>
                                  		<label class="checkbox-inline">
                                    		<input type="radio" value="photo" name="type" <#if folder.type=="photo">checked</#if>>
                                        	图片
                                  		</label>
                                  		<label class="checkbox-inline">
                                    		<input type="radio" value="download" name="type" <#if folder.type=="download">checked</#if>>
                                        	下载
                                  		</label>                                 			
                                  		<label class="checkbox-inline">
                                    		<input type="radio" value="shop" name="type" <#if folder.type=="shop">checked</#if>>
                                        	商品
                                  		</label>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">目录类型</label>
                                      <div class="col-sm-10">
                                  		<label class="checkbox-inline">
                                    		<input type="radio" value="everyone" name="rank" <#if folder.rank=="everyone">checked</#if>>
                                        	所有人
                                  		</label>
                                  		<label class="checkbox-inline">
                                    		<input type="radio" value="login" name="rank" <#if folder.rank=="login">checked</#if>>
                                        	登陆用户
                                  		</label>
                                  		<label class="checkbox-inline">
                                    		<input type="radio" value="vip" name="rank" <#if folder.rank=="vip">checked</#if>>
                                        	VIP
                                  		</label>                                 			
                                  		<label class="checkbox-inline">
                                    		<input type="radio" value="admin" name="rank" <#if folder.rank=="admin">checked</#if>>
                                        	管理员
                                  		</label>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">目录状态</label>
                                      <div class="col-sm-10">
                                      	<label class="checkbox-inline">
                                    		<input type="radio" name="status" value="display" <#if folder.status=="display">checked</#if>/>display
                                  		</label>
                                  		<label class="checkbox-inline">
                                    		<input type="radio" name="status" value="hidden" <#if folder.status=="hidden">checked</#if>/>hidden
                                  		</label>
                                      </div>
                                  </div>
						<div class="form-group">
                        	<label class="col-sm-2 col-sm-2 control-label"></label>
                            <button class="btn btn-danger" type="submit">修改</button>
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
 <script type="text/javascript">
	$(function() {
		$("#update_folderId").hide();
		$('#update_folder_form').ajaxForm({
			dataType : 'json',
			success : function(data) {
				if (data.result) {
					bootbox.dialog({
						message : "更新成功",
						title : "提示",
						buttons : {
							add : {
								label : "再次更新",
								className : "btn-success",
								callback : function() {
									window.location.reload();
								}
							},
							list : {
								label : "前往文件夹列表",
								className : "btn-primary",
								callback : function() {
									window.location.href="${basePath}/admin/folder/page";
								}
							},
						}
					});
				}else{
					showErrors($('#update_folder_form'),data.errors);
				}
			}
		});
	});	
</script>
<#include "/system/foot.ftl">