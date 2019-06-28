<#import "../layout/main.ftl" as m>

<#macro dashboard>
<@m.page title="Admin dashboard">
    <div class="container-fluid">
        <div class="row d-flex">
            <div class="col-lg-2 admin-sidebar">
                <ul class="dashboard-pages">
                    <li><a href="/admin/users"><i class="fas fa-user"></i> Users</a></li>
                    <li><a href="/admin/topics"><i class="fas fa-align-justify"></i> Topics</a></li>
                </ul>
            </div>
            <div class="col-lg-10">
                <#nested>
            </div>
        </div>
    </div>
</@m.page>
</#macro>