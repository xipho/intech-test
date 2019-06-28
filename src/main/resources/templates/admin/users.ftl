<#import "dashboard.ftl" as d/>

<@d.dashboard>
    <h1>Users control</h1>
    <hr />

    <table class="table">
        <thead>
            <th>Id</th>
            <th>Username</th>
            <th>Active</th>
            <th>Actions</th>
        </thead>
        <tbody>
            <#list users as user>
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.active?then("Yes", "No")}</td>
                    <td>
                        <a href="/admin/users/${user.id}/edit" class="btn btn-sm btn-warning"><i class="fas fa-user-edit"></i></a>
                        <a href="/admin/users/${user.id}/delete" class="btn btn-sm btn-danger"><i class="fas fa-trash-alt"></i></a>
                    </td>
                </tr>
            </#list>
        </tbody>
        <tfoot>
        <th>Id</th>
        <th>Username</th>
        <th>Active</th>
        <th>Actions</th>
        </tfoot>
    </table>

</@d.dashboard>