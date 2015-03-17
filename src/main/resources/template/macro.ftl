<#macro header title="网站联盟管理">
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
    <link rel="stylesheet" href="asserts/css/bootstrap.min.css"/>
    <#nested>
</head>
<body>
<div id="container">
</#macro>


<#macro footer>
</div>
<#nested>
</body>
</html>
</#macro>