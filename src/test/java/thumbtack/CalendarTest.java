package thumbtack;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalendarTest {

    private static final Calendar instance = new Calendar();
    @Test
    public void addEvent() throws Exception {
        instance.addEvent(1, 10, "WOCAO");
        System.out.println(instance.getEvents());
    }

    @Test
    public void updateEvent() throws Exception {
    }

    @Test
    public void removeEvent() throws Exception {
    }

    @Test
    public void getEvents() throws Exception {
    }

}