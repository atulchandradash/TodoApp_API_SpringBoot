package com.codeinfinity.TodoApp_API.Services.Impl;

import com.codeinfinity.TodoApp_API.Entities.TodoEntity;
import com.codeinfinity.TodoApp_API.Mapper.TodoMapper;
import com.codeinfinity.TodoApp_API.Services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoMapper todoMapper;

    @Override
    public List<TodoEntity> getallTodos() {

        return todoMapper.getallTodos();
    }

    @Override
    public TodoEntity getTodoById(Integer id) {
        return todoMapper.getTodoById(id);
    }

    @Override
    public void addTodos(TodoEntity todo) {
        todoMapper.addTodos(todo);
    }

    @Override
    public void deleteTodos(Integer id) {
        todoMapper.deleteTodos(id);
    }

    @Override
    public void todoIsCompleted(Integer id) {
        todoMapper.todoIsCompleted(id);
    }
}
