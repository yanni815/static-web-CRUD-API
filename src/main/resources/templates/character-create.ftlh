<!DOCTYPE html>
<html>
<head>
    <title>Create Character</title>
</head>
<body>
    <h1>Create New Character</h1>

    <form action="/characters" method="post">
        <label>Name:</label>
        <input type="text" name="name" required><br>

        <label>Age:</label>
        <input type="number" name="age"><br>

        <label>Description:</label>
        <textarea name="description"></textarea><br>

        <button type="submit">Create</button>
    </form>

    <a href="/characters">Back</a>
</body>
</html>