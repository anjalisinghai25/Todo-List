package com.todo.todo_list.Controller;

import com.todo.todo_list.Entity.TodoItem;
import com.todo.todo_list.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    public TodoService todoService;

    @GetMapping("/items")
    public List<TodoItem> getAllItem(){
        return todoService.getAllItem();
    }

    @GetMapping("/item/{id}")
    public TodoItem getItemById(@PathVariable("id") Integer id){
        return todoService.getItemById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteItem(@PathVariable Integer id){
        todoService.deleteItem(id);
    }

    @PutMapping("/update/{id}")
    public void updateItem(@PathVariable Integer id ,@RequestBody TodoItem todoItem ){
        todoService.updateItem(id, todoItem);
    }


    @PostMapping("/add")
    public void addItem(@RequestBody TodoItem todoItem){
         todoService.addItem(todoItem);
    }

}
