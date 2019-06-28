<#import "layout/main.ftl" as m/>
<#import "layout/pager.ftl" as p/>
<@m.page title="Topics">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <a href="/topics/add" class="btn btn-success pull-right">New topic</a>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <hr>
                <@p.pager page=topics url="/topics" />
                <table class="table">
                    <thead>
                    <th>Remove</th>
                    <th>Name</th>
                    <th>Info</th>
                    <th></th>
                    </thead>
                    <tbody>
                    <#list topics.content as topic>
                        <tr>
                            <td>
                                <#if m.isAdmin || topic.author.username == m.name >
                                <form action="/topics/${topic.id}/delete" method="post">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                    <a class="btn btn-xs btn-danger text-white" onclick="deletePrompt(this, '${topic.title}')"><i class="fas fa-trash-alt"></i></a>
                                </form>
                                <#else>
                                    ${topic.id}
                                </#if>
                            </td>
                            <td>
                                <h6><a href="/topics/${topic.slug}">${topic.title}</a></h6>
                                <p>${topic.description}</p>
                            </td>
                            <td>
                                Author: ${topic.author.username}<br>
                                Created: ${topic.createdAt}<br>
                            </td>
                        </tr>
                    <#else>
                        <tr><td colspan="3">No Topics yet!</td></tr>
                    </#list>
                    </tbody>
                    <tfoot>
                    <th>Remove</th>
                    <th>Name</th>
                    <th>Info</th>
                    <th></th>
                    </tfoot>
                </table>
                <@p.pager page=topics url="/topics" />
            </div>
        </div>
    </div>

    <script>
        function deletePrompt(element,title) {
            if (confirm("Are you sure to delete topic '" + title + "'")) {
                element.parentElement.submit();
                return true;
            } else {
                return false;
            }
        }
    </script>
</@m.page>
