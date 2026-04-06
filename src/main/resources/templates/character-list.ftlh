<!DOCTYPE html>
<html>
<head>
    <title>Character List</title>

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

        h1 {
            text-align: center;
            padding-top: 20px;
            color: #e9d5ff;
        }

        .create-btn {
            display: inline-block;
            margin: 20px auto;
            padding: 10px 16px;
            background: linear-gradient(90deg, #a855f7, #ec4899);
            color: white;
            border-radius: 10px;
            text-decoration: none;
            text-align: center;
            transition: 0.3s;
        }

        .create-btn:hover {
            transform: scale(1.05);
            box-shadow: 0 0 15px #a855f7;
        }

        .container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
            padding: 20px;
        }

        .card {
            width: 220px;
            padding: 15px;
            text-align: center;

            background: rgba(15, 23, 42, 0.85);
            backdrop-filter: blur(12px);
            border-radius: 16px;
            border: 1px solid rgba(255,255,255,0.1);

            box-shadow: 0 0 20px rgba(168, 85, 247, 0.25);
            transition: 0.3s;
        }

        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 0 25px rgba(236, 72, 153, 0.4);
        }

        .card img {
            border-radius: 12px;
            width: 90px;
            height: 90px;
            object-fit: cover;
            margin-bottom: 10px;
            border: 2px solid rgba(168, 85, 247, 0.5);
        }

        a {
            color: #e9d5ff;
            text-decoration: none;
            font-weight: bold;
            display: block;
            margin: 8px 0;
        }

        a:hover {
            color: white;
        }

        button {
            margin-top: 10px;
            padding: 8px 12px;
            border: none;
            border-radius: 8px;
            background: #8a1df8;
            color: white;
            cursor: pointer;
            transition: 0.3s;
        }

        button:hover {
            background: #b667ff;
            transform: scale(1.05);
        }
    </style>
</head>

<body>

<h1>✨ Anime Characters</h1>

<div style="text-align:center;">
    <a class="create-btn" href="/characters/create">+ Create New Character</a>
</div>

<div class="container">

    <#list characterList as character>

        <div class="card">

            <#if character.imageUrl??>
                <img src="${character.imageUrl}">
            </#if>

            <a href="/characters/${character.id}">
                ${character.name!"Unknown"}
            </a>

            <form action="/characters/${character.id}/delete" method="post">
                <button type="submit">Delete</button>
            </form>

        </div>

    </#list>

</div>

</body>
</html>