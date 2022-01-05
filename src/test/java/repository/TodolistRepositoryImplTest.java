package repository;

import com.zaxxer.hikari.HikariDataSource;
import entity.Todolist;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.DatabaseUtil;


public class TodolistRepositoryImplTest {

    private HikariDataSource dataSource;

    private TodoListRepository todoListRepository;

    @BeforeEach
    void setUp(){
        dataSource = DatabaseUtil.getDataSource();
        todoListRepository = new TodoListRepositoryImpl(dataSource);
    }

    @Test
    void testAdd(){
        Todolist todolist = new Todolist();
        todolist.setTodo("Ana");
        todoListRepository.add(todolist);
    }

    @Test
    void testRemove(){
        todoListRepository.remove(1);
        todoListRepository.remove(2);
        todoListRepository.remove(3);
    }

    @Test
    void testGetAll(){
        todoListRepository.add(new Todolist("andri"));
        todoListRepository.add(new Todolist("ana"));
        todoListRepository.add(new Todolist("marisa"));

        Todolist [] todolists = todoListRepository.getAll();

        for (Todolist  todo : todolists) {
            System.out.println(todo.getId() + " : " + todo.getTodo());
        }
    }

    @AfterEach
    void tearDown(){
        dataSource.close();
    }
}
