<#macro header title="记在收获的季节 | 以梦为马，诗酒趁年华">
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
    <link rel="icon" href="assets/img/favico.png" type="image/x-icon">
    <link rel="shortcut icon" href="assets/img/favico.png" type="image/x-icon">
    <link rel="stylesheet" href="assets/css/pure.min.css"/>
    <link rel="stylesheet" href="assets/css/fonts.css">
    <link rel="stylesheet" href="assets/css/grids-responsive-min.css">
    <link rel="stylesheet" href="assets/css/baby-blue.css">
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="assets/css/side-menu-old-ie.css">
    <![endif]-->
    <!--[if gt IE 8]><!-->
    <link rel="stylesheet" href="assets/css/side-menu.css">
    <!--<![endif]-->
    <#nested>
</head>
<body>
<div id="layout">
    <!-- Menu toggle -->
    <a href="#menu" id="menuLink" class="menu-link">
        <!-- Hamburger icon -->
        <span></span>
    </a>
    <div id="menu">
        <div class="pure-menu">
            <a class="pure-menu-heading" href="https://github.com/MurphyL/Autumn" target="_blank">Autumn</a>

            <ul class="pure-menu-list">
                <li class="pure-menu-item"><a href="/started" class="pure-menu-link">通用</a></li>
                <li class="pure-menu-item"><a href="#" class="pure-menu-link">jQuery</a></li>
                <li class="pure-menu-item"><a href="#" class="pure-menu-link">easyui</a></li>
                <li class="pure-menu-item"><a href="#" class="pure-menu-link">moment.js</a></li>
                <li class="pure-menu-item"><a href="#" class="pure-menu-link">DEMO</a></li>
            </ul>
        </div>
    </div>
    <div id="main">
</#macro>

<#macro footer>
    </div>
</div>
<script src="assets/js/jquery.js"></script>
<script src="assets/js/ui.js"></script>
<script src="assets/js/rainbow.js"></script>
<#nested>
</body>
</html>
</#macro>