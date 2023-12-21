package com.codeinfinity.TodoApp_API.Controllers;

import com.codeinfinity.TodoApp_API.Entities.TodoEntity;
import com.codeinfinity.TodoApp_API.ResposeResult.Result;
import com.codeinfinity.TodoApp_API.Services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping()
    public Result<List<TodoEntity>> getallTodos()
    {
        try
        {
            List<TodoEntity> data = todoService.getallTodos();
            return Result.success(data);

        }catch (Exception e)
        {
            e.printStackTrace();
            return  Result.error("操作失败 " + e);
        }
    }


    @GetMapping("/{id}")
    public Result getallTodos(@PathVariable Integer id)
    {
        try
        {
            TodoEntity data = todoService.getTodoById(id);
            return Result.success(data);

        }catch (Exception e)
        {
            e.printStackTrace();
            return  Result.error("操作失败 " + e);
        }
    }


    @PostMapping
    public Result addTodos(@RequestBody TodoEntity todo)
    {
        try
        {
            todoService.addTodos(todo);
            return Result.success();

        }catch (Exception e)
        {
            e.printStackTrace();
            return  Result.error("操作失败 " + e);
        }
    }


    @DeleteMapping("/{id}")
    public Result deleteTodos(@PathVariable Integer id)
    {
        try
        {
            todoService.deleteTodos(id);
            return Result.success();

        }catch (Exception e)
        {
            e.printStackTrace();
            return  Result.error("操作失败 " + e);
        }
    }


    @PutMapping("/{id}")
    public Result todoIsCompleted(@PathVariable Integer id)
    {
        try
        {
            todoService.todoIsCompleted(id);
            return Result.success();

        }catch (Exception e)
        {
            e.printStackTrace();
            return  Result.error("操作失败 " + e);
        }
    }



}
