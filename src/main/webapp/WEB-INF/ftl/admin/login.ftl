<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>师说CMS 后台</title>

    <!-- Bootstrap core CSS -->
    <link href="${basePath}/admin/css/bootstrap.min.css" rel="stylesheet">
    <link href="${basePath}/admin/css/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link href="${basePath}/admin/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <!-- Custom styles for this template -->
    <link href="${basePath}/admin/css/style.css" rel="stylesheet">
    <link href="${basePath}/admin/css/style-responsive.css" rel="stylesheet" />

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
    <script src="${basePath}/admin/js/html5shiv.js"></script>
    <script src="${basePath}/admin/js/respond.min.js"></script>
    <![endif]-->
</head>

  <body class="login-body">

    <div class="container">

      <form class="form-signin" action="index.html">
        <h2 class="form-signin-heading"><img src="${basePath}/admin/images/logo.png" style="height:38px;"/></h2>
        <div class="login-wrap">
            <input type="text" class="form-control" placeholder="邮箱" autofocus>
            <input type="password" class="form-control" placeholder="密码">
            <label class="checkbox">
                <input type="checkbox" value="remember-me"> Remember me
                <span class="pull-right"> <a href="#"> Forgot Password?</a></span>
            </label>
            <button class="btn btn-lg btn-login btn-block" type="submit">登录</button>
            <div class="registration">
                Don't have an account yet?
                <a class="" href="registration.html">
                    Create an account
                </a>
            </div>

        </div>

      </form>

    </div>


  </body>
</html>
