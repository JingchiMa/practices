package interviews.Houzz;

import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class CalendarTest {

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    private java.util.Calendar c = java.util.Calendar.getInstance();

    @Before
    public void setup() {
        c.setTime(new Date());
    }

    @Test
    public void addDays() throws Exception {
        Calendar instance = new Calendar(2018, 12, 29);
        System.out.println(instance.addDays(1000));
        c.add(java.util.Calendar.DATE, 1000);
        System.out.println(dateFormat.format(c.getTime()));
    }

    @Test
    public void addDaysTest2() {
        Calendar instance = new Calendar(2018, 12, 29);
        System.out.println(instance.addDays(10000));
        c.add(java.util.Calendar.DATE, 10000);
        System.out.println(dateFormat.format(c.getTime()));
    }

}