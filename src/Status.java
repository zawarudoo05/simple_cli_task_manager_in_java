import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {

    TODO("TODO"),IN_PROGRESS("IN_PROGRESS"),DONE("DONE");
    private String label;

    Status(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }
}
