package quora;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExamRoomTest {
    @Test
    public void test() {
        ExamRoom instance = new ExamRoom(4);
        instance.seat();
        instance.seat();
        instance.seat();
        instance.seat();
        instance.leave(1);
        instance.leave(3);
        instance.seat();
    }
}