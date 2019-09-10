import javax.swing.text.DateFormatter;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public abstract class Task {
    private String name;
    private boolean isDone;
    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy HHmm", Locale.ENGLISH);

    /**
     * constuctor method
     */
    Task(String name){
        this.name = name;   // this. refers to instance variable
    }

    String getName() {
        return name;
    }

    public void setName(String name) {//to change name
        this.name = name;
    }

    void setDone(){
        this.isDone = true;
    }

    String showDoneStatus(){
        return isDone?"✓":"✗";
    }
}


