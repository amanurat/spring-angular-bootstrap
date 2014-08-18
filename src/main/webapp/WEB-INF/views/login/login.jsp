<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<head>
    <title>Spring Angular Bootstrap</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" media="screen" />
    <link href="<c:url value="/resources/css/jumbotron.css" />" rel="stylesheet" media="screen" />
    <link href="<c:url value="/resources/css/signin.css" />" rel="stylesheet" media="screen" />
    <link href="<c:url value="/resources/css/core.css" />" rel="stylesheet" media="screen" />

    <tilesx:useAttribute id="styles" name="styles" classname="java.util.List" ignore="true" />
    <c:forEach var="cssName" items="${styles}">
        <link type="text/css" href="<c:url value="/resources/css/${cssName}"/>" rel="stylesheet" media="screen" />
    </c:forEach>

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

</head>


<body>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Spring Angular Bootstrap</a>
        </div>
        <div class="navbar-collapse collapse">

            <ul class="nav navbar-nav">
               <li > <a href="/getting-started">Getting started</a></li>
                <li><a href="/user-manual">User Manual</a></li>
            </ul>

            <form class="navbar-form navbar-right" role="form" action="<s:url value="/j_spring_security_check"/>" method="post">
                <div class="form-group">
                    <input type="email" placeholder="Email" class="form-control" id="email" name="j_username" required="true">
                </div>
                <div class="form-group">
                    <input type="password" placeholder="Password" class="form-control" id="password" name="j_password" required="true">
                </div>
                <button type="submit" class="btn btn-success">Sign in</button>
            </form>
        </div><!--/.navbar-collapse -->
    </div>
</div>

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-5">
            <div class="container">
                <h1>Spring Angular Bootstrap</h1>
                <p>Spring MVC + AngularJS + Twitter Bootstrap</p>
                <iframe class="github-btn" src="http://ghbtns.com/github-btn.html?user=thysmichels&amp;repo=spring-angular-bootstrap&amp;type=watch&amp;count=true" allowtransparency="true" frameborder="0" scrolling="0" width="100px" height="20px"></iframe>
                <iframe class="github-btn" src="http://ghbtns.com/github-btn.html?user=thysmichels&amp;repo=spring-angular-bootstrap&amp;type=fork&amp;count=true" allowtransparency="true" frameborder="0" scrolling="0" width="98px" height="20px"></iframe>
                <a href="https://twitter.com/share" class="twitter-share-button" data-url="http://spring-angular-bootstrap.herokuapp.com/" data-text="Check out Spring Angular Bootstrap" data-via="thysmichels" data-hashtags="springangularbootstrap">Tweet</a>
                <script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script>
            </div>
        </div>
        <div class="col-md-6">
            <form class="form-signin" role="form" action="<s:url value="/signup"/>" method="post">
                <h2 class="form-signin-heading">Please sign up</h2>
                <input type="email" name="email" class="form-control" placeholder="Email address" required autofocus>
                <input type="password" name="password" class="form-control" placeholder="Password" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
            </form>
        </div>

    </div>
</div>


<div class="container">
    <!-- Example row of columns -->
    <div class="row">
        <div class="col-md-4">
            <h2>Spring MVC</h2>
            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
            <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>
        <div class="col-md-4">
            <h2>AngularJS</h2>
            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
            <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>
        <div class="col-md-4">
            <h2>Twitter Bootstrap</h2>
            <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
            <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>
    </div>



    <hr>

    <footer>
        <p>&copy; Thys Michels 2014</p>
    </footer>
</div> <!-- /container -->
