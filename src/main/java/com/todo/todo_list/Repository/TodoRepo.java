package com.todo.todo_list.Repository;

import com.todo.todo_list.Entity.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TodoRepo extends JpaRepository<TodoItem, Integer> {
}
