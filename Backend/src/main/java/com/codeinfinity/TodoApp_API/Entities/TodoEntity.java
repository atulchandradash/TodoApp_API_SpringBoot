package com.codeinfinity.TodoApp_API.Entities;

import lombok.Data;

@Data
public class TodoEntity {

    private Integer id;
    private String todo;

    private boolean complete;

    private String created_at;

}
