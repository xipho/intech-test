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
                    <th>ID</th>
                    <th>Name</th>
                    <th>Info</th>
                    <th></th>
                    </thead>
                    <tbody>
                    <#list topics.content as topic>
                        <tr>
                            <td>${topic.id}</td>
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
                    <th>ID</th>
                    <th>Name</th>
                    <th>Info</th>
                    <th></th>
                    </tfoot>
                </table>
                <@p.pager page=topics url="/topics" />
            </div>
        </div>
    </div>
</@m.page>
