import java.text.SimpleDateFormat;
import java.util.Date;

public class Event extends Task {
    private Date date;

    public Event(String description, Date date) {
        super(description);
        this.date = date;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + new SimpleDateFormat("dd MMM yyyy h:mma").format(date) + ")";
    }

    @Override
    public String writeToFile(){
        return "E," + super.writeToFile() + "," + new SimpleDateFormat("dd MMM yyyy h:mma").format(date);
    }
}