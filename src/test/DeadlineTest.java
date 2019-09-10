import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

class DeadlineTest {
    String sDate1= "2/12/2019 1800";
    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy HHmm", Locale.ENGLISH);
    LocalDateTime date1 = LocalDateTime.parse(sDate1, inputFormatter);
    private Deadline deadline = new Deadline("first deadline",date1);



    @Test
    void testGetName() {
        assertEquals("first deadline", deadline.getName());
    }
    @Test
    void testToString() {
        assertEquals("[D][✗]first deadline (by: 2/12/2019 1800)","[D]["+ deadline.showDoneStatus()+"]"+ deadline.getName()+" (by: "+ deadline.showDateBy()+")");
    }
}