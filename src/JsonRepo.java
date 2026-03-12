import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class JsonRepo implements Repo{
    private File json_file;
    private ObjectMapper objectMapper;
    public JsonRepo(String path){
        json_file = new File(path);
        objectMapper = new ObjectMapper();
    }

    @Override
    public void save(List task_list) throws IOException {
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(json_file,task_list);
    }

    @Override
    public List loadAll() throws IOException {

        if (json_file.exists() && json_file.length()>0){
            return objectMapper.readValue(json_file,new TypeReference<List<Task>>(){});
        }
        else {
            return new ArrayList<Task>();
        }
    }

}
