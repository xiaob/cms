<#assign menu="article">
<#assign submenu="add_article">
<#include "/system/head.ftl">
<style type="text/css">
.m-bot15 {
    margin-bottom: 0;
}
.form-horizontal .control-label {
    font-size: 14px;
    font-weight: 300;
    margin-top: -5px;
    text-align: left;
}
</style>
<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
              <!-- page start-->
              <div class="row">
                  <div class="col-lg-12">
                      <section class="panel">
                          <header class="panel-heading">
                            	添加文章
                          </header>
                          <div class="panel-body">
                              <form id="add_article_form" method="post" class="form-horizontal" autocomplete="off" action="${basePath}/admin/article/add.json">
                              	<fieldset>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">标题</label>
                                      <div class="col-sm-10">
                                          <input type="text" class="form-control" name="name" placeholder="标题" id="name">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">所属目录</label>
                                      <div class="col-sm-10">
                                         <select class="form-control input-lg m-bot15" style="font-size:15px;width: 300px;height: 45px;" name="folderId">
                                        	<#list allFolderList as folder>  	
                                          		<option value="${folder.folderId}">
                                          		<#list 1..folder.level as i>-</#list> ${folder.name}
                                          		</option>
                                        	</#list>
                                        </select>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">文章内容</label>
                                      <div class="col-sm-10">
                                          <p class="help-block" for="content"></p>
                                          <script id="content" name="content" type="text/plain" style="width:80%;height:400px;"></script>
                                      	  <script type="text/javascript">
                                      	  	 $(function() {
											   var editor = UE.getEditor('content')
											 });
										  </script>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                  		<label class="col-sm-2 col-sm-2 control-label"></label>
                                  		<div class="col-sm-10">
                                      		<button class="btn btn-danger" type="submit">保存</button>
                                      	</div>
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
		
		$('#add_article_form').ajaxForm({
			dataType : 'json',
			success : function(data) {
				if (data.result) {
					bootbox.dialog({
  						message: '<form enctype="multipart/form-data" id="add_article_picture_form" method="post" autocomplete="off" action="${basePath}/admin/article/upload/picture.json"><fieldset><input type="file" id="file" name= "file" value=""/><input type="hidden" name= "fileId" value="'+data.t+'"/><input type="hidden" name="type" value="article"/></fieldset></form>',
  						title: "是否上传文章图片",
  						buttons: {
  							add : {
								label : "再次添加文章",
								className : "btn-primary",
								callback : function() {
									window.location.reload();
								}
							},
    						success: {
      							label: "上传",
      							className: "btn-success",
      							callback: function() {
        							$('#add_article_picture_form').ajaxSubmit({
										dataType : 'json',
										success : function(data) {
											if (data.result) {
												bootbox.dialog({
  													message: '图片上传成功',
  													title: "提示",
							  						buttons: {
							  							add : {
															label : "继续添加文章",
															className : "btn-primary",
															callback : function() {
																window.location.reload();
															}
														},
							    						list : {
															label : "查看文件夹列表",
															className : "btn-danger",
															callback : function() {
																window.location.href="${basePath}/admin/file/page?type=article";
															}
														},
							  						}
												});
											}else{
												showErrors($('#add_article_picture_form'),data.errors);
											}
										}
									});
      							}
    						},
    						list : {
								label : "查看文件夹列表",
								className : "btn-danger",
								callback : function() {
									window.location.href="${basePath}/admin/file/page?type=article";
								}
							},
  						}
					});
				}else{
					showErrors($('#add_article_form'),data.errors);
				}
			}
		});
	});	
</script>
<#include "/system/foot.ftl">
