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
                                	<div class="col-sm-10">
                                    	<input type="file" id="file" name= "file"/>
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
				
				}else{
				
				}
			}
		}
	});
<#include "/system/foot.ftl">
