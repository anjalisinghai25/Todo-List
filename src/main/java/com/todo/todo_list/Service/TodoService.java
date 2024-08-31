package com.todo.todo_list.Service;

import com.todo.todo_list.Entity.TodoItem;
import com.todo.todo_list.Repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class TodoService {

@Autowired
public TodoRepo todoRepo;

    public TodoItem getItemById(Integer id){
        Optional<TodoItem> byId = todoRepo.findById(id);

        if(byId.isPresent()){
            return byId.get();
        }
        else{
            throw new RuntimeException("Id not Found!");
        }
    }

    public List<TodoItem> getAllItem(){
        return todoRepo.findAll();

    }

    public void deleteItem(Integer id){
        try {
            todoRepo.deleteById(id);
        }
        catch(RuntimeException e){
            throw new RuntimeException("id not found!");
        }
    }

    public void addItem(TodoItem todoItem){
      todoRepo.save(todoItem);
    }

    public void updateItem(Integer id , TodoItem todoItem){
        TodoItem item = todoRepo.findById(id).orElseThrow(()->new RuntimeException("Id not found!"));
        item.setTitle(todoItem.getTitle());
        item.setCompleted(todoItem.getCompleted());
        item.setDescription(todoItem.getDescription());
        todoRepo.save(item);
    }

}
