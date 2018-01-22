package com.restapp.demo;

public class ToDoItem {
    private final String text;
    private final boolean isComplete;

    public ToDoItem(String text, boolean isComplete) {
        this.text = text;
        this.isComplete = isComplete;
    }

    public String getText() {
        return text;
    }

    public boolean isComplete() {
        return isComplete;
    }
}