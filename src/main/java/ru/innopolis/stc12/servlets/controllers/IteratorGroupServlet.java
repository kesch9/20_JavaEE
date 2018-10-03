package ru.innopolis.stc12.servlets.controllers;

import ru.innopolis.stc12.servlets.service.GroupServiceImplement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IteratorGroupServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("list", new GroupServiceImplement().getAllGroup());
        req.getRequestDispatcher("/addstudentform.jsp").forward(req, resp);
    }

}
