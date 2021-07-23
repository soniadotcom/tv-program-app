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
                case "/like":
                    program(request, response);
                    break;
                case "/unlike":
                    program(request, response);
                    break;
                case "/comment":
                    program(request, response);
                    break;
                case "/":
                case "/search":
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

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();

        String login = request.getParameter("login");
        User user = userService.getByLogin(login);
        if (user == null) {
            error(request, response, "Sorry, user with login '" + login + "' not exists");
            return;
        }
        String password = request.getParameter("password");

        if (!userService.checkPassword(user, password)) {
            error(request, response, "Sorry, wrong password");
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


    protected void error(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        request.setAttribute("message", message);
        request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
