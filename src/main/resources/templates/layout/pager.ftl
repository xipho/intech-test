<#macro pager page url>
    <#if page.getTotalPages() gt 1>
        <#assign pageNum = page.getNumber() + 1/>
        <ul class="pagination">
            <li class="page-item <#if pageNum == 1>disabled</#if>">
                <a class="page-link" href="${url}?page=${pageNum-1}">Previous</a>
            </li>
            <#list 1..page.getTotalPages() as p>
                <#if pageNum == p><#assign active = true /><#else><#assign active = false /></#if>
                <li class="page-item <#if active>active</#if>"><a class="page-link"
                                                                  <#if !active>href="${url}?page=${p}"</#if>>${p}</a>
                </li>
            </#list>
            <li class="page-item <#if pageNum == page.getTotalPages()>disabled</#if>">
                <a class="page-link" href="${url}?page=${pageNum+1}">Next</a>
            </li>
        </ul>
    </#if>
</#macro>