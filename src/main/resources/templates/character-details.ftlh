<!DOCTYPE html>
<html>
<head>
    <title>Character Details</title>
</head>
<body>
    <h1>${character.name}</h1>

    <p><strong>Anime:</strong> ${character.anime}</p>
    <p><strong>Power:</strong> ${character.power}</p>
    <p><strong>Description:</strong> ${character.description}</p>

    <a href="/characters/${character.id}/edit">Edit</a>
    <a href="/characters">Back to List</a>
    <a href="/characters/${character.id}/edit">Edit Character</a>

    <form action="/characters/${character.id}/delete" method="post"
        onsubmit="return confirm('Are you sure you want to delete this character?');">
    <button type="submit">Delete</button>
    </form>
</body>
</html>