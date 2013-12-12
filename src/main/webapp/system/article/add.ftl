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
              <div class="row">
                  <div class="col-lg-9">                
                      <section class="panel">
                          <header class="panel-heading">
                          	添加文章
                          </header>
                          <div class="panel-body">
                              <form role="form" id="add_article_form" method="post" autocomplete="off">
                                  <input  type="hidden" class="form-control" name="status" id="status" value="">
                                  <input  type="hidden" class="form-control" name="folderId" id="folderId" value="">
                                  <input  type="hidden" class="form-control" name="password" id="password" value="">
                                  <input type="hidden" class="form-control" name="fileId" id="fileId" value="${article.fileId}">
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
                                      <a href="#home-2" data-toggle="tab">
                                       	  小标题
                                      </a>
                                  </li>
                                  <li class="">
                                      <a href="#about-2" data-toggle="tab">
                                          <i class="icon-user"></i>
                                          	描述
                                      </a>
                                  </li>
                                  <li class="active">
                                      <a href="#contact-2" data-toggle="tab">
                                          <i class="icon-envelope"></i>
                                          	图片
                                      </a>
                                  </li>
                                  <li class="">
                                      <a href="#sdg-2" data-toggle="tab">
                                          <i class="icon-envelope"></i>
                                          	资料
                                      </a>
                                  </li>
                              </ul>
                          </header>
                          <div class="panel-body">
                              <div class="tab-content">
                                  <div class="tab-pane" id="home-2">
                                      <div class="form-group">
                                      <input type="text" class="form-control" name="title" placeholder="在此填写小标题" id="title" style="width: 100%;">
                                  	  </div>
                                  </div>
                                  <div class="tab-pane" id="about-2">
                                  	<textarea class="form-control" name="title" placeholder="在此填写简介" id="title" style="width: 100%;">
                                  	  </textarea>
                                  </div>
                                  <div class="tab-pane active" id="contact-2">
                          			<div class="panel-body">
										<p class="hide-if-no-js">添加图片</p>
										<img title="c3039 (1).jpg" _src="http://localhost:8080/CMS/upload/photo/20131212/c3039 (1).jpg" src="http://localhost:8080/CMS/upload/photo/20131212/c3039 (1).jpg" style="width:33%;height:200px;">
											<img title="c3039 .jpg" _src="http://localhost:8080/CMS/upload/photo/20131212/c3039 .jpg" src="http://localhost:8080/CMS/upload/photo/20131212/c3039 .jpg" style="width:33%;height:200px;">
										</div>
								  </div>
                                  <div class="tab-pane" id="sdg-2">
                                  	<div class="panel-body">
										<p class="hide-if-no-js">上传资料</p>
										<img title="c3039 .jpg" _src="http://localhost:8080/CMS/upload/photo/20131212/c3039 .jpg" src="http://localhost:8080/CMS/upload/photo/20131212/c3039 .jpg" style="width:33%;height:200px;">
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
                            	<button id="article_status_draft" fileId="${article.fileId}" class="btn btn-white" data-toggle="button" >保存草稿</button>
                        	</div>
                        	<div class="form-group">
                            	<select id="article_status" class="form-control input-lg m-bot15" name="article_status">
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
                    <div class="form-group">
                   		<#list allFolderList as folder>
                        	<input type="radio" value="${folder.folderId}" name="folderId" checked>
                        	<#list 1..folder.level as i>
                            	-
                        	</#list>
                            ${folder.name}
                            <br>
                        </#list>
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
	var fileId=$("#add_article_form input[name='folderId']").val();
		$('#article_password').hide();
		$('#article_status_draft').click(function(){
			$("#add_article_form input[name='status']").val("draft");
			$("#add_article_form input[name='folderId']").val($("select[name='folderId'] option:selected").val());
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
			$("#add_article_form input[name='status']").val($("select option:selected").val());
			$("#add_article_form input[name='folderId']").val($("select[name='folderId'] option:selected").val());
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
		$("select[name='article_status']").change(function(){
			$('#article_password').hide();
			if($("select[name='article_status'] option:selected").val()=="secret"){
				$('#article_password').show();
			}
		});
		$("#js_article_password").click(function(){
			$("#add_article_form input[name='password']").val($("#article_password input[name='password']").val());
			$('#article_password').hide();
		});
	});	
</script>
<#include "/system/foot.ftl">
