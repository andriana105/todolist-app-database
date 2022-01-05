package view;

import service.TodoListService;
import util.InputUtil;

public class TodoListView {

    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodoList(){
        while (true) {

            todoListService.showTodoList();
            System.out.println("Menu :");
            System.out.println("1. Add");
            System.out.println("2. Delete");
            System.out.println("x. Exit");

            String input = InputUtil.input("Choose");
            if(input.equals("1")){
                addTodoList();
            }else if(input.equals("2")){
                removeTodoList();
            }else if(input.equals("x")){
                break;
            }else{
                System.out.println("Option is wrong.");
            }

        }

    }

    public void addTodoList(){

        System.out.println("Add Todolist");

        String todo = InputUtil.input("Todo (x if want to cancel)");

        if(todo.equals("x")){
            //exit
        }else{
            todoListService.addTodoList(todo);
        }

    }

    public void removeTodoList(){

        System.out.println("Delete Todolist");

        String number = InputUtil.input("Which Number will be deleted ?(x if want to camcel)");

        if(number.equals("x")){
            //cancel
        }else{
            todoListService.removeTodoList(Integer.valueOf(number));
        }
    }
}
