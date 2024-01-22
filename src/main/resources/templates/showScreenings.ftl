<html>

    <head>
        
    </head>
    <body>
        <a href="form">Form</a>
        <#list screenings as screening >
            <p> ${screening.toString()}</p>
        </#list>
    </body>
</html>