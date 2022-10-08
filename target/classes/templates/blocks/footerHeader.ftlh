<#macro footerHeader user, title>
    <html>
    <head>
        <title> ${title} </title>
    </head>
    <body>
        <div class = "header">
            Здесь будет хэдер
            <#if user?? && user.username??>
                Здравствуйте, ${user.username}
            <#else>
                Вы не вошли,
                <a href = "/login">войти</a>
                или
                <a href = "/registration">зарегистрироваться</a>
            </#if>
            <br />
            <a href = "/events">Мероприятия</a>
        </div>
        <#nested />
        <div class = "footer">
            Здесь будет футер.

        </div>
    </body>
    </html>
</#macro>