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
                    		<div class="form-group">
                            	<label class="col-sm-2 col-sm-2 control-label">大图</label>
                                <div class="col-sm-10">
                                	<input type="text" class="form-control" name="name" placeholder="标题" id="name">
                                </div>
                           	</div>
                        </div>
                  </div>
              </section>
              <!-- page end-->
          </section>
		</section>
		<!--main content end-->
<#include "/admin/foot.ftl">
