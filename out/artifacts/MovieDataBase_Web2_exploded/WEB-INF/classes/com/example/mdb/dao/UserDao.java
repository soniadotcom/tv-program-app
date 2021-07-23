package com.example.mdb.dao;

import com.example.mdb.model.User;


public interface UserDao extends AbstractDao<User> {

    User getByLogin(String login);
}
