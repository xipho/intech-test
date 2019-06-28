<#import "layout/main.ftl" as m>
<@m.page title="Topics">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <form action="/topics" method="post" class="form">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <label for="topic-title">Topic title:</label>
                    <input type="text" name="title" class="form-control" id="topic-title">
                    <label for="topic-description">Topic description:</label>
                    <textarea name="description" class="form-control" id="topic-description"></textarea>
                    <button type="submit" class="btn btn-primary">Create</button>
                </form>
            </div>
        </div>
    </div>
</@m.page>