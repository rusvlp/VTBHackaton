<#import "blocks/footerHeader.ftlh" as fh>
<@fh.footerHeader user, title>
    Добро пожаловать в админ-панель!<br />
    Добавьте мероприятие
    <form action = "/admin/addEvent" method="post">
        <label for = "title">Название: </label>
        <input type = "text" name = "title" id = "title"> <br />
        <label for = "description">Описание: </label>
        <input type = "text" name = "description" id = "description"> <br />
        <label for = "dateOfStart">Дата начала: </label>
        <input type = "date" name = "date" id = "dateOfStart"> <br />
        <label for = "seasonPassXpValue">Очки сезонного пропуска: </label>
        <input type = "number" name = "seasonPassXpValue" id = "seasonPassXpValue"> <br />
        <label for = "cryptoValue">Крипторубли: </label>
        <input type="number" name = "cryptoValue" id = "cryptoValue"> <br />
        <input type = "submit" value = "Добавить мероприятие">
        <input type = "hidden" name = "_csrf" value = "${_csrf.token}">
    </form>
</@fh.footerHeader>