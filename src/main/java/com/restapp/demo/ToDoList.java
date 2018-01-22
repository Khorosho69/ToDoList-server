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

    public void changeItemStatus(int index, boolean status ){
        toDoItemList.set(index, new ToDoItem(toDoItemList.get(index).getText(), status));
    }

    public void removeItem(int index){
        toDoItemList.remove(index);
    }

    public List<ToDoItem> getToDoItemList() {
        return toDoItemList;
    }

    @JsonIgnore
    public Integer getToDoListCount(){
        return toDoItemList.size();
    }
}
