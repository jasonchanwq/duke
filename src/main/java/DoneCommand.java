public class DoneCommand extends Command {
    @Override
    public void execute(String cin, TaskList tasks, Ui ui, Storage storage, int i){
        String[] arrOfStr = cin.split(" ", 2);
        String index = arrOfStr[1];
        int number = Integer.parseInt(index);
        tasks.doneTask(number);
    }
}
