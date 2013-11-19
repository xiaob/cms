<#assign menu="system">
<#assign submenu="system_basic">
<#include "../head.ftl">
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
                            	 添加管理员
                          </header>
                          <div class="panel-body">
                              <form method="post" class="form-horizontal" action="${basePath}/admin/admin/addNewAdmin.do">
                              	<fieldset>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">管理员名称</label>
                                      <div class="col-sm-10">
                                          <input type="text" class="form-control" name="adminName">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <input class="button" value="增加" type="submit" style="height:35px">
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
<#include "../foot.ftl">