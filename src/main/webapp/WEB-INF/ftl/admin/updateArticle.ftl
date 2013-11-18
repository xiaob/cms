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
                              <form method="post" class="form-horizontal tasi-form" action="/CMS/admin/file/updateFile.do">
                              	<fieldset>
                              	  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">文件Id</label>
                                      <div class="col-sm-10">
                                      	<label class="col-sm-2 col-sm-2 control-label" name="fileId">
                                      		${file.fileId}
                                      	</label>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">文章名称</label>
                                      <div class="col-sm-10">
                                          <input type="text" class="form-control" name="fileName" value="${file.name}">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">文章链接</label>
                                      <div class="col-sm-10">
                                          <input type="text" class="form-control" name="url" value="${file.url}">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">文章图片</label>
                                      <div class="col-sm-10">
                                          <input type="text" class="form-control" name="images" value="${file.images}">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">文章类型</label>
                                      <div class="col-sm-10">
                                          <input type="text" class="form-control" name="description" value="${file.description}">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <input class="button" value="修改" type="submit" style="height:35px">
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
<#include "foot.ftl">
