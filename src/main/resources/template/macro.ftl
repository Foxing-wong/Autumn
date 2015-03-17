<#macro header title="常用演示的案例">
<!doctype html>
<html lang="zh_CN">
<head prefix="og: http://ogp.me/ns#">
    <meta charset="UTF-8">
    <title>${title}</title>
    <meta name="robots" content="index, follow">
    <meta name="author" content="MurphyL">
    <meta name="email" content="im@murphyl.com">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="assets/css/blog.css"/>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="assets/js/html5shiv.min.js"></script>
    <![endif]-->
    <#nested>
</head>
<body>
<div id="container">
</#macro>


<#macro footer>
</div>
<script src="assets/js/jquery.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/docs.min.js"></script>
<#nested>
</body>
</html>
</#macro>