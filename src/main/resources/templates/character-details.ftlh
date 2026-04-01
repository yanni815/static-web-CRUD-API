<!DOCTYPE html>
<html>
<head>
    <title>Character Details</title>
    <link rel="stylesheet" href="/styles.css">
</head>
<body>

<div class="container">

    <h1>${character.name}</h1>
    <img src="${character.imageUrl}" width="200" style="border-radius: 12px;">

    <!-- Info Card -->
    <div class="card">
        <p><strong>Anime:</strong> ${character.anime}</p>
    </div>

    <!-- Info Card -->
    <div class="card">
        <p><strong>Power:</strong> ${character.power}</p>
    </div>

    <!-- Description Card -->
    <div class="card">
        <p><strong>Description:</strong> ${character.description}</p>
    </div>

    <!-- Action Buttons -->
    <div style="margin-top: 20px; text-align: center;">
        <a href="/characters/${character.id}/edit">✏️ Edit</a>
        <br><br>

        <form action="/characters/${character.id}/delete" method="post"
              onsubmit="return confirm('Are you sure you want to delete this character?');">

            <button type="submit" style="background-color: red;">
                🗑 Delete
            </button>

        </form>

        <br>

        <a href="/characters">⬅ Back to List</a>
    </div>

</div>



</body>
</html>