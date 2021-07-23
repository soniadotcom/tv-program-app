package com.example.mdb.dao.impl.inmemory;

import com.example.mdb.dao.CommentDao;
import com.example.mdb.model.Comment;
import com.example.mdb.model.Program;
import com.example.mdb.model.User;

import java.util.Collection;

class InMemoryCommentDao extends InMemoryAbstractDao<Comment> implements CommentDao {

    InMemoryCommentDao(InMemoryDatabase database) {
        super(database.comments, Comment::getCommentId, Comment::setCommentId, database);
    }

    @Override
    public Collection<Comment> findByProgramId(Integer moveId) {
        return database.programs.get(moveId).getComments();
    }

    @Override
    public void addComment(Program program, User user, String text) {
        Comment comment = new Comment(-1, program, user, text);

        this.insert(comment, true);
        program.getComments().add(comment);
    }

    @Override
    public void deleteComment(Program program) {

        //this.delete(comment);
        program.getComments().clear();
    }
}
