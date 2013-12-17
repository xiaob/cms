<#assign menu="appendix">
<#assign submenu="add_appendix">
<#include "/system/head.ftl">
	<section id="main-content">
		<section class="wrapper">
        	<!-- page start-->
            <section class="panel">
            	<header class="panel-heading">
               		上传附件
                </header>
                <div class="panel-body">
                	<div class="adv-table">
                     	<form id="add_appendix_form" method="post" enctype="multipart/form-data" class="form-horizontal" autocomplete="off" action="${basePath}/admin/file/upload.json">
                        	<fieldset>
                        		<div class="form-group">
                        			<label class="col-sm-2 col-sm-2 control-label">选择目录</label>
                                	<div class="col-sm-10">
                                    	<select id="article_status" class="form-control input-lg m-bot15" name="article_status">
                                			<option class="article_status_option" value="">图片</option>
                                			<#list photoList as photo>
                                			<option class="article_status_option" value="${photo.folderId}">${photo.name}</option>
                                			</#list>
                                			<option class="article_status_option" value="">文件</option>
                                			<#list fileList as photo>
                                			<option class="article_status_option" value="${file.folderId}">${file.name}</option>
                                			</#list>
                                			<option class="article_status_option" value="">商品</option>
                                			<#list shopList as photo>
                                			<option class="article_status_option" value="${shop.folderId}">${shop.name}</option>
                                			</#list>
                            			</select>
                                	</div>
                                </div>
                        		<div class="form-group">
                        			<label class="col-sm-2 col-sm-2 control-label">选择附件</label>
                                	<div class="col-sm-10">
                                    	<input type="file" name= "file"/>
                                	</div>
                                </div>
                                <div class="form-group">
                                	<label class="col-sm-2 col-sm-2 control-label"></label>
                                    <button class="btn btn-danger" type="submit">保存</button>
                               </div>
                        	</fieldset>  
                        </form>   
                    </div>
                  </div>
              </section>
              <!-- page end-->
          </section>
		</section>
<script type="text/javascript">
	$(function() {
		$('#add_appendix_form').ajaxForm({
			dataType : 'json',
			success : function(data) {
				if (data.result) {
					bootbox.dialog({
  						message: '附件上传成功',
  						title: "提示",
						buttons: {
							add : {
								label : "继续添加附件",
								className : "btn-primary",
								callback : function() {
									window.location.reload();
								}
							},
							photoList : {
								label : "查看图片列表",
								className : "btn-danger",
								callback : function() {
									window.location.href="${basePath}/admin/file/page.htm?type=photo";
								}
							},
							fileList : {
								label : "查看附件列表",
								className : "btn-success",
								callback : function() {
									window.location.href="${basePath}/admin/file/page.htm?type=file";
								}
							},
						}
					});
				}else{
					showErrors($('#add_article_picture_form'),data.errors);
				}
			}
		});
	});
</script>
<#include "/system/foot.ftl">
