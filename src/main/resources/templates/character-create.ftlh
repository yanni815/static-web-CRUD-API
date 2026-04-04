<!DOCTYPE html>
<html>
<head>
    <title>Create Character</title>

    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            color: white;

            background: linear-gradient(-45deg, #0f172a, #1e1b4b, #312e81, #0f172a);
            background-size: 400% 400%;
            animation: gradientBG 12s ease infinite;

            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        @keyframes gradientBG {
            0% { background-position: 0% 50%; }
            50% { background-position: 100% 50%; }
            100% { background-position: 0% 50%; }
        }

        .glow {
            position: absolute;
            width: 300px;
            height: 300px;
            background: rgba(168, 85, 247, 0.25);
            filter: blur(100px);
            border-radius: 50%;
            top: 10%;
            left: 20%;
        }

        .card {
            position: relative;
            background: rgba(15, 23, 42, 0.85);
            backdrop-filter: blur(12px);
            padding: 30px;
            border-radius: 20px;
            width: 420px;
            box-shadow: 0 0 25px rgba(168, 85, 247, 0.4);
            border: 1px solid rgba(255,255,255,0.1);
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
            color: #e9d5ff;
        }

        label {
            font-size: 13px;
            color: #cbd5e1;
        }

        input, textarea {
            width: 100%;
            padding: 10px;
            margin-top: 6px;
            margin-bottom: 14px;
            border-radius: 10px;
            border: none;
            outline: none;
            background: rgba(255,255,255,0.08);
            color: white;
        }

        textarea {
            height: 90px;
            resize: none;
        }

        button {
            width: 100%;
            padding: 12px;
            border: none;
            border-radius: 10px;
            background: linear-gradient(90deg, #a855f7, #ec4899);
            color: white;
            font-weight: bold;
            cursor: pointer;
            transition: 0.3s;
        }

        button:hover {
            transform: scale(1.03);
            box-shadow: 0 0 15px #a855f7;
        }

        .back {
            display: block;
            text-align: center;
            margin-top: 15px;
            color: #cbd5e1;
            text-decoration: none;
        }

        .back:hover {
            color: white;
        }
    </style>
</head>

<body>

<div class="glow"></div>

<div class="card">
    <h1>✨ Create New Character</h1>

    <form action="/characters/save" method="post" enctype="multipart/form-data">

        <label>Name</label>
        <input type="text" name="name" required>

        <label>Anime</label>
        <input type="text" name="anime">

        <label>Power</label>
        <input type="text" name="power">

        <label>Description</label>
        <textarea name="description"></textarea>

        <!-- FIXED: must match backend MultipartFile imageFile -->
        <label>Image</label>
        <input type="file" name="imageFile">

        <button type="submit">🌸 Create</button>
    </form>

    <a class="back" href="/characters">← Back</a>
</div>

</body>
</html>