<#import "layout/main.ftl" as m>
<@m.page title="${topic.title}">
    <div class="container">
        <#list topic.posts as post>
            <div class="row my-2 post-row">
                <div class="col-lg-2 author-info">
                    ${post.author.username}
                </div>
                <div class="col-lg-10 post-data">
                    <p>${post.text}</p>
                    <#if m.isAdmin || m.name == post.author.username>
                        <form action="/posts/${post.id}" method="post">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                            <input type="hidden" name="method" value="DELETE">
                            <button type="submit" class="btn btn-danger float-right">Delete post</button>
                        </form>
                    </#if>
                </div>
            </div>
        <#else>
            <div class="row">
                <div class="col-lg-12">
                    <h6>There is no posts in this topic yet</h6>
                </div>
            </div>
        </#list>
        <hr>
        <div class="row">
            <div class="col-lg-12">
                <form action="/posts/${topic.id}" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <textarea name="text" id="post-text" class="form-control" rows="5"></textarea><br>
                    <button type="submit" class="btn btn-danger float-right">Create post</button>
                </form>
            </div>
        </div>
    </div>
</@m.page>