package duke.storage;

import duke.exception.DukeException;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Storage {

    String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }
    // constructor
    public void saveTaskList(ArrayList<Task> tasks) {

        try(FileWriter fileWriter = new FileWriter(filePath)) {
            for(int j=0;j<tasks.size();j++) {
                fileWriter.write(tasks.get(j).toString());
                fileWriter.write(System.lineSeparator()); //new line
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Task> loadTaskList() throws DukeException {
        ArrayList<Task> previousList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNext()) {
                String cinLine = scanner.nextLine();

                String[] arrOfStr = cinLine.split("]", 3);
                String taskType = arrOfStr[0];
                String taskDone = arrOfStr[1];
                String taskName = arrOfStr[2];


                if (taskType.equals("[T")) {
                    Task task = new Todo(taskName);
                    if (taskDone.equals("[✓")) {
                        task.setDone();
                    }
                    previousList.add(task);

                }
                else if (taskType.equals("[D")) {
                    try {
                        String[] arrOfStr2 = taskName.split(" \\(by: ", 2);
                        String cinDeadline = arrOfStr2[1].substring(0,arrOfStr2[1].length()-1);
                        String cinDeadlineLessDate = arrOfStr2[0];
                        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm", Locale.ENGLISH);
                        LocalDateTime date1 = LocalDateTime.parse(cinDeadline, inputFormatter);
                        Task task = new Deadline(cinDeadlineLessDate, date1);
                        if (taskDone.equals("[✓")) {
                            task.setDone();
                        }
                        previousList.add(task);
                    } catch (StringIndexOutOfBoundsException ex) {
                        System.out.println("error");
                    }
                }
                else if (taskType.equals("[E")) {
                    try {
                        String[] arrOfStr2 = taskName.split(" \\(at: ", 2);
                        String cinEvent = arrOfStr2[1].substring(0,arrOfStr2[1].length()-1);
                        String cinEventLessDate = arrOfStr2[0];
                        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy HHmm", Locale.ENGLISH);
                        LocalDateTime date1 = LocalDateTime.parse(cinEvent, inputFormatter);
                        Task task = new Event(cinEventLessDate, date1);
                        if (taskDone.equals("[✓")) {
                            task.setDone();
                        }
                        previousList.add(task);
                    }catch (StringIndexOutOfBoundsException ex) {
                        System.out.println("error");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new DukeException("File not found");
        }
            return previousList;
        }
    }
