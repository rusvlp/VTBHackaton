<#macro footerHeader user, title>
    <html>
    <head>
        <title> ${title} </title>
    </head>
    <body>
        <div class = "header">
            Здесь будет хэдер
        </div>
        <#nested />
        <div class = "footer">
            Здесь будет футер.
            <#if user?? && user.username??>
               Здравствуйте, ${user.username}
            <#else>
                Вы не вошли,
                <a href = "/login">войти</a>
                или
                <a href = "/registration">зарегистрироваться</a>
            </#if>
        </div>
    </body>
    </html>
</#macro>