<h1>Anime Characters</h1>

<ul>
<#list animeList as characters>
    <li>
    <a href="/characters/${character.id}">
    ${character.name} 
    </a>
    </li>
</#list>
</ul>