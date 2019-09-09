public class Duke {
    /**
     * The Ui object that handles input and output of the application
     */
    private Ui ui;
    /**
     * The FileIO object that handles the read and write of text file from the local computer.
     */
    private FileIO fileIO;
    /**
     * The taskList object that handles the list of task added by the user.
     */
    private TaskList taskList;

    /**
     * Constructs a new Duke object.
     * @param path The path of the save file in the local computer.
     */
    public Duke(String path){
        ui = new Ui();
        fileIO = new FileIO(path);
        taskList = new TaskList(fileIO.loadFile());
    }

    public static void main(String[] args) {
        new Duke(".\\duke.txt").run();
    }

    /**
     * Execute and run the Duke application.
     */
    public void run(){
        ui.welcomeMsg();
        boolean isExit = false;
        while (!isExit){
            String cmd = ui.readLine();
            ui.printLine();
            isExit = Parser.parse(cmd, taskList, fileIO);
            ui.printLine();
        }
        ui.byeMsg();
    }
}
