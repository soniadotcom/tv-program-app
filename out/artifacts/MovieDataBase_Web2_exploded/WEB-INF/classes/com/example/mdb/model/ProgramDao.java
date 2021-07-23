package com.example.mdb.dao;

import com.example.mdb.model.*;
import java.util.Collection;

public interface ProgramDao extends com.example.mdb.dao.AbstractDao<Program> {

    Collection<Program> findByText(String text);

}
