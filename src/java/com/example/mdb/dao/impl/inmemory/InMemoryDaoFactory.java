package com.example.mdb.dao.impl.inmemory;
import com.example.mdb.dao.*;
import com.example.mdb.dao.impl.inmemory.InMemoryDatabase;

class InMemoryDaoFactory implements DaoFactory {

    InMemoryDatabase database;

    ProgramDao programDao;
    CommentDao commentDao;
    com.example.mdb.dao.UserDao userDao;

    InMemoryDaoFactory(InMemoryDatabase database) {
        this.database = database;

        programDao = new InMemoryProgramDao(database);
        commentDao = new InMemoryCommentDao(database);
        userDao = new InMemoryUserDao(database);
    }

    @Override
    public CommentDao getCommentDao() {
        return commentDao;
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
