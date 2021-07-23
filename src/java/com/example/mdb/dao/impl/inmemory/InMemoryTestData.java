package com.example.mdb.dao.impl.inmemory;

import com.example.mdb.model.Comment;
import com.example.mdb.model.Program;
import com.example.mdb.model.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;


public class InMemoryTestData {

    public static void generateTo(com.example.mdb.dao.impl.inmemory.InMemoryDatabase database) {
        database.users.clear();
        database.programs.clear();

        LocalDate localDate = LocalDate.now();
        String currentDate = DateTimeFormatter.ofPattern("dd.MM.yy").format(localDate);

        User admin = new User(1, true,"admin", "admin");
        User user1 = new User(2, false,"user1", "userpass");
        User user2 = new User(3, false, "user2", "userpass");

        List<User> users = Arrays.asList(admin, user1, user2);
        users.forEach(user -> database.users.put(user.getUserId(), user));

        Program prog1 = new Program(1, "The Oprah Winfrey Show","Oprah",currentDate,"04:45","talk show");
        Program prog2 = new Program(2, "The Ellen DeGeneres Show","NBC",currentDate,"22:05","comedy");
        Program prog3 = new Program(3, "The Voice","NBC",currentDate,"13:00","singing competition ");
        Program prog4 = new Program(4, "Seinfeld","NBC",currentDate,"22:00","sitcom series");
        Program prog5 = new Program(5, "60 Minutes","CBS",currentDate,"15:20","news magazine");
        Program prog6 = new Program(6, "Night Football","ABC",currentDate,"23:12","sport");
        Program prog7 = new Program(6, "The Red Skelton Show","NBC",currentDate,"22:55","comedy");



        List<Program> programs = Arrays.asList(prog1, prog2, prog3, prog4, prog5, prog6, prog7);
        programs.forEach(program -> database.programs.put(program.getProgramId(), program));

    }
}
