public class Duke {
    private Ui ui;
    private FileIO fileIO;
    private TaskList taskList;

    public Duke(String path){
        ui = new Ui();
        fileIO = new FileIO(".\\duke.txt");
        taskList = new TaskList(fileIO.loadFile());
    }

    public static void main(String[] args) {
        new Duke(".\\duke.txt").run();
    }

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
