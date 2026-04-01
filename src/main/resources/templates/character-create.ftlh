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

        <label>Anime:</label>
        <input type="number" name="anime"><br>
        
        <label>Power:</label>
        <input type="number" name="power"><br>

        <label>Description:</label>
        <textarea name="description"></textarea><br>

        <button type="submit">Create</button>
    </form>

    <a href="/characters">Back</a>
</body>
</html>