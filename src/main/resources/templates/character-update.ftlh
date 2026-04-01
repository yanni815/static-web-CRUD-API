<!DOCTYPE html>
<html>
<head>
    <title>Update Character</title>
</head>
<body>
    <h1>Update Character</h1>

    <form action="/characters/${character.id}" method="post">
        <input type="hidden" name="_method" value="put">

        <label>Name:</label>
        <input type="text" name="name" value="${character.name}" required><br>

        <label>Anime:</label>
        <input type="number" name="anime" value="${character.anime}"><br>

        <label>Power:</label>
        <input type="number" name="power" value="${character.power}"><br>


        <label>Description:</label>
        <textarea name="description">${character.description}</textarea><br>

        <button type="submit">Update</button>
    </form>

    <a href="/characters/${character.id}">Cancel</a>
</body>
</html>