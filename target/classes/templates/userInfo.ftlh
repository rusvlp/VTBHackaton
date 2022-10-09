<#import "blocks/footerHeader.ftlh" as fh>
<@fh.footerHeader user, title>
    <div class="Page">
        <div>
        Личный кабинет. <br/>
        Аватарка: <br/>
        <#if targetUser.avatar??>
            <img src = "/image/${targetUser.avatar.id}" alt="Аватар">
        <#else>
            Аватара нет
        </#if>
        ФИО: ${targetUser.lastName} ${targetUser.firstName} ${targetUser.middleName} <br />
        Должность: ${targetUser.jobTitle} <br />
        Дата рождения: ${targetUser.dateOfBirth} <br />
        Отдел: <#if targetUser.department?? && targetUser.department.title??> ${targetUser.department.title} <#else>Нет отдела</#if> <br />
        <#if targetUser == user>

            Загрузить аватар:
            <form action = "/account/setAvatar" method="post" enctype="multipart/form-data">
                <input type="file" name = "file">
                <input type = "hidden" name = "_csrf" value = "${_csrf.token}">
                <input type = "submit" value = "Загрузить изображение">
            </form>
            <form action = "logout" method="post">
                <input type = "hidden" name = "_csrf" value = "${_csrf.token}">
                <input type = "submit" value = "Выйти из аккаунта">
            </form>
            </div>
            <div>
                <img src="/static/images/NFTGroup.png">
            </div>
        </div>
    </#if>
</@fh.footerHeader>