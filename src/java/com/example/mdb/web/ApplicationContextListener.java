package com.example.mdb.web;

import com.example.mdb.dao.DaoFactory;
import com.example.mdb.dao.impl.inmemory.*;
import com.example.mdb.services.*;
import java.util.function.UnaryOperator;
import javax.servlet.*;

public class ApplicationContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        // Change to real database in real project
        InMemoryDatabase database = new InMemoryDatabase();
        
        // Don't use in real project
        InMemoryTestData.generateTo(database);

        DaoFactory daoFactory = database.getDaoFactory();

        ProgramService programService = new ProgramServiceImpl(daoFactory);
        sce.getServletContext().setAttribute("programService", programService);

        UserService userService = new UserServiceImpl(daoFactory, UnaryOperator.identity());
        sce.getServletContext().setAttribute("userService", userService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
