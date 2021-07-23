package com.example.mdb.services;

import com.example.mdb.dao.DaoFactory;
import com.example.mdb.model.Program;
import com.example.mdb.model.User;
import java.util.Collection;
import java.util.stream.Collectors;

public class ProgramServiceImpl implements com.example.mdb.services.ProgramService {

    DaoFactory daoFactory;

    public ProgramServiceImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Program getProgramById(Integer programId) {
        return daoFactory.getProgramDao().get(programId);
    }


    @Override
    public Collection<Program> getAllPrograms() {
        return daoFactory.getProgramDao().findAll();
    }

    @Override
    public Collection<Program> getAllPrograms(ProgramSortCriteria programSortCriteria) {
        Collection<Program> programs = getAllPrograms();
        return sort(programs, programSortCriteria);
    }

    @Override
    public Collection<Program> search(String text, ProgramSortCriteria programSortCriteria) {
        Collection<Program> programs = search(text);
        return sort(programs, programSortCriteria);
    }

    @Override
    public Collection<Program> search(String text) {
        if (text == null || text.equals("")) {
            return getAllPrograms();
        }
        return daoFactory.getProgramDao().findByText(text);
    }

    private Collection<Program> sort(Collection<Program> programs, ProgramSortCriteria programSortCriteria) {
        return programs.stream()
                .sorted(com.example.mdb.services.ProgramSorters.sorters.get(programSortCriteria))
                .collect(Collectors.toList());
    }

}
