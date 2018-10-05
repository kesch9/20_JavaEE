package ru.innopolis.stc12.servlets.controllers;

import org.apache.log4j.Logger;
import ru.innopolis.stc12.servlets.pojo.Student;
import ru.innopolis.stc12.servlets.service.StudentService;
import ru.innopolis.stc12.servlets.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DeleteStudentServlet extends HttpServlet {
    private StudentService studentService;
    private static final Logger LOGGER = Logger.getLogger(StudentServlet.class);

    @Override
    public void init() throws ServletException {
        super.init();
        studentService = new StudentServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> studentList = studentService.getAllStudents();
        for (Student student:studentList){
            LOGGER.info(student.getFirstName());
            if (student.getGroup() == null){
                LOGGER.info("Group is null for student " + student.getLastName());
            } else {
                LOGGER.info("Group is " + student.getGroup().getNameCourse());
            }


        }
        req.setAttribute("studentList",studentList);
        req.getRequestDispatcher("/deletestudent.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] selectType = req.getParameterValues("del_stud");
        LOGGER.info(req.getQueryString());
        LOGGER.info(req.getParameterNames());
        if (selectType != null){
            for (String s : selectType){
                studentService.deleteStudent(s);
            }
        }
        List<Student> studentList = studentService.getAllStudents();
        req.setAttribute("studentList",studentList);
        req.getRequestDispatcher("/deletestudent.jsp").forward(req, resp);
    }
}
