package com.example.mdb.model;

import java.util.Objects;

public class User {

    private Integer userId;
    private boolean admin;
    private String login;
    private String passwordHash;

    public User(Integer userId, boolean admin, String login, String passwordHash) {
        this.userId = userId;
        this.admin = admin;
        this.login = login;
        this.passwordHash = passwordHash;
    }

    public boolean isAdmin(){ return admin; }

    public Integer getUserId() {
        return userId;
    }

    public String getLogin() {
        return login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    // Used for HashSet in Movie.likers
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.userId);
        return hash;
    }

    // Used for HashSet in Movie.likers
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        return true;
    }

}
