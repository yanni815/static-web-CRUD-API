<!DOCTYPE html>
<html>
<head>
    <title>Character Details</title>

    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            color: white;

            background: linear-gradient(-45deg, #0f172a, #1e1b4b, #312e81, #0f172a);
            background-size: 400% 400%;
            animation: gradientBG 12s ease infinite;
            min-height: 100vh;
        }

        @keyframes gradientBG {
            0% { background-position: 0% 50%; }
            50% { background-position: 100% 50%; }
            100% { background-position: 0% 50%; }
        }

        .container {
            max-width: 600px;
            margin: auto;
            padding: 40px;
            text-align: center;
        }

        h1 {
            color: #e9d5ff;
            margin-bottom: 20px;
        }

        .card {
            background: rgba(15, 23, 42, 0.85);
            backdrop-filter: blur(14px);
            border-radius: 18px;
            border: 1px solid rgba(255,255,255,0.1);

            padding: 15px;
            margin: 12px 0;

            box-shadow: 0 0 18px rgba(168, 85, 247, 0.25);
        }

        .hero-img {
            width: 200px;
            height: 200px;
            object-fit: cover;
            border-radius: 18px;
            border: 2px solid rgba(168, 85, 247, 0.6);
            box-shadow: 0 0 20px rgba(236, 72, 153, 0.3);
        }

        .btn {
            display: inline-block;
            padding: 10px 14px;
            margin: 8px;
            border-radius: 10px;
            text-decoration: none;
            font-weight: bold;
            transition: 0.3s;
        }

        .edit-btn {
            background: linear-gradient(90deg, #a855f7, #ec4899);
            color: white;
        }

        .edit-btn:hover {
            transform: scale(1.05);
            box-shadow: 0 0 15px #a855f7;
        }

        .delete-btn {
            background: #ef4444;
            color: white;
            border: none;
            cursor: pointer;
        }

        .delete-btn:hover {
            background: #dc2626;
            transform: scale(1.05);
        }

        .back {
            display: inline-block;
            margin-top: 20px;
            color: #cbd5e1;
            text-decoration: none;
        }

        .back:hover {
            color: white;
        }
    </style>
</head>

<body>

<div class="container">

    <h1>✨ ${character.name}</h1>

    <#if character.imageUrl??>
        <img class="hero-img" src="${character.imageUrl}">
    <#else>
        <img class="hero-img" src="/default.png">
    </#if>

    <div class="card">
        <p><strong>Anime:</strong> ${character.anime!"Unknown"}</p>
    </div>

    <div class="card">
        <p><strong>Power:</strong> ${character.power!"Unknown"}</p>
    </div>

    <div class="card">
        <p><strong>Description:</strong> ${character.description!"No description"}</p>
    </div>

    <!-- Actions -->
    <div style="margin-top: 20px;">

        <a href="/characters/${character.id}/edit" class="btn edit-btn">
            ✏️ Edit Character
        </a>

        <form action="/characters/${character.id}/delete" method="post"
              style="display:inline;"
              onsubmit="return confirm('Are you sure you want to delete this character?');">

            <button type="submit" class="btn delete-btn">
                🗑 Delete
            </button>

        </form>

        <br>

        <a class="back" href="/characters">⬅ Back to List</a>
    </div>

</div>

</body>
</html>