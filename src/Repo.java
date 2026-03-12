import java.io.IOException;
import java.util.*;

public interface Repo {
    public void save(List task_list) throws IOException;
    public List loadAll() throws IOException;
}
