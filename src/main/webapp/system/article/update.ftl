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
                            	 修改文章 <a href="${basePath}/admin/article/add.htm">写文章</a>
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
                                      	<label class="checkbox-inline">
                                    		<input type="radio" name="status" value="display" <#if file.status=="display">checked</#if>/>显示
                                  		</label>
                                  		<label class="checkbox-inline">
                                    		<input type="radio" name="status" value="draft" <#if file.status=="draft">checked</#if>/>草稿
                                  		</label>
                                  		<label class="checkbox-inline">
                                    		<input type="radio" name="status" value="priv" <#if file.status=="priv">checked</#if>/>私有
                                  		</label>
                                  		<label class="checkbox-inline">
                                    		<input type="radio" name="status" value="secret" <#if file.status=="secret">checked</#if>/>显示
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
		$("#article_fileId").hide();
		$("#article_adminId").hide();
		$('#update_article_form').ajaxForm({
			dataType : 'json',
			success : function(data) {
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
								label : "前往文件夹列表",
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
			}
		});
	});	
</script>
<#include "/system/foot.ftl">
