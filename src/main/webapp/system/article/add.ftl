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
.form-control {
    border: 1px solid #E2E2E4;
    box-shadow: none;
    color: #888888;
}
.input-lg {
    border-radius: 6px;
    font-size: 18px;
    height: 45px;
    line-height: 1.33;
    padding: 10px 16px;
}
.m-bot15{
	font-size:15px;
	width:250px;
	height: 40px;
}
</style>
<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
              <!-- page start-->
              <form role="form" id="add_article_form" method="post" autocomplete="off">
              <div class="row">
              	
                  <div class="col-lg-9">                
                      <section class="panel">
                          <header class="panel-heading">
                          	添加文章
                          </header>
                          <div class="panel-body">
                          			<input type="hidden" name="fileId" value="${file.fileId}">
                                  <div class="form-group">
                                  	<input type="text" class="form-control" name="name" placeholder="在此填写标题" id="name">${name}
                                  </div>
                                  <br>
                                  <div class="form-group">
                                  	<script id="content" name="content" type="text/plain" placeholder="在此填写内容" style="width:100%; height:260px;" value="${content}">
                                   	</script>
                                   	<p class="help-block" for="content">${content}</p>
                                    <script type="text/javascript">
                                    	$(function() {
											var editor = UE.getEditor('content')
										});
									</script>
                                  </div>
                              </form>
                          </div>
                      </section>
                      <section class="panel">
                          <header class="panel-heading tab-bg-dark-navy-blue">
                              <ul class="nav nav-tabs">
                                  <li class="">
                                      <a href="#title-1" data-toggle="tab">
                                       	  小标题
                                      </a>
                                  </li>
                                  <li class="">
                                      <a href="#description-1" data-toggle="tab">
                                          <i class="icon-user"></i>
                                          	描述
                                      </a>
                                  </li>
                                  <li class="active">
                                      <a href="#photo-1" data-toggle="tab">
                                          <i class="icon-envelope"></i>
                                          	图片
                                      </a>
                                  </li>
                                  <li class="">
                                      <a href="#sdg-1" data-toggle="tab">
                                          <i class="icon-envelope"></i>
                                          	资料
                                      </a>
                                  </li>
                              </ul>
                          </header>
                          <div class="panel-body">
                              <div class="tab-content">
                                  <div class="tab-pane" id="title-1">
                                      <div class="form-group">
                                      <input type="text" class="form-control" name="title" placeholder="在此填写小标题" id="title" style="width: 100%;">
                                  	  </div>
                                  </div>
                                  <div class="tab-pane" id="description-1">
                                  	<textarea class="form-control" name="description" placeholder="在此填写简介" id="description" style="width: 100%;">
                                  	  </textarea>
                                  </div>
                                  <div class="tab-pane active" id="photo-1">
                          			<div class="panel-body">
										<p class="hide-if-no-js">添加图片</p>
										<button id="upload_photo" class="btn btn-white" data-toggle="button" >上传图片</button>
										<p id="js_photo_list">
										</p>
										</div>
								  </div>
                                  <div class="tab-pane" id="sdg-1">
                                  	<div class="panel-body">
										<p class="hide-if-no-js">上传资料</p>
										<button id="upload_file" class="btn btn-white" data-toggle="button" >上传资料</button>
										<p id="js_file_list">
										</p>
									</div>
                                  </div>
                              </div>
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
                            	<button id="article_status_draft" class="btn btn-white" data-toggle="button" >保存草稿</button>
                        	</div>
                        	<div class="form-group">
                            	<select id="status" class="form-control input-lg m-bot15" name="status">
                                	<option class="article_status_option" value="display">公开的</option>
                                	<option class="article_status_option" value="priv">私有的</option>
                                	<option id="secret" class="article_status_option" value="secret">密码保护</option>
                                	<option class="article_status_option" value="draft">草稿</option>
                            	</select>
                        	</div>
                        	<div class="form-group" id="article_password">
                            	<input class="text" name="password">
                            	<button id="js_article_password" class="btn btn-white" data-toggle="button">确定</button>
                            </div>
                        	<div class="form-group">
                            	<button id="article_status_display" class="btn btn-white" data-toggle="button">发布</button>
                        	</div>
                        </div>
                   </section>
                   <section class="panel">
                    	<header class="panel-heading">
							所属目录
                        </header>
                        <div class="panel-body">
                    <div class="form-group" >
                   		<#list allFolderList as fold>
                        	<#list 1..fold.level as i>
                            	-
                        	</#list>
                        	<input type="radio" value="${fold.folderId}" name="folderId">
                            ${fold.name}
                            <br>
                        </#list>
                   	</div>
                   	</div>
                   </section>
              	</div>
              </div>
              </form>
              <!-- page end-->
          </section>
		</section>
		<!--main content end-->
