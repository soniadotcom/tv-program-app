package com.example.mdb.services;

import com.example.mdb.dao.DaoFactory;
import com.example.mdb.model.User;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UserServiceImpl implements UserService {

    DaoFactory daoFactory;
    UnaryOperator<String> passwordHasher;

    public UserServiceImpl(DaoFactory daoFactory, UnaryOperator<String> passwordHasher) {
        this.daoFactory = daoFactory;
        this.passwordHasher = passwordHasher;
    }

    @Override
    public User getByLogin(String login) {
        return daoFactory.getUserDao().getByLogin(login);
    }

    @Override
    public boolean checkPassword(User user, String password) {
        return user.getPasswordHash().equals(passwordHasher.apply(password));
    }

}

