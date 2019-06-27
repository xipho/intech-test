<#import "../layout/main.ftl" as p>

<@p.page title="Registration">
    <div class="row mt-2">
        <div class="col-lg-4 offset-lg-4">
            <div class="card">
                <div class="card-header">Registration</div>
                <form action="/register" method="post" class="form">
                    <div class="card-body">
                        <#if errors??>
                            <div class="alert alert-danger">
                                <ul>
                                   <#list errors as error>
                                       <li>${error.defaultMessage}</li>
                                   </#list>
                                </ul>
                            </div>
                        </#if>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                        <label>Username: </label><input type="text" name="username" class="form-control" value="<#if user??>${user.username}</#if>">
                        <label>Password: </label><input type="password" name="password" class="form-control" value="<#if user??>${user.password}</#if>">
                        <label>Confirm password: </label><input type="password" name="confirmPassword" class="form-control" value="<#if user??>${user.confirmPassword}</#if>">
                    </div>
                    <div class="card-footer">
                        <button type="submit" class="btn btn-primary">Register</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</@p.page>