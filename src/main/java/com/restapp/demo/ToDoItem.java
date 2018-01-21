package com.restapp.demo;

public class ToDoItem {
    private final long id;
    private final String text;
    private final boolean isComplete;

    public ToDoItem(long id, String text, boolean isComplete) {
        this.id = id;
        this.text = text;
        this.isComplete = isComplete;
    }

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public boolean isComplete() {
        return isComplete;
    }
}