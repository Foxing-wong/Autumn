<#assign user = getUser(), mapping = getMenuMapping() />
<#-- 渲染菜单 -->
<#macro render key>
    <#assign menu = mapping[key] />
    <#assign icon = menu.icon!'' />
    <#if (menu.parent!false)>
    <#if user.hasRole(menu.role)>
    <li>
        <a href="${menu.path!'javascript:;'}" title="${menu.descrption!''}">
            <i class="fa ${icon} fa-fw"></i> ${key}
        </a>
    </li>
    </#if>
    <#else>
    <li>
        <a href="javascript:;"><i class="fa ${icon} fa-fw"></i> ${key}<span class="fa arrow"></span></a>
        <ul class="nav nav-second-level">
        <#list menu.menus as subMenu>
        <#if user.hasRole(subMenu.role)>
            <li>
                <a href="${subMenu.path!'javascript:;'}"  title="${subMenu.descrption!''}">${subMenu.name!'超链接'}</a>
            </li>
        </#if>
        </#list>
        </ul>
        <!-- /.nav-second-level -->
    </li>
    </#if>
</#macro>

<#macro header title, st=false>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="author" content="MurphyL">
    <link rel='shortcut icon' type='image/x-icon' href='favicon.ico' />
    <title>${title} | I'm MurphyL.</title>
    <!-- Bootstrap Core CSS -->
    <link href="/metro/css/metro.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="/metro/css/metro-icons.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="/metro/css/docs.css" rel="stylesheet" type="text/css">
    <#nested>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cijian.qiniudn.com/js/html5shiv.js"></script>
    <script src="http://cijian.qiniudn.com/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <div>
        <header class="app-bar fixed-top" data-role="appbar">
            <div class="container">
                <a href="/dashboard" class="app-bar-element branding">I'm MurphyL.</a>
                <ul class="app-bar-menu">
                    <li data-flexorderorigin="0" data-flexorder="1">
                        <a href="#" class="dropdown-toggle">Base CSS</a>
                        <ul class="d-menu" data-role="dropdown" data-no-close="true">
                            <li class="disabled"><a href="overview.html">Overview</a></li>
                            <li class="divider"></li>
                            <li><a href="grid.html">Grid system</a></li>
                            <li><a href="typography.html">Typography</a></li>
                            <li><a href="tables.html">Tables</a></li>
                            <li><a href="inputs.html">Forms &amp; Inputs</a></li>
                            <li><a href="buttons.html">Buttons</a></li>
                            <li><a href="images.html">Images</a></li>
                            <li><a href="font.html">Metro Icon Font</a></li>
                            <li class="divider"></li>
                            <li><a href="colors.html">Colors</a></li>
                            <li><a href="helpers.html">Helpers classes</a></li>
                            <li class="divider"></li>
                            <li class="disabled"><a href="responsive.html">Responsive</a></li>
                        </ul>
                    </li>
                    <li data-flexorderorigin="1" data-flexorder="2">
                        <a href="#" class="dropdown-toggle">Widgets</a>
                        <ul class="d-menu" data-role="dropdown" data-no-close="true">
                            <li class="disabled"><a href="#">Overview</a></li>
                            <li class="divider"></li>
                            <li>
                                <a href="#" class="dropdown-toggle">Utils</a>
                                <ul class="d-menu" data-role="dropdown">
                                    <li><a href="validator.html">Form Validator</a></li>
                                    <li class="divider"></li>
                                    <li><a href="easing.html">Easing functions</a></li>
                                    <li class="disabled"><a href="precode.html">PreCode</a></li>
                                </ul>
                            </li>
                            <li class="divider"></li>
                            <li><a href="tiles.html">Tiles</a></li>
                            <li>
                                <a href="#" class="dropdown-toggle">Controls</a>
                                <ul class="d-menu" data-role="dropdown" data-no-close="true">
                                    <li><a href="accordion.html">Accordion</a></li>
                                    <li><a href="appbar.html">Application bar</a></li>
                                    <li><a href="button-groups.html">Button groups</a></li>
                                    <li><a href="keypad.html">Keypad</a></li>
                                    <li><a href="menu.html">Menus</a></li>
                                    <li><a href="sidebar.html">Sidebar</a></li>
                                    <li><a href="tabcontrol.html">Tab Control</a></li>
                                    <li><a href="treeview.html">TreeView</a></li>
                                    <li><a href="listview.html">ListView</a></li>
                                    <li><a href="sliders.html">Slider</a></li>
                                    <li><a href="stepper.html">Stepper</a></li>
                                    <li><a href="wizard.html">Wizard</a></li>
                                    <li><a href="wizard2.html">Wizard2</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="#" class="dropdown-toggle">Visualization</a>
                                <ul class="d-menu" data-role="dropdown" data-no-close="true">
                                    <li><a href="carousel.html">Carousel</a></li>
                                    <li class="no-display"><a href="windows.html">Windows</a></li>
                                    <li><a href="popovers.html">Popovers</a></li>
                                    <li><a href="progressbar.html">Progress Bar</a></li>
                                    <li><a href="panels.html">Panels</a></li>
                                    <li><a href="rating.html">Rating</a></li>
                                    <li><a href="preloaders.html">Preloaders</a></li>
                                    <li><a href="hints.html">Hints</a></li>
                                    <li><a href="streamer.html">Streamer</a></li>
                                    <li><a href="presenter.html">Presenter</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="#" class="dropdown-toggle">Information</a>
                                <ul class="d-menu" data-role="dropdown" data-no-close="true">
                                    <li><a href="notify.html">Notify system</a></li>
                                    <li><a href="dialog.html">Dialogs</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="#" class="dropdown-toggle">Date &amp; Time</a>
                                <ul class="d-menu" data-role="dropdown" data-no-close="true">
                                    <li><a href="calendar.html">Calendar</a></li>
                                    <li><a href="datepicker.html">Datepicker</a></li>
                                    <li><a href="countdown.html">Countdown</a></li>
                                </ul>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#" class="dropdown-toggle">Third-party</a>
                                <ul class="d-menu" data-role="dropdown" data-no-close="true">
                                    <li><a href="select2.html">Select2</a></li>
                                    <li><a href="datatables.html">DataTables</a></li>
                                </ul>
                            </li>
                        </ul>
                    </li>

                    <li data-flexorderorigin="2" data-flexorder="3">
                        <a href="#" class="dropdown-toggle">Templates</a>
                        <ul class="d-menu" data-role="dropdown" data-no-close="true">
                            <li><a href="templates/start-screen.html">Start screen</a></li>
                            <li><a href="templates/news-portal.html">News Portal</a></li>
                            <li><a href="templates/login.html">Login form</a></li>
                        </ul>
                    </li>

                    <li data-flexorderorigin="3" data-flexorder="4">
                        <a href="#" class="dropdown-toggle">Community</a>
                        <ul class="d-menu" data-role="dropdown" data-no-close="true">
                            <li><a href="http://forum.metroui.org.ua">Forum</a></li>
                            <li><a href="https://github.com/olton/Metro-UI-CSS">Github</a></li>
                            <li class="divider"></li>
                            <li><a href="license.html">License</a></li>
                        </ul>
                    </li>
                </ul>
                <span class="app-bar-pull"></span>
                <div class="app-bar-pullbutton automatic" style="display: none;"></div>
                <div class="clearfix" style="width: 0;"></div>
                <nav class="app-bar-pullmenu hidden flexstyle-app-bar-menu" style="display: none;">
                    <ul class="app-bar-pullmenubar hidden app-bar-menu"></ul>
                </nav>
            </div>
        </header>
    </div>
    <div class="container page-content">
        <div id="app-content">
            <#if st><h1><a href="/dashboard" class="nav-button transform"><span></span></a>&nbsp;${title}</h1><hr class="thin"></#if>
</#macro>


<#macro footer>
        </div>
    </div>
<script src="http://cijian.qiniudn.com/js/jquery.min.js"></script>
<script src="/metro/js/metro.js"></script>
<#nested>
</body>
</html>
</#macro>