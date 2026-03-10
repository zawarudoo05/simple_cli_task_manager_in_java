import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Task {
    private static int id_counter=0;
    private int id;
    private Status status;
    private String description;
    private String createdAt;
    private String updatedAt;
    public Task(String description){
        this.id= ++id_counter;
        this.status = Status.TODO;
        this.description= description;
        this.createdAt= LocalDateTime.now().toString();
        this.updatedAt= createdAt;
    }

    public Task() {
    }

    public static int getId_counter() {
        return id_counter;
    }
    public static void setId_counter(int id_counter) {
        Task.id_counter = id_counter;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    public String getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Task: " +
                 id +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'';
    }
}
