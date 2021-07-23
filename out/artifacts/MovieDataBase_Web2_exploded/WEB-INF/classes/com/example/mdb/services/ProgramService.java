package com.example.mdb.services;

import com.example.mdb.model.*;
import java.util.Collection;

public interface ProgramService {

    Collection<Program> getAllPrograms();

    Collection<Program> getAllPrograms(ProgramSortCriteria programSortCriteria);

    Collection<Program> search(String text);

    Collection<Program> search(String text, ProgramSortCriteria programSortCriteria);

    Program getProgramById(Integer programId);

    // возможно дописать удаление, редактирование и добавление программ

}

