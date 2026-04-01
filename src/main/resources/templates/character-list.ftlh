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
        </#list>
    </ul>
</body>
</html>