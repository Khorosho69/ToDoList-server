package com.restapp.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private final List<ToDoItem> toDoItemList;

    public ToDoList() {
        toDoItemList = new ArrayList<ToDoItem>();
    }

    public void addItemToList(ToDoItem toDoItem){
        toDoItemList.add(toDoItem);
    }

    public ToDoItem getToDoItem(int index){
        return  toDoItemList.get(index);
    }

    public void removeItem(int index){
        toDoItemList.remove(index);
    }

    public void updateToDoItem(int id, ToDoItem newItem){
        toDoItemList.set(id, newItem);
    }

    public List<ToDoItem> getToDoItemList() {
        return toDoItemList;
    }

    @JsonIgnore
    public Integer getToDoListCount(){
        return toDoItemList.size();
    }
}
