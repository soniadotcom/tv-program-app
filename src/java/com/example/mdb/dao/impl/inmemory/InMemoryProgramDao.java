package com.example.mdb.dao.impl.inmemory;

import com.example.mdb.dao.ProgramDao;
import com.example.mdb.model.*;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class InMemoryProgramDao extends com.example.mdb.dao.impl.inmemory.InMemoryAbstractDao<Program> implements ProgramDao {

    InMemoryProgramDao(com.example.mdb.dao.impl.inmemory.InMemoryDatabase database) {
        super(database.programs, Program::getProgramId, Program::setProgramId, database);
    }

    @Override
    public Collection<Program> findByText(String text) {
        String[] words = text.toLowerCase().split(" ");
        return database.programs.values().stream()
                .filter(program -> containsAllWords(program, words))
                .collect(Collectors.toList());
    }

    @Override
    public void addProgram() {
        Program program = new Program(-1, "New program", "Channel", "20.05.20", "12:00","description");

        this.insert(program, true);
    }

    @Override
    public void deleteProgram(int programId){
        database.programs.remove(programId);
    }


    private static boolean containsAllWords(Program program, String[] words) {
        String string = program.getTitle() + " " + program.getDescription();
        string = string.toLowerCase();
        return Stream.of(words).allMatch(string::contains);
    }

}
