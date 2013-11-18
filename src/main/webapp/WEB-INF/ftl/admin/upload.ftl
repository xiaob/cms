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
                      <form id="my-awesome-dropzone" class="dropzone clickable" style="min-height:520px;" action="${basePath}/admin/photo"><div class="default message" ><span>Drop files here to upload</span></div></form>
                     <button class="btn btn-primary upload" type="submit" style="margin-top:15px;">开始上传</button>
                  </div>
              </section>
              <!-- page end-->
          </section>
      </section>
	    <!-- js placed at the end of the document so the pages load faster -->
  <!-- js placed at the end of the document so the pages load faster -->
    <script src="${basePath}/admin/js/jquery.js"></script>
    <script src="${basePath}/admin/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="${basePath}/admin/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="${basePath}/admin/js/jquery.scrollTo.min.js"></script>
    <script src="${basePath}/admin/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="${basePath}/admin/js/dropzone.js"></script>
    <script src="${basePath}/admin//js/respond.min.js" ></script>

    <!--common script for all pages-->
    <script src="js/common-scripts.js"></script>
    <script>
    	$(function(){
    		$(".upload").click(function(){
    		});
    	});
    </script>
	  
<#include "foot.ftl">
