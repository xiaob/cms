<#assign menu="folder"> <#assign submenu="update_folder"> <#include
"/system/head.ftl">
<style type="text/css">
</style>
<!--main content start-->
<section id="main-content">
	<section class="wrapper">
		<!-- page start-->
		<div class="row">
			<form id="update_folder_form" method="post"
				class="form-horizontal tasi-form" autocomplete="off"
				action="${basePath}/admin/folder/update.json">
				<div class="col-lg-9">
					<input type="hidden" class="form-control" name="folderId"
						value="${folder.folderId}">
					<section class="panel">
						<header class="panel-heading">【${folder.name}】目录的描述 </header>
						<div class="panel-body">
							<script id="content" name="content" type="text/plain" style="width: 100%; height: 260px;">${folder.content!}</script>
							<p class="help-block" for="content"></p>
							<script type="text/javascript">
									var contentEditor;
									$(function() {
										contentEditor = UE.getEditor('content');
									});
							</script>
						</div>
					</section>
					<section class="panel">
						<div class="panel-body">
							<table class="table">
								<thead>
									<tr>
										<th>文件名</th>
										<th>链接</th>
										<th>大小</th>
										<th>操作</th>
								</thead>
								<tbody>
									<#list attachmentPage.list as attachment>
									<tr>
										<td>
											<#if attachment.type == "photo">
												<img src="${basePath}${attachment.path}" width="200"/>
											<#else>
												${attachment.name}
											</#if>
										</td>
										<td>${attachment.link}</td>
										<td>${attachment.size}</td>
										<td>
											<a title="删除" name="${attachment.name}"
												class="btn btn-danger btn-xs js_delete"
												attachmentId="${attachment.attachmentId}" type="button">
												删除
											</a>
											<a title="链接" name="${attachment.name}"
												class="btn btn-primary btn-xs js_link"
												attachmentId="${attachment.attachmentId}"
												link="'${attachment.link}" type="button">
												修改链接
											</a>
										</td>
									</tr>
									</#list>
								</tbody>
							</table>
							${attachmentPage.pageNumHtml}
							<button id="file_upload"  class="btn btn-shadow btn-info" type="button"><i class="icon-cloud-upload"></i> 添加附件</button>
						</div>
					</section>
				</div>
				<div class="col-lg-3">
					<section class="panel">
						<header class="panel-heading">更新</header>
						<div class="panel-body">
							<div>
								<label for="exampleInputEmail1">中文名</label> <input type="text"
									class="form-control" name="name" value="${folder.name}"
									placeholder="中文名">
							</div>
							<div>
								<label for="exampleInputEmail1">英文名</label> <input type="text"
									class="form-control" name="ename" value="${folder.ename}"
									placeholder="英文名">
							</div>
							<div>
								<label for="exampleInputEmail1">状态</label>
								<div>
									<input type="radio" name="status" value="display"<#if
									folder.status=="display">checked</#if>/> 显示 <input type="radio"
										name="status" value="hidden"<#if
									folder.status=="hidden">checked</#if>/> 隐藏
								</div>
							</div>
							<div>
								<button class="btn btn-shadow btn-primary" type="submit">更新【${folder.name}】目录</button>
							</div>
						</div>
					</section>
				</div>
			</form>
		</div>

		<!-- page end-->
	</section>
</section>
<!--main content end-->
<script type="text/javascript">
 	var fatherId = ${folder.fatherId};
 	var kindId = ${folder.folderId};
	var kind = "folder";	
	$(function() {
		$('#update_folder_form').ajaxForm({
			dataType : 'json',
			beforeSerialize: function($form, options) {
				contentEditor.sync();
			},			
			success : function(data) {
				if (data.result) {
					bootbox.alert("保存成功，将刷新页面", function() {
						window.location.reload();
					});
				}else{
					showErrors($('#update_folder_form'),data.errors);
				}
			}
		});
		$('#file_upload').uploadify({
			'buttonText'  		: 	'请选择文件',
	        'swf'         		: 	'${basePath}/system/assets/uploadify/uploadify.swf',
	        'uploader'    		: 	'${basePath}/admin/attachment/upload.json;jsessionid=${JSESSIONID}',
	        'formData'  		: 	{'kindId':kindId,'kind':kind},
	        'fileObjName'		: 	'file',
	        'fileTypeExts' 		: 	'*.gif;*.png;*.jpg;*.jpeg;*.bmp;*.rar;*.doc;*.docx;*.zip,*.pdf;*.txt;*.swf;*.wmv',
	        'method'			:	'post',
	        'onUploadSuccess' 	: 	function(file, data, response) {
	        }
		});
		$('#folderId').change(function(){
			window.location.href = "${basePath}/admin/attachment/page.htm?folderId="+$('#folderId').val();
		});
		$('#btn_reflash').click(function(){
			window.location.reload();
		});
		jQuery(".fancybox").fancybox();
	});	
</script>
<#include "/system/foot.ftl">
