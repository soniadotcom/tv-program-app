package com.example.mdb.dao.impl.inmemory;

import com.example.mdb.model.User;

class InMemoryUserDao extends com.example.mdb.dao.impl.inmemory.InMemoryAbstractDao<User> implements com.example.mdb.dao.UserDao {

    InMemoryUserDao(com.example.mdb.dao.impl.inmemory.InMemoryDatabase database) {
        super(database.users, User::getUserId, User::setUserId, database);
    }

    @Override
    public User getByLogin(String login) {
        return database.users.values()
                .stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst()
                .orElse(null);
    }

}
