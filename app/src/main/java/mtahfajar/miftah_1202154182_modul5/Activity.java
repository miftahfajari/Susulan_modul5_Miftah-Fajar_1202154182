package mtahfajar.miftah_1202154182_modul5;

/**
 * Created by Miftah on 25/03/2018.
 */

public class Activity {

    private long id;
    private String todo;
    private String description;
    private String priority;

    public Activity(){

    }

    public Activity(String todo, String description, String priority){
        this.todo = todo;
        this.description = description;
        this.priority = priority;
    }

    public Activity(int id, String todo, String description, String priority){
        this.id = id;
        this.todo = todo;
        this.description = description;
        this.priority = priority;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}