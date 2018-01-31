package com.restapp.demo;

public class ToDoItem {
    private String text;
    private boolean isComplete;

    public ToDoItem() {
    }

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

    public void setText(String text) {
        this.text = text;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}