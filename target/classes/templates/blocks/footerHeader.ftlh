<#macro footerHeader user, title>
    <html>
    <head>
        <title> ${title} </title>
        <link rel="stylesheet" href="/static/styles/Events.css">
    </head>
    <body>
        <div class = "header">
            Здесь будет хэдер
            <#if user?? && user.username??>
                Здравствуйте, ${user.username}
                <form action = "/logout" method="post">
                    <input type = "hidden" name = "_csrf" value = "${_csrf.token}">
                    <input type="submit" value="Выйти из аккаунта">
                </form>
                <a href = "/events">Мероприятия</a>
            <#else>
                Вы не вошли,
                <a href = "/login">войти</a>
                или
                <a href = "/registration">зарегистрироваться</a>
            </#if>
            <br />

        </div>
        <#nested />
        <div class = "footer">
            Здесь будет футер.

        </div>
    </body>
    </html>
</#macro>