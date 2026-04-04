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
            padding-top: 25px;
            color: #e9d5ff;
            font-size: 32px;
        }

        .subtitle {
            text-align: center;
            color: #94a3b8;
            margin-top: -10px;
            margin-bottom: 20px;
            font-size: 14px;
        }

        .create-btn {
            display: inline-block;
            margin: 10px auto 30px auto;
            padding: 12px 18px;
            background: linear-gradient(90deg, #a855f7, #ec4899);
            color: white;
            border-radius: 12px;
            text-decoration: none;
            text-align: center;
            transition: 0.3s;
            font-weight: bold;
        }

        .create-btn:hover {
            transform: scale(1.08);
            box-shadow: 0 0 20px #a855f7;
        }

        .top-bar {
            text-align: center;
        }

        .container {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
            gap: 22px;
            padding: 30px;
            max-width: 1000px;
            margin: auto;
        }

        .card {
            padding: 15px;
            text-align: center;

            background: rgba(15, 23, 42, 0.85);
            backdrop-filter: blur(14px);
            border-radius: 18px;
            border: 1px solid rgba(255,255,255,0.1);

            box-shadow: 0 0 18px rgba(168, 85, 247, 0.25);
            transition: 0.3s;
        }

        .card:hover {
            transform: translateY(-8px);
            box-shadow: 0 0 30px rgba(236, 72, 153, 0.45);
        }

        .card img {
            border-radius: 14px;
            width: 95px;
            height: 95px;
            object-fit: cover;
            margin-bottom: 10px;
            border: 2px solid rgba(168, 85, 247, 0.6);
        }

        .card a {
            color: #e9d5ff;
            text-decoration: none;
            font-weight: bold;
            font-size: 16px;
            display: block;
            margin: 6px 0;
        }

        .card a:hover {
            color: white;
        }

        .delete-btn {
            margin-top: 10px;
            padding: 8px 12px;
            border: none;
            border-radius: 10px;
            background: #ef4444;
            color: white;
            cursor: pointer;
            transition: 0.3s;
        }

        .delete-btn:hover {
            background: #dc2626;
            transform: scale(1.05);
        }

        .empty {
            text-align: center;
            color: #94a3b8;
            margin-top: 40px;
        }
    </style>
</head>

<body>

<h1>✨ Anime Characters</h1>
<div class="subtitle">Your growing anime universe</div>

<div class="top-bar">
    <a class="create-btn" href="/characters/create">+ Create New Character</a>
</div>

<div class="container">

    <#if characterList?size == 0>
        <div class="empty">No characters yet... create your first one ✨</div>
    </#if>

    <#list characterList as character>

        <div class="card">

            <#if character.imageUrl??>
                <img src="${character.imageUrl}">
            <#else>
                <img src="/default.png">
            </#if>

            <a href="/characters/${character.id}">
                ${character.name!"Unknown"}
            </a>

            <form action="/characters/${character.id}/delete" method="post">
                <button class="delete-btn" type="submit">Delete</button>
            </form>

        </div>

    </#list>

</div>

</body>
</html>