package dolinski.andrzej.zaliczenie;

/**
 * Created by andrz_000 on 2015-06-02.
 */
public class TaskEntry {

    private final String summary;
    private final String description;
    private final String date;

    public TaskEntry(String summary, String description, String date) {
        this.summary = summary;
        this.description = description;
        this.date = date;
    }

    public String getSummary() {
        return summary;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }
}
