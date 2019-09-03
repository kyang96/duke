public class Task {
    private String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "✓" : "✘"); //return tick or X symbols
    }

    public boolean getStatus(){
        return isDone;
    }

    public void markAsDone(){
        isDone = true;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.getDescription();
    }

    public String writeToFile(){
        return (this.isDone ? '1' : '0') + "," + this.getDescription();
    }
}