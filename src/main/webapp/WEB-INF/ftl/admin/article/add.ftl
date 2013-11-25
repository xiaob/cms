<#assign menu="article">
<#assign submenu="add_article">
<#include "/admin/head.ftl">
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
                              	<input type="hidden" class="form-control" name="picture" value="NO_EXIST">
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
                                         <select class="form-control input-lg m-bot15" style="font-size:15px;width: 300px;height: 40px;" name="folderId">
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
                                          <textarea name="content"  placeholder="文章内容">
                                          </textarea>
                                          <p class="help-block" for="description"></p>
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
					bootbox.alert("保存成功，将刷新页面", function() {
						window.location.reload();
					});
				}else{
					showErrors($('#add_article_form'),data.errors);
				}
			}
		});
	});	
</script>
<#include "/admin/foot.ftl">