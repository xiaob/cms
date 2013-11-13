<!DOCTYPE html>
<html lang="zh_CN">
  <head>
  	<base href="${basePath}">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

    <title>Justified Nav Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
  
    <div class="container">

      <div class="masthead">
      	<div>
      		<img src="images/jiawacms.png" style=" height: 60px;margin-bottom: 10px;margin-left: 10px;"/>
      	</div>
        <ul class="nav nav-justified">
          <li class="active"><a href="#">首页</a></li>
          		<@cms_folder_list>
					<#list folderList as l>
						<li class="active"><a href="folder.do?folderId=${l.folderId}">${l.name}</a></li>
					</#list>
				</@cms_folder_list>
          <li><a href="about.do">关于</a></li>
          <li><a href="#">招聘</a></li>
        </ul>
      </div>
      
    </div>