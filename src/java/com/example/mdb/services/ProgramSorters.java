package com.example.mdb.services;

import com.example.mdb.model.Program;
import java.util.*;
import static java.util.Comparator.*;

    public class ProgramSorters {

        public static final Map<ProgramSortCriteria, Comparator<Program>> sorters;

        static {
            sorters = new HashMap<>();
            sorters.put(ProgramSortCriteria.OLD_FIRST, comparing(Program::getTime));
            sorters.put(ProgramSortCriteria.NEW_FIRST, comparing(Program::getTime, reverseOrder()));
            sorters.put(ProgramSortCriteria.BY_CHANNEL, comparing(Program::getChannel));
        }
    }
