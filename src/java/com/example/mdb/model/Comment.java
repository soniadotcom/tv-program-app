package com.example.mdb.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class Comment {

    private Integer commentId;
    private String text;
    private Program program;
    private User user;
    private Instant instant;

    public Comment(Integer commentId, Program program, User user, String text) {
        this(commentId, program, user, text, Instant.now());
    }

    public Comment(Integer commentId, Program program, User user, String text, Instant instant) {
        this.commentId = commentId;
        this.text = text;
        this.program = program;
        this.user = user;
        this.instant = instant;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public String getText() {
        return text;
    }

    public Program getProgram() {
        return program;
    }

    public User getUser() {
        return user;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }
    
    public Date getDate() {
       return Date.from(instant); 
    }
    
}
