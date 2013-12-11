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
                                  <br><br>
                                  <div class="form-group">
                                        <script id="content" name="content" type="text/plain" style="width:100%;height:400px;" value="${content}"></script>
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
                    <div class="form-group">
                    	<select class="form-control input-lg m-bot15" name="folderId" style="margin-left: 15px;">
                    		<option value="0" selected >weifenlei</option>
                         	<#list allFolderList as folder>
                            	<option value="${folder.folderId}">
                        	<#list 1..folder.level as i>
                            	 -
                        	</#list>
                            	${folder.name}</option>
                       		</#list>
                   		</select>
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
		$('#article_password').hide();
		$('#article_status_draft').click(function(){
			$("#add_article_form input[name='status']").val("draft");
			$("#add_article_form input[name='folderId']").val($("select[name='folderId'] option:selected").val());
			$.post("${basePath}/admin/article/update.json",$('#add_article_form').serialize(),function(data){
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
			$.post("${basePath}/admin/article/update.json",$('#add_article_form').serialize(),function(data){
				if(data.result){
					bootbox.dialog({
  						message: '提示',
  						title: "文章已发布",
  						buttons: {
  							add : {
								label : "再次添加文章",
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
