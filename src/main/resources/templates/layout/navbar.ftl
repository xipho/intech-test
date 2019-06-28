<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">${title}</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
            </li>
        </ul>
<#--        <form class="form-inline my-2 my-lg-0">-->
<#--            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">-->
<#--            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>-->
<#--        </form>-->

        <#if name == "Guest">
            <h6>Hello, Guest!</h6>
        <#else>
            <h6 class="mr-3">Hello, ${name}!</h6>
            <form action="/logout" id="logout-form" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <a href="#" class="btn btn-sm btn-secondary" onclick="document.getElementById('logout-form').submit();">Logout</a>
            </form>
        </#if>
    </div>
</nav>