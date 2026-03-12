import java.io.IOException;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.*;

public class Task_cli {
    public static void main(String[] args) throws IOException {
        String path ="/home/alichliyah/IdeaProjects/Task Tracker/src/file.json";


        try {
            JsonRepo repo= new JsonRepo(path);
            TaskManager taskManager= new TaskManager(repo);
            if (args.length==0){
                manual();
                return;
            }
            String command ;
            command = args[0].toLowerCase();
            switch (command){
                //adding a task
                case "add" ->{
                    if (args.length >1){
                        taskManager.add(new Task(args[1]));
                        System.exit(0);
                    }
                    else {
                        System.out.println("you need a discritpion to add a task");
                        System.exit(1);
                    }
                }
                //updating the description of a task
                case "update"->{
                    //user has to give the index and the description, without any description there's no command
                    if (args.length>=3){
                        int index = Integer.parseInt(args[1]);
                        String description = args[2];
                        taskManager.updateTaskbyId(index,description);
                        System.exit(0);
                    }
                    else {
                        System.out.println("you need the number of the task and the description you want to update");
                        System.exit(1);
                    }
                }
                //listing the tasks, list all if no argument is given, or list by status
                case "list"->{
                    if (args.length>1){
                        String status_choice = args[1].toLowerCase();
                        switch (status_choice){
                            case "todo", "in_progress", "done" ->{
                                taskManager.listByStatus(status_choice);
                            }
                            default ->{
                                System.out.println("the possible status choices are : todo, in_porgress, done");
                                System.exit(1);
                            }
                        }System.exit(0);
                    }else {
                        taskManager.listAll();
                        System.exit(0);
                    }
                }
                //mark a task in a new status, by giving the number and the new status to the arguments
                case "mark"->{
                    if (args.length>=3){
                        int task_index= Integer.parseInt(args[1]);
                        String newStatus  = args[2].toLowerCase();
                        switch (newStatus){
                            case "todo","in_progress","done"->{
                                taskManager.mark(task_index,newStatus);
                                System.exit(0);
                            }
                            default ->{
                                System.out.println("the possible status choices are : todo, in_porgress, done");
                                System.exit(1);
                            }
                        }
                    }
                    else {
                        System.out.println("you need the number of the task and the status of the task you wanna mark");
                        System.exit(1);
                    }
                }
                // removing a task, the argument is the number of the task
                case "remove"->{
                    if (args.length ==2){
                        int task_index= Integer.parseInt(args[1]);
                        taskManager.deleteTask(task_index);
                        System.exit(0);
                    }
                    else {
                        System.out.println("remove command only needs the id of the task");
                        System.exit(1);
                    }
                }

                default -> throw  new IllegalArgumentException();
            }
        } catch (IOException e) {
            System.out.println("Error:"+e.getMessage());
        }
        catch (NumberFormatException e) {
            System.out.println("Error: The ID must be a valid number.");
            System.exit(1);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error:"+e.getMessage());
        }

    }
    public static void manual(){
        System.out.println("HOW TO USE");
        System.out.println("task [add|update|mark|remove|list] [arguments]");
        System.out.println("task add 'description'");
        System.out.println("task update ID/number_of_task  'description'");
        System.out.println("task mark ID/number_of_task 'status' (status: todo,done,in_progress)");
        System.out.println("task remove ID");
        System.out.println("task list 'status' (list all the tasks when no status is given)");
    }
}
