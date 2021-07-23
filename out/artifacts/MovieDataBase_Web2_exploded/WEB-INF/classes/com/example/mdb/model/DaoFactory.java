package com.example.mdb.dao;

public interface DaoFactory {

    ProgramDao getProgramDao();

    com.example.mdb.dao.UserDao getUserDao();
}
