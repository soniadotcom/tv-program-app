package com.example.mdb.dao.impl.inmemory;

import com.example.mdb.dao.DaoFactory;
import com.example.mdb.model.*;

import java.util.Map;
import java.util.TreeMap;

public class InMemoryDatabase {

    Map<Integer, Program> programs;
    Map<Integer, User> users;

    public InMemoryDatabase() {
        programs = new TreeMap<>();
        users = new TreeMap<>();
    }

    public DaoFactory getDaoFactory() {
        return new com.example.mdb.dao.impl.inmemory.InMemoryDaoFactory(this);
    }

}
