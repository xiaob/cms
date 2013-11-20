<#assign menu="system">
<#assign submenu="system_basic">
<#include "head.ftl">
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
                              <form id="update_article_form" method="post" class="form-horizontal" autocomplete="off" action="/CMS/admin/file/update.json">
                              	<fieldset>
                              	  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">文件Id</label>
                                      <div class="col-sm-10">
                                      	<input type="text" class="form-control" name="fileId" value="${file.fileId}">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">所属目录Id</label>
                                      <div class="col-sm-10">
                                      	<label class="col-sm-2 col-sm-2 control-label">
											${folderName}
										</label>
                                         <select class="form-control input-lg m-bot15" style="font-size:15px;width: 300px;height: 40px;" name="folderId">
                                        	<option value="0">未分类</option>
                                        	<#list folderAll as folder>  	
                                          		<option value="${folder.folderId}">${folder.name}</option>
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
                                      <label class="col-sm-2 col-sm-2 control-label">文章链接</label>
                                      <div class="col-sm-10">
                                          <input type="text" class="form-control" name="url" value="${file.url}"
                                          	placeholder="文章链接" id="url">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">文章图片</label>
                                      <div class="col-sm-10">
                                          <input type="text" class="form-control" name="images" value="${file.images}"
                                          	placeholder="文章图片" id="fileName">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">文章种类</label>
                                      <div class="col-sm-10">
                                          <input type="text" class="form-control" name="description" value="${file.description}"
                                          	placeholder="文章种类" id="description">
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
<#include "foot.ftl">
