<#macro footerHeader user, title>
    <html>
    <head>
        <title> ${title} </title>
        <link rel="stylesheet" href="/static/styles/Events.css">
        <link href="/static/styles/UserCabinetCss.css" rel="stylesheet">
    </head>
    <body>
        <div class = "header">
            <header class="headerUserPage">
                <img src="/static/images/Logo.png" style="width:240px; height:70px">
                <a href="/events" class="ItemList">Мероприятия</a>
                <a href="" class="ItemList">Коллеги</a>
                <a href="" class="ItemList">История</a>
                <a href="/" class="ItemList">Услуги</a>
                <#if user?? && user.avatar??>
                    <img onclick = "account()" class = "avatar" src = "/image/${user.avatar.id}">
                <#else >
                    <img class = "avatar" src="/static/images/userLogo.png">
                </#if>
            </header>
                <div class="pic">
                    <img src="/static/images/Забери награду.png" style="width: 218px;" class="Prize">
                    <img src="/static/images/ГруппаИконок.png" style="width: 529px;" class="Icons1">
                    <img src="/static/images/ГруппаИконок.png" style="width: 529px;" class="Icons2">
                </div>


            <br />

        </div>
        <#nested />
        <div class = "footer">

        </div>
        <script>
            function account(){
                document.location.replace("/account")
            }
        </script>
    </body>
    </html>
</#macro>