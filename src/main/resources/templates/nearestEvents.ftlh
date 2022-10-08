<#import "blocks/footerHeader.ftlh" as fh>
<@fh.footerHeader user, title>
    Ближайшие мероприятия:
    <#list nearestEvents as event>
        <div>
            Название: ${event.title}
            Дата проведения: ${event.getFormattedDate()}
            <a href = "">Подробнее</a>
        </div>
    <#else>
        Нет ближайших мероприятий
    </#list>
    <a href = "/events/all">Все мероприятия</a>
</@fh.footerHeader>