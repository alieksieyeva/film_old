package com.generation.model.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.generation.model.entities.Film_screening;

public class Film_screeningRepository implements Repository <Film_screening>
{
    private Connection con;

    public Film_screeningRepository() 
    {
        try
        {
            String versione = "com.mysql.cj.jdbc.Driver";
            Class.forName(versione);   
            String dbInformations = "jdbc:mysql://localhost:3306/movie_theater?user=jaita&password=jaita107";
            con =  DriverManager.getConnection(dbInformations);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    @Override
    public List<Film_screening> findAll() 
    {
        try 
        {
            List<Film_screening> res = new ArrayList<Film_screening>();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM film_screening");

            while(rs.next())
                res.add(_rsToFilm_screening(rs));
            return res;

        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            return null;
        }
        
    }

    private Film_screening _rsToFilm_screening(ResultSet rs) throws Exception
    {
        Film_screening res = new Film_screening();

        res.setId(rs.getInt("id"));
        res.setScreening_time(LocalDateTime.parse(rs.getString("screening_time").replace(" ","T")));
        res.setTitle(rs.getString("title"));
        res.setCinema_room(rs.getString("cinema_room"));
        res.setPrice(rs.getDouble("price"));

        return res;
    }

    @Override
    public void save(Film_screening x) 
    {
        try
        {
            Statement s = con.createStatement();
            //query creata con i placeholder, si distinguono qua per le parentesi quadre []
            String query="INSERT INTO film_screening (screening_time,title,cinema_room,price) VALUES('[screening_time]','[title]','[cinema_room]',[price])";
            query =   query.replace("[screening_time]", x.getScreening_time().toString())
                           .replace("[title]", x.getTitle())
                           .replace("[cinema_room]",x.getCinema_room())
                           .replace("[price]",x.getPrice()+"");
            s.execute(query);
            s.close();

        }
        catch(Exception e )
        {
            e.printStackTrace();
        }
    }

}
