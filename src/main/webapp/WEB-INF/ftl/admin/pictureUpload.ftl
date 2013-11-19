<#include "head.ftl">

    <!-- Bootstrap core CSS -->
    <link href="${basePath}/admin/css/bootstrap.min.css" rel="stylesheet">
    <link href="${basePath}/admin/css/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link href="${basePath}/admin/css/font-awesome.css" rel="stylesheet" />
    <link href="${basePath}/admin/css/dropzone.css" rel="stylesheet"/>
      <!-- Custom styles for this template -->
    <link href="${basePath}/admin/css/style.css" rel="stylesheet">
    <link href="${basePath}/admin/css/style-responsive.css" rel="stylesheet" />

<section id="main-content">
          <section class="wrapper">
              <!-- page start-->
              <section class="panel">
                  <header class="panel-heading">
                                                                              上传文件
                  </header>
                  <div class="panel-body">
                      <form id="my-awesome-dropzone" class="dropzone clickable" style="min-height:520px;" action="${basePath}/admin/picture/"><div class="default message" ><spa></span></div></form>
                  </div>
              </section>
              <!-- page end-->
          </section>
      </section>
	    <!-- js placed at the end of the document so the pages load faster -->
  <!-- js placed at the end of the document so the pages load faster -->
    <script src="${basePath}/admin/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="${basePath}/admin/js/dropzone.js"></script>
    <!--common script for all pages-->
    <script src="js/common-scripts.js"></script>
<#include "foot.ftl">
