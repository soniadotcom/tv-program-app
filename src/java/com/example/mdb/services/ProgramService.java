package com.example.mdb.services;

import com.example.mdb.model.*;
import java.util.Collection;

public interface ProgramService {

    Collection<Program> getAllPrograms();

    Collection<Program> getAllPrograms(ProgramSortCriteria programSortCriteria);

    Collection<Program> search(String text);

    Collection<Program> search(String text, ProgramSortCriteria programSortCriteria);

    Program getProgramById(Integer programId);

    Program editProgram(Integer programId, String title, String channel, String date, String time, String description);

    void addComment(Program program, User user, String comment);

    void deleteComment(Program program);

    void addProgram();

    void deleteProgram(int ProgramId);

}

