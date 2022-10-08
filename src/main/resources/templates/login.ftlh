<#import "blocks/footerHeader.ftlh" as fh>
<@fh.footerHeader user, title>
    Войти:
    <form action = "/login" method="post">
        <label for = "username">Имя пользователя</label>
        <input type = "text" name = "username" id = "username"> <br />
        <lablel for = "password">Пароль</lablel>
        <input type = "password" name ="password" id = "password">
        <input type = "hidden" name = "_csrf" value = "${_csrf.token}">
        <input type = "submit" value="Войти">
    </form>
</@fh.footerHeader>