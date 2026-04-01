<!DOCTYPE html>
<html>
<head>
    <title>Create Character</title>
</head>
<body>
    <h1>Create New Character</h1>

    <form action="/characters" method="post" enctype="multipart/form-data">
        <label>Name:</label>
        <input type="text" name="name" required><br>

        <label>Anime:</label>
        <input type="text" name="anime"><br>
        
        <label>Power:</label>
        <input type="text" name="power"><br>

        <label>Description:</label>
        <textarea name="description"></textarea><br>

        <label>Image:</label>
        <input type="file" name="image"><br>

        <button type="submit">Create</button>
    </form>

    <a href="/characters">Back</a>
</body>
</html>