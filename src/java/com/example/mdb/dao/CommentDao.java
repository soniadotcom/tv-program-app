package com.example.mdb.dao;

import com.example.mdb.model.Comment;
import com.example.mdb.model.Program;
import com.example.mdb.model.User;

import java.util.Collection;

public interface CommentDao extends AbstractDao<Comment> {

    Collection<Comment> findByProgramId(Integer moveId);

    void addComment(Program program, User user, String text);

    void deleteComment(Program program);
}
