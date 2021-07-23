package com.example.mdb.web;

import com.example.mdb.model.*;
import com.example.mdb.services.*;
import java.io.IOException;
import java.util.Collection;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "FrontControllerServlet", urlPatterns = {"/do/*"})
public class FrontControllerServlet extends HttpServlet {

    ProgramService programService;
    UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        programService = (ProgramService) config.getServletContext().getAttribute("programService");
        userService = (UserService) config.getServletContext().getAttribute("userService");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            pathInfo = "/";
        }
        try {
            switch (pathInfo) {
                case "/login":
                    login(request, response);
                    break;
                case "/logout":
                    logout(request, response);
                    break;
                case "/program":
                    program(request, response);
                    break;
                case "/":
                case "/search":
                    programs(request, response);
                    break;
                case "/edit":
                    edit(request, response);
                    break;
                case "/comment":
                    comment(request, response);
                    break;
                case "/delete":
                    delete(request, response);
                    break;
                case "/newProgram":
                    newProgram(request, response);
                    break;
                case "/deleteProgram":
                    deleteProgram(request, response);
                    break;
                default:
                    programs(request, response);
                    break;
            }
        } catch (RuntimeException ex) {
            error(request, response, "Oopsss, " + ex.getMessage());
        }

    }

    protected void programs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchText = request.getParameter("text");

        String sort = request.getParameter("sort");
        ProgramSortCriteria sortCriteria;
        if (sort == null || sort.equals("")) {
            sortCriteria = ProgramSortCriteria.OLD_FIRST;
        } else {
            sortCriteria = ProgramSortCriteria.valueOf(sort);
        }

        Collection<Program> programs = programService.search(searchText, sortCriteria);
        request.setAttribute("programs", programs);
        request.setAttribute("text", searchText);
        request.getRequestDispatcher("/WEB-INF/jsp/programs.jsp").forward(request, response);
    }

    protected void program(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int programId = Integer.parseInt(request.getParameter("programId"));
        Program program = programService.getProgramById(programId);
        request.setAttribute("program", program);
        request.getRequestDispatcher("/WEB-INF/jsp/program.jsp").forward(request, response);
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            error(request, response, "Log in first!");
            return;
        }
        if(user.isAdmin()) {
            int programId = Integer.parseInt(request.getParameter("programId"));
            //Program program = programService.getProgramById(programId);

            String title = request.getParameter("title");
            String channel = request.getParameter("channel");
            String date = request.getParameter("date");
            String time = request.getParameter("time");
            String description = request.getParameter("description");

            programService.editProgram(programId, title, channel, date, time, description);
            response.sendRedirect("./program?programId=" + programId);
        }else{
            error(request, response, "Sorry, but you need to log in as admin first!");
            return;
        }
    }

    protected void comment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            error(request, response, "Log in first!");
            return;
        }
        if(user.isAdmin()) {
            int programId = Integer.parseInt(request.getParameter("programId"));
            Program program = programService.getProgramById(programId);

            String text = request.getParameter("text");

            programService.addComment(program, user, text);
            response.sendRedirect("./program?programId=" + programId);
        }else{
            error(request, response, "Sorry, but you need to log in as admin first!");
            return;
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            error(request, response, "Log in first!");
            return;
        }
        if(user.isAdmin()) {
            int programId = Integer.parseInt(request.getParameter("programId"));
            Program program = programService.getProgramById(programId);

            programService.deleteComment(program);
            response.sendRedirect("./program?programId=" + programId);
        }else{
            error(request, response, "Sorry, but you need to log in as admin first!");
            return;
        }
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();

        String login = request.getParameter("login");
        User user = userService.getByLogin(login);
        if (user == null) {
            error(request, response, "User with login '" + login + "' does not exist!");
            return;
        }
        String password = request.getParameter("password");

        if (!userService.checkPassword(user, password)) {
            error(request, response, "Sorry, your password is wrong!");
            return;
        }

        request.getSession().setAttribute("user", user);
        response.sendRedirect(".");
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("programs", programService.getAllPrograms());
        request.getSession().invalidate();
        response.sendRedirect(".");
    }

    protected void newProgram(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            error(request, response, "Log in first!");
            return;
        }
        if(user.isAdmin()) {
            if (request.getMethod().equals("POST")) {
                programService.addProgram();
                response.sendRedirect(".");
            }
        }else{
            error(request, response, "Sorry, but you need to log in as admin first!");
            return;
        }
    }

    protected void deleteProgram(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            error(request, response, "Log in first!");
            return;
        }
        if(user.isAdmin()) {
            int programId = Integer.parseInt(request.getParameter("programId"));

            if (request.getMethod().equals("POST")) {
                programService.deleteProgram(programId);
                response.sendRedirect(".");
            }
        }else{
            error(request, response, "Sorry, but you need to log in as admin first!");
            return;
        }
    }

        protected void error(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        request.setAttribute("message", message);
        request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
