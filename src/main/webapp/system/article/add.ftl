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
    width：300px;
    text-align: left;
    
}

</style>
<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
              <!-- page start-->
              <div class="row">
                  <div class="col-lg-9">                
                      <section class="panel">
                          <header class="panel-heading">
                            	添加文章
                          </header>
                          <div class="panel-body">
                              <form role="form" id="add_article_form" method="post" autocomplete="off" action="${basePath}/admin/article/add.json">
                                  <div class="form-group">
                                  		<input type="text" class="form-control" name="name" placeholder="在此填写标题" id="name">
                                  </div>
                                  <br><br>
                                  <div class="form-group">
                                        <script id="content" name="content" type="text/plain" style="width:100%;height:400px;"></script>
                                      	<script type="text/javascript">
                                      	 	$(function() {
											   var editor = UE.getEditor('content')
											});
										</script>
                                  </div>
                              </form>
                          </div>
                      </section>
                  </div>
                  <!-- 右侧开始 -->
                  <div class="col-lg-3">
					<section class="panel">
                        <header class="panel-heading">
							发布
                        </header>
                        <div class="panel-body">
                        	<div class="form-group">
                            	<button class="btn btn-white" data-toggle="button">保存草稿</button>
                        	</div>
                        	
                        	<div class="form-group">
                            	<select id="article_status" class="form-control input-lg m-bot15" style="font-size:15px;width:250px;height: 40px;" name="folderId">
                                	<option class="article_status_option" value="display">公开的</option>
                                	<option class="article_status_option" value="priv">私有的</option>
                                	<option id="secret" class="article_status_option" value="secret">密码保护</option>
                                	<option class="article_status_option" value="draft">草稿</option>
                            	</select>
                            	<div class="article_password">
                                	<input class="text" name="password">
                                </div>
                        	</div>
                        	<div class="form-group">
                            	<button class="btn btn-white" data-toggle="button">发布</button>
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
		$('.article_password').hide();
		function ss(){
			var slt=document.getElementById("article_status");
			if(slt.value=="secret"){
				$('.article_password').show();
			}
		};
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
																window.location.href="${basePath}/admin/file/page.htm?type=article";
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
