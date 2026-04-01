<!DOCTYPE html>
<html>
<head>
    <title>Character List</title>
</head>
<body>
    <h1>Characters</h1>

    <a href="/characters/create">Create New Character</a>

    <ul>
        <#list characters as character>
            <li>
                <a href="/characters/${character.id}">
                    ${character.name}
                </a>
            </li>

<li>
    <a href="/characters/${character.id}">
        ${character.name}
    </a>

    <form action="/characters/${character.id}/delete" method="post" style="display:inline;">
        <button type="submit">Delete</button>
    </form>
</li>
        </#list>
    </ul>
</body>
</html>