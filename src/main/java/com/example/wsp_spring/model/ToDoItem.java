package com.example.wsp_spring.model;

public class ToDoItem {

    private String subject;
    private String body;

    public ToDoItem() {
        this.subject = "";
        this.body = "";
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
