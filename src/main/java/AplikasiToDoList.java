public class AplikasiToDoList {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        //testShowTodolist();
        //testAddTodolist();
        //testRemoveTodolist();
        //testInput();
        //testViewShowTodolist();
        //testViewRemoveTodolist();
        viewShowTodolist();

    }

    /**
     * Displaying ToDo List
     */
    public static void showTodolist(){
        System.out.println("TODOLIST");
        for(int i = 0; i < model.length; i++){
            String todo = model[i];
            int no = i + 1;

            if(todo !=null){
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testShowTodolist(){
        model[0] = "Learning Basic Java";
        model[1] = "Case Study Basic Java : Todolist Application";
        showTodolist();
    }

    /**
     * Adding ToDo List
     */
    public static  void addTodolist(String todo){
        // check if the length of model is full ?
        boolean isFull = true;
        for(int i =0; i < model.length; i++){
            if(model[i] == null){
                //model is not full
                isFull = false;
                break;
            }
        }

        //if model is full, resize the length of model to be 2 times the previous length
        if(isFull){
            String[] temp = model;
            model = new String[model.length * 2];

            for (int i =0; i<temp.length; i++) {
                model[i] = temp[i];
            }
        }
        // add to the position which value of array data is NULL
        for(int i = 0; i < model.length; i++){
            if(model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodolist(){
        for (int i = 0; i <25; i++){
            addTodolist("Todo " + i);
        }

    showTodolist();
    }
    /**
     * Delete ToDo List
     */
    public  static boolean removeTodolist(Integer number){
        if((number - 1) >= model.length){
            return false;
        }else if(model[number - 1]== null){
            return false;
        }else{
            model[number -1 ] = null;

            for(int i = (number - 1); i < model.length; i++){
                if(i == model.length - 1){
                    model[i] = null;
                }else {
                    model[i] = model[i + 1];
                }

            }
            return true;
        }

    }

    public static void testRemoveTodolist(){
        addTodolist("One");
        addTodolist("Two");
        addTodolist("Three");

        boolean result = removeTodolist(20);
        System.out.println(result);

        result = removeTodolist(4);
        System.out.println(result);

        result = removeTodolist(2);
        System.out.println(result);

        showTodolist();
    }

    public static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static  void testInput(){
        String name = input("Name");
        System.out.println("Hi " + name );

        String channel = input("Channel");
        System.out.println(channel);
    }

    /**
     * View of Show ToDo List
     */
    public static void viewShowTodolist(){
        while (true) {

            showTodolist();
            System.out.println("Menu :");
            System.out.println("1. Add");
            System.out.println("2. Delete");
            System.out.println("x. Exit");

            String input = input("Choose");
            if(input.equals("1")){
                viewAddTodolist();
            }else if(input.equals("2")){
                viewRemoveTodolist();
            }else if(input.equals("x")){
                break;
            }else{
                System.out.println("Option is wrong.");
            }

        }

    }

    public static void testViewShowTodolist(){
        addTodolist("One");
        addTodolist("Two");
        addTodolist("Three");
        addTodolist("Four");
        addTodolist("Four");
        viewShowTodolist();
    }

    /**
     * View of Add ToDo List
     */
    public  static  void viewAddTodolist(){
        System.out.println("Add Todolist");

        String todo = input("Todo");

        if(todo.equals("x")){
            //exit
        }else{
            addTodolist(todo);
        }
    }

    public static void testViewTodolist(){
        addTodolist("one");
        addTodolist("two");
        viewAddTodolist();
        showTodolist();
    }

    /**
     * View of Remove ToDo List
     */

    public static void viewRemoveTodolist(){
        System.out.println("Delete Todolist");

        String number = input("Which Number will be deleted ?(x if want to camcel)");

        if(number.equals("x")){
            //cancel
        }else{
            boolean success = removeTodolist(Integer.valueOf(number));
            if(!success){
                System.out.println("Failed to delete : " + number);
            }
        }
    }

    public static void testViewRemoveTodolist(){
        addTodolist("One");
        addTodolist("Two");
        addTodolist("Three");
        addTodolist("Four");

        showTodolist();
        viewRemoveTodolist();
        showTodolist();
    }
}
