<#import "blocks/footerHeader.ftlh" as fh>
<@fh.footerHeader user, title>
    Личный кабинет. <br/>
    Аватарка: <br/>
    <#if targetUser.avatar??>
        <img src = "/image/${targetUser.avatar.id}" alt="Аватар">
    <#else>
        Аватара нет
    </#if>
    ФИО: ${targetUser.lastName} ${targetUser.firstName} ${targetUser.middleName} <br />
    Должность: ${targetUser.jobTitle}
    Дата рождения: ${targetUser.dateOfBirth}
    Отдел: <#if targetUser.department?? && targetUser.department.title??> ${targetUser.department.title} <#else>Нет отдела</#if>
    Загрузить аватар:
    <form action = "/account/setAvatar" method="post" enctype="multipart/form-data">
        <input type="file" name = "file">
        <input type = "hidden" name = "_csrf" value = "${_csrf.token}">
        <input type = "submit" value = "Загрузить изображение">
    </form>
</@fh.footerHeader>