import duke.task.Todo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodoTest {
    private Todo todo = new Todo("first todo");

    @Test
    void testGetName() {
        assertEquals("first todo", todo.getName());
    }
    @Test
    void testToString() {
        assertEquals("[T][✗]first todo", "[T]["+ todo.showDoneStatus()+"]"+ todo.getName());
    }
}