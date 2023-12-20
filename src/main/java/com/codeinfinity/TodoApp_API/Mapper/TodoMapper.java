package com.codeinfinity.TodoApp_API.Mapper;

import com.codeinfinity.TodoApp_API.Entities.TodoEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TodoMapper {

    @Select("SELECT * FROM todos")
    List<TodoEntity> getallTodos();

    @Select("SELECT * FROM todos WHERE id = #{id} ")
    TodoEntity getTodoById(Integer id);

    @Insert("INSERT INTO todos (todo) VALUES (#{todo})")
    void addTodos(TodoEntity todo);

    @Delete("DELETE FROM todos WHERE id = #{id}")
    void deleteTodos(Integer id);
}
