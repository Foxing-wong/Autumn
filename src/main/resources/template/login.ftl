<!DOCTYPE html>
<html lang="en" ng-app>
<head>
    <meta charset="utf-8"/>
    <title>登陆管理后台</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
    <link rel="stylesheet" href="http://cijian.qiniudn.com/css/bootstrap.css" type="text/css"/>
    <link rel="stylesheet" href="http://cijian.qiniudn.com/css/animate.css" type="text/css"/>
    <link rel="stylesheet" href="http://cijian.qiniudn.com/css/font-awesome.min.css" type="text/css"/>
    <link rel="stylesheet" href="http://cijian.qiniudn.com/css/simple-line-icons.css" type="text/css"/>
    <link rel="stylesheet" href="http://cijian.qiniudn.com/css/font.css" type="text/css"/>
    <link rel="stylesheet" href="angular/css/app.css" type="text/css"/>
</head>
<body>
<div class="app">
    <div class="smooth">
        <div class="container w-xxl w-auto-xs login">
            <div class="m-b-lg">
                <form name="form" class="form-validation" action="" method="post">
                    <div class="list-group list-group-sm">
                        <div class="list-group-item">
                            <input type="text" name="username" placeholder="Username" class="form-control no-border" ng-model="username" required="" autofocus>
                        </div>
                        <div class="list-group-item">
                            <input type="password" name="password" placeholder="Password" class="form-control no-border" ng-model="password" required="">
                        </div>
                    </div>
                    <button type="submit" class="btn btn-lg btn-primary btn-block" ng-disabled="form.$invalid" disabled="disabled">Log in</button>
                </form>
            </div>
            <div class="text-center">
                <p><small class="text-muted">Web app framework base on Bootstrap and AngularJS<br>© 2014</small></p>
            </div>
        </div>
    </div>
</div>
<script src="http://cijian.qiniudn.com/js/angular.js"></script>
</body>
</html>