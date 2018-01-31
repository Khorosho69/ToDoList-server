package com.restapp.demo;

import com.restapp.demo.Response.ResponseNotFound;
import com.restapp.demo.Response.ResponseOK;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ToDoController {
    private ToDoList toDoList = new ToDoList();

    @RequestMapping(value = "/toDoItems", method = RequestMethod.POST)
    public ToDoItem addNewToDoItem(@RequestParam(value = "itemText") String itemText) {
        ToDoItem newToDoItem = new ToDoItem(itemText, false);
        toDoList.addItemToList(newToDoItem);
        return newToDoItem;
    }

    @RequestMapping(value = "/toDoItems", method = RequestMethod.GET)
    public List<ToDoItem> getToDoItems() {
        if (toDoList == null) throw new ResponseNotFound();
        return toDoList.getToDoItemList();
    }

    @RequestMapping(value = "/toDoItems/{id}", method = RequestMethod.GET)
    public ToDoItem getToDoItem(@PathVariable("id") Integer id) {
        if (toDoList.getToDoListCount() <= id) throw new ResponseNotFound();
        return toDoList.getToDoItem(id);
    }

//    @RequestMapping(value = "/toDoItems", method = RequestMethod.PUT)
//    public ResponseOK updateToDoItem(
//            @RequestParam(value = "id") Integer id, @RequestParam(value = "status") boolean status) {
//        if (toDoList.getToDoListCount() <= id) throw new ResponseNotFound();
//        toDoList.changeItemStatus(id, status);
//        return new ResponseOK();
//    }

    @RequestMapping(value = "/toDoItems/{id}", method = RequestMethod.DELETE)
    public ResponseOK removeToDoItem(@PathVariable("id") Integer id) {
        if (toDoList.getToDoListCount() <= id) throw new ResponseNotFound();
        toDoList.removeItem(id);
        return new ResponseOK();
    }

    @RequestMapping(value = "/toDoItems/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateToDoItem(@PathVariable("id") int id, @RequestBody ToDoItem toDoItem) {
        if(toDoList.getToDoItem(id) == null) throw new ResponseNotFound();
        toDoList.updateToDoItem(id, toDoItem);
        return new ResponseEntity<>(toDoItem, HttpStatus.OK);
    }

}
