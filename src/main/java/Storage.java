import java.io.FileReader;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Storage extends Duke {//might be wrong need to edit this

    List<Task> previousList;

    // constructor
    public void saveTask() {
        try(FileWriter fileWriter = new FileWriter("duke.txt")) {
            //inherited method from java.io.Writer
            for(int j=0;j<tasks.size();j++) {
                fileWriter.write("    " + (j + 1) + "." + tasks.get(j));
                fileWriter.write(System.lineSeparator()); //new line
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Task> loadTask() {

            Scanner scanner = new Scanner("duke.txt");
            while (scanner.hasNext()) {
                String cinLine = scanner.nextLine();
                int i = cinLine.indexOf(' ');//if (i==-1) or use if(i!=-1)
                String cinFirstWord = cinLine.substring(0, i);
                String cinLineLessFirstWord = cinLine.substring(i + 1);//less SPACE


                if (cinFirstWord.equals("todo")) {
                    Task task = new Todo(cinLineLessFirstWord);
                    previousList.add(task);
                } else if (cinFirstWord.equals("deadline")) {
                    int j = cinLineLessFirstWord.indexOf("/by");

                    try{
                        String cinDeadline = cinLineLessFirstWord.substring(j+4);
                        String cinDeadlineLessDate = cinLineLessFirstWord.substring(0,j-1);//less space

                        String sDate1=cinDeadline;
                        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hhmm", Locale.ENGLISH);
                        LocalDateTime date1 = LocalDateTime.parse(sDate1, inputFormatter);
                        Task task = new Deadline(cinDeadlineLessDate,date1);
                        previousList.add(task);
                    }
                    catch(StringIndexOutOfBoundsException ex){
                        System.out.println("error");
                    }
                } else if (cinFirstWord.equals("event")) {
                    int j = cinLineLessFirstWord.indexOf("/at");

                    String cinEvent = cinLineLessFirstWord.substring(j + 4);
                    String cinEventLessDate = cinLineLessFirstWord.substring(0, j - 1);//less space

                    Task task = new Event(cinEventLessDate, cinEvent);
                    previousList.add(task);
                }
            }
            return previousList;
        }
    }
