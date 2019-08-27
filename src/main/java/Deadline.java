import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task{
    private Date by;

    public Deadline(String description, Date by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + new SimpleDateFormat("dd MMM yyyy h:mma").format(by) + ")";
    }

    @Override
    public String writeToFile(){
        return "D," + super.writeToFile() + "," + new SimpleDateFormat("dd MMM yyyy h:mma").format(by);
    }
}
