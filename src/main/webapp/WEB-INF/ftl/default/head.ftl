<!DOCTYPE html>
<html lang="zh_CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

    <title>Justified Nav Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="${basePath}/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${basePath}/css/style.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="${basePath}/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="${basePath}/js/html5shiv.js"></script>
      <script src="${basePath}/js/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
  
    <div class="container">

      <div class="masthead">
      	<div>
      		<img src="${basePath}/images/jiawacms.png" style=" height: 60px;margin-bottom: 10px;margin-left: 10px;"/>
      	</div>
        <ul class="nav nav-justified">
          <@cms_folder_list fatherId="0">
	          <#list folderList as folder>
	          <li <#if folder.folderId == currentFolder.topId>class="active"</#if> ><a href="${basePath}${folder.ename}">${folder.name}</a></li>
	          </#list>
		  </@cms_folder_list>
        </ul>
      </div>
      
    </div>