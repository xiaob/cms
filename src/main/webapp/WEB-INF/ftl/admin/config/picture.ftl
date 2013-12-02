<#assign menu="system">
<#assign submenu="system_picture">
<#include "/admin/head.ftl">
<style type="text/css">
.pagination {
    border-radius: 4px;
    display: inline-block;
    margin: 0;
    padding-left: 0;
}
</style>
	<!--main content start-->
	<section id="main-content">
		<section class="wrapper">
        	<!-- page start-->
            <section class="panel">
            	<header class="panel-heading">
               		图片选项
                </header>
                <div class="panel-body">
                	<div class="adv-table">
                    	<div role="grid" class="dataTables_wrapper" id="hidden-table-info_wrapper">
                    	<form id="add_article_form" method="post" class="form-horizontal" autocomplete="off" action="${basePath}/admin/config/update/picture.json">
                            <fieldset>
                    		<div class="form-group">
                            	<label class="col-sm-2 col-sm-2 control-label">大图</label>
                                <div class="col-sm-10">
                                	<label class="col-sm-2 col-sm-2 control-label">最大宽度</label>
                                	<input type="number" class="small-text" value="800" id="picture_big_w" name="bigWidth">
                                	<label class="col-sm-2 col-sm-2 control-label">最大高度</label>
                                	<input type="number" class="small-text" value="800" id="picture_big_h" name="bigHeight">
                                </div>
                           	</div>
                           	<div class="form-group">
                            	<label class="col-sm-2 col-sm-2 control-label">小图</label>
                                <div class="col-sm-10">
                                	<label class="col-sm-2 col-sm-2 control-label">最大宽度</label>
                                	<input type="number" class="small-text" value="300" id="picture_small_w" name="smallWidth">
                                	<label class="col-sm-2 col-sm-2 control-label">最大高度</label>
                                	<input type="number" class="small-text" value="300" id="picture_small_h" name="smallHeight">
                                </div>
                           	</div>
                           	<div class="form-group">
                            	<label class="col-sm-2 col-sm-2 control-label"></label>
                            	<div class="col-sm-10">
                                	<button class="btn btn-danger" type="submit">修改配置</button>
                            	</div>
                            </div>
                        </fieldset>
                        </form>
                        </div>
                  </div>
			</section>
              <!-- page end-->
		</section>
	</section>
		<!--main content end-->
<#include "/admin/foot.ftl">
