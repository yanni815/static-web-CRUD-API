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

        <label>Age:</label>
        <input type="number" name="age" value="${character.age}"><br>

        <label>Description:</label>
        <textarea name="description">${character.description}</textarea><br>

        <button type="submit">Update</button>
    </form>

    <a href="/characters/${character.id}">Cancel</a>
</body>
</html>