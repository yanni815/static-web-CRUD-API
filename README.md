# static-web-CRUD-API
#AnimeCharacterAPI
# AnimeCharacter API

## Installation
1. Clone the repository:
git clone <https://github.com/yanni815/ static-web-CRUD-API.git>

2. Navigate to the project folder:
   cd <static-web-CRUD-API>
   
3. Build and run the project:
-**Maven**:
   ```bash
   mvn clean install
   mvn spring-boot:run
API Endpoints 
1. Get All Characters
   GET/characters
Returns all anime characters in the database
   
2. Search by Name
GET/characters/search?name={name}
ex: /characters/search?name=Sh

3. Search by Category(Anime)
GET /characters/category/{anime}
ex: /characters/category/Nana

4. Add a Character
POST /characters
Adds a new character 
JSON body example:
json
{
  "name": "Shin",
  "anime": "Nana"
}

6. Update a character
   PUT /charcters/{id}
   Updates an existing character by ID
   JSON body example:
   json
   {
   "name": "Shin Okazaki",
   "anime": "Nana"
   }

6. Delete a Character
   DELETE /characters/{id}
   Deletes a character by ID

##Demo Video
[Watch the demo](https://uncg-my.sharepoint.com/:v:/g/personal/asgarrett_uncg_edu/IQAhefA8z-67SrQfGTYFt1epAboCZyFJ6-7IOZT8_-weELc?e=6sL4qM)


##Mvc Demo video
[Watch the demo](https://uncg-my.sharepoint.com/:v:/g/personal/asgarrett_uncg_edu/IQAhefA8z-67SrQfGTYFt1epAboCZyFJ6-7IOZT8_-weELc?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJPbmVEcml2ZUZvckJ1c2luZXNzIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXciLCJyZWZlcnJhbFZpZXciOiJNeUZpbGVzTGlua0NvcHkifX0&e=WnLWqx)
