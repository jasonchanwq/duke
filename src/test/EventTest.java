import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {
    private Event event = new Event("first event", "2/12/2019 1800");
    @Test
    void testGetName() {
        assertEquals("first event", event.getName());
    }
    @Test
    void testToString() {
        assertEquals("[E][✗]first event (at: 2/12/2019 1800)", "[E]["+ event.showDoneStatus()+"]"+ event.getName()+" (at: "+event.getEventAt()+")");
    }
}