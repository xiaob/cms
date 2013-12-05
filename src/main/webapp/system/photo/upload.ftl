<#assign menu="photo">
<#assign submenu="add_picture">
<#include "/system/head.ftl">
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
                            	上传图片
                          </header>
                          <div class="panel-body">
                              <form id="picture_upload_form" method="post" class="form-horizontal" autocomplete="off" action="${basePath}/admin/picture/upload.json">
                              	<fieldset>
                                  <div class="form-group last">
                                  <label class="control-label col-md-3">Image Upload</label>
                                    <div class="col-md-9">
                                    	<div data-provides="fileupload" class="fileupload fileupload-new">
                                        	<div style="width: 200px; height: 150px;" class="fileupload-new thumbnail">
                                            	<img alt="" src="http://www.placehold.it/200x150/EFEFEF/AAAAAA&amp;text=no+image">
                                            </div>
                                           	<div>
                                            	<span class="btn btn-white btn-file">
                                            		<input type="file" class="default" name="file">
                                            	</span>
                                            </div>
                                        </div>
                                  	</div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">图片描述</label>
                                      <div class="col-sm-10">
                                          <textarea id="content" name="content" placeholder="图片描述">
                                          </textarea>
                                          <p class="help-block" for="content"></p>
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
		$('#picture_upload_form').bind('form-pre-serialize', function(event,form,options,veto){
    		tinyMCE.triggerSave();
		});
		$('#picture_upload_form').ajaxForm({
			dataType : 'json',
			success : function(data) {
				if (data.result) {
					$("#picture_upload_form").show();
				}else{
					showErrors($('#picture_upload_form'),data.errors);
				}
			}
		});
	});	
</script>		
<#include "/system/foot.ftl">
