<#assign menu="article">
<#assign submenu="update_article">
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
                            	 修改文章
                          </header>
                          <div class="panel-body">
                              <form id="update_article_form" method="post" class="form-horizontal" autocomplete="off" action="${basePath}/admin/article/update.json">
                              	<fieldset>
                              	  <div class="form-group" id="article_fileId">
                                      <label class="col-sm-2 col-sm-2 control-label">文件Id</label>
                                      <div class="col-sm-10">
                                      	<input type="text" class="form-control" name="fileId" value="${file.fileId}">
                                      </div>
                                  </div>
                                  <div class="form-group" id="article_adminId">
                                      <label class="col-sm-2 col-sm-2 control-label">管理员Id</label>
                                      <div class="col-sm-10">
                                      	<input type="text" class="form-control" name="adminId" value="${file.adminId}">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">所属目录Id</label>
                                      <div class="col-sm-10">
                                         <select class="form-control input-lg m-bot15" style="font-size:15px;width: 300px;height: 40px;" name="folderId">
                                        	<option value="0" selected >未分类</option>
                                        	<#list folderAll as folder>
                                          		<option value="${folder.folderId}" <#if folder.folderId==file.folderId>selected</#if>>
                                          		<#list 1..folder.level as i>
                                          		-
                                          		</#list>
                                          		${folder.name}</option>
                                        	</#list>
                                        </select>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">文章名称</label>
                                      <div class="col-sm-10">
                                          <input type="text" class="form-control" name="fileName" value="${file.name}"
                                          	placeholder="文章名称" id="fileName">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">文章内容</label>
                                      <div class="col-sm-10">
                                          <input type="text" class="form-control" name="content" value="${file.content}"
                                          	placeholder="文章内容" id="description">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">文章状态</label>
                                      <div class="col-sm-10">
										<#if file.status=="hidden">
										<input type="radio" name="status" value="hidden" checked="checked"/>hidden
										<input type="radio" name="status" value="display"/>display
										<#else>
										<input type="radio" name="status" value="hidden"/>hidden
										<input type="radio" name="status" value="display" checked="checked"/>display
										</#if>
									</div>
                                  </div>
                                  <div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">文章图片</label>
									<div class="col-sm-10">
										<#if file.picture=="no_exist">
										<input type="radio" name="picture" value="no_exist" checked="checked"/>NO_EXIST
										<input type="radio" name="picture" value="exist"/>EXIST
										<#else>
										<input type="radio" name="picture" value="no_exist"/>NO_EXIST
										<input type="radio" name="picture" value="exist" checked="checked"/>EXIST
										</#if>
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
		$("#article_fileId").hide();
		$("#article_adminId").hide();
		$('#update_article_form').ajaxForm({
			dataType : 'json',
			success : function(data) {
				if (data.result) {
					bootbox.alert("保存成功，将刷新页面", function() {
						window.location.reload();
					});
				}else{
					showErrors($('#update_article_form'),data.errors);
				}
			}
		});
	});	
</script>
<#include "/system/foot.ftl">
