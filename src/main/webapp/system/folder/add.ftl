<#assign menu="folder">
<#assign submenu="add_folder">
<#include "/system/head.ftl">
<style type="text/css">
.m-bot15 {
    margin-bottom: 5px;
}
.form-control {
    border: 1px solid #E2E2E4;
    box-shadow: none;
    color: #C2C2C2;
}
.input-lg {
    border-radius: 6px;
    font-size: 15px;
    height: 40px;
    line-height: 1.33;
    padding: 9px 15px；
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
                            	 添加目录
                          </header>
                          <div class="panel-body">
                              <form id="addFolder_form" method="post" class="form-horizontal" autocomplete="off" action="${basePath}/admin/folder/addNew.json">
                              	<fieldset>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">目录名称</label>
                                      <div class="col-sm-10">
                                          <input type="text" class="form-control" name="folderName"
                                          	placeholder="目录名称" id="folderName" >${folderName}
                                          </input>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">英文名称</label>
                                      <div class="col-sm-10">
                                          <input type="text" class="form-control" name="folderEname"
                                          	placeholder="英文名称" id="folderEname" value="${folderEname}">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">父级标签</label>
                                      <div class="col-sm-10">
                                        <select class="form-control input-lg m-bot15" style="font-size:15px;width: 300px;" name="fatherId">
                                        	<option value="0">未分类</option>
                                        	<#list folderAll as folder>  	
                                          		<option value="${folder.folderId}">
                                          		<#list 1..folder.level as i>
                                          		-
                                          		</#list>
                                          		${folder.name}</option>
                                        	</#list>
                                        </select>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">目录类型</label>
                                      <div class="col-sm-10">
                                  		<label class="checkbox-inline">
                                    		<input type="radio" value="article" name="type" checked>
                                        	文章
                                  		</label>
                                  		<label class="checkbox-inline">
                                    		<input type="radio" value="photo" name="type">
                                        	图片
                                  		</label>
                                  		<label class="checkbox-inline">
                                    		<input type="radio" value="download" name="type">
                                        	下载
                                  		</label>                                 			
                                  		<label class="checkbox-inline">
                                    		<input type="radio" value="shop" name="type">
                                        	商品
                                  		</label>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">目录等级</label>
                                      <div class="col-sm-10">
                                  		<label class="checkbox-inline">
                                    		<input type="radio" value="everyone" name="rank" checked>
                                        	所有人
                                  		</label>
                                  		<label class="checkbox-inline">
                                    		<input type="radio" value="login" name="rank">
                                        	登录用户
                                  		</label>
                                  		<label class="checkbox-inline">
                                    		<input type="radio" value="vip" name="rank">
                                        	VIP
                                  		</label>                                 			
                                  		<label class="checkbox-inline">
                                    		<input type="radio" value="admin" name="rank">
                                        	管理员
                                  		</label>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">目录状态</label>
                                      <div class="col-sm-10">
                                      	<label class="checkbox-inline">
                                    		<input type="radio" name="status" value="display" checked/>显示
                                  		</label>
                                  		<label class="checkbox-inline">
                                    		<input type="radio" name="status" value="hidden"/>隐藏
                                  		</label>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                  	<label class="col-sm-2 col-sm-2 control-label"></label>
                                      <button class="btn btn-danger" type="submit">保存</button>
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
		$('#addFolder_form').ajaxForm({
			dataType : 'json',
			success : function(data) {
				if (data.result) {
					bootbox.dialog({
						message : "保存成功",
						title : "提示",
						buttons : {
							add : {
								label : "继续添加",
								className : "btn-success",
								callback : function() {
									window.location.reload();
								}
							},
							list : {
								label : "查看文件夹列表",
								className : "btn-primary",
								callback : function() {
									window.location.href="${basePath}/admin/folder/page";
								}
							},
						}
					});
				}else{
					showErrors($('#addFolder_form'),data.errors);
				}
			}
		});
	});	
</script>
<#include "/system/foot.ftl">
