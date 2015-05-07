<#include "../main.ftl">
<#macro page_body>
<main id="content" role="main" xmlns="http://www.w3.org/1999/html">
    <h1>Welcome to your homepage! Please find useful links below!</h1>
    <div>
        <form action="create-new-person">
            <button type="button">Create a new person</button>
        </form>
        <form action="delete-user">
            <button type="button">Delete a user</button>
        </form>
        <form action="view-all">
            <button type="button">View all people and their details</button>
        </form>
        <form action="find-by-id">
            <button type="button">Find persons name by their ID</button>
        </form>
    </div>
</main>
</#macro>