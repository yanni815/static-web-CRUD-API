<!DOCTYPE html>
<html>
<head>
    <title>Character List</title>
    <link rel="stylesheet" href="/styles.css">
</head>

<body>

<h1>Characters</h1>

<a class="create-btn" href="/characters/create">+ Create New Character</a>

<div class="container">

    <#list characterList as character>

        <div class="card">

            <#if character.imageUrl??>
                <img src="${character.imageUrl}" width="80" height="80" style="border-radius: 10px;">
            </#if>

            <a href="/characters/${character.id}">
                ${character.name}
            </a>

            <form action="/characters/${character.id}/delete" method="post">
                <button type="submit">Delete</button>
            </form>

        </div>
    </#list>
</div>


</body>
</html>