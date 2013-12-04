<#assign menu="picture">
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
                              <form id="picture_upload_form" method="post" class="form-horizontal" autocomplete="off" action="${basePath}/admin/picture/upload">
                              	<fieldset>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">图片</label>
                                      <div class="col-sm-10">
                                          <input type="file" name="file" id="file">
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
	$("#picture_upload_form").hide();
		$('#addFolder_form').ajaxForm({
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
