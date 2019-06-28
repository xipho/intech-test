<#import "../layout/main.ftl" as p>

<@p.page title="Login">
    <div class="container">
        <div class="row mt-2">
            <div class="col-lg-4 offset-lg-4">
                <div class="card">
                    <div class="card-header">Login</div>
                    <form action="/login" method="post" class="form">
                        <div class="card-body">
                            <#if errors??>
                                <div class="alert error">
                                    <ul>
                                        <#list errors as error>
                                            <li>${error}</li>
                                        </#list>
                                    </ul>
                                </div>
                            </#if>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                            <label>Username: </label><input type="text" name="username" class="form-control">
                            <label>Password: </label><input type="password" name="password" class="form-control">
                        </div>
                        <div class="card-footer">
                            <button type="submit" class="btn btn-primary">Login</button>
                            <a class="btn btn-primary" href="/register">Register</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</@p.page>