<h1>Anime Gallery</h1>
<ul>
<#list animeList as anime>
    <li>$
    <a href="/anime/${anime.id}">
    ${anime.title} 
    </a>
    </li>
</#list>
</ul>