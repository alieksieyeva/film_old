package com.generation.controllers;


import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.model.entities.Film_screening;
import com.generation.model.repositories.Film_screeningRepository;
import com.generation.model.repositories.Repository;

@WebServlet("/form")
public class Film_screeningInsertController extends HttpServlet
{

    //SERVLET riceve le request hhtp, chiamare il model per i dati e li manda alla view
    //CONTROLLER perché si interfaccia con l'esterno e gestisce il flusso di dati

    Repository <Film_screening> repo = new Film_screeningRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
       

        req.getRequestDispatcher("/insertForm.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        String title= req.getParameter("title");
        String cinema_room = req.getParameter("cinema_room");
        double price = Double.parseDouble(req.getParameter("price"));
        LocalDateTime screening_time= LocalDateTime.parse(req.getParameter("screening_time"));

        Film_screening fs = new Film_screening(screening_time, title, cinema_room, price);
        repo.save(fs);

        req.getRequestDispatcher("/insertForm.ftl").forward(req, resp);
    }

   
}