<script type="text/javascript">
	$(function() {
		
		$("select[name='status']").change(function(){
			$('#article_password').hide();
			if($("select[name='status'] option:selected").val()=="secret"){
				$('#article_password').show();
			}
		});
		$("#js_article_password").click(function(){
			$('#article_password').hide();
		});
		var fileId=$("#add_article_form input[name='folderId']").val();
		
		$("#upload_photo").click(function(){
			var fileId = $("#add_article_form input[name='fileId']").val();
			bootbox.dialog({
  				message: '<form role="form" id="add_article_photo" enctype="multipart/form-data" method="post" autocomplete="off" action="${basePath}/admin/file/upload.json"><fieldset><input type="hidden" name="fileId" value=""></fieldset><input type="file" name="file"></form>',
  				title: "提示",
  				buttons: {
  					add : {
						label : "上传",
						className : "btn-primary",
						callback : function() {
							$("#add_article_photo input[name='fileId']").val(fileId);
								$("#add_article_photo").ajaxSubmit({
									dataType : 'json',
									success : function(data){
										if(data.result){
											$("#js_photo_list").append("<img src="+window.BasePath+data.t+" style='width:33%;'/>");
										}
									}
								});
							}
						},
  					}
				});
		});
		
		$("#upload_file").click(function(){
			var fileId = $("#add_article_form input[name='fileId']").val();
			bootbox.dialog({
  				message: '<form role="form" id="add_article_photo" enctype="multipart/form-data" method="post" autocomplete="off" action="${basePath}/admin/file/upload.json"><fieldset><input type="hidden" name="fileId" value=""></fieldset><input type="file" name="file"></form>',
  				title: "提示",
  				buttons: {
  					add : {
						label : "上传",
						className : "btn-primary",
						callback : function() {
							$("#add_article_photo input[name='fileId']").val(fileId);
								$("#add_article_photo").ajaxSubmit({
									dataType : 'json',
									success : function(data){
										if(data.result){
											$("#js_file_list").append("<a href="+window.BasePath+data.t+">"+data.msg+"</a><br>");
										}
									}
								});
							}
						},
  					}
				});
		});
		
		
		$('#article_password').hide();
		$('#article_status_draft').click(function(){
			$.post("${basePath}/admin/article/add.json",$('#add_article_form').serialize(),function(data){
				if(data.result){
					bootbox.dialog({
  						message: '文章已存入草稿',
  						title: "提示",
  						buttons: {
  							add : {
								label : "再次添加文章",
								className : "btn-primary",
								callback : function() {
									window.location.reload();
								}
							},
    						list : {
								label : "查看草稿列表",
								className : "btn-danger",
								callback : function() {
									window.location.href="${basePath}/admin/file/page.htm?type=article&status=draft";
								}
							},
  						}
					});
				}else{
					showErrors($('#add_article_form'),data.errors);
				}
			});
		});
		
		$('#article_status_display').click(function(){
			$.post("${basePath}/admin/article/add.json",$('#add_article_form').serialize(),function(data){
				if(data.result){
					bootbox.dialog({
  						message: '文章已发布',
  						title: "提示",
  						buttons: {
  							add : {
								label : "再次添加文章",
								className : "btn-primary",
								callback : function() {
									window.location.reload();
								}
							},
    						list : {
								label : "查看文件列表",
								className : "btn-danger",
								callback : function() {
									window.location.href="${basePath}/admin/file/page.htm?type=article";
								}
							},
  						}
					});
				}else{
					showErrors($('#update_article_form'),data.errors);
				}
			});
		});
	});	
</script>
<#include "/system/foot.ftl">
