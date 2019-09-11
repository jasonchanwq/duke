import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {
    String sDate1="2/12/2019 1800";
    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy HHmm", Locale.ENGLISH);
    LocalDateTime date1 = LocalDateTime.parse(sDate1, inputFormatter);
    private Event event = new Event("first event", date1);
    @Test
    void testGetName() {
        assertEquals("first event", event.getName());
    }
    @Test
    void testToString() {
        assertEquals("[E][✗]first event (at: 2/12/2019 1800)", "[E]["+ event.showDoneStatus()+"]"+ event.getName()+" (at: "+event.showEventAt()+")");
    }
}