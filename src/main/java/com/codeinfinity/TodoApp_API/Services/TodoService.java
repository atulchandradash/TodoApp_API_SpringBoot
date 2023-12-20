package com.codeinfinity.TodoApp_API.Services;

import com.codeinfinity.TodoApp_API.Entities.TodoEntity;

import java.util.List;

public interface TodoService {

    List<TodoEntity> getallTodos();


    TodoEntity getTodoById(Integer id);

    void addTodos(TodoEntity todo);

    void deleteTodos(Integer id);
}
