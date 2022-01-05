package service;

import entity.Todolist;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService {

    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {

        Todolist[] model = todoListRepository.getAll();

        System.out.println("TODOLIST");

        for(Todolist todolist : model){
            System.out.println(todolist.getId() + "." + todolist.getTodo());
        }
    }

    @Override
    public void addTodoList(String todo) {
        Todolist todolist = new Todolist(todo);
        todoListRepository.add(todolist);
        System.out.println("Succesfully Added TODO " + todo);
    }

    @Override
    public void removeTodoList(Integer number) {
        boolean success = todoListRepository.remove(number);
        if(success){
            System.out.println("Successfully Removed TODO " + number);
        }else{
            System.out.println("Failed To Removed TODO " + number);
        }

    }
}