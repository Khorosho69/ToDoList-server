package com.restapp.demo;

import com.restapp.demo.Response.ResponseNotFound;
import com.restapp.demo.Response.ResponseOK;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ToDoController {
    //This is SERVER
    private final AtomicLong counter = new AtomicLong();
    private ToDoList toDoList = new ToDoList();

    @RequestMapping(value = "/toDoItems", method = RequestMethod.POST)
    public ResponseOK addNewToDoItem(@RequestParam(value="itemText", defaultValue="Work on this shit") String itemText){
        toDoList.addItemToList(new ToDoItem(counter.incrementAndGet(), counter.get() + ": " + itemText, false));
        return new ResponseOK();
    }

    @RequestMapping(value = "/toDoItems", method = RequestMethod.GET)
    public List<ToDoItem> getToDoItem(){
        if(toDoList == null) throw new ResponseNotFound();
        return toDoList.getToDoItemList();
    }

    @RequestMapping(value = "/toDoItems/{id}", method = RequestMethod.GET)
    public ToDoItem getToDoItem(@PathVariable("id") Integer id){
        if(toDoList.getToDoListCount() <= id) throw new ResponseNotFound();
        return toDoList.getToDoItem(id);
    }

    @RequestMapping(value = "/toDoItems", method = RequestMethod.PUT)
    public ResponseOK changeToDoItemStatus(
            @RequestParam(value = "id") Integer id, @RequestParam(value = "status") boolean status){
        if(toDoList.getToDoListCount() <= id) throw new ResponseNotFound();
        toDoList.changeItemStatus(id, status);
        return new ResponseOK();
    }

    @RequestMapping(value = "/toDoItems/{id}", method = RequestMethod.DELETE)
    public ResponseOK removeToDoItem(@PathVariable("id") Integer id) {
        if(toDoList.getToDoListCount() <= id) throw new ResponseNotFound();
            toDoList.removeItem(id);
            return new ResponseOK();
    }
}
