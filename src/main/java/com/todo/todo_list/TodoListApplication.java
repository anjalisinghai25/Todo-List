package com.todo.todo_list;

import com.todo.todo_list.Repository.TodoRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TodoListApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TodoListApplication.class, args);
		TodoRepo todoRepo = context.getBean(TodoRepo.class);
	}

}
