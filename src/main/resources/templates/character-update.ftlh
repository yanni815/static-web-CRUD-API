<!DOCTYPE html>
<html>
<head>
    <title>Edit Character</title>

    <style>
        body {
            margin: 0;
            font-family: Arial;
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
            max-width: 500px;
            margin: auto;
            padding: 40px;
        }

        input, textarea {
            width: 100%;
            margin: 8px 0;
            padding: 10px;
            border-radius: 8px;
            border: none;
        }

        button {
            padding: 10px 15px;
            background: #a855f7;
            color: white;
            border: none;
            border-radius: 10px;
            cursor: pointer;
        }
    </style>
</head>

<body>

<div class="container">

    <h1>Edit Character</h1>

    <form action="/characters/save" method="post" enctype="multipart/form-data">

        <input type="hidden" name="id" value="${character.id!}">

        <input type="text" name="name" value="${character.name!}">
        <input type="text" name="anime" value="${character.anime!}">
        <input type="text" name="power" value="${character.power!}">

        <textarea name="description">${character.description!}</textarea>

        <input type="file" name="imageFile">

        <button type="submit">Save</button>

    </form>

</div>

</body>
</html>