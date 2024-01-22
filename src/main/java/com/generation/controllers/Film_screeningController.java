package com.generation.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.model.entities.Film_screening;
import com.generation.model.repositories.Film_screeningRepository;
import com.generation.model.repositories.Repository;

@WebServlet("/homepage")
public class Film_screeningController extends HttpServlet
{

    //SERVLET riceve le request hhtp, chiamare il model per i dati e li manda alla view
    //CONTROLLER perché si interfaccia con l'esterno e gestisce il flusso di dati

    Repository <Film_screening> repo = new Film_screeningRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setAttribute("screenings", repo.findAll());

        req.getRequestDispatcher("/showScreenings.ftl").forward(req, resp);
    }


   
}
