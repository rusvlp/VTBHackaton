<#import "blocks/footerHeader.ftlh" as fh>
<@fh.footerHeader user, title>
    Регистрация <br/>
    <form action="/registration" method="post">
        <label for = "username">Имя пользователя: </label>
        <input type="text" name = "username" id = "username"/>
        <label for = "password">Пароль: </label>
        <input type = "password" name = "password" id = "password">
        <input type = "hidden" name = "_csrf" value = "${_csrf.token}">
        <input type = "submit" value ="Зарегистрироваться"><br/>
        <#if message??>
            ${message}
        </#if>

    </form>
</@fh.footerHeader>