<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Регистрация пользователя</title>
    <link rel="stylesheet" href="/static/styles/Registration.css">
</head>
<body>
<form action = "url" method = "post">
    <div class="t1">
        <p>Форма для регистрации</p>
    </div>
    <div class="t1">
        <p>Личная информация</p>
        <div class="t2">
            <p><b>*</b>Фамилия:<br><input type="text" pattern="[А-Яа-яЁё ]+" placeholder="Фамилия" class="textbox"></p>
            <p><b>*</b>Имя:<br><input type="text" pattern="[А-Яа-яЁё ]+" placeholder="Имя" class="textbox"></p>
            <p>Отчество(при наличии):<br><input type="text" pattern="[А-Яа-яЁё ]+" placeholder="Отчество" class="textbox"></p>
            <hr  width="150px">
            <p><b>*</b>Дата рождения</p><input type="date"  min="1900-01-01" max="20022-10-08">
            <hr  width="150px">
            <p><b>*</b><lable>Email</lable><br>
                <input style="width: 200px;" class="textbox" type="emal" id="mail" name="mail" placeholder="Adress@mail.ru" pattern="[a-zA-Z]{1,}[a-zA-Z0-9.-_][a-zA-Z0-9]{1,}@(mail|gmail|yahoo|yandex).(ru|com)" required>
                <br>
            <p><b>*</b><lable>Логин:</lable><br>
                <input style="width: 200px;" class="textbox" type="text" name="login" placeholder="Логин" required>
                <br>
            <p><b>*</b><lable>Пароль:</lable><br>
                <input style="width: 200px;" class="textbox" type="password" name="password" placeholder="Пароль" required>
                <br>
            <p><b>*</b><lable>Отдел:</lable><br>
                <input style="width: 200px;" class="textbox" type="text" name="Post" placeholder="Отдел" required>
                <br>
            <p><b>*</b><lable>Должность:</lable><br>
                <input style="width: 200px;" class="textbox" type="text" name="Post2" placeholder="Должность" required>
                <br>
            <p><b>*</b>Дата начала работы:</p><input type="date"  min="1900-01-01" max="20022-10-08">
            <form action="registration.html" target="_blank">
                <button class="blubtn1">Зарегестрироваться</button>
            </form>
            <button class="blubtn1" type="reset">Очистить</button><br>
        </div><br>
        <input type= "hidden" name = "_csrf" value = "${_csrf.token}">
    </div>
</form>
</body>
</html>