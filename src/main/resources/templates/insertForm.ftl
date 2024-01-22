<html>

    <head>
        
    </head>
    <body>
        <a href="homepage">Homepage</a>
        <h2> Inserimento nuova proiezione</h2>
        <form action="form" method="post" >
            <input  name="title" type="text" placeholder="inserisci titolo film" />
            <input  name="screening_time" type="datetime-local" placeholder="inserisci l'orario proiezione" />
            <input  name="cinema_room" type="text" placeholder="inserisci la sala" />
            <input  name="price" type="number" placeholder="inserisci prezzo" step="0.01" />
            <input type="submit" value="Salva" />
        </form>
    </body>
</html>