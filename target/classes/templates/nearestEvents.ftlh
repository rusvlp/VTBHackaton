<#import "blocks/footerHeader.ftlh" as fh>
<@fh.footerHeader user, title>
    Ближайшие мероприятия:
        <div>

            <div class="nearest">
                <#list nearestEvents as event>
                <div class="event">
                    <div id="FonParty">
                        <#if event.previewImage??>
                            <img src="/image/${event.previewImage.id}" style="width: 250px; margin-bottom: 5px; display: block; margin: 0 auto; margin-bottom: 12px; justify-content: center;">
                        <#else>
                            <img src="/static/images/imagePlaceholder.jpeg" style="width: 250px; margin-bottom: 5px; display: block; margin: 0 auto; margin-bottom: 12px; justify-content: center;">
                        </#if>
                        <div>
                            ${event.title}
                        </div>
                    </div>
                </div>
                <#else>
                    Нет ближайших мероприятий
                </#list>
                <div class="event">
                    <div id="FonAll">
                        <img src="/static/images/TitleAll.png" style="width: 250px; padding-top: 90px; margin: 0 auto; padding-left: 10px;">
                    </div>
                </div>
            </div>
        </div>



    <a href = "/events/all">Все мероприятия</a>
</@fh.footerHeader>