<#assign menu="article">
<#assign submenu="update_article">
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
                            	 修改文章 <a href="${basePath}/admin/article/add.htm">写文章</a>
                          </header>
                          <div class="panel-body">
                              <form role="form" id="update_article_form" method="post" autocomplete="off">
                                  <input  type="hidden" class="form-control" name="status" id="status" value="">
                                  <input  type="hidden" class="form-control" name="folderId" id="folderId" value="">
                                  <input type="hidden" class="form-control" name="fileId" value="${file.fileId}">
                                  <input  type="hidden" class="form-control" name="password" id="password" value="">
                                  <div class="form-group">
                                  	<input type="text" class="form-control" name="name" placeholder="在此填写标题" id="name" value="${file.name}">
                                  </div>
                                  <br>
                                  <div class="form-group">
                                  	<script id="content" name="content" type="text/plain" style="width:100%;height:400px;">
                                  	<p class="help-block" for="content">${file.content}</p>
                                  	</script>
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
							更新
                        </header>
                        <div class="panel-body">
                        	<div class="form-group">
                            	<select id="article_status" class="form-control input-lg m-bot15" name="article_status">
                                	<option class="article_status_option" value="display" <#if file.status=="display">selected</#if>>公开的</option>
                                	<option class="article_status_option" value="priv" <#if file.status=="priv">selected</#if>>私有的</option>
                                	<option id="secret" class="article_status_option" value="secret" <#if file.status=="secret">selected</#if>>密码保护</option>
                                	<option class="article_status_option" value="draft" <#if file.status=="draft">selected</#if>>草稿</option>
                            	</select>
                        	</div>
                        	<div class="form-group" id="article_password">
                            	<input class="text" name="password" value="${file.password}">
                            	<button id="js_article_password" class="btn btn-white" data-toggle="button">确定</button>
                            </div>
                        	<div class="form-group">
                            	<button id="js_update_article" class="btn btn-white" data-toggle="button">更新</button>
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
                         	<#list folderAll as folder>
                            	<option value="${folder.folderId}"<#if file.folderId==folder.folderId>selected</#if>>
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
		if($("select[name='article_status'] option:selected").val()=="secret"){
        	$("#article_password").show();
    	}else{
    		$("#article_password").hide();
    	}
    	
		$("select[name='article_status']").change(function(){
			$('#article_password').hide();
			if($("select[name='article_status'] option:selected").val()=="secret"){
				$('#article_password').show();
			}
		});
		
		$("#js_article_password").click(function(){
			$("#update_article_form input[name='password']").val($("#article_password input[name='password']").val());
			$('#article_password').hide();
		});
		
		$('#js_update_article').click(function(){
			$("#update_article_form input[name='status']").val($("select option:selected").val());
			$("#update_article_form input[name='folderId']").val($("select[name='folderId'] option:selected").val());
			$.post("${basePath}/admin/article/update.json",$('#update_article_form').serialize(),function(data){
				if (data.result) {
					bootbox.dialog({
						message : "更新成功",
						title : "提示",
						buttons : {
							update : {
								label : "返回",
								className : "btn-success",
								callback : function() {
									window.location.reload();
								}
							},
							list : {
								label : "前往文件列表",
								className : "btn-primary",
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
