package com.example.mdb.dao.impl.inmemory;
import com.example.mdb.dao.*;
import com.example.mdb.dao.impl.inmemory.InMemoryDatabase;

class InMemoryDaoFactory implements DaoFactory {

    InMemoryDatabase database;

    ProgramDao programDao;
    com.example.mdb.dao.UserDao userDao;

    InMemoryDaoFactory(InMemoryDatabase database) {
        this.database = database;

        programDao = new InMemoryProgramDao(database);
        userDao = new InMemoryUserDao(database);
    }

    @Override
    public com.example.mdb.dao.ProgramDao getProgramDao() {
        return programDao;
    }

    @Override
    public com.example.mdb.dao.UserDao getUserDao() {
        return userDao;
    }

}
