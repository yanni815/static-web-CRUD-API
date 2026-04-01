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
</body>
</html>