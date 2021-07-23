package com.example.mdb.services;

import com.example.mdb.model.User;

public interface UserService {

    User getByLogin(String login);

    boolean checkPassword(User user, String password);
}
