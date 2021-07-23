package com.example.mdb.model;

import java.time.Instant;
import java.util.*;

public class Program {

    private Integer programId;
    private String title;
    private String channel;
    private String date;
    private String time;
    private String description;
    private List<Comment> comments;
    private Instant instant;

    public Program(Integer programId, String title, String channel, String date, String time, String description) {
        this(programId, title, channel, date, time, description, Instant.now());
    }

    public Program(Integer programId, String title, String channel, String date, String time, String description, Instant instant) {
        this.programId = programId;
        this.title = title;
        this.channel = channel;
        this.date = date;
        this.time = time;
        this.description = description;
        this.instant = instant;
        comments = new ArrayList<>();
    }

    public Integer getProgramId() {
        return programId;
    }

    public String getTitle() {
        return title;
    }

    public String getChannel() {
        return channel;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public int getNumberOfComments() {
        return comments.size();
    }
}
