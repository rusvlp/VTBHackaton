<#import "blocks/footerHeader.ftlh" as fh>
<@fh.footerHeader user, title>
    Все мероприятия:
    <#list events as event>
        <div>
            Название: ${event.title}
            Дата проведения: ${event.getFormattedDate()}
            <a href = "/events/${event.id}">Подробнее</a>
        </div>
    <#else>
        Нет мероприятий
    </#list>
</@fh.footerHeader>