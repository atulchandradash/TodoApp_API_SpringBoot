package com.codeinfinity.TodoApp_API.Mapper;

import com.codeinfinity.TodoApp_API.Entities.TodoEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TodoMapper {

    @Select("SELECT * FROM todos")
    List<TodoEntity> getallTodos();

    @Select("SELECT * FROM todos WHERE id = #{id} ")
    TodoEntity getTodoById(Integer id);

    @Insert("INSERT INTO todos (todo,created_at) VALUES (#{todo}, now() )")
    void addTodos(TodoEntity todo);

    @Delete("DELETE FROM todos WHERE id = #{id}")
    void deleteTodos(Integer id);

    @Update("UPDATE todos SET complete = 1 WHERE id = #{id}")
    void todoIsCompleted(Integer id);
}
