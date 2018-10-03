package ru.innopolis.stc12.servlets.controllers;

import org.apache.log4j.Logger;
import ru.innopolis.stc12.servlets.pojo.Group;
import ru.innopolis.stc12.servlets.pojo.Student;
import ru.innopolis.stc12.servlets.repository.dao.GroupDao;
import ru.innopolis.stc12.servlets.repository.dao.GroupDaoImpl;
import ru.innopolis.stc12.servlets.repository.dao.StudentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddStudentServlet extends HttpServlet {

    Logger LOGGER = Logger.getLogger(AddStudentServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LOGGER.info("nameCourse " + req.getParameter("nameCourse"));
        LOGGER.info("firstname " + req.getParameter("firstname"));
        LOGGER.info("lastname " + req.getParameter("lastname"));
        LOGGER.info("contact " + req.getParameter("contact"));
        LOGGER.info("city " + req.getParameter("city"));
        LOGGER.info("age " +  Long.parseLong(req.getParameter("age")));

        GroupDao groupDao = new GroupDaoImpl();
        Long age = Long.parseLong(req.getParameter("age"));
        Group group = groupDao.getGroupByNameCourse(req.getParameter("nameCourse"));
        if (group != null) {
            LOGGER.info("Group numberSteam " + group.getNumberStream());
        }
        Student student = new Student(1, req.getParameter("firstname"),
                req.getParameter("lastname"),
                age.intValue(),
                req.getParameter("contact"),
                req.getParameter("city"),
                        group);
        if(new StudentDaoImpl().addStudent(student)){
            req.setAttribute("confirm", "true");
        } else {
            req.setAttribute("confirm", "false");
        }
        req.getRequestDispatcher("/studentaddapply.jsp").forward(req, resp);


    }
}
