package com.example.mdb.dao.impl.inmemory;

import com.example.mdb.model.Program;
import com.example.mdb.model.User;

import java.util.Arrays;
import java.util.List;

public class InMemoryTestData {

    public static void generateTo(com.example.mdb.dao.impl.inmemory.InMemoryDatabase database) {
        database.users.clear();
        database.programs.clear();

        User alice = new User(1,"alice@example.com", "passwordhash");
        User bob = new User(2, "bob@example.com", "passwordhash");
        User charlie = new User(3, "charlie@example.com", "passwordhash");
        User diana = new User(4, "diana@example.com", "passwordhash");
        User evil = new User(5, "evil@example.com", "passwordhash");
        List<User> users = Arrays.asList(alice, bob, charlie, diana, evil);
        users.forEach(user -> database.users.put(user.getUserId(), user));

        Program dom2 = new Program(1, "DOM2","1+1","12.07.20","22:00",".......");
        Program dom3 = new Program(2, "DOM3","Discovery","12.07.20","22:00",".......");
        List<Program> programs = Arrays.asList(dom2);
        programs.forEach(program -> database.programs.put(program.getProgramId(), program));
    }
}
