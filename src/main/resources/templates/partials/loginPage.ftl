<#include "../main.ftl">
<#macro page_body>
<main id="content" role="main" xmlns="http://www.w3.org/1999/html">
    <h1>Hello, this page works!</h1>
    <div>
        <div>
            <#if !success>
                An error has occurred, please re enter your details
            </#if>
        </div>
        <form method="POST" action="login-details">
            Username: <input type="text" name="username">
            Password: <input type="password" name="password">
            <input type="submit" value="submit">
        </form>
    </div>
</#macro>