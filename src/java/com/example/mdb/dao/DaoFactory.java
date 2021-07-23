package com.example.mdb.dao;

public interface DaoFactory {

    CommentDao getCommentDao();

    ProgramDao getProgramDao();

    com.example.mdb.dao.UserDao getUserDao();
}
