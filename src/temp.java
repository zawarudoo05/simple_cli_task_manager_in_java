import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class temp {
    public static void main(String[] args) throws IOException {
        //Task task= new Task("make a cli todo list");
        //System.out.println(task.getId());
        //System.out.println(task.getCreatedAt());

        //writing into a json file
        //ObjectMapper mapper = new ObjectMapper();
        //Task task1 = new Task("fucking work");
        //String test = mapper.writeValueAsString(task1);
        //System.out.println(test);

//        String json = " {\n" +
//                "    \"id\": 0,\n" +
//                "    \"description\": \"make a todo list\",\n" +
//                "    \"status\": \"TODO\",\n" +
//                "    \"createdAt\": \"2026-03-03\",\n" +
//                "    \"updatedAt\": \"2026-03-03\"\n" +
//                "  }";
//        ObjectMapper objectMapper = new ObjectMapper();
//        Task task = objectMapper.readValue(json,Task.class);
//        System.out.println(task.toString());

        //reading from a json file into a java obejct
        ObjectMapper mapper = new ObjectMapper();
        //try {

        //    File json_file = new File("src/file.json");
        //    Task task = mapper.readValue(json_file,Task.class);
        //    System.out.println(task.toString());
        //} catch (IOException e) {
        //    throw new RuntimeException(e);
        //}
        ////writing into a json file
        Task task1 = new Task("writing into json");
        Task task2 = new Task("writing into json 2");
        //List<Task> taskList = new ArrayList<Task>();
        //taskList.add(task1);
        //taskList.add(task2);
        //mapper.writeValue(new FileOutputStream("src/test.json"),taskList);

        //testing the TaskManager class
        TaskManager manager= new TaskManager();
        //manager.add(task1);
        //manager.add(task2);
            //marking a test as done
        //String status="done";
        //manager.mark(1,status);
            //updating the descriptions of a task
        //manager.updateTaskbyId(2,"updating the task");
        //Task task3= new Task("making list methods");
        //manager.deleteTask(1);
        manager.listAll();
    }
}
