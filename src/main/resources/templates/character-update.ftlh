<!DOCTYPE html>
<html>
<head>
    <title>Character Details</title>
    <link rel="stylesheet" href="/styles.css">
</head>
<body>

<div class="container">

    <h1>${character.name}</h1>

    <div class="card">
        <p><strong>Anime:</strong> ${character.anime}</p>
    </div>

      <div class="card">
        <p><strong>Power:</strong> ${character.power}</p>
    </div>

    <div class="card">
        <p>${character.description}</p>
    </div>

 <a href="/characters/${character.id}/edit">Edit</a>

<form action="/save" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value="${character.id}"/>

    <input type="text" name="name" value="${character.name}"/>
    <input type="text" name="anime" value="${character.anime}"/>
    <input type="text" name="power" value="${character.power}"/>
    <input type="text" name="description" value="${character.description}"/>
    
    <input type="file" name="imageFile"/>

   

    <button type="submit">Save</button>
</form>
    <br>
    <a href="/characters">Back</a>

    <label>Change Image:</label>
    <input type="file" name="image">

</div>

</body>
</html>